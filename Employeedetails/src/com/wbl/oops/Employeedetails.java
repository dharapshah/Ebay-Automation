package com.wbl.oops;

public class Employeedetails {
		public String EmployeeName;
		public int EmployeeId;
		public String DepartmentName;
		public float TotalSalary;
		public int Experience;
		
		public float MonthlySalarycal(){
		float Result=0;
		
		Result=TotalSalary/12;
		
	
		return Result; 
		
	
		}
		
}
