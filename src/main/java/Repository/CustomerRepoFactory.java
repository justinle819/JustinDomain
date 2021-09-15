package Repository;

public class CustomerRepoFactory {

    private CustomerRepoFactory() {}

    public static CustomerRepository createMemoryProductRepo(){
        CustomerRepository custMemory = new MemoryCustomerRepository();
        return custMemory;
    }
}
