package org.calculator.junit;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the ID number
        System.out.print("Enter your South African ID number: ");
        String id = scanner.nextLine();

        // Validate the ID number and process it
        boolean isValid = isIdNumberValid(id);
        if (isValid) {
            System.out.println("ID number is valid!");
            displayIdDetails(id);
        } else {
            System.out.println("Invalid SA ID number.");
        }
    }

    // Function to check if the ID number is valid
    public static boolean isIdNumberValid(String id) {
        if (id.length() != 13) return false;

        // Check if all characters are digits
        if (!id.matches("\\d+")) return false;

        // Extract date parts
        String yy = id.substring(0, 2);
        String mm = id.substring(2, 4);
        String dd = id.substring(4, 6);

        return isValidDate(yy, mm, dd);
    }

    // Validate the extracted date intelligently
    public static boolean isValidDate(String yy, String mm, String dd) {
        try {
            int year = Integer.parseInt(yy);
            int month = Integer.parseInt(mm);
            int day = Integer.parseInt(dd);

            int currentYear = LocalDate.now().getYear() % 100;
            int century = (year > currentYear) ? 1900 : 2000;
            int fullYear = century + year;

            // Attempt to create a valid date
            LocalDate.of(fullYear, month, day);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Display the details based on the ID number
    public static void displayIdDetails(String id) {
        String yy = id.substring(0, 2);
        String mm = id.substring(2, 4);
        String dd = id.substring(4, 6);
        String genderCode = id.substring(6, 10); // Next 4 digits represent gender
        char citizenship = id.charAt(10); // Citizenship (0 or 1)

        int year = Integer.parseInt(yy);
        int currentYear = LocalDate.now().getYear() % 100;
        int fullYear = (year > currentYear) ? (1900 + year) : (2000 + year);

        LocalDate dob = LocalDate.of(fullYear, Integer.parseInt(mm), Integer.parseInt(dd));

        // Determine gender
        String gender = Integer.parseInt(genderCode) < 5000 ? "Female" : "Male";

        // Determine citizenship
        String citizenshipStatus = citizenship == '0' ? "South African Citizen" : "Permanent Resident";

        // Calculate age
        int age = calculateAge(dob);

        // Output the details
        System.out.println("Date of Birth : " + dob);
        System.out.println("Gender        : " + gender);
        System.out.println("Citizenship   : " + citizenshipStatus);
        System.out.println("Age           : " + age);
    }

    // Calculate age from DOB
    public static int calculateAge(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
