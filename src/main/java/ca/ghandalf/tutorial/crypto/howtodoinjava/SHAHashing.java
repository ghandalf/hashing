package ca.ghandalf.tutorial.crypto.howtodoinjava;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SHAHashing extends Hashing {

	private static final Logger logger = LoggerFactory.getLogger(SHAHashing.class);

	@Override
	public String compute(String password) throws NoSuchAlgorithmException {

		logger.info("From {} class compute had been called.", this.getClass().getSimpleName());

		return this.compute(password, HashType.SHA_1);
	}

	@Override
	public String compute(String password, HashType type) throws NoSuchAlgorithmException {

		MessageDigest messageDigest = MessageDigest.getInstance(type.value());
		messageDigest.update(getSalt());

		byte[] hashesBytes = messageDigest.digest(password.getBytes());

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < hashesBytes.length; i++) {
			builder.append(Integer.toString((hashesBytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		return builder.toString();
	}

}
