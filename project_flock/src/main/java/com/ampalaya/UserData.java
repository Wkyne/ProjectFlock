package com.ampalaya;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserData {
    public static ArrayList<User> users = new ArrayList<>();

    // Read data from text file
    public static void readFromTextFile() {
        users.clear();  // Clear the list to avoid duplication
        try {
            File file = new File("users.txt");
            if (!file.exists()) {
                System.out.println("File 'users.txt' does not exist. Creating a new one.");
                file.createNewFile();  // Create the file if it doesn't exist
            }
            
            Scanner scanner = new Scanner(new FileReader(file));
            System.out.println("Reading from file...");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] data = line.split("\\|");
                    if (data.length == 5) {
                        // Extract user data
                        String firstName = data[0];
                        String lastName = data[1];
                        String email = data[2];
                        String studentNumber = data[3];
                        String password = data[4];

                        User user = new User(firstName, lastName, email, studentNumber, password);
                        users.add(user);
                    } else {
                        System.out.println("Skipping invalid line in file: " + line);
                    }
                }
            }
            scanner.close();

            for (User user : users) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();  // Print the full stack trace for debugging
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    // Write data to text file
    public static void writeToTextFile() {
        try {
            PrintWriter writer = new PrintWriter("users.txt");
            for (User user : users) {
                writer.println(user.toString());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Check if a user exists by email
    public static User checkUser(String email) {
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

        // Verify login credentials
        public static boolean verifyLogin(String email, String password) {
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return true;  // Login successful
                }
            }
            return false;  // Login failed
        }
}

