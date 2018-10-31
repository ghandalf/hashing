package ca.ghandalf.tutorial.crypto.howtodoinjava;

import java.security.NoSuchAlgorithmException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ca.ghandalf.tutorial.crypto.howtodoinjava.HashType;
import ca.ghandalf.tutorial.crypto.howtodoinjava.MD5Algo;

public class MD5AlgoTest {

	private MD5Algo classUnderTest;
	
	@BeforeClass
	public void setUp() {
		classUnderTest = new MD5Algo();
	}
	
	@Test
	public void computeSuccesEncryption() throws NoSuchAlgorithmException {
		String password = "MyNameIs";
		String result = classUnderTest.compute("MyNameIs");
		
		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", HashType.MD5.value(), password, result);
	}
	
}
