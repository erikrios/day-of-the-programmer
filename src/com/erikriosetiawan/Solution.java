package com.erikriosetiawan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {

        // Determine is Julian Calendar or Gregorian Calendar
        boolean isJulianCalendar;
        if (year <= 1917 && year >= 1700)
            isJulianCalendar = true;
        else
            isJulianCalendar = false;

        // Determine is leap year
        boolean leapYear;
        if (isJulianCalendar) {
            if (year % 4 == 0)
                leapYear = true;
            else
                leapYear = false;
        } else {
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
                leapYear = true;
            else
                leapYear = false;
        }

        List<Integer> months = new ArrayList<>();
        months.add(0, 31);
        if (year == 1918) months.add(1, 15);
        else if (leapYear) months.add(1, 29);
        else months.add(1, 28);
        months.add(2, 31);
        months.add(3, 30);
        months.add(4, 31);
        months.add(5, 30);
        months.add(6, 31);
        months.add(7, 31);

        // Determine date of the programmer
        final int dayOfTheProgrammer = 256;
        int dateOfTheProgrammer;

        int sumOfMonths = 0;
        for (int i = 0; i < months.size(); i++) {
            sumOfMonths += months.get(i);
        }

        dateOfTheProgrammer = dayOfTheProgrammer - sumOfMonths;
        return dateOfTheProgrammer + "." + "0" + (months.size() + 1) + "." + year;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
