package ca.ghandalf.tutorial.crypto.howtodoinjava;

import java.security.NoSuchAlgorithmException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ca.ghandalf.tutorial.crypto.howtodoinjava.BCriptHash;
import ca.ghandalf.tutorial.crypto.howtodoinjava.HashType;

public class BCriptHashTest {

	private BCriptHash classUnderTest;
	
	@BeforeClass
	public void setUp() {
		classUnderTest = new BCriptHash();
	}
	
	@Test
	public void computeSuccesEncryption() throws NoSuchAlgorithmException {
		String password = "MyNameIs";
		String result = classUnderTest.compute("MyNameIs");
		
		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", HashType.MD5.value(), password, result);
		
		System.out.format("passeword:[%s], result:[%s]%n", password, result);
		
		Assert.assertTrue(classUnderTest.validate(password, result));
	}
}
