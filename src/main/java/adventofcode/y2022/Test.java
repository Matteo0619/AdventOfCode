package adventofcode.y2022;

import adventofcode.y2022.day11.Utility;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println("18736832456238468273462378467234682837487263846284238761873683245623846827346237846723468283748726384628423876".length());

        for(int i=0; i<1000; i++) {
            Utility.sum("18736832456238468273462378467234682837487263846284238761873683245623846827346237846723468283748726384628423876", "18736832456238468273462378467234682837487263846284238761873683245623846827346237846723468283748726384628423876");
        }

        System.out.println(System.currentTimeMillis() - start);

        char[] arr = "18736832456238468273462378467234682837487263846284238761873683245623846827346237846723468283748726384628423876".toCharArray();

        start = System.currentTimeMillis();

        for(int i=0; i<1000; i++) {
            Utility.sum(arr, arr);
        }
        System.out.println(System.currentTimeMillis() - start);

        List<String> list = new ArrayList<>();
        list.set(50, "abcd");
        System.out.println(list);

    }


    public static String sum(char[] add1, char[] add2) {
        int l1 = add1.length;
        int l2 = add2.length;
        int ld = l1-l2;

        String sum = "";
        int carry = 0;

        for (int i = l2-1; i >=0; i--) {

            int str = ((int)add1[i+ld] - '0') + (int)(add2[i] - '0') + carry;
            sum += (char)(str % 10 + '0');

            carry = str / 10;
        }

        for (int i = ld-1; i >= 0; i--) {
            int str = ((int)(add1[i] - '0') + carry);
            sum += (char)(str % 10 + '0');
            carry = str / 10;
        }

        if (carry > 0) {
            sum += (char) (carry + '0');
        }

        return new StringBuilder(sum).reverse().toString();
    }
}
