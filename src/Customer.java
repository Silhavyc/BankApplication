import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.LinkedList;
public class Customer {
    private String firstName, lastName;
    private int pinNum;
    private List<Account> accountLinkedList = new LinkedList<>();


    public Customer(String firstName, String lastName, int pinNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinNum = pinNum;
    }

    public StringBuilder getAllAccount() {
        StringBuilder sb = new StringBuilder();
        for (Account account : accountLinkedList) {
            sb.append(account.toString() + "\n");
        }
        return sb;
    }

    public void addAccount(Account account) {
        accountLinkedList.add(account);
    }

    public void removeAccount(Account account) {
        accountLinkedList.remove(account);
    }

    public Account getAccountNumber(int accountNumber) {
        Account foundAccountNumber = null;
        for (Account account : accountLinkedList) {
            if (account.getAccountNumber()== accountNumber) {
                foundAccountNumber = account;
                break;
            }
        }
        return foundAccountNumber;
    }

    @Override
    public String toString() {
        return String.format("The name on the account is %s %s and the account PIN is %d", firstName, lastName, pinNum);
    }

    public int getPinNum() {
        return pinNum;
    }
}
