import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bank {
    private List<Customer> customerLinkedList = new LinkedList<>();

    public StringBuilder getAllCustomers() {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customerLinkedList) {
            sb.append(customer.toString() + "\n");
        }
        return sb;
    }

    public void addCustomer(Customer customer) {

        customerLinkedList.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customerLinkedList.remove(customer);
    }

    public Customer getCustomerName(int pinNumber) {
        Customer foundCustomerName = null;
        for (Customer customer : customerLinkedList) {
            if (customer.getPinNum()== pinNumber) {
                foundCustomerName = customer;
                break;
            }
        }
        return foundCustomerName;
    }
}
