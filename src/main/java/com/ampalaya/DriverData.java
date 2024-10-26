package com.ampalaya;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class DriverData {
    public static ArrayList<Driver> drivers = new ArrayList<>();

    // Read data from text file
    public static void readFromTextFile() {
        drivers.clear();  // Clear the list to avoid duplication
        try {
            File file = new File("drivers.txt");
            System.out.println("File path: " + file.getAbsolutePath());  // Print the file path
            if (!file.exists()) {
                System.out.println("File 'drivers.txt' does not exist. Creating a new one.");
                file.createNewFile();  // Create the file if it doesn't exist
            }
    
            try (Scanner scanner = new Scanner(new FileReader(file))) {  // Use try-with-resources
                System.out.println("Reading from file...");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    if (!line.isEmpty()) {
                        String[] data = line.split("\\|");
                        if (data.length == 5) {
                            // Extract driver data
                            String firstName = data[0];
                            String lastName = data[1];
                            String email = data[2];
                            String licenseNumber = data[3];
                            String password = data[4];
    
                            Driver driver = new Driver(firstName, lastName, email, licenseNumber, password);
                            drivers.add(driver);
                        } else {
                            System.out.println("Skipping invalid line in file: " + line);
                        }
                    }
                }
    
                for (Driver driver : drivers) {
                    System.out.println(driver);
                }
    
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
    
        } catch (Exception e) {
            e.printStackTrace();  // Print the full stack trace for debugging
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
    

    // Write data to text file
    public static void writeToTextFile() {
        try {
            PrintWriter writer = new PrintWriter("drivers.txt");
            for (Driver driver : drivers) {
                writer.println(driver.toString());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Verify login credentials
    public static boolean verifyLogin(String email, String password) {
        for (Driver driver : drivers) {
            if (driver.getEmail().equals(email) && driver.getPassword().equals(password)) {
                return true;  // Login successful
            }
        }
        return false;  // Login failed
    }

    // Check if a driver exists by email
    public static Driver checkDriver(String email) {
        for (Driver driver : drivers) {
            if (email.equals(driver.getEmail())) {
                return driver;
            }
        }
        return null;
    }
}

