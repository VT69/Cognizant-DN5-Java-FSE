public interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        
        if (id == 1) {
            return "Customer [ID: 1, Name: Alice Johnson]";
        } else if (id == 2) {
            return "Customer [ID: 2, Name: Bob Smith]";
        } else {
            return "Customer [ID: " + id + "] Not Found in Database.";
        }
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomerDetails(int id) {
        String customerData = customerRepository.findCustomerById(id);
        System.out.println(customerData);
    }
}

class TestDependencyInjection {
    public static void main(String[] args) {
        System.out.println("--- Dependency Injection Test ---");
        
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        CustomerService service = new CustomerService(repository);
        
        System.out.println("Looking up Customer 1:");
        service.displayCustomerDetails(1);

        System.out.println("\nLooking up Customer 2:");
        service.displayCustomerDetails(2);

        System.out.println("\nLooking up Customer 99:");
        service.displayCustomerDetails(99);
    }
}