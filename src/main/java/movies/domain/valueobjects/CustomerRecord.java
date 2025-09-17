package movies.domain.valueobjects;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import movies.domain.models.Customer;
import movies.domain.models.Rental;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerRecord {
    private static CustomerRecord instance;

    @XmlElementWrapper(name = "customers")
    @XmlElement(name = "customer")
    public List<Customer> customers;

    private CustomerRecord() {
        this.customers = new ArrayList<>();
    }

    public static CustomerRecord getInstance() {
        if (instance == null) {
            instance = new CustomerRecord();
        }

        return instance;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void add(Customer customer) {
        for (Customer each : customers) {
            if (!each.getName().equals(customer.getName())) {
                continue;
            }

            for (Rental rental : customer.getRentals()) {
                each.addRental(rental);
            }
            return;
        }

        customers.add(customer);
    }

    public void generalStatement() {
        for (Customer customer : customers) {
            System.out.println(customer.statement());
            System.out.println();
            System.out.println("==========================================");
            System.out.println();
        }
    }
}
