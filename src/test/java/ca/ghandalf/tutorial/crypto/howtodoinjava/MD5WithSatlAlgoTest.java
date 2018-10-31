package ca.ghandalf.tutorial.crypto.howtodoinjava;

import java.security.NoSuchAlgorithmException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ca.ghandalf.tutorial.crypto.howtodoinjava.HashType;
import ca.ghandalf.tutorial.crypto.howtodoinjava.MD5WithSatlAlgo;

public class MD5WithSatlAlgoTest {

	private MD5WithSatlAlgo classUnderTest;
	
	@BeforeClass
	public void setUp() {
		classUnderTest = new MD5WithSatlAlgo();
	}
	
	@Test
	public void computeSuccesEncryption() throws NoSuchAlgorithmException {
		String password = "MyNameIs";
		String result = classUnderTest.compute("MyNameIs");
		
		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", HashType.SHA1PRNG.value(), password, result);
		
	}
}
