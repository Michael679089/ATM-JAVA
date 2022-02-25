package Com.ciit;

// Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Custom Imports
import java.time.LocalDateTime; // import the LocalDateTime class


public class AtmMachine 
{
	public static void main(String[] args) throws IOException 
	{
		//Important (BufferedReader , InputStreamReader)
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		// Variables
		Boolean Account = false;
		String userID = "";
		String passWord = "";
		String confirmPass = "";
		String confirmID = ""; 
		int withDraw = 0;
		int deposit = 0;
		int totalMoney = 0;
		
		char userInput = ' ';
		
		while (userInput != 'q' && userInput != 'Q') 
		{
			System.out.println("Hello and welcome to MJ's ATM!");
			System.out.println("L -> Login\nC -> Create new Account\nQ -> Quit");
			System.out.print("> ");
			userInput = reader.readLine().charAt(0);
			
			
			
			
			//Login page
			if ((userInput == 'L' || userInput == 'l') && Account == false) 
			{
				System.out.println("Please create an account first\n");
				
			}
			else if ((userInput == 'L' || userInput == 'l') && Account == true) 
			{
				System.out.print("Please enter your user id: ");
				confirmID = reader.readLine();				
				System.out.print("Please enter your password: ");
				confirmPass = reader.readLine();
				
				if (confirmPass.isBlank() || confirmPass.isEmpty()){ 
					System.out.println("empty input");
					break;
				}
				
				if (confirmPass.contentEquals(passWord) && confirmID.contentEquals(userID) && Account == true)
				{
					System.out.println("Access Granted!");			
					char userInput2 = 0;

					while (userInput2 != 'L') 
					{						
						System.out.println(" ");
						System.out.println("Hello #" + userID + ", welcome back!");
						System.out.println("Your balance is: $" + totalMoney);
						System.out.println("W -> Withdraw money\nD -> Deposit money\nR - Request balance\nL -> Log Out");
						userInput2 = reader.readLine().charAt(0);
						
						switch (userInput2) 
						{
							case 'W':
							case 'w':
								System.out.println();
								System.out.println("Please input the Amount you want to withdraw (Input Numerical Integers, ex: 1 to 100)?");
								System.out.print(">$"); 
								withDraw = Integer.parseInt(reader.readLine());
								if (totalMoney >= withDraw) {
									totalMoney -= withDraw;
								}
								else if (totalMoney < withDraw) {
									System.out.println("[Not enough Balance left!]");
								}
								break;
							case 'D':
							case 'd':
								System.out.println();
								System.out.println("Please input the Amount you want to deposit (Input Numerical Integers, ex: 1 to 100)?");
								System.out.print(">$");
								deposit = Integer.parseInt(reader.readLine());
								totalMoney += deposit;
								break;
							case 'L':
							case 'l':
								System.out.println();
								System.out.println("You just logged out...\n");
								confirmID = "";
								confirmPass = "";
								break;
							case 'R':
							case 'r':
									System.out.println();
									System.out.println("Your Balance is: "+totalMoney); 
									break;
							default:
								System.out.println("wrong input\n");
								break;
						}
					}
				}
				else if (confirmPass.contentEquals(passWord) == false && confirmID.contentEquals(userID) == true) 
				{
					System.out.println("******** LOGIN FAILED! ********");
					System.out.println("\npassword clue: " + passWord);
				}
				else if (confirmPass.contentEquals(passWord) == true && confirmID.contentEquals(userID) == false) 
				{
					System.out.println("******** LOGIN FAILED! ********");
					System.out.println("\nUser ID clue: " + userID);
				}
				else if (confirmPass.contentEquals(passWord) == false && confirmID.contentEquals(userID) == false) 
				{
					System.out.println("******** LOGIN FAILED! ********");
					System.out.println("Oh no you forgot your password and user id! Don't worry this is a demo\n");
					System.out.println("Password: "+passWord);
					System.out.println("User ID: "+userID);
					System.out.println("\n");
				}
			}
			
			
			
			
			
			// Create account
			else if (userInput == 'C' || userInput == 'c') 
			{
				System.out.println("Creating an Account Page");
				System.out.println("Please Input your UserID and Password. (UserID & Password can be both AlphaNumeric, ex: Password123)");
				System.out.print("UserID: ");				
				userID = reader.readLine();
				System.out.print("password: ");
				passWord = reader.readLine();
				
				if (passWord.isBlank() || passWord.isEmpty()) {
					System.out.println("It can't be empty");
				}
				
				System.out.print("Confirm password: ");
				confirmPass = reader.readLine();
				System.out.println(confirmPass.equals(passWord));

				if (passWord.contentEquals(confirmPass) == true) 
				{
					System.out.println(" ");
					System.out.println("Account Info");
					System.out.println("UserID: " + userID);
					System.out.println("Password: " + passWord); 
					System.out.println(" ");
					System.out.println("Thank You! Your account has been created!");
					Account = true;
				}
				else if (passWord.contentEquals(confirmPass) == false) 
				{
					System.out.println(" ");
					System.out.println("Passwords are not equal, try again.\n");
					Account = false; 
					passWord = "";
					userID = "";
					userInput = ' ';
				}
			}
			
			else 
			{
				System.out.println("Invalid input");
			}	
		}
		// End of ATM Machine
		//Clear Screen Makeshift
		for (int i = 0; i < 50; ++i) System.out.println(); 
		System.out.println("Thanks for stopping by and have a nice day!");
		System.out.print("Date: "); 
		LocalTime(args);
	}
	 public static void LocalTime(String[] args) {
		 LocalDateTime myDateTime = LocalDateTime.now();
		 System.out.println(myDateTime);
		 
		  }
}
