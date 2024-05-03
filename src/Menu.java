import java.util.Scanner;

public class Menu {
        private Scanner scanner = new Scanner(System.in);
        private Teller bank = new Teller("CHRIS",2517);
        public void displayMenu()
        {
            while (true){
                String select;
                System.out.printf("\n%s Menu %s\n","*".repeat(10),"*".repeat(10));
                System.out.print("Please make a selection: \n"+
                        "1) Accesss account\n" +
                        "2) Open a New Account\n" +
                        "3) Close All Accounts\n" +
                        "4) Exit\n" +
                        ">>" );
                select = scanner.nextLine();
                if (select.equals("1")){
                    accessAccount();
                } else if (select.equals("2")) {
                    createNewCustomer();

                } else if (select.equals("3")) {
                    closeAllAccounts();
                } else if (select.equals("4")) {
                    System.out.println("Exiting... :9");
                    break;
                }else {
                    System.out.println("Invalid Entry");
                }

            }
        }
        private void accessAccount() {
        Account account;
            System.out.println("Enter in your account Pin");
            int pin = Integer.parseInt(scanner.nextLine());
            Customer customer = bank.getCustomerName(pin);
            if (customer == null) {
                System.out.println("INVALID PIN!");
                return;
            }
            System.out.println("Active Accounts:");
            System.out.println(customer.getAllAccount());
            System.out.println("enter in which account you want to view");
            int accountNumber= Integer.parseInt(scanner.nextLine());
            account = customer.getAccountNumber(accountNumber);
            if (account == null) {
                System.out.println("INVALID ACCOUNT!");
                return;
            }
            while (true){
                String select;
                System.out.print("Please make a selection: \n"+
                        "1) Make a deposit\n" +
                        "2) Withdraw\n" +
                        "3) Account Balance\n" +
                        "4)Close All Accounts\n"+
                        "5) Exit\n" +
                        ">>" );
                select = scanner.nextLine();
                if (select.equals("1")){
                    System.out.println("enter in the amount you would like to deposit");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    account.deposit(depositAmount);
                } else if (select.equals("2")) {
                    System.out.println("enter in amount you would like to withdraw");
                    double withdrawAmmount = Double.parseDouble(scanner.nextLine());
                    account.withdraw(withdrawAmmount);
                } else if (select.equals("3")) {
                    System.out.println("Account Number:"+account.getAccountNumber());
                    System.out.println("Account Balance:"+ account.getBalance());
                } else if (select.equals("4")) {
                    System.out.println("Account Closed: "+account.getAccountNumber());
                } else if (select.equals("5")) {
                    System.out.println("Exiting... :9");
                    break;
                }else {
                    System.out.println("Invalid Entry");
                }

        }
        }
        private void createNewCustomer(){
            System.out.println(bank); // display teller info
            String newCustomer;
            Customer customer;
            Account account;
            System.out.println("Are you new to the bank?\n 1) YES\n 2)No");
            newCustomer = scanner.nextLine();
            if (newCustomer.equals("1")) {
            customer = createCustomer();
            }else {
                System.out.println("Please enter PIN :");
                customer = bank.getCustomerName(Integer.parseInt(scanner.nextLine()));
                if (customer==null){
                    System.out.println("Youre wrong try again!");
                    return;
                }
            }
            System.out.println("Please Enter your Initial deposit amount!");
            double deposit = Double.parseDouble(scanner.nextLine());
            account = new Account(deposit,bank.getTellerName(), bank.getTellerID());
            customer.addAccount(account);
            System.out.printf("new account opened: %d \nwith teller %s ID %d",account.getAccountNumber(),bank.getTellerName(),bank.getTellerID());
        }
        private Customer createCustomer() {
            String firstName, lastName;
            int accountPIN;
            Customer customer;
            Account account;
            System.out.println("Enter in customer first name: ");
            firstName = scanner.nextLine();
            System.out.println("Enter in customers lastname: ");
            lastName = scanner.nextLine();
            System.out.printf("Enter in Pin for %s %s: ", firstName, lastName);
            accountPIN = Integer.parseInt(scanner.nextLine());
            customer = new Customer(firstName, lastName, accountPIN);
            bank.addCustomer(customer);
            return customer;
        }

        private void closeAllAccounts(){
            Customer customer;
            Account account;
            System.out.println("Enter in the PIN");
            int pinNumber= Integer.parseInt(scanner.nextLine());
            customer= bank.getCustomerName(pinNumber);
            if (customer== null){
                System.out.println("PIN is wrong try again");
                return;
            }
            bank.removeCustomer(customer);
            System.out.println("your accounts are closed");

        }

    }


