package ca.ghandalf.tutorial.crypto.howtodoinjava;

import java.security.NoSuchAlgorithmException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ca.ghandalf.tutorial.crypto.howtodoinjava.HashType;
import ca.ghandalf.tutorial.crypto.howtodoinjava.SHAHashing;

public class SHAHashingTest {

	private SHAHashing classUnderTest;

	@BeforeClass
	public void setUp() {
		classUnderTest = new SHAHashing();
	}

	@Test
	public void computeSuccesEncryption() throws NoSuchAlgorithmException {
		HashType type = HashType.SHA_1;

		String password = "MyNameIs";
		String result = classUnderTest.compute("MyNameIs");

		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", type, password, result);

		type = HashType.SHA_256;
		result = classUnderTest.compute("MyNameIs", type);

		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", type, password, result);

		type = HashType.SHA_384;
		result = classUnderTest.compute("MyNameIs", type);

		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", type, password, result);

		type = HashType.SHA_512;
		result = classUnderTest.compute("MyNameIs", type);

		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", type, password, result);
	}
}
