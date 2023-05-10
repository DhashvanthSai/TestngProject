package org.test;

import org.base.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleProj extends BaseClass {
	@BeforeClass
	private void tc1() {
		launchBrowser();windowMaximize();}
	
	@Test
	private void tc2() {
		launchUrl("https://www.myntra.com/");
    
	}
	@AfterClass
	private void tc4() {
closeBrowser();	}
	@Test
	private void tc3() {
System.out.println("myntra page ");
	}

}
