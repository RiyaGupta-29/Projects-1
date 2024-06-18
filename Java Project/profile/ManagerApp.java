package profile;
import Expense.*;
import java.util.Scanner;


public class ManagerApp {

	public static void main(String[] args){
            User u= new User(); 
            Menu M =new Menu();
            char ch;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t ***WELCOME TO THE DAILY EXPENSES MANAGER APP*** ");
            System.out.println("*** your login credentials ***");
		    u.checkUsername();
            System.out.print(
                "1. A password must have at least eight characters.\n" +
                "2. A password consists of only letters and digits.\n" +
                "3. A password must contain at least two digits \n" +
                "Input a password (You are agreeing to the above Terms and Conditions.): ");
                String s = sc.nextLine();  
            
        if (u.is_Valid_Password(s)) {
            System.out.println("Password is valid: " + s);
            System.out.println("would you like to-\n a.save\t b.log out:");
            char enter=sc.next().charAt(0);
             if(enter=='a'||enter=='A'){
                  do{
              System.out.println("Application includes :\n 1. display information\n 2. Add information\n 3. update information\n 4.delete information\n 5. Logout");
              System.out.println("enter the choice: ");
                  int choice=sc.nextInt();
                  System.out.println("please wait......");
                  switch(choice){
                              case 1:
                                    M.display();
                                    break;
                              case 2:
                                    M.AddExpense();
                                   break;
                               case 3:
                                    M.updateExpense();
                                    break;
            
                              case 4:
                                    M.DeleteExpense();
                                    break;
                  
                              case 5:
                                    System.out.println(" you have successfully logged out");
                                    sc.close();
                                    break;
                              default:
                                    System.out.println(" you have enter the wrong choice!!! ");
                                    break;
                              }
                              System.out.println("do you what to do more changes?(Y/N)");
                              ch=sc.next().charAt(0);
                        }while(ch=='Y'|| ch=='y');
              }
              else if(enter=='b'|| enter=='B'){
                  System.out.println(" you have successfully logged out");
                  sc.close(); 
                  }
               else{
                  System.out.println("you have entered wrong!!!!");
                }
            }
            else {
            System.out.println("Not a valid password: " + s);
            
        }
       }     
}