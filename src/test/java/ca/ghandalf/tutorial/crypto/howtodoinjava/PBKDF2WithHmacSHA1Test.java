package ca.ghandalf.tutorial.crypto.howtodoinjava;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ca.ghandalf.tutorial.crypto.howtodoinjava.HashType;
import ca.ghandalf.tutorial.crypto.howtodoinjava.PBKDF2WithHmacSHA1;

public class PBKDF2WithHmacSHA1Test {

	private static final Logger logger = LoggerFactory.getLogger(PBKDF2WithHmacSHA1Test.class);
	
	private PBKDF2WithHmacSHA1 classUnderTest;
	
	@BeforeClass
	public void setUp() {
		classUnderTest = new PBKDF2WithHmacSHA1();
	}
	
	@Test
	public void computeSuccesEncryption() throws NoSuchAlgorithmException {
		String password = "MyNameIs";
		String result = classUnderTest.compute("MyNameIs");
		
		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", HashType.PBKDF2.value(), password, result);
		
		logger.info("passeword:[{}], result:[{}]", password, result);
		
		boolean matched = classUnderTest.validate(password, result);
		
		Assert.assertTrue(matched);
	}
}
