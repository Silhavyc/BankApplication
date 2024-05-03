import java.util.Scanner;

public class Account extends Teller{
    private double balance;
    private   int accountNumber;
    private static int numOfAccounts=1000;


    public Account(double initialDeposit,String name, int tellerID){
        super(name,tellerID);
        this.balance = initialDeposit;
        this.accountNumber = Account.numOfAccounts++;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double depositAmount){
        //System.out.println("enter in the amount you would like to deposit");
        //int depositAmount = Integer.parseInt(scanner.nextLine());
        balance += depositAmount;
        System.out.println("You have deposited " + depositAmount);
        System.out.println("you now have a balance of " + balance);

    }
    public  void withdraw(double withdrawAmmount){
       // System.out.println("enter in amount you would like to withdraw");
        //int withdrawAmmount = Integer.parseInt(scanner.nextLine());
        if (withdrawAmmount> balance){
            System.out.println("you have insufficient funds for this withdraw");
        }else{
            balance = balance - withdrawAmmount;
            System.out.println("you now have a balance of " + balance);
        }
    }
    public  String toString(){
        return String.format("accountNumber = %d\nBalance: %.2f" , accountNumber , balance);

    }

    public double getBalance() {
        return balance;
    }
}
