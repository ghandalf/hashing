package ca.ghandalf.tutorial.hashing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MD5WithSatlAlgoTest {

	private MD5WithSatlAlgo classUnderTest;
	
	@BeforeClass
	public void setUp() {
		classUnderTest = new MD5WithSatlAlgo();
	}
	
	@Test
	public void computeSuccesEncryption() {
		String password = "MyNameIs";
		String result = classUnderTest.compute("MyNameIs");
		
		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", HashType.SHA1PRNG.value(), password, result);
		
	}
}
