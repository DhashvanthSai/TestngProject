package org.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitPro {
	
	@Test
	public  void tc1() {
System.out.println("Test Case 1");
	}
	@BeforeClass
	public static  void tc4() {
System.out.println("Launch browser");
	}
	@Test
	public void tc3() {
System.out.println("TestCase 3");
	}
	@AfterClass
	public static   void tc2() {
System.out.println("Close browser");
	}

}
