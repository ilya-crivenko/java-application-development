package demo;

import javax.xml.ws.soap.Addressing;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.util.Collections.emptyList;
import static java.util.Optional.of;

public class OperatorsDemo {
    public static void main(String[] args) {
        //region Type operators
        byte b = 0;
        int i = b; //implicit type casting

        i = Byte.MAX_VALUE + 1;
        b = (byte) i; //unary operator
        System.out.println(b);

        Object object = new Integer("1"); // polymorphism
        if (object instanceof String) {
            System.out.println(( (String) object )); // ClassCastException
        }
        //endregion

        Object obj = new Object();
        String s = "abc"; // new String("abc)
        Integer integer = 1; // new Integer(1)
        int[] array = {1,2,3}; //
        Optional maybe = of("125.7.8.6:666"); // Factory Method
        final List<Object> objects = emptyList();

        //region Arithmetics
        // + - * / %
        System.out.println( 1/3 );

        byte b1 = 1, b2 = 2;
        int i1 = b1 + b2;
        long l = i1 + 1L;
        double v = l + 1.;

        System.out.println( 1 + 2 + "3" + 4 + 5 );

        System.out.println(0./0.);
        System.out.println(POSITIVE_INFINITY == POSITIVE_INFINITY);
        System.out.println(POSITIVE_INFINITY + 1 == POSITIVE_INFINITY);
        System.out.println(NaN == NaN);
        System.out.println(NaN + 1 < NaN);
        //endregion
    }
}