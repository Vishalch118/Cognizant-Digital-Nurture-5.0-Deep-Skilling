public class DependencyInjectionExample {

    public static void main(String[] args) {

        // Create Repository
        CustomerRepository repository =
                new CustomerRepositoryImpl();

        // Inject Repository into Service
        CustomerService service =
                new CustomerService(repository);

        // Use Service
        String customer = service.getCustomer(101);

        System.out.println(customer);
    }
}