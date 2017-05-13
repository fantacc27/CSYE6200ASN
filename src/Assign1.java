
import java.util.Scanner;

/**
* A starter file for implementing CSYE 6200 Assignment 1
* Filename: Assign1.java
* NUID: (001664997)
* @author (Xiao Tan)
*/

public class Assign1 {

	/**
	 * The main entry point... your program starts here
	 * @param args command line arguments
	 */
	public static void main(String[] args) throws java.io.IOException {
		
                Scanner input = new Scanner(System.in);
                
		char inChar = ' ';
                
                                
                String AccountName, AccountPwd, Balance;

		String accounts[][] = {  {"Name1", "1575", "12000.00"},  {"Name2", "7721", "500.00"},  {"Name3",  "3884", "700.00"}};
                
                
                while(true){ 
                    System.out.println("Please Enter Your Name");
                   
                    AccountName = input.nextLine();
                    System.out.println("Pleas enter Your Password");
                    
                    AccountPwd = input.nextLine();
                
                    if(AccountPwd.equals(accounts[0][1]) && AccountName.equals(accounts[0][0])){
                        System.out.println("You have logined in successfully");
                        Balance = accounts[0][2];
                        break;
                    } else if(AccountPwd.equals(accounts[1][1]) && AccountName.equals(accounts[1][0])){
                        System.out.println("You have logined in successfully");
                        Balance = accounts[1][2];
                        break;
                    } else if(AccountPwd.equals(accounts[2][1]) && AccountName.equals(accounts[2][0])){
                        System.out.println("You have logined in successfully");
                        Balance = accounts[2][2];
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }        
		System.out.println("Please Enter Your Choice, to show your balance, press '1'; to obtain cash, press '2'; to quit, press '3'"); // <--- Change this prompt before submitting your code
		   do {
		   	  inChar = (char) System.in.read();
                          
                          switch(inChar){
                              
                              case '1':
                                  System.out.println("Your Balance is " + Balance);
                                  break;
                              case '2':
                                  
                                  while(true){
                                      System.out.println("Obtain cash");
                                      int WithDraw = input.nextInt();
                                      if(WithDraw <= 200){
                                            int a = WithDraw/20;
                                            int b = (WithDraw - a*20)/10;
                                            int c = (WithDraw - a*20 - b*10)/5;
                                            int d = WithDraw - a*20 - b*10 - c*5;
                                            System.out.println("You will get " + a + " $20 bills");
                                            System.out.println("You will get " + b + " $10 bills");
                                            System.out.println("You will get " + c + " $5 bills");
                                            System.out.println("You will get " + d + " $1 bills");
                                            double Balance1 = Double.parseDouble(Balance);
                                            Double Balance2 = Balance1 - WithDraw;
                                            Balance = Double.toString(Balance2);
                                               
                                            break;                                                
                                           } else if(WithDraw >200) {
                                               System.out.println("$200 is the maximum amount per transaction, please try again");
                                           }                                    
                                           
                                  }
                                  break;
                              case '3':
                              case '\n':
                              case '\r':
                                  break;                                      
                              default:
                                  System.out.println("Invalid selection");
                                  break;
                                                               
                          }
		   	 
                           // react to input and take appropriate action

	          // check for password matching

	        } 
	       while (inChar != '3'); // Exit on quit
		   System.out.println("Quiting...");
	    } 	

}
