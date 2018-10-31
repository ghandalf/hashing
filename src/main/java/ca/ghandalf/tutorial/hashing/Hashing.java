package ca.ghandalf.tutorial.hashing;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public abstract class Hashing {

	private byte[] salt = null;
	
	public abstract String compute(String password) throws NoSuchAlgorithmException;
	
	public abstract String compute(String password, HashType type) throws NoSuchAlgorithmException;
	
	
	protected final byte[] getSalt() throws NoSuchAlgorithmException {
		
		if ( salt == null ) {
			SecureRandom secureRandom = SecureRandom.getInstance(HashType.SHA1PRNG.name());			
			salt = new byte[16];	
			secureRandom.nextBytes(salt);		
		} 
		
		return salt;
	}
}
