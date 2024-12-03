package adventofcode.y2024.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondExercise {

    public static boolean isSafe(List<String> levels) {
        if (levels == null || levels.size() < 2) {
            return false; // Not enough levels to compare
        }

        boolean isIncreasing = Integer.parseInt(levels.get(1)) > Integer.parseInt(levels.get(0));
        boolean isDecreasing = Integer.parseInt(levels.get(1)) < Integer.parseInt(levels.get(0));

        // Iterate through the levels to check differences and direction consistency
        for (int i = 1; i < levels.size(); i++) {
            int diff = Math.abs(Integer.parseInt(levels.get(i)) - Integer.parseInt(levels.get(i-1)));

            // Check if the difference is between 1 and 3
            if (diff < 1 || diff > 3) {
                return false; // Unsafe if difference is out of range
            }

            // Ensure the sequence is either strictly increasing or decreasing
            if (Integer.parseInt(levels.get(i)) > Integer.parseInt(levels.get(i-1))) {
                if (isDecreasing) return false; // Inconsistent sequence, was decreasing but found an increase
                isIncreasing = true;
            } else if (Integer.parseInt(levels.get(i)) < Integer.parseInt(levels.get(i-1))) {
                if (isIncreasing) return false; // Inconsistent sequence, was increasing but found a decrease
                isDecreasing = true;
            }
        }

        return true; // If we passed all checks, the report is safe
    }

    // Method to check if a report can be made safe by removing one level
    public static boolean canBeSafeByRemovingOne(List<String> levels) {
        for (int i = 0; i < levels.size(); i++) {
            List<String> modifiedLevels = new ArrayList<>(levels);
            modifiedLevels.remove(i); // Remove the element at index i

            // Check if the modified list is safe
            if (isSafe(modifiedLevels)) {
                return true; // If removing this element makes the report safe
            }
        }
        return false; // If no single removal makes it safe
    }

    // Method to count safe reports considering the Problem Dampener
    public static int countSafeReports(List<List<String>> reports) {
        int safeCount = 0;
        for (List<String> report : reports) {
            // If the report is safe or can be made safe by removing one level, count it as safe
            if (isSafe(report) || canBeSafeByRemovingOne(report)) {
                safeCount++;
            }
        }
        return safeCount;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("res/2024/day2/input.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String line = null;

        List<List<String>> list = new ArrayList<>();

        while ((line = buffer.readLine()) != null) {

            String[] arr = line.split(" ");
            List<String> l = new ArrayList<>(List.of(arr));
            list.add(l);
        }


        // Count safe reports
        System.out.println("Number of safe reports: " + countSafeReports(list));
    }

}
