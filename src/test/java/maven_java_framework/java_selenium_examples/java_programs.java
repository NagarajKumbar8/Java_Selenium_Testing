package maven_java_framework.java_selenium_examples;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class java_programs<Interger> {

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

		for (int i = split.length - 1; i >= 0; i--)
		{
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
	
	@Test
	public void duplicates_in_array() {
		
		int a[] = {1,2,1,3,4,3,6,4};
		
		HashSet<Integer> seen=new HashSet<Integer>(); 
		HashSet<Integer> duplicates=new HashSet<Integer>();
		
		for (int num : a)
		{
			if ( !seen.add(num)) {
				
				duplicates.add(num);
			}
			
		}
		
		System.out.println(duplicates);
	}
	
	
	@Test
	public void duplicates_str_array() {
		
		List<String> names= Arrays.asList("nagu","akash","nagu","akash","guru");
		
		Set<String> seen=new HashSet<String>(); 
		Set<String> duplicates=new HashSet<String>();
		
		for (String  name : names)
		{
			if ( !seen.add(name)) {
				
				duplicates.add(name);
			}
			
		}
		
		System.out.println(duplicates);
	}
	
	
	@Test //find unique numbers
	public void remove_duplicates() {
		
		//int a[] = {1,2,1,3,4,3,6};
		
		List<Integer> arr=Arrays.asList(1,2,1,3,4,3,6);
		
		Set<Integer>  unique= new HashSet<Integer>(arr);
		
		System.out.println(unique);
		
		
	}
	
	
	@Test
	public void countfrequency_of_char() {
		
		
		String name= "nagaraj";
		
		Map<Character, Integer> count= new HashMap<>();
		
		
		for (char c : name.toCharArray() ) {
			
			count.put(c, count.getOrDefault(c, 0) + 1);  //method used -  getOrDefault
		}
		System.out.println(count);
	}
	
	
	@Test
	public void replace_space_in_string(){
		
		String s="n a ga r a j";
		
		String output=s.replaceAll("\\s", "");  //  \\s whitespace
		
		System.out.println(output);
		
	}
	
	
	@Test
	public void str_split_iterat()
	{
		
		String str="My name is nagaraj";
		
		String[] words=str.split(" ");
		
		for (String s : words)
		{
			System.out.println(s);
		}
		
	}
	
	@Test
	public void compare_two_str() {
		
		
		String s1="abc";
		String s2="abc";
		
		System.out.println(s1 == s2);
		//False  - reference check
		
		System.out.println(s1.equals(s2));
		//true - Value check
	}
	
	@Test
	public void print_even_num() {
		
		List<Integer> list=Arrays.asList(1,2,4,5,2,7,8,9,12);
		
		list.stream().filter(e  -> e%2 ==0) .forEach(System.out::println);
		
		
	}
	
	
	
	
	
	
}
