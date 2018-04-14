package com.executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.Test;

import com.config.ActionKeywords;
import com.config.Constants;
import com.utility.ExcelUtility;

public class DriverScript {

	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static Method[] method;
	public static Properties OR;
	public static String sPageObject;
	
	
	public void driverScript() throws Exception {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass()
				.getMethods();
		

	}

	
	public void excelDataReader() throws Exception {

		String sPath = System.getProperty("user.dir") + Constants.Path_TestData;
		
		ExcelUtility.readExcel(sPath,Constants.Sheet_TestSteps);
		
    	
		
		
		for (int iRow =Constants.Col_TestScenarioID;iRow <=ExcelUtility.rowCount();iRow++){
		    
    	sActionKeyword = ExcelUtility.getCellData(iRow, Constants.Col_ActionKeyword);
    	sPageObject = ExcelUtility.getCellData(iRow, Constants.Col_PageObject);            
    	execute_Actions();
    	}
    }
	
	public void propertiesDataReader() throws Exception {
		String Path_OR =System.getProperty("user.dir") + Constants.Path_OR;
		FileInputStream fs = new FileInputStream(Path_OR);
		OR= new Properties(System.getProperties());
		OR.load(fs);		
	}

	private static void execute_Actions() throws Exception, IllegalArgumentException, InvocationTargetException {
		
		for(int i = Constants.Zero;i < method.length;i++){
	
			if(method[i].getName().equals(sActionKeyword)){
			
				method[i].invoke(actionKeywords,sPageObject);

				break;
				}
			}
		}
		
	}

	

