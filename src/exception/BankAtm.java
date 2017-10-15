package exception;

import java.util.Scanner;

public class BankAtm {
	//intializing variables
	int atmid;
	String bankname,location;
	static double balance=0;
	static double amt;
	Scanner sc=new Scanner(System.in);
	public void read() //raeding input details
	{	
		System.out.println("enter the atm id");
		atmid=sc.nextInt();
		System.out.println("enter the bank name");
		bankname=sc.next();
		System.out.println("enter the location");
		location=sc.next();
		
	}
	public void transaction()
	{
		System.out.println("enter the amount of transaction");
		amt=sc.nextDouble();
	}
	public void withdraw(double amt)
	{	this.amt=amt;
		try //exception code
		{
			if((balance-amt)<10000||amt>balance)
			{
				throw new BankAtmException(); //throwing to user defined exception
			}
			else
				{
				balance=balance-amt;
				System.out.println(balance);
				}
			
		}
		catch(BankAtmException ae)	//handling exception
		{
			ae.printStackTrace();
		}
		
	}
	public void deposit(double amt)
	{
		this.amt=amt;
		balance=balance+amt;
		System.out.println(balance);
	}
	public static void main(String args[])
	{	int x;
		Scanner ss=new Scanner(System.in);
		BankAtm obj=new BankAtm();
		obj.read();
		do
		{	//menu driven program
		System.out.println("enter the choice 1=deposit 2=withdraw 3=exit");
		x=ss.nextInt();
		switch(x)
		{
		case 1:obj.transaction();obj.deposit(amt);break;
		case 2:obj.transaction();obj.withdraw(amt);break;
		default:System.out.println("exitting");
		}
		}while(x!=3);
		
	}
}
