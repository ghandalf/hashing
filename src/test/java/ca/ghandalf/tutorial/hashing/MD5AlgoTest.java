package ca.ghandalf.tutorial.hashing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MD5AlgoTest {

	private MD5Algo classUnderTest;
	
	@BeforeClass
	public void setUp() {
		classUnderTest = new MD5Algo();
	}
	
	@Test
	public void computeSuccesEncryption() {
		String password = "MyNameIs";
		String result = classUnderTest.compute("MyNameIs");
		
		System.out.format("%n\t\tHash Method: [%s], value to compute:[%s], result:[%s] %n%n", HashType.MD5.value(), password, result);
	}
	
}
