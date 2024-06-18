package profile;
import java.io.IOException;
import java.util.Scanner;

public class User {
        public static final int PASSWORD_LENGTH = 8;
        Scanner input = new Scanner(System.in);
    
    public void checkUsername(){
        
        System.out.print("\nEnter the username: ");
        String name = input.next();
            
    }
        


    public  boolean is_Valid_Password(String password) {

        if (password.length() < PASSWORD_LENGTH)
              return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (is_Numeric(ch)) 
                numCount++;
            else if (is_Letter(ch))
             charCount++;
            else 
                return false;
        }

        return (charCount >= 2 && numCount >= 2);
    }

    public static boolean is_Letter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean is_Numeric(char ch){

        return (ch >= '0' && ch <= '9');
    }

}
    




