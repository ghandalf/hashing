package ca.ghandalf.tutorial.hashing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PBKDF2WithHmacSHA1HashingTest {

	private static final Logger logger = LoggerFactory.getLogger(PBKDF2WithHmacSHA1HashingTest.class);
	
	private PBKDF2WithHmacSHA1Hashing classUnderTest;
	
	@BeforeClass
	public void setUp() {
		classUnderTest = new PBKDF2WithHmacSHA1Hashing();
	}
	
	@Test
	public void computeSuccesEncryption() {
		String password = "MyNameIs";
		String result = classUnderTest.compute("MyNameIs");
		
		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", HashType.PBKDF2.value(), password, result);
		
		logger.info("passeword:[{}], result:[{}]", password, result);
		
		boolean matched = classUnderTest.validate(password, result);
		
		Assert.assertTrue(matched);
	}
}
