package maven_java_framework.java_selenium_examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class java_programs {

	@Description(" Reverse string and check palindrome")
	@Test
	public void reverseString() {
		String name = "madam";
		String reverse = "";

		// Iterate through the string in reverse order
		for (int i = name.length() - 1; i >= 0; i--) {
			reverse += name.charAt(i); // Correctly append characters
		}

		// Output the reversed string
		System.out.println("Reversed string: " + reverse);

		// Check palindrom string
		if (name.equalsIgnoreCase(reverse)) {
			System.out.println("its palindrom");

		} else {
			System.out.println("its not palindrom");
		}
	}

	
	
	@Test
	public void prinrepatedchar() {

		String input = "my name is nagaraj";
		StringBuilder checked = new StringBuilder(); // To track processed characters

		// Outer loop to pick each character
		for (int i = 0; i < input.length(); i++) {
			char currentChar = input.charAt(i);

			// Skip already processed characters
			if (checked.toString().indexOf(currentChar) != -1) {
				continue;
			}

			// Inner loop to count occurrences of the current character
			int count = 0;
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == currentChar) {
					count++;
				}
			}

			// Mark the character as processed
			checked.append(currentChar);

			// Print the result
			System.out.println("Character '" + currentChar + "' repeated " + count + " times.");
		}
	}

	
	
	@Test
	public void revwords() {
		String name = "My name is nagaraj";
		String[] split = name.split(" ");
		String rev = " ";

		for (int i = split.length - 1; i >= 0; i--) {
			rev = rev + split[i] + " ";
		}
		System.out.println(rev);

	}
	
	

	@Test
	public void RevStringbuilder() {
		StringBuilder str = new StringBuilder("abcd abc");

		// Convert StringBuilder to String to use split()
		String[] split = str.toString().split(" ");

		// Print reversed string
		System.out.println(str.reverse());

	}
	
	
	
	
	
	
}
