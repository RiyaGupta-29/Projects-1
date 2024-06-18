package Expense;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Menu{
    String date;
    String item;
    double cost;
	Scanner sc=new Scanner(System.in);
     
	public void display(){
     System.out.println("Are you sure you want to view the log?(Y/N)");
     char choice=sc.next().charAt(0);
     
     if(choice=='Y'|| choice=='y'){
        try{
         File f= new File("daily_expense.txt");
         FileReader fr= new FileReader(f);
         BufferedReader br = new BufferedReader(fr);
         String line;
         while((line=br.readLine())!= null){
         System.out.println(line);
         }
          br.close();
          System.out.println("file is readed successfully");
          
       }catch(Exception e){
         System.out.println(e);
       }
     }
     else
     	sc.close();
	}
	public void AddExpense(){
            System.out.println(" no. of expenses you want to add: ");
            int a=sc.nextInt();
             Log[] lg = new Log[a]; 
            for(int i=0;i<a;i++){
                  lg[i]= new Log();
                  System.out.println("\t\t\t EXPENSE"+(i+1)); 
                  System.out.println(" enter the date");
                  date=sc.next();
                   lg[i].Setdate(date);
                  System.out.println(" enter item");
                  item=sc.next();
                  lg[i].Setitem(item);
            try{
            System.out.println("enter cost");
            cost=sc.nextDouble();
               lg[i].Setcost(cost);
                if(cost<0){
                throw new IllegalArgumentException();
                }
            }catch(IllegalArgumentException e){
                System.out.println("you cannot write negative number!!!!!\n write again:");
                 cost=sc.nextDouble();
                 lg[i].Setcost(cost);
                }
             catch(InputMismatchException e){
                System.out.println("***NO LETTERS***\n you can write number only !!!!!\n write again:");
                sc.next();
                cost=sc.nextDouble();
                lg[i].Setcost(cost);
           }
       
        }

        try{
         File f= new File("daily_expense.txt");
         FileWriter fw= new FileWriter(f,true);
         BufferedWriter bw = new BufferedWriter(fw);
         for(int i=0; i<a;i++){
         bw.write("\n");
         bw.write((i+1)+lg[i].date+","+lg[i].item+","+lg[i].cost);
         bw.write("\n"); 
         }
          bw.close();
          System.out.println("file is saved successfully");
       }catch(Exception e){
         System.out.println(e);
       }
   	}
public void updateExpense()
{
try{ 
String filePath = "daily_expense.txt";
Scanner input = new Scanner(new File(filePath));
StringBuffer buffer = new StringBuffer();
while (input.hasNextLine()) {
   buffer.append(input.nextLine()+"\t"+System.lineSeparator());
}
String fileContents = buffer.toString();
System.out.println("Contents of the file: "+"\t"+fileContents);
input.close();

System.out.println("write word  which you want to update");
String oldLine =sc.nextLine();
boolean flag=false;
int count = 0;
System.out.println("Contents of the line");
      //Reading the contents of the file
      Scanner sc2 = new Scanner(new FileInputStream("daily_expense.txt"));
      while(sc2.hasNextLine()) {
         String line = sc2.nextLine();
         System.out.println(line);
         if(line.indexOf(oldLine)!=-1) {
            flag = true;
            count = count+1;
         }
      }
      if(flag) {
         System.out.println("File contains the specified word");
         System.out.println("Number of occurrences is: "+count);
      } else {
         System.out.println("File does not contain the specified word");
      }
System.out.println("write new word that you want to add");
String newLine =sc.nextLine();
//Replacing the old line with new line
fileContents = fileContents.replaceAll(oldLine, newLine);
//instantiating the FileWriter class
FileWriter writer = new FileWriter(filePath);
System.out.println("");
System.out.println("new data: "+fileContents);
writer.append(fileContents);
writer.flush();
}catch(Exception e){
    System.out.println(e);
}
}

	public void DeleteExpense(){
    System.out.println("Are you sure you want to delete the file?(Y/N)");
     char dchoice=sc.next().charAt(0);
     if(dchoice=='Y'||dchoice=='y'){
        try{
          File f= new File("daily_expense.txt");
          if(f.delete()){
            System.out.println(f.getName()+"is deleted");
          }
          else 
            System.out.println("failed");
          }catch(Exception e){
            System.out.println(e);
          }
        }
    else
        sc.close();   
}

}
