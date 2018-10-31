package ca.ghandalf.tutorial.hashing;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PBKDF2WithHmacSHA1 extends Hashing {

	private static final Logger logger = LoggerFactory.getLogger(PBKDF2WithHmacSHA1.class);
	
	@Override
	public String compute(String password) throws NoSuchAlgorithmException {
		
		logger.info("From {} class compute had been called.", this.getClass().getSimpleName());

		String result = null;

		int iterations = 1000;
		char[] chars = password.toCharArray();

		try {
			PBEKeySpec specification = new PBEKeySpec(chars, getSalt(), iterations, 64 * 8);
			SecretKeyFactory factory = SecretKeyFactory.getInstance(HashType.PBKDF2.value());

			byte[] hash = factory.generateSecret(specification).getEncoded();

			result = iterations + ":" + toHex(getSalt()) + ":" + toHex(hash);

		} catch (InvalidKeySpecException e) {
			logger.error("{} algorithm implementation error.", e.getClass().getSimpleName());
		}

		return result;
	}

	@Override 
	public String compute(String password, HashType type) throws NoSuchAlgorithmException {
		return this.compute(password);
	}

	public boolean validate(String currentPassword, String storedPassword) throws NoSuchAlgorithmException {

		boolean result = false;
		
		String[] parts = storedPassword.split(":");
		int iterations = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);
		byte[] hash = fromHex(parts[2]);

		try {
			PBEKeySpec specification = new PBEKeySpec(currentPassword.toCharArray(), salt, iterations, hash.length * 8);
			SecretKeyFactory factory = SecretKeyFactory.getInstance(HashType.PBKDF2.value());
			
			byte[] comparativeHash = factory.generateSecret(specification).getEncoded();
			
			int comparativeValue = hash.length ^ comparativeHash.length;
			
			for (int i = 0; i < hash.length && i < comparativeHash.length; i++) {
				
				comparativeValue |= hash[i] ^ comparativeHash[i];				
			}
			
			result = comparativeValue == 0;

		} catch (InvalidKeySpecException e) {
			logger.error("{} algorithm implementation error.", e.getClass().getSimpleName());
		}

		return result;
	}

	private String toHex(byte[] array) {

		BigInteger bigInt = new BigInteger(1, array);
		String hexadecimal = bigInt.toString(16);

		int padding = (array.length * 2) - hexadecimal.length();

		return (padding > 0) ? String.format("%0" + padding + "d", 0) + hexadecimal : hexadecimal;
	}

	private byte[] fromHex(String value) {

		byte[] result = new byte[value.length() / 2];

		for (int i = 0; i < result.length; i++) {

			result[i] = (byte) Integer.parseInt(value.substring(2 * i, (2 * i) + 2), 16);
		}

		return result;
	}
}
