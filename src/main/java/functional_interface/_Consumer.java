package functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer maria=new Customer("Maria","99999");

        greetCustomer(maria);
        //consumer
        System.out.println("consumer function");
        greetCostumerConsumer.accept(maria);
        //biconsumer
        greetCostumerBiConsumer.accept(maria,false);
    }
    static void greetCustomer(Customer customer){
        System.out.println("Hello "+customer.customerName+", thanks for registring phone number "+customer.customerPhoneNumber);
    }
    static BiConsumer<Customer,Boolean> greetCostumerBiConsumer=
            (customer,showPhoneNumber) ->{
                System.out.println("Hello "
                        +customer.customerName+
                        ", thanks for registring phone number "
                        +(showPhoneNumber? customer.customerPhoneNumber:"***************"));
            };
    static Consumer<Customer>greetCostumerConsumer=customer ->
        System.out.println("Hello "
                +customer.customerName+
                        ", thanks for registring phone number "
                +customer.customerPhoneNumber);

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName,String customerPhoneNumber){
            this.customerName=customerName;
            this.customerPhoneNumber=customerPhoneNumber;
        }
    }
}
