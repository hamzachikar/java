package functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //function example
        System.out.println(incrementByOne(0));
        // increment by one function
        int increment=incrementByOneFunction.apply(1);
        System.out.println(increment);
        //multiply by 10 function
        int multiply=multiplyBy10Function.apply(increment);
        System.out.println(multiply);
        //increment then multiply
        System.out.println(incrementByOneFunction.andThen(multiplyBy10Function).apply(1));
        //biFunction (increment+multiply)
        System.out.println(incrementByOneAndMultiplyFunction.apply(2,10));
    }

    static Function<Integer, Integer>incrementByOneFunction= number->number+1;
    static Function<Integer, Integer>multiplyBy10Function=number->number*10;

    static int incrementByOne(int number){
        return number+1;
    }

    static BiFunction<Integer,Integer,Integer>incrementByOneAndMultiplyFunction=
        (numberToIncrementByOne,numberToMultiply)->
                (numberToIncrementByOne+1)*numberToMultiply;

    static int incrementByOneAndMultiply(int number,int numToMultiplyBy){
        return (number+1)*numToMultiplyBy;
    }
}
