package adventofcode.y2022.day11;

public class Utility {

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) {
            return "0";
        }

        int result[] = new int[len1 + len2];

        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = len1 - 1; i >= 0; i--) {

            int carry = 0;
            int n1 = num1.charAt(i) - '0';

            i_n2 = 0;

            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;

                carry = sum / 10;

                result[i_n1 + i_n2] = sum % 10;

                i_n2++;
            }

            if (carry > 0) {
                result[i_n1 + i_n2] += carry;
            }

            i_n1++;
        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }

        if (i == -1) {
            return "0";
        }

        String s = "";

        while (i >= 0) {
            s += (result[i--]);
        }

        return s;
    }

    public static String sum(String str1, String str2) { //

        if (str1.length() > str2.length()){
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        String str = "";

        int n1 = str1.length(), n2 = str2.length();

        str1=new StringBuilder(str1).reverse().toString();
        str2=new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++) {

            int sum = ((int)(str1.charAt(i) - '0') + (int)(str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');

            carry = sum / 10;
        }

        for (int i = n1; i < n2; i++) {
            int sum = ((int)(str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        if (carry > 0) {
            str += (char) (carry + '0');
        }

        str = new StringBuilder(str).reverse().toString();

        //System.out.println(new StringBuilder(str1).reverse().toString() + " + " +  new StringBuilder(str2).reverse().toString() + " = " + str);
        return str;
    }

    public static boolean isDivisible(String str, int div) {

        int remain = 0;

        for(int i=0; i<str.length(); i++) {
            int value = Integer.parseInt(String.valueOf(str.charAt(i)));
            remain = (value+remain*10) % div;
        }

        return remain == 0;

    }

}
