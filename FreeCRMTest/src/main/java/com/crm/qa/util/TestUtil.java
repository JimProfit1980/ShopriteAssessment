package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

import org.apache.poi.ss.usermodel.WorkbookFactory;


public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	private static String firstName = "";
	private static String lastName = "";
	private static String emailAddress = "",companyName = "";
	public static String[] emailDomainName = {"outlook","gmail","mail","stiff"};
	public static String[] companyNames = {"Amazon","Google","Microsoft","Apple","Honda"};
	
	public static String TEST_DATA_PATH = System.getProperty("user.dir") + "\\FreeCRMDataFile.xlsx";
	//public static Workbook workBook;
    //public static Sheet sheet;
    private XSSFSheet sheet;
    
    // Turn flag on so you can get the logs of every event of the user story that takes place
    public static boolean WEB_EVENT_LISTENER = false;
	
	public static String createFirstName()
	{
		Random random = new Random();
		int newFirstNameRandomNumber = random.nextInt(10000);
		firstName = "Superhero" + newFirstNameRandomNumber;
		return  firstName;
	}
	
	public static String createLastName()
	{
		Random random = new Random();
		int newLastNameRandomNumber = random.nextInt(1000000);		
		lastName = "Superhero" + newLastNameRandomNumber;
		return lastName;
	}
	
	public static String createEmailAddress()
	{
		Random random = new Random();
		Random randomDomainName = new Random();
		int domainIndex = randomDomainName.nextInt(4);
		int newRandomNumber = random.nextInt(100000);	
		emailAddress = firstName.concat(".").concat(lastName).concat(newRandomNumber + "").concat(emailDomainName[domainIndex] + ".com");	
		return emailAddress;
	}
	
	public static String getCompanyName()
	{
		Random random = new Random();		
		int newRandomNumber = random.nextInt(5);	
		companyName = companyNames[newRandomNumber];	
		return companyName;
	}	
	
	/*****
	 * 
	 * Gets Test data from an excel spreadsheet. sheetIndex (starts at zero) and is used for selecting the sheet that will be used in the excel spreadsheet
	 * @param sheetIndex
	 * @return Object [Test Data]
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static Object[][] getTestData(int sheetIndex) throws EncryptedDocumentException, IOException{
		
		FileInputStream file = null;
		try {
		file = new FileInputStream(TEST_DATA_PATH);
			}
		catch(IOException fnfe) {
		fnfe.printStackTrace();
		}		
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i =0;i < sheet.getLastRowNum();i++) {
				
				for(int k = 0;k < sheet.getRow(0).getLastCellNum();k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				}
			}
	return data;
//		catch(InvalidFormatException ife) {
//		ife.printStackTrace();	
//		}
//		catch(IOException io) {
//			io.printStackTrace();
//		}
	



}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile,new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	/**
	 * A method that returns a random whole number greater than 0
	 * */
	public static int RandonNumberGenerated(int maxLengthOfRandomNumber) {
		Random randomNumber = new Random();
		int random = randomNumber.nextInt(maxLengthOfRandomNumber) + 1;
		return random;
	}	
}
