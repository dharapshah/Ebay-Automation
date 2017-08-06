package com.wbl.oops;

public class Employee {

	public static void main(String[] args) {
	
Employeedetails obje1=new Employeedetails();
		
		obje1.EmployeeName="Pranav";
		obje1.EmployeeId=2468;
		obje1.DepartmentName="Admin";
		obje1.TotalSalary=100000;
		obje1.Experience=36;
		
 Float Salary_Pranav= obje1.MonthlySalarycal();
		 
		 System.out.println(Salary_Pranav.toString());
		
	}

}
