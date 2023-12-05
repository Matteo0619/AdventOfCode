package adventofcode.y2022;

import adventofcode.y2022.day11.Utility;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String s = "467..114..";

        System.out.println(s.indexOf("467"));

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
