interface CustomerRepository { String findCustomerById(int id); }

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id){ return "Customer#" + id; }
}

class CustomerService {
    private final CustomerRepository repo;
    public CustomerService(CustomerRepository repo){ this.repo = repo; }
    public String getCustomer(int id){ return repo.findCustomerById(id); }
}

public class DependencyInjectionDemo {
    public static void main(String[] args){
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService svc = new CustomerService(repo);
        System.out.println(svc.getCustomer(42));
    }
}
