package ca.ghandalf.tutorial.crypto.howtodoinjava;

public enum HashType {

	MD5("MD5"), SHA1PRNG("SHA1PRNG"), 
	SHA_1("SHA-1"), SHA_256("SHA-256"), SHA_384("SHA-384"), SHA_512("SHA-512"),
	PBKDF2("PBKDF2WithHmacSHA1");
	
	private String value;
	
	private HashType(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
}
