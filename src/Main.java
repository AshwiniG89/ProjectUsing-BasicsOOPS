import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name,password, balance to create account");

        String name = sc.nextLine();
        String password=sc.nextLine();
        double balance = sc.nextDouble();
        SBIUser user= new SBIUser(name,password,balance);

        String message = user.addMoney(5000);
        System.out.println(message);

        System.out.println("Enter amount you want to withdraw");
        int money = sc.nextInt();
        System.out.println("Enter Password");
        String passord = sc.nextLine();
        System.out.println(user.withdrawMoney(1000,passord));

        System.out.println(user.calculateInterest(10));
    }
}