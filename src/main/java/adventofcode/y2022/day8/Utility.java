package adventofcode.y2022.day8;

import java.util.*;
import java.util.stream.Collectors;

public class Utility {

    public static boolean isBorder(int i, int j, int row, int col) {
        return i == row-1 || i == 0 || j == col-1 || j == 0;
    }

    public static boolean isVisible(String[][] arr, int i, int j) {
        int value = Integer.parseInt(arr[i][j]);
        List<String> listR = Arrays.asList(arr[i]);
        List<String> listC = Arrays.asList(getColumn(arr, j));
        return isVisible(listR.subList(0, j+1), value) || isVisible(listR.subList(j, listR.size()), value) ||
                isVisible(listC.subList(0, i+1), value) || isVisible(listC.subList(i, listC.size()), value);

    }

    public static int getView(String[][] arr, int i, int j) {

        int value = Integer.parseInt(arr[i][j]);
        List<String> listR = Arrays.asList(arr[i]);
        List<String> listC = Arrays.asList(getColumn(arr, j));
        int viewR = getView(listR.subList(j+1, listR.size()), value);
        int viewD = getView(listC.subList(i+1, listC.size()), value);
        Collections.reverse(listR);
        Collections.reverse(listC);
        int viewL = getView(listR.subList(listR.size() - j, listR.size()), value);
        int viewU = getView(listC.subList(listC.size() - i, listC.size()), value);
        Collections.reverse(listR);
        Collections.reverse(listC);

        return viewR * viewL * viewU * viewD;
    }

    private static String[] getColumn(String[][] arr, int c) {
        String[] col = new String[arr[0].length];

        for(int i=0; i<arr[0].length; i++) {
            col[i] = arr[i][c];
        }

        return col;
    }

    private static  boolean isVisible(List<String> list, int value) {
        List<Integer> l = list.stream().map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return l.get(0) == value && !l.get(0).equals(l.get(1));
    }

    private static int getView(List<String> list, int value) {
        int counter = 0;
        for (String s : list) {
            counter++;
            if (Integer.parseInt(s) >= value) {
                return counter;
            }
        }
        return counter;
    }
}
