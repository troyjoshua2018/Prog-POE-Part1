/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/*
 * Author: Troy Joshua
 * Date: 10 April 2026
 * Program: ChatAppP1
 * Description: Validates username, password, and phone number input.
 */
// Source: Oracle Java Documentation - Character Class
// https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html

package com.mycompany.chatappp1;

import java.util.Scanner;

public class ChatAppP1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Username
        System.out.print("Enter a username that contains an underscore and is no more than five characters long:\n");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("Username successfully captured!");
        } else {
            System.out.println("Username is not correctly formatted; please ensure your username contains an underscore and is no more than five characters in length.");
        }

        // Password
        System.out.print("Enter a password that contains at least eight characters, an uppercase letter, a number and a special character:\n");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password successfully captured!");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character!");
        }

        // Phone Number
        System.out.print("Enter a phone number with international country code (e.g. +27123456789):\n");
        String phoneNumber = scanner.nextLine();

        if (isValidPhoneNumber(phoneNumber)) {
            System.out.println("Phone number successfully captured!");
        } else {
            System.out.println("Phone number is not correctly formatted; please ensure it contains an international country code and no more than 10 digits after it.");
        }

        scanner.close();
    }

    // Username Validation
    public static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    // Password Validation
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasUppercase && hasDigit && hasSpecial;
    }

    // Phone Number Validation
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\+\\d{1,3}\\d{10}$");
    }
}
