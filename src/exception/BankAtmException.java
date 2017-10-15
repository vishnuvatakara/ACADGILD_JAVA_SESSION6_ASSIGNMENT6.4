package exception;

public class BankAtmException extends Exception{
	public BankAtmException()
	{
		System.out.println("no sufficient balance for withdrawing");
	}

}
