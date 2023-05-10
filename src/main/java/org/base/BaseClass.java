package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.apache.poi.ss.usermodel.Cell;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static  void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	public static  void windowMaximize() {
		driver.manage().window().maximize();
	}
	public static  void launchUrl(String url) {
		driver.get(url);
     }
	public static  String pageTitle() {
		String title = driver.getTitle();
		return title;}
	public static String pageUrl() {
		String url = driver.getCurrentUrl();
		return  url;}
	public static void closeBrowser() {
driver.quit();
	}
	public static void passText(String txt,WebElement ele) {
    ele.sendKeys(txt);}
	public static void clickBtn(WebElement ele) {
		ele.click();}
	public static void screenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("Locationpath//imgName.png");
		FileUtils.copyFile(img, f);}	
	
	public static Actions a;
	public static void moveToCursor(WebElement tarele) {
		a= new Actions(driver);
		a.moveToElement(tarele).perform();}
	public static void dragAndDrop(WebElement dragele,WebElement dropele) {
		a=new Actions(driver);
		a.dragAndDrop(dragele, dropele).perform();}
	public static JavascriptExecutor js;
	public static void scrollDown(WebElement ele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", ele);}
	public static void scrollUp(WebElement ele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].ScrollIntoView(false)",ele );}
	public static void ExcelRead(int getrow,int getcell,String sheetName) throws IOException {
	    File f=new File("ExcelLocation.xlsx");
	    FileInputStream fis=new FileInputStream(f);
	    Workbook w= new XSSFWorkbook(fis);
	    Sheet sheet = w.getSheet("sheetName");
	    Row row = sheet.getRow(getrow);
	    Cell c =  row.getCell(getcell);
	    int CellType =  c.getCellType();
		String s = "";
	    if (CellType==1) {
	    String val = c.getStringCellValue();System.out.println(val);}
	    else if (DateUtil.isCellDateFormatted(c)) {
	    	Date d = c.getDateCellValue();
	    	SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-YY");
	    	String val = sf.format(d);System.out.println(val);}
	    else {
			double num = c.getNumericCellValue();
			long l=(long)num;
			String val = String.valueOf(l);System.out.println(val);}}
	    public static void createNewExcel(int rownum,int cellnum,String writedata) throws IOException {
	    	File f = new File("C:\\Users\\saravnan\\eclipse-workspace\\CreateExc\\Excel\\newfile.xlsx");
	    	Workbook w = new XSSFWorkbook();
	    	Sheet cresheet = w.createSheet("Datas");
	    	Row crerow = cresheet.createRow(rownum);
	    	Cell crecell = crerow.createCell(cellnum);
	    	crecell.setCellValue(writedata);   	
	    	FileOutputStream fos = new FileOutputStream(f);
	    	w.write(fos);}
	    public static void CreateRow(int creRow,int creCell,String newdata) throws IOException {
	    	File f = new File("C:\\Users\\saravnan\\eclipse-workspace\\CreateExc\\Excel\\newfile.xlsx");
		    FileInputStream fis = new FileInputStream(f);
		    Workbook w=new XSSFWorkbook(fis);
		    Sheet s = w.getSheet("Datas");
		    Row row = s.createRow(creRow);
		    Cell cell = row.createCell(creCell);
		    cell.setCellValue(newdata);
		    FileOutputStream fos = new FileOutputStream(f);
		    w.write(fos);}
	    public static void createCell(int rownum,int cellnum,String newData) throws IOException {
	    	File f=new File("C:\\Users\\saravnan\\eclipse-workspace\\CreateExc\\Excel\\newfile.xlsx");
	    	FileInputStream fis = new FileInputStream(f);
	    	Workbook w=new XSSFWorkbook(fis);
	    	Sheet sheet = w.getSheet("Datas");
	    	Row row = sheet.getRow(rownum);
	    	Cell cell = row.createCell(cellnum);
	    	cell.setCellValue(newData);
	    	FileOutputStream fos = new FileOutputStream(f);
	    	w.write(fos);} 
	    public static void updateParticularCell (int getTheRow,int getTheCell,String existingData,String newData) throws IOException {
		  File f = new File("C:\\Users\\saravnan\\eclipse-workspace\\CreateExc\\Excel\\newfile.xlsx");
		  FileInputStream fis = new FileInputStream(f);
		  Workbook w =new XSSFWorkbook(fis);
		  Sheet s = w.getSheet("Datas");
		  Row r = s.getRow(getTheRow);
		  Cell c = r.getCell(getTheCell);
		  String str = c.getStringCellValue();
		  if (str.equals(existingData) ) {
			  c.setCellValue(newData);}
		  FileOutputStream fos = new FileOutputStream(f);
		  w.write(fos);}
	    
}