/*
* @author: Bianca Catalunha
* Student number: 2014305
* CA1 - Write a Java program to model an ATM machine
* April - 2016
*/
import java.util.Scanner;

class Machine 
{
    public void Machine(double a) 
    {	
        Account withdraw = new Account();//creates a new instance of Account()
		ATMCard pin = new ATMCard();//Creates an instance of ATMCard.java 

		Scanner s = new Scanner(System.in);//creates an instance of Scanner
		int attempts   = 0;//stores number of attempts 
		double amount=a;
		
		if(pin.isLocked() == true)//if the card is not locked
	    {
	    	System.out.println("Your card is locked. Please contact your bank.");//informs customer
	    	System.exit(0);//exit
	    }
	    else
	    {    	
			while((attempts < 3) || (pin.isLocked() == false))//while the user did not type the right password 
			{  			  	
	    		System.out.println("\nTo proceed to payment please enter your pin [4 digits]");
            	String userID = s.nextLine(); // get input from command line
	
				if(pin.pinOK(Integer.parseInt(userID)))//Uses the method pinOK to verify the pin that the user entered and stores in the boolean variable access
				{	    		    		
            		if( withdraw.debit(amount))//calls the method debit() and stores the result into accepted
            		{
            			System.out.println("The transaction was successful. Thank you");//prints success message
            			System.exit(0);//exit
            		}  
            		else//if the transaction was not accepted 
            		{
            			System.out.println("Transaction declined. Not enough funds. \nWould you like to try another amount? \nEnter 1 for yes or 0 for no.");
            			int retry = s.nextInt();//stores if the user wants to try again or not
            			
            			if(retry == 0)//if user does not want to retry
            			{
            				System.exit(0);//exit
            			}
            			else
            			{
            				new Machine();
            			}
            		}    	
	    		}
	    		else 
	    		{
	    			attempts++;//if pin is incorrect increments attempts
	    		
		    		System.out.println("Incorrect pin. Please, try again.\n");
		    	
		    		if((attempts > 2) || (userID.isEmpty())){ //if attempts are not less than 3
					{
						pin.lockCard();//locks card
		    			System.out.println("Your card is now locked. Please contact your bank.");//informs customer
		    			System.exit(0);//exit
					}
	    		}
	    	}	
		}
    }
}
}
