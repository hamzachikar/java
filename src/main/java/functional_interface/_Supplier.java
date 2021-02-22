package functional_interface;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {

        System.out.println(getDBConnection());

        System.out.println(getDBConnectionSupplier.get());
    }

    static Supplier<String>getDBConnectionSupplier=()-> "jdbc://localhost:3030";

    static String getDBConnection(){
        return "jdbc://localhost:3030";
    }
}
