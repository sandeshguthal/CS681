package edu.umb.cs681.hw14;
public class ThreadSafeBankAccountRunnable {

	public static void main(String[] args) {
		
		
		ThreadSafeBankAccount accBankAccess = new ThreadSafeBankAccount();
		DepositRunnable deposit= new DepositRunnable(accBankAccess);
		WithdrawRunnable withdraw = new WithdrawRunnable(accBankAccess);

		Thread [] depositsThread = new Thread [5];
		for (int i = 0; i < 5; i++)
		{
			depositsThread[i] = new Thread(deposit);
		}
		Thread [] withdrawalThreads = new Thread [5];
		for (int i = 0; i < 5; i++)
		{
			withdrawalThreads[i] = new Thread(withdraw);
		}

		for (int i = 0; i < 5; i++)
		{
			depositsThread[i].start();
		}

		for (int i = 0; i < 5; i++)
		{
			withdrawalThreads[i].start();
		}
		deposit.setDone();
		withdraw.setDone();

		for (int i = 0; i < 5; i++)
		{
			depositsThread[i].interrupt();
		}

		for (int i = 0; i < 5; i++)
		{
			withdrawalThreads[i].interrupt();
		}
		
		try {
			for (int i = 0; i < 5; i++)
			{
				depositsThread[i].join();
			}
			
			for (int i = 0; i < 5; i++)
			{
				withdrawalThreads[i].join();
			}

			
		}catch(InterruptedException e) {
			
		}
		
		

	}

}


