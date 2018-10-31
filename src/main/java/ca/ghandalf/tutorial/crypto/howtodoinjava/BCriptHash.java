package ca.ghandalf.tutorial.crypto.howtodoinjava;

import java.security.NoSuchAlgorithmException;

public class BCriptHash extends Hashing {

	@Override
	public String compute(String password) throws NoSuchAlgorithmException {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	@Override
	public String compute(String password, HashType type) throws NoSuchAlgorithmException {
		return this.compute(password);
	}

	public boolean validate(String currentPassword, String storedPassword) {
		return BCrypt.checkpw(currentPassword, storedPassword);
	}
}
