package com.palle;

import java.util.Scanner;

public class Results {

	public static void main(String[] args) 
	{
		Employee e = new Employee();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number between 1 to 5");
		int x=sc.nextInt();
		
		if(x==1) 
		{
			e.creating();
		}
		else if(x==2)
		{
			e.inserting(1,"ramesh", 20000);
			e.inserting(2,"suresh", 30000);
			e.inserting(3,"umesh", 40000);
		} 
		
		else if(x==3)
		{
			e.update(2,"rakesh", 25000);
		}
		else if(x==4) 
		{
			e.delete(3);
		}
		else if(x==5)
		{
			e.exit();
		}

	}

}
