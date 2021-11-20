package com.testingshastra.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	int x,y,result=0;
	double d1,d2,dresult=0;
	String first,second;
	List<Integer> numbers;
	@Then("print result")
	public void print_result() {
		System.out.println("Result="+result);
	}
	
	@When("I add them")
	public void m2() {
		result = x+y;
	}
	
	@Given("I have {int} and {int}")
	public void i_have_and(Integer int1, Integer int2) {
		x=int1;
		y=int2;
	}
	
	@Given("I have two words like {string} and {string}")
	public void m1(String first, String second) {
		this.first=first;
		this.second=second;
	}
	@Then("print them in alphabetic order")
	public void arrangeInAlphabeticOrder() {
		if(first.compareTo(second)==0) {
			System.out.println("Strings are identical");
		}else if(first.compareTo(second)>0) {
			System.out.println(second+" "+first);
		}else {
			System.out.println(first+" "+second);
			
		}
	}
	
	@Given("I have two float numbers {float} and {float}")
	public void i_have_two_float_numbers(float double1, float double2) {
		d1=double1;
		d2=double2;
	}

	@Then("add both float numbers")
	public void add_both_float_numbers() {
		dresult=d1+d2;
	}

	@Then("Print float result")
	public void print_float_result() {
		System.out.println("Double result: "+dresult);
	}
	
	@Given("I have following number:")
	public void i_have_following_number(io.cucumber.datatable.DataTable dataTable) {
	 numbers = dataTable.asList(Integer.class);
	}
	
	@Then("print all numbers from list")
	public void print_list_items() {
		for (Integer integer : numbers) {
			System.out.println(integer);
		}
	}
	
	@Given("I have following table:")
	public void get_numbers_from_table(DataTable table) {
		List l = table.row(0);
		System.err.println(l);
	}
	
	@Then("print them in row column format")
	public void print_in_row_column_format() {

	}
	
	@Then("verify if result is prime")
	public void verify_if_result_is_prime() {
		int count = 0;
		for(int i=1;i<result;i++) {
			if(result%i==0) {
				count++;
			}
		}
		if(count>2) {
			System.out.println("Result is NOT prime: "+result);
		}else {
			System.out.println("Result is Prime: "+result);
		}
	}
	
	@Given("I have two numbers from {int}")
	public void readNumbersFromExcel(int rowNum) throws IOException {
		FileInputStream fis = new FileInputStream("src/test/resources/numbers.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheetAt(0);
		x = (int) sheet.getRow(rowNum).getCell(1).getNumericCellValue();
		y = (int) sheet.getRow(rowNum).getCell(2).getNumericCellValue();
	}
}
