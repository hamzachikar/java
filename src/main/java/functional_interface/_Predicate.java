package functional_interface;

import java.sql.PreparedStatement;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        //without predicate
        System.out.println(isPhoneNumValid("07000000000"));
        System.out.println(isPhoneNumValid("06000000000"));
        //call the predicate function
        System.out.println(isPhoneNumValidPredicate.test("06000000000"));
        //call for a chain of predicate
        System.out.println(isPhoneNumValidPredicate.and(containsNum3).test("07000000030"));

        System.out.println(isTheSame.test("07000000000","07000000001"));
    }

    //the predicate function
    static Predicate<String> isPhoneNumValidPredicate=phoneNumber->
                                phoneNumber.startsWith("07")&&phoneNumber.length()==11;

    static Predicate<String> containsNum3=phoneNumber->phoneNumber.contains("3");

    static BiPredicate<String,String> isTheSame=(num1,num2)->num1.equalsIgnoreCase(num2);

    static boolean isPhoneNumValid(String phoneNumber){
        return phoneNumber.startsWith("07")&&phoneNumber.length()==11;
    }
}
