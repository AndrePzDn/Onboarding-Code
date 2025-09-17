package movies;

import movies.domain.models.Customer;
import movies.domain.models.Movie;
import movies.domain.models.PersistenceType;
import movies.domain.models.Rental;
import movies.domain.valueobjects.CustomerRecord;
import movies.services.DataManager;

public class Main {
    public static void main(String[] args) {
        DataManager<CustomerRecord> dm = new DataManager<>(
                PersistenceType.JSON,
                "./customers.json",
                CustomerRecord.class);

        CustomerRecord instance = CustomerRecord.getInstance();
        if (dm.load() != null) {
            instance = dm.load();
        }

        Customer customer = new Customer("Andre");
        customer.addRental(new Rental(new Movie("Zack Snyder's Justice League", 1), 5));
        customer.addRental(new Rental(new Movie("Terminator", 0), 1));
        customer.addRental(new Rental(new Movie("Soul", 2), 3));

        instance.add(customer);
        instance.generalStatement();

        dm.save(instance);
    }
}
