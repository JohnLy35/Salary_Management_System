package Salary_Management_System;

public class Driver {

	public static void main(String[] args)
	{
		salaryRaise sR = new salaryRaise();
		sR.create("src\\Salary_Management_System\\yes.txt");
		System.out.println("~~~~ yes.txt ~~~~");
		sR.display("yes.txt");
		System.out.println("~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
		
		sR.addTo("src\\Salary_Management_System\\yes.txt", "src\\Salary_Management_System\\test.txt", 3, 400000.00, 1);
		sR.addTo("src\\Salary_Management_System\\test.txt", "src\\\\Salary_Management_System\\\\yes.txt", 5, 500000.00, 2);
		sR.addTo("src\\Salary_Management_System\\yes.txt", "src\\Salary_Management_System\\test.txt", 15, 800000.00, 5);
		sR.addTo("src\\\\Salary_Management_System\\\\test.txt", "src\\\\Salary_Management_System\\yes.txt", 7, 700000.00, 3);
		sR.addTo("src\\Salary_Management_System\\yes.txt", "src\\Salary_Management_System\\test.txt", 10, 600000.00, 2);
		System.out.println("~~~~ test.txt ~~~~");
		sR.display("src\\Salary_Management_System\\test.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
		
		sR.removeFrom("src\\Salary_Management_System\\test.txt", "src\\Salary_Management_System\\test2.txt", 3);
		System.out.println("~~~~ test2.txt ~~~~");
		sR.display("src\\Salary_Management_System\\test2.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
		sR.addService("src\\Salary_Management_System\\test.txt", "src\\Salary_Management_System\\test3.txt");
		System.out.println("~~~~ test3.txt ~~~~");
		sR.display("src\\Salary_Management_System\\test3.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
		sR.raise("src\\Salary_Management_System\\test.txt", "src\\Salary_Management_System\\test4.txt", 2, 2.5);
		System.out.println("~~~~ test4.txt ~~~~");
		sR.display("src\\Salary_Management_System\\test4.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
		sR.create("src\\Salary_Management_System\\yes.txt");
		sR.addTo("src\\Salary_Management_System\\yes.txt", "src\\Salary_Management_System\\test5.txt", 6, 400000.00, 5);
		sR.addTo("src\\Salary_Management_System\\test5.txt", "src\\Salary_Management_System\\yes.txt", 4, 500000.00, 7);
		sR.addTo("src\\Salary_Management_System\\yes.txt", "src\\Salary_Management_System\\test5.txt", 9, 600000.00, 2);
		sR.addTo("src\\Salary_Management_System\\test5.txt", "src\\Salary_Management_System\\yes.txt", 1, 500000.00, 4);
		sR.addTo("src\\Salary_Management_System\\yes.txt", "src\\Salary_Management_System\\test5.txt", 12, 600000.00, 5);
		System.out.println("~~~~ test5.txt ~~~~");
		sR.display("src\\Salary_Management_System\\test5.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
		
		sR.mergeFiles("src\\Salary_Management_System\\test.txt", "src\\Salary_Management_System\\test5.txt", "src\\Salary_Management_System\\test6.txt");
		System.out.println("~~~~ test6.txt ~~~~");
		sR.display("src\\Salary_Management_System\\test6.txt");
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println();
		
	}
}