package org.base;


	import java.io.File;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.RichTextString;
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

	import io.github.bonigarcia.wdm.WebDriverManager;


	public class BaseClass1 {	

		private static final String url = null;
		public static WebDriver driver;
		
	   public static void launchBrowser() {
	      WebDriverManager.chromedriver().setup();
	      driver = new  ChromeDriver();
	}
		
		public static void windowMaximize() {
			 driver.manage().window().maximize();

		}
		
	
		

		
		public static void launchUrl(String Url) {
		  driver.get(Url);

		}
		
		public static String pageTitle() {
			String title = driver.getTitle();
			return title;

		}
		
		public static String pageUrl() {
			String curntUrl = driver.getCurrentUrl();
			return url;
		}
		
		public static void passText(String txt , WebElement ele) {
			ele.sendKeys(txt);
			
		}
		
		
		public static void closeEntireBrowser() {
			driver.quit();
		}
		
		public void clickBtn(WebElement e) {
		  e.click();
		}
		
		public static void screenShot(String imgName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File img = ts.getScreenshotAs(OutputType.FILE);
			File f = new File("location + imageName.png");
			FileUtils.copyFile(img, f);
		}
		
		public static Actions a;
		private void moveTheCursor(WebElement targetWebElement) {
			a=new Actions(driver);
			a.moveToElement(targetWebElement).perform();
		}
		
		public static void dragDrop(WebElement dragWebElement ,WebElement dropElement) {
		  a= new Actions(driver);
		  a.dragAndDrop(dragWebElement, dropElement).perform();
		}
		
		public static JavascriptExecutor js;
		private void scrollIntoView(WebElement tarWebElement) {
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].screenIntoView(true)", tarWebElement);
		}
		
		public static void scroll(WebElement element) {
			js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].screenIntoView(false)", element);
		}
		
		public static void libreOfficeRead(String sheetName, int rowNum, int cellNum) throws FileNotFoundException {
		 File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\LibreOffice");
		 FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(); 
		Sheet sheet = wb.getSheet("Datas");
		Row r = sheet.getRow(rowNum);
	    Cell c = r.getCell(cellNum);
	    int cellType = c.getCellType();
		
		String value =" ";
		if (cellType ==1) {
			RichTextString value2 = c.getRichStringCellValue();
		}
		
		else if (DateUtil.isCellInternalDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String format = s.format(dd);
		}
		
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			String valueOf = String.valueOf(l);
		  }
		}
		
		
		public static void createNewLibreFile(int rowNum, int cellNum, String WriteData) throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\LibreOffice\\newFile.xlsx");
		Workbook wb = new XSSFWorkbook();
	    Sheet newSheet = wb.createSheet("Datas");
	    Row newRow = newSheet.createRow(rowNum);
	    Cell newCell = newRow.createCell(cellNum);
	    newCell.setCellValue(WriteData);
	    FileOutputStream fos = new FileOutputStream(f);
	    wb.write(fos);
		}
		
	  public static void createCell(int getRow, int creCell, String newData) throws IOException  {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\LibreOffice\\newFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
	    Workbook wb = new XSSFWorkbook();
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(getRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		
		}
	  
	  public static void createRow(int creRow, int creCell, String newData) throws IOException {
	    File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\LibreOffice\\newFile.xlsx");
	    FileInputStream fis = new FileInputStream(f);
	    Workbook wb = new XSSFWorkbook();
	    Sheet s = wb.getSheet("Datas");
	    Row r = s.createRow(creRow);
	    Cell c = r.createCell(creCell);
	    c.setCellValue(newData);
	    FileOutputStream fos = new FileOutputStream(f);
	    wb.write(fos);

	}
		
		public static void updateDataToParticularCell(int getTheRow, int getTheCell, String existingData, String writeNewData) throws IOException {
	 	 File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\MavenProject\\LibreOffice\\newFile.xlsx");
	 	 FileInputStream fis = new FileInputStream(f);
	 	 Workbook wb = new XSSFWorkbook();
	     Sheet s = wb.getSheet("Datas");
	     Row r = s.getRow(getTheRow);
	     Cell c = r.getCell(getTheCell);
	     String string = c.getStringCellValue();
	     if (string.equals(existingData)) {
			c.setCellValue(writeNewData);
		FileOutputStream fos = new FileOutputStream(f);
	     wb.write(fos);
		}	
	}	
	}







