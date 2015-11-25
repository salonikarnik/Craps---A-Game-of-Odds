import java.io.*;
import java.util.Random;


public class Assignment1 {

	static int balance = 1000;
	static int wager = 100; 	
	static int i;
	static String answer;
	int dice1,dice2,sum;
	int shooterSum;					
	int minimum = 1;
	int maximum = 6;
	String outcome;
	
	Random r = new Random();
	
	
	
	public static void main(String[] args) throws IOException {
		
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "utf-8"));		
		Assignment1 object = new Assignment1();		
		for(i=1;i<6;i++){
			System.out.println("Round " + i);
			writer.write("Round " + i + " : ");
			writer.write(System.getProperty( "line.separator" ));
			writer.write(System.getProperty( "line.separator" ));
			writer.write("Strategy" + "\t No. of Games" + "\t Ending Balance");
			writer.write(System.getProperty( "line.separator" ));
			writer.write(System.getProperty( "line.separator" ));
			writer.write(System.getProperty( "line.separator" ));
			System.out.println("Starting wager amount: "+wager);
			answer=object.even(balance,wager);
			writer.write(answer);
			writer.write(System.getProperty( "line.separator" ));
			writer.write(System.getProperty( "line.separator" ));
			System.out.println();
			answer=object.martingale(balance, wager);
			writer.write(answer);
			writer.write(System.getProperty( "line.separator" ));
			writer.write(System.getProperty( "line.separator" ));
			System.out.println();
			answer=object.reverseMartingale(balance, wager);
			writer.write(answer);
			writer.write(System.getProperty( "line.separator" ));
			writer.write(System.getProperty( "line.separator" ));
			writer.write(System.getProperty( "line.separator" ));
			writer.write(System.getProperty( "line.separator" ));
			System.out.println();			
		}//End of for loop
		
		writer.close();
		
	}//End of method main()
	
	public String even(int balance,int wager){
		
		int wagerAmount=wager;
		int endingBalance=balance;
		int noOfGames=0;
		System.out.println();
		System.out.println("Using the Even Strategy:");
		System.out.println();
		
		while(noOfGames<10){			
			
			System.out.println("\t Rolling the pair of dice");
			dice1 = r.nextInt(maximum - minimum + 1) + minimum;
			System.out.print("\t 1st Dice :" + dice1);
			dice2 = r.nextInt(maximum - minimum + 1) + minimum;
			System.out.print("\t 2nd Dice :" + dice2);
			sum = dice1 + dice2;
			System.out.println("\t Sum = "+sum);
			
			if(sum==7||sum==11)
			{
				outcome="win";
				noOfGames=noOfGames+1;	
				
				System.out.println();
				System.out.print("\t Game Number: "+ noOfGames);
				System.out.print("\t Starting Balance = "+endingBalance);
				System.out.print("\t Outcome: "+outcome);				
				
				endingBalance=endingBalance+wagerAmount;
				System.out.print("\t Ending Balance = "+endingBalance);
				if(endingBalance<Assignment1.wager)
				 {
					 wagerAmount=endingBalance;
					 endingBalance=0;
				 }
				
				else
					wagerAmount=Assignment1.wager;
				
				System.out.println("\t Next wager amount ="+wagerAmount);
				System.out.println();
				
			}
			else if(sum==2||sum==3||sum==12)
			{
				outcome="loss";
				noOfGames=noOfGames+1;				
				
				System.out.println();
				System.out.print("\t Game Number: "+ noOfGames);
				System.out.print("\t Starting Balance = "+endingBalance);
				System.out.print("\t Outcome: "+outcome);
				
				endingBalance=endingBalance-wagerAmount;
				System.out.print("\t Ending Balance = "+endingBalance);
				if(endingBalance<Assignment1.wager)
				 {
					 wagerAmount=endingBalance;
					 endingBalance=0;
				 }
				else
					wagerAmount=Assignment1.wager;
				
				System.out.println("\t Next wager amount ="+wagerAmount);
				System.out.println();
				
			}			
			else{
				System.out.println();
				System.out.println("\t Shooter's point = "+ sum); 
				
				do{
					 	dice1 = r.nextInt(maximum - minimum + 1) + minimum;
					 	System.out.print("\t 1st Dice :" + dice1);
						dice2 = r.nextInt(maximum - minimum + 1) + minimum;
						System.out.print("\t 2nd Dice :" + dice2);
						shooterSum=dice1+dice2;
						System.out.println("\t Sum = "+shooterSum);
						
						if(shooterSum==7)
							break;
						
				 }while(shooterSum!=sum);
				 
				 if(shooterSum==7){
					 noOfGames=noOfGames+1;
					 outcome="loss";
					 
					 System.out.println();
					 System.out.print("\t Game Number: "+ noOfGames);
					 System.out.print("\t Starting Balance = "+endingBalance);
					 System.out.print("\t Outcome: "+outcome);
				     
					 endingBalance=endingBalance-wagerAmount;
					 System.out.print("\t Ending Balance = "+endingBalance);
					 if(endingBalance<Assignment1.wager)
					 {
						 wagerAmount=endingBalance;
						 endingBalance=0;
					 }
					else
						wagerAmount=Assignment1.wager;
					 
					 System.out.println("\t Next wager amount ="+wagerAmount);
					 System.out.println();
					 
				 }
				 
				 else{
					 noOfGames=noOfGames+1;
					 outcome="win";
					 
					 System.out.println();
					 System.out.print("\t Game Number: "+ noOfGames);
					 System.out.print("\t Starting Balance = "+endingBalance);
					 System.out.print("\t Outcome: "+outcome);
				     
					 endingBalance=endingBalance+wagerAmount;
					 System.out.print("\t Ending Balance = "+endingBalance);
					 if(endingBalance<Assignment1.wager)
					 {
						 wagerAmount=endingBalance;
						 endingBalance=0;
					 }
					else
						wagerAmount=Assignment1.wager;
					 
					 System.out.println("\t Next wager amount ="+wagerAmount);
					 System.out.println();					 
					 
					 
				 }//End of inner else
			}//End of outer else			
			
			if(endingBalance==0)
				break;			
			
		}//End of while
		
		String result = "1 " + "\t" + String.valueOf(noOfGames) + "\t" + "\t" + "$" + String.valueOf(endingBalance);
		return result;
		
	}//End of method "even(int balance, int wager)"
	
	
	public String martingale(int balance, int wager){
		
		int wagerAmount=wager;
		int endingBalance=balance;
		int noOfGames=0;
		System.out.println();
		System.out.println();
		System.out.println("Using the Martingale System Strategy");
		System.out.println();
		while(noOfGames<10){
			
			System.out.println("\t Rolling the pair of dice");
			dice1 = r.nextInt(maximum - minimum + 1) + minimum;
			System.out.print("\t 1st Dice :" + dice1);
			dice2 = r.nextInt(maximum - minimum + 1) + minimum;
			System.out.print("\t 2nd Dice :" + dice2);
			sum = dice1 + dice2;
			System.out.println("\t Sum = "+sum);
			
			if(sum==7||sum==11)
			{
				outcome="win";
				noOfGames=noOfGames+1;	
				
				System.out.println();
				System.out.print("\t Game Number: "+ noOfGames);
				System.out.print("\t Starting Balance = "+endingBalance);
				System.out.print("\t Outcome: "+outcome);				
				
				endingBalance=endingBalance+wagerAmount;
				System.out.print("\t Ending Balance = "+endingBalance);
				
				if(endingBalance<wagerAmount){
					wagerAmount=endingBalance;
					endingBalance=0;
				}
				
				else					
				wagerAmount=Assignment1.wager;
			
				System.out.println("\t Next wager amount ="+wagerAmount);
				System.out.println();
				
			}
			
			else if(sum==2||sum==3||sum==12)
			{
				outcome="loss";
				noOfGames=noOfGames+1;				
				
				System.out.println();
				System.out.print("\t Game Number: "+ noOfGames);
				System.out.print("\t Starting Balance = "+endingBalance);
				System.out.print("\t Outcome: "+outcome);
				
				endingBalance=endingBalance-wagerAmount;
				System.out.print("\t Ending Balance = "+endingBalance);
				
				if(endingBalance<(2*wagerAmount)){
					wagerAmount=endingBalance;
					endingBalance=0;
				}
				
				else					
				wagerAmount=2*wagerAmount;
				
				System.out.println("\t Next wager amount ="+wagerAmount);
				System.out.println();
				
			}
			
			else{
				System.out.println();
				System.out.println("\t Shooter's point = "+ sum); 
				
				do{
					 	dice1 = r.nextInt(maximum - minimum + 1) + minimum;
					 	System.out.print("\t 1st Dice :" + dice1);
						dice2 = r.nextInt(maximum - minimum + 1) + minimum;
						System.out.print("\t 2nd Dice :" + dice2);
						shooterSum=dice1+dice2;
						System.out.println("\t Sum = "+shooterSum);
						
						if(shooterSum==7)
							break;
						
				 }while(shooterSum!=sum);
				 
				 if(shooterSum==7){
					 noOfGames=noOfGames+1;
					 outcome="loss";
					 
					 System.out.println();
					 System.out.print("\t Game Number: "+ noOfGames);
					 System.out.print("\t Starting Balance = "+endingBalance);
					 System.out.print("\t Outcome: "+outcome);
				     
					 endingBalance=endingBalance-wagerAmount;
					 System.out.print("\t Ending Balance = "+endingBalance);
					 
					 if(endingBalance<(2*wagerAmount)){
							wagerAmount=endingBalance;
							endingBalance=0;
						}
						
						else					
						wagerAmount=2*wagerAmount;
					 
					 System.out.println("\t Next wager amount ="+wagerAmount);
					 System.out.println();
					 
				 }
				 
				 else{
					 noOfGames=noOfGames+1;
					 outcome="win";
					 
					 System.out.println();
					 System.out.print("\t Game Number: "+ noOfGames);
					 System.out.print("\t Starting Balance = "+endingBalance);
					 System.out.print("\t Outcome: "+outcome);
				     
					 endingBalance=endingBalance+wagerAmount;
					 System.out.print("\t Ending Balance = "+endingBalance);
					 
					 if(endingBalance<wagerAmount){
							wagerAmount=endingBalance;
							endingBalance=0;
						}
						
						else					
						wagerAmount=Assignment1.wager;
					 
					 System.out.println("\t Next wager amount ="+wagerAmount);
					 System.out.println();					 
					 
					 
				 }
			}	
			
			if(endingBalance==0)
				break;
		}//End of while
		
		String result = "2 " + "\t" + String.valueOf(noOfGames) + "\t" + "\t" + "$" + String.valueOf(endingBalance);
		return result;		
		
	}//End of method "martingale(int balance, int wager)"
	
	
	public String reverseMartingale(int balance,int wager){
		
		int wagerAmount=wager;
		int endingBalance=balance;
		int noOfGames=0;
		System.out.println();
		System.out.println("Using the Reverse Martingale System Strategy");
		System.out.println();
		while(noOfGames<10){
			
			System.out.println("\t Rolling the pair of dice");
			dice1 = r.nextInt(maximum - minimum + 1) + minimum;
			System.out.print("\t 1st Dice :" + dice1);
			dice2 = r.nextInt(maximum - minimum + 1) + minimum;
			System.out.print("\t 2nd Dice :" + dice2);
			sum = dice1 + dice2;
			System.out.println("\t Sum = "+sum);
			
			if(sum==7||sum==11)
			{
				outcome="win";
				noOfGames=noOfGames+1;	
				
				System.out.println();
				System.out.print("\t Game Number: "+ noOfGames);
				System.out.print("\t Starting Balance = "+endingBalance);
				System.out.print("\t Outcome: "+outcome);	
				endingBalance=endingBalance+wagerAmount;
				System.out.print("\t Ending Balance = "+endingBalance);
				if(endingBalance<(2*wagerAmount)){
					wagerAmount=endingBalance;
					endingBalance=0;
				}
				
				else					
				wagerAmount=2*wagerAmount;
				
				System.out.println("\t Next wager amount ="+wagerAmount);
				System.out.println();
				
			}
			
			else if(sum==2||sum==3||sum==12)
			{
				outcome="loss";
				noOfGames=noOfGames+1;				
				
				System.out.println();
				System.out.print("\t Game Number: "+ noOfGames);
				System.out.print("\t Starting Balance = "+endingBalance);
				System.out.print("\t Outcome: "+outcome);				
				endingBalance=endingBalance-wagerAmount;
				System.out.print("\t Ending Balance = "+endingBalance);
				
				if(endingBalance<wagerAmount){
					wagerAmount=endingBalance;
					endingBalance=0;
				}
				
				else					
				wagerAmount=Assignment1.wager;
				
				System.out.println("\t Next wager amount ="+wagerAmount);
				System.out.println();
				
			}
			
			else{
				System.out.println();
				System.out.println("\t Shooter's point = "+ sum); 
				
				do{
					 	dice1 = r.nextInt(maximum - minimum + 1) + minimum;
					 	System.out.print("\t 1st Dice :" + dice1);
						dice2 = r.nextInt(maximum - minimum + 1) + minimum;
						System.out.print("\t 2nd Dice :" + dice2);
						shooterSum=dice1+dice2;
						System.out.println("\t Sum = "+shooterSum);
						
						if(shooterSum==7)
							break;
						
				 }while(shooterSum!=sum);
				 
				 if(shooterSum==7){
					 noOfGames=noOfGames+1;
					 outcome="loss";
					 
					 System.out.println();
					 System.out.print("\t Game Number: "+ noOfGames);
					 System.out.print("\t Starting Balance = "+endingBalance);
					 System.out.print("\t Outcome: "+outcome);
				     
					 endingBalance=endingBalance-wagerAmount;
					 System.out.print("\t Ending Balance = "+endingBalance);
					 if(endingBalance<wager)
					 {
						 wagerAmount=endingBalance;
						 endingBalance=0;
					 }
					 
					 else
						 wagerAmount=Assignment1.wager;
					 
					 System.out.println("\t Next wager amount ="+wagerAmount);
					 System.out.println();
					 
				 }
				 
				 else{
					 noOfGames=noOfGames+1;
					 outcome="win";
					 
					 System.out.println();
					 System.out.print("\t Game Number: "+ noOfGames);
					 System.out.print("\t Starting Balance = "+endingBalance);
					 System.out.print("\t Outcome: "+outcome);
				     
					 endingBalance=endingBalance+wagerAmount;
					 System.out.print("\t Ending Balance = "+endingBalance);
						if(endingBalance<(2*wagerAmount)){
							wagerAmount=endingBalance;
							endingBalance=0;
						}
						
						else					
						wagerAmount=2*wagerAmount;
						
					 System.out.println("\t Next wager amount ="+wagerAmount);
					 System.out.println();					 
					 
					 
				 }
			}
			
		    if(endingBalance==0)
			    	break;
		}
		
		String result = "3 " + "\t" + String.valueOf(noOfGames) + "\t" + "\t" + "$" + String.valueOf(endingBalance);
		return result;	
		
	}//End of method "reverseMartingale(int balance, int wager)"
	
}//End of Class 
