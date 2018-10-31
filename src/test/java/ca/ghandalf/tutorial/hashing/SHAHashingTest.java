package ca.ghandalf.tutorial.hashing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SHAHashingTest {

	private SHAHashing classUnderTest;

	@BeforeClass
	public void setUp() {
		classUnderTest = new SHAHashing();
	}

	@Test
	public void computeSuccesEncryption() {
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
