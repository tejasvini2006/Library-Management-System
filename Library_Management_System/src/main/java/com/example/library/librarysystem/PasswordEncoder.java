package com.example.library.librarysystem;

import java.util.Scanner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	    	
	// Create a BCryptPasswordEncoder instance
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    
    String rawPassword = sc.next();

    // Encrypt the password
    String encryptedPassword = encoder.encode(rawPassword);

    // Print the encrypted password
    System.out.println("Encrypted Password: " + encryptedPassword);
}
}
