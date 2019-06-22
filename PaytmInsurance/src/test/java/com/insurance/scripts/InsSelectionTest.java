package com.insurance.scripts;

import org.testng.annotations.Test;
import com.insurance.generic.BaseLib;
import com.insurance.features.ChooseInsType;
import com.insurance.features.Choose2WDetails;
import com.insurance.features.ChooseCarDetails;
import com.insurance.features.ChooseHealthDetails;
import com.insurance.generic.ExcelUtilities;

public class InsSelectionTest extends BaseLib
{
	@Test(description="to verify the selection of car insurance ")
	public void chooseInsurance1()
	{
		ExcelUtilities eu=new ExcelUtilities("/home/anuratnakumar/workspace/PaytmInsurance/testdata/ReadExcel.xls");
		String insType=eu.readData("Sheet2", 1, 1);
		ChooseInsType cit=new ChooseInsType(driver);
		ChooseCarDetails ccd=new ChooseCarDetails(driver);
		cit.chooseIns(insType);
		cit.fillCarDataIns();
		ccd.Model();
		ccd.variant();
		ccd.RTO();
		ccd.policyExpiry();
	}
	
	
	/*@Test(description="to verify the selection of two wheeler insurance ")
	public void chooseInsurance4()
	{
		ExcelUtilities eu=new ExcelUtilities("/home/anuratnakumar/workspace/PaytmInsurance/testdata/ReadExcel.xls");
		String insType=eu.readData("Sheet2", 4, 1);
		ChooseInsType cit=new ChooseInsType(driver);
		Choose2WDetails cwd=new Choose2WDetails(driver);
		cit.chooseIns(insType);
		cit.fill2WDataIns();
		cwd.Make();
		cwd.Model();
		cwd.variant();
		cwd.RTO();
		cwd.policyExpiry();
	}
	
	@Test(description="to verify the selection of health insurance ")
	public void chooseInsurance2()
	{
		ExcelUtilities eu=new ExcelUtilities("/home/anuratnakumar/workspace/PaytmInsurance/testdata/ReadExcel.xls");
		String insType=eu.readData("Sheet2", 2, 1);
		ChooseInsType cit=new ChooseInsType(driver);
		ChooseHealthDetails chd=new ChooseHealthDetails(driver);
		cit.chooseIns(insType);
		chd.relations();
		
		
	}
	*/

}
