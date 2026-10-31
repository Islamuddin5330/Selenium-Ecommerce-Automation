package EcommerceTestCases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PracticeQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Even or odd number
		int[] num = { 1, 2, 3, 4, 56, 7, 8, 17, 9, 10 };
		for (int i = 0; i < num.length; i++) {
			if (num[i] % 2 == 0) {
//				System.out.print(i);
//				System.out.print(" | ");
				System.out.println(num[i] + " is even");
			} else {
				System.out.println(num[i] + " is an odd");
			}
		}

		// Find the largest of three numbers
		int[] numbers = { 12, 45, 29, 67, 34 };
//		 int largest = 12;
		int largest = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > largest) {
				largest = numbers[i];
			}
		}
		System.out.println(largest + " is a greater number");

		// Print a multiplication table
		int[] num3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < num3.length; i++) {
			System.out.println(num3[i] + " * 5 = " + (num3[i] * 5));
		}

		// Reverse a number
		int numb = 1234;
		int rev = 0;
		while (numb > 0) {
			//When we divide a number by 10, the remainder gives us its last digit. =here we got 4
			int digit = numb % 10;
			rev = rev * 10 + digit;
			//Because numb is an int, Java performs integer division and removes the last digit.
			numb = numb / 10;
		}
		System.out.println("Reversed number: " + rev);

		// Count the digits
		int[] count = { 5, 8, 3, 2, 1 };
		for (int i1 = 0; i1 < count.length; i1++) {
		}
		System.out.println(count.length);

		// Check a palindrome number
		int palin = 1221;
		int original = palin;
		int reverse = 0;

		while (palin > 0) {
			int digit = palin % 10;
			reverse = reverse * 10 + digit;
			palin = palin / 10;
		}
		if (original == reverse) {
			System.out.println("Palindrome number");
		} else {
			System.out.println("Not a palindrome number");
		}

		// Find factorial
		int fact = 5;
		int factorial = 1;
		for (int i = 1; i <= fact; i++) {
			factorial = factorial * i;
		}
		System.out.println("Factorial of 5 is : " + factorial);

		// Find the second-largest number
		int[] numbers1 = { 10, 5, 8, 10, 7 };
		int largest1 = numbers1[0];
		int secondLargest = Integer.MIN_VALUE;

		for (int i = 0; i < numbers1.length; i++) {

			if (numbers1[i] > largest1) {
				secondLargest = largest1;
				largest1 = numbers1[i];
			} else if (numbers1[i] > secondLargest && numbers1[i] < largest1) {
				secondLargest = numbers1[i];
			}
		}

		System.out.println("Largest: " + largest1);
		System.out.println("Second largest: " + secondLargest);

		// Remove duplicate array values
		int[] duparr = { 2, 3, 2, 4, 3 };

		for (int i = 0; i < duparr.length; i++) {
			boolean duplicate = false;

			for (int j = 0; j < i; j++) {
				if (duparr[i] == duparr[j]) {
					duplicate = true;
					break;
				}
			}
			if (!duplicate) {
				System.out.println(duparr[i]);
			}
		}

		// Count character occurrences
		String chara = "selenium";
		for (int i = 0; i < chara.length(); i++) {
			int count1 = 0;
			for (int j = 0; j < chara.length(); j++) {
				if (chara.charAt(i) == chara.charAt(j)) {
					count1++;
				}
			}
			// Print only the first occurrence of each character
			if (chara.indexOf(chara.charAt(i)) == i) {
				System.out.println(chara.charAt(i));
			}
		}

		// Find the missing number
		int[] miss = { 1, 2, 3, 5, 6 };

		int expectedSum = 0;
		int actualSum = 0;

		for (int i = 1; i <= 6; i++) {
			expectedSum = expectedSum + i;
		}
		for (int i = 0; i < miss.length; i++) {
			actualSum = actualSum + miss[i];
		}
		int missingNumber = expectedSum - actualSum;

		System.out.println("Missing number: " + missingNumber);

		// Sort an array in ascending order
		int[] sort = { 5, 2, 8, 1, 3 };
		for (int i = 0; i < sort.length; i++) {
			for (int j = i + 1; j < sort.length; j++) {
				if (sort[i] > sort[j]) {
					int temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;
				}
			}
		}
		System.out.println("Ascending order:");
		for (int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}

		// Reverse a string
		String str = "selenium";
		String rever = "";

		// i=str.length() is the last index value
		// i-- reduce vlaue by one
		for (int i = str.length() - 1; i >= 0; i--) {
			rever = rever + str.charAt(i);
		}
		System.out.println("Original string: " + str);
		System.out.println("Reversed string: " + reverse);

		// Find the first non-repeated character
		String nonstr = "selenium";

		boolean repeated = false;
		for (int i = 0; i < nonstr.length(); i++) {
			for (int j = 0; j < nonstr.length(); j++) {
				if (i != j && nonstr.charAt(i) == nonstr.charAt(j)) {
					repeated = true;
					break;
				}
			}
			if (!repeated)
				System.out.println("First non-repeated character: " + str.charAt(i));
			break;
		}

		// Find the missing number

		int[] missing = { 1, 2, 4, 5 };

		int actualSum1 = 0;
		int expectedSum1 = 0;

		// Calculate the sum of array elements
		for (int i = 0; i < numbers.length; i++) {
			actualSum1 = actualSum1 + numbers[i];
		}

		// Calculate the expected sum from 1 to 5
		for (int i = 1; i <= 5; i++) {
			expectedSum1 = expectedSum1 + i;
		}

		// Find the missing number
		int missing1 = expectedSum1 - actualSum1;
		System.out.println("Actual sum: " + actualSum1);
		System.out.println("Expected sum: " + expectedSum1);
		System.out.println("Missing number is: " + missing1);

		
		// smallest and second-smallest numbers in an array without sorting the array..
		int[] sam = { 12, 5, 8, 2, 10 };

		int smallest = Integer.MAX_VALUE; // 2147483647 is a value of integer
		int secondSmallest = Integer.MAX_VALUE; // 2147483647

		for (int i = 0; i < sam.length; i++) {
			if (sam[i] < smallest) {
				secondSmallest = smallest;
				smallest = sam[i];
			} else if (sam[i] > smallest && sam[i] < secondSmallest) {
				secondLargest = sam[i];
			}
		}

		System.out.println("Smallest number: " + smallest);

		if (secondSmallest != Integer.MAX_VALUE) {
			System.out.println("Second-smallest number: " + secondSmallest);
		} else {
			System.out.println("No second distinct number found.");
		}

		// Sort an array without built-in sorting

		int[] sorting = { 5, 2, 8, 1, 3 };

		// outerloop
		for (int i = 0; i < sorting.length - 1; i++) {
			// inner loop
			for (int j = 0; j < sorting.length - 1; j++) {
				// Check whether elements are in the wrong order
				if (sorting[j] > sorting[j + 1]) {
					// Swap the elements
					int temp = sorting[j];
					sorting[j] = sorting[j + 1];
					sorting[j + 1] = temp;
				}
			}
		}
		// Print the sorted array
		System.out.println("Array in ascending order: ");
		for (int i = 0; i < sorting.length; i++) {
			System.out.print(sorting[i] + " ");
		}
		System.out.println();

		
		// Find duplicate values and their frequencies
		int[] duplicate = { 2, 4, 2, 5, 4, 2, 7 };

//		int count1 = 0;
		for (int i = 0; i < duplicate.length; i++) {
			int count1 = 0; // Reset count for each number
			for (int j = 0; j < duplicate.length; j++) {
				if (duplicate[i] == duplicate[j]) {
					count1++;
				}
			}
			if (count1 > 1) {
				System.out.println("Duplicate values are : " + duplicate[i] + " appears " + count1 + " times");
			}
		}
		System.out.println();

		// same second problm
		int[] duplicate1 = { 2, 4, 2, 5, 4, 2, 7 };

		for (int i = 0; i < duplicate1.length; i++) {

//			i = the index of the current value.
//			k = the index used to check earlier values.
			boolean alreadyChecked = false;
			for (int k = 0; k < i; k++) {
				if (duplicate1[i] == duplicate1[k]) {
					alreadyChecked = true;
					break;
				}
			}

			if (alreadyChecked) {
				continue;
			}

			int count1 = 0; // Reset count for each number
			for (int j = 0; j < duplicate1.length; j++) {
				if (duplicate1[i] == duplicate1[j]) {
					count1++;
				}
			}
			if (count1 > 1) {
				System.out.println("Duplicate values are : " + duplicate1[i] + " appears " + count1 + " times");
			}
		}

//		Find the sum and average of array elements

		int[] sum = { 10, 20, 30, 40, 50 };

		int sums = 0;
		double average = 0; // it can also be demimal like 25.8

		for (int i = 0; i < sum.length; i++) {
			sums = sums + sum[i];
		}
		System.out.println("Sum of total number is " + sums);

		average = (double) sums / sum.length;
		System.out.println("Average of total number is " + average);

		// Find common elements in two arrays
		int[] a = { 10, 20, 30, 40, 50 };
		int[] b = { 30, 40, 60, 70, 80 };

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					System.out.println(a[i]);
				}
			}
		}

//		Separate even and odd numbers
		int[] even = { 10, 15, 22, 33, 40, 51 };

		System.out.println("This are the even number");
		for (int i = 0; i < even.length; i++) {
			if (even[i] % 2 == 0) {
				System.out.println(even[i]);
			}
		}
		System.out.println("This are not the even number");
		for (int i = 0; i < even.length; i++) {
			if (even[i] % 2 != 0) {
				System.out.println(even[i]);
			}
		}

//		Level 3 — String logic
//		Reverse a string - To reverse the string, we start from the last index and move backward.
//		Last index = name.length() - 1
//		Move backward using i--
//		Get each character using name.charAt(i)

		String name = "Java";
//		name.length() - 1 → starts at index 3.
//		i >= 0 → continues until index 0.
//		i-- → decreases the index by 1 each time.
//		name.charAt(i) → gets the character at the current index.
		for (int i = name.length() - 1; i >= 0; i--) {
			System.out.println(name.charAt(i));
		}

		// Check a palindrome string

		String original1 = "madam";
		String reversed = "madam";

		if (original1 == reversed) {
			System.out.println("It's palinrome...");
		} else {
			System.out.println("It's not a palinrome...");
		}

//		Question :- Count vowels and consonants
//		Vowels: a, e, i, o, u
//		Consonants: Other alphabet letters, such as s, l, n, m.

		String name3 = "Selenium";

		int Vowels = 0;
		int Consonants = 0;

		name3 = name3.toLowerCase();

		for (int i = 0; i < name3.length(); i++) {
			char ch = name3.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					Vowels++;
				} else {
					Consonants++;
				}
			}
		}
		System.out.println("Vowels: " + Vowels);
		System.out.println("Consonants: " + Consonants);

		// Remove duplicate characters

		String dupl = "Selenium";
		String result = "";

//		Does result contain "h"? No — false.
//		!false becomes true.
//		The code inside if runs.
//		result becomes "h".

//		Does result contain "l"? Yes — true.
//		!true becomes false.
//		The code inside if does not run.
//		result remains "hel"

		for (int i = 0; i < dupl.length(); i++) {
			char ch = dupl.charAt(i);
			if (!result.contains(String.valueOf(ch))) {
				result = result + ch;
			}
		}
		System.out.println("Original String: " + dupl);
		System.out.println("After removing duplicates: " + result);

		// Find the first non-repeated character
		String nonrep = "Selenium";

		for (int i = 0; i < nonrep.length(); i++) {
			char ch = nonrep.charAt(i);
			boolean repeated1 = false; // assumes the character is unique initially.
			for (int j = 0; j < nonrep.length(); j++) {
//				i != j => means we don't compare a character with itself.
				if (i != j && ch == nonrep.charAt(j)) {
					repeated1 = true;
					break;
				}
			}
			if (!repeated1) {
				System.out.println("First non-repeated character: " + ch);
				break; // Stop after finding the first non-repeated character
			}
		}

//		Count words in a sentence
		String sentence = "I am learning Java";

		String[] word = sentence.split(" ");
		System.out.println("No of words are : " + word.length);

		
		// Check whether two strings are anagrams
		// Two strings are called anagrams if they contain the same characters with the
		// same frequencies, but the characters can be in a different order.
		String str1 = "listen";
		String str2 = "silent";

		// Convert both strings to lowercase
		str1 = str1.toLowerCase();
		str1 = str2.toLowerCase();

		// Check whether lengths are different
		if (str1.length() != str2.length()) {
			System.out.println("The strings are not anagram");
		} else {
			// Convert strings into character arrays
			// For "listen", the array contains l, i, s, t, e, n.
			char[] arr1 = str1.toCharArray();
			char[] arr2 = str1.toCharArray();

			// Sort both character arrays
			Arrays.sort(arr1);
			Arrays.sort(arr2);

			// Compare the sorted arrays
			if (Arrays.equals(arr1, arr2)) {
				System.out.println("The strings are anagrams");
			} else {
				System.out.println("The strings are not anagrams");
			}
		}

		// Fibonacci series
		// The Fibonacci series is a sequence of numbers in which each new number is the
		// sum of the previous two numbers.

		int a1 = 0;
		int b1 = 1;
		int c1;
		System.out.print("0 1 ");
		for (int i = 2; i <= 10; i++) {
			c1 = a1 + b1;
			a1 = b1;
			b1 = c1;
			System.out.print(c1 + " ");
		}
		System.out.println();

		// Prime numbers in a range
		// A prime number is a number greater than 1 that is divisible only by 1 and
		// itself.

		int start = 1;
		int end = 20;
		System.out.println("Prime numbers between " + start + " and " + end + " are:");

		for (int i = start; i <= end; i++) {
			if (i < 2) { // skips 1 because it is not prime.
				continue;
			}
			boolean isPrime = true; // assumes the current number is prime initially.
			for (int j = 2; j < i; j++) { // The inner loop checks whether any number from 2 to number - 1 divides it
											// exactly.
				if (i % j == 0) { // i % j == 0 means the number is divisible by j, so it is not prime.
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		// Armstrong number
		// An Armstrong number is a number equal to the sum of its digits, where each
		// digit is raised to the power of the total number of digits.
//        temp % 10 — extracts the last digit.
//        temp / 10 — removes the last digit.
//        power = power * digit — calculates the digit's power using a loop.
//        sum = sum + power — accumulates the results.

		int number = 153;

		// Preserve the original number
		int originalNumber = number;

		// Count the digits
		int count1 = 0;
		int temp = number;

		while (temp > 0) {
			count1++;
			temp = temp / 10;
		}

		// Calculate the sum of digits raised to the digit count
		int sum1 = 0;
		temp = number;

		while (temp > 0) {
			// Extract the last digit
			int digit = temp % 10;
			// Raise the digit to the power of count
			int power = 1;

			for (int i = 1; i <= count1; i++) {
				power = power * digit;
			}

			// Add the result
			sum1 = sum1 + power;
			// Remove the last digit
			temp = temp / 10;
		}

		// Check whether it is an Armstrong number
		if (sum1 == originalNumber) {
			System.out.println(originalNumber + " is an Armstrong number");
		} else {
			System.out.println(originalNumber + " is not an Armstrong number");
		}

		// Swap two numbers
		int a4 = 10;
		int b4 = 20;

		System.out.println("Before swapping:");
		System.out.println("a = " + a4);
		System.out.println("b = " + b4);

		// Store the value of a temporarily
		int temp4 = a4;

		// Copy b into a
		a4 = b4;

		// Copy the original value of a into b
		b4 = temp4;

		System.out.println("After swapping:");
		System.out.println("a = " + a4);
		System.out.println("b = " + b4);

		System.out.println();

//        Use HashMap to count frequencies

		int[] hasmap = { 2, 4, 2, 5, 4, 2, 7 };

		// Create a HashMap to store number and frequency
		Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

		// Count the frequency of each number
		for (int i = 0; i < hasmap.length; i++) {

			int num1 = hasmap[i];

			if (frequency.containsKey(num1)) {
				// If number exists, increase its frequency
				frequency.put(num1, frequency.get(num1) + 1);
			} else {
				// If number is new, set frequency to 1
				frequency.put(num1, 1);
			}

			// Print the frequencies
			for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
				System.out.println(entry.getKey() + " appears " + entry.getValue() + " times");
			}
		}

		System.out.println();

//        Use ArrayList, Set, and Map
//        ArrayList — add, retrieve, update, remove, and search for elements.
//        Set — remove duplicates from a list and find unique values.
//        Map — count the frequency of numbers and characters.

		ArrayList<Integer> li = new ArrayList<Integer>();
		li.add(10);
		li.add(20);
		li.add(30);
		li.add(10);
		li.add(20);
		System.out.println(li);
		li.set(1, 15);
		System.out.println(li.get(2));
		System.out.println(li);

		// Set - Set stores unique values.
		Set<Integer> lis = new HashSet<Integer>();
		lis.add(10);
		lis.add(20);
		lis.add(10);
		lis.add(30);
		System.out.println(lis);
		System.out.println(lis.size());
		System.out.println(lis.remove(10));
		System.out.println(lis);

		// HashMap - store key-value as a paire -A Map has unique keys, and adding an
		// existing key with put() replaces its value.
		HashMap<String, Integer> hmap = new HashMap<>();
		hmap.put("Ali", 60);
		hmap.put("Sara", 30);
		hmap.put("Ali", 90);

		System.out.println(hmap.get("Ali"));

		// Basic exception handling and OOP concepts

//        Basic Exception Handling
//        1. What is an exception?
//        An exception is an unexpected problem that occurs while a program is running.

		// Eg:-
		int a5 = 10;
		int b5 = 0;
//		System.out.println(a5 / b5); //get error and code will get stop

//        This causes an ArithmeticException because we cannot divide an integer by zero.
//        Without exception handling, the program stops at that statement.

		try {
			int a6 = 10;
			int b6 = 0;
			System.out.println(a6 / a6);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero");
		} finally {
			System.out.println("Program continues");
		}

//        try: contains code that might throw an exception.
//        catch: handles a matching exception if one occurs.
//        e: the exception object containing details about the error.

		/*
		 * => How OOP applies to Selenium Concept Example in your automation framework
		 * Encapsulation = Page Object classes keep locators and page methods together.
		 * Inheritance = Test classes reuse setup and driver handling from BaseClass.
		 * Polymorphism = Overloaded methods or overridden methods provide different
		 * behaviors. Abstraction = A reusable ActionDriver can hide the details of
		 * clicking and typing.
		 */

		// 1)Encapsulation
//        Encapsulation means keeping data and methods together in a class while controlling access to the data.

//        For example, instead of allowing anyone to directly change a bank balance, we can make it private and provide controlled methods.
		/*
		 * class BankAccount {
		 * 
		 * private int balance = 1000;
		 * 
		 * public int getBalance() { return balance; }
		 * 
		 * public void deposit(int amount) { if (amount > 0) { balance = balance +
		 * amount; } } }
		 */

		/*
		 * public class PracticeQuestions { public static void main(String[] args) {
		 * 
		 * BankAccount account = new BankAccount();
		 * 
		 * account.deposit(500);
		 * 
		 * System.out.println(account.getBalance()); } }
		 */
//		output:-1500
		/*
		 * The field balance is private, so it cannot be accessed directly from another
		 * class. The public methods provide controlled access.
		 */

		// Practice encapsulation with a getter and setter
		/*
		 * class Student { private int age = 20;
		 * 
		 * public int getAge() { return age; }
		 * 
		 * public void setAge(int age) { this.age = age; } }
		 */

		/*
		 * getAge() returns the current age. setAge() changes the age. this.age refers
		 * to the object's field. age on the right side refers to the method parameter.
		 */

		// OOP Concept 2 — Inheritance

		// Inheritance means one class can acquire accessible fields and methods from
		// another class.

		/*
		 * class Animal {
		 * 
		 * void eat() { System.out.println("Animal is eating"); } }
		 * 
		 * class Dog extends Animal {
		 * 
		 * void bark() { System.out.println("Dog is barking"); } }
		 * 
		 */

		/*
		 * public class PracticeQuestions { public static void main(String[] args) {
		 * 
		 * Dog d = new Dog();
		 * 
		 * d.eat(); d.bark(); } }
		 */

		// Method overriding in Inheritance
		/*
		 * class Parent { void show() { System.out.println("Parent method"); } }
		 * 
		 * class Child extends Parent {
		 * 
		 * @Override void show() { System.out.println("Child method"); } }
		 */

		/*
		 * public class PracticeQuestions { public static void main(String[] args) {
		 * Child c = new Child(); c.show(); } }
		 */

		// polymorphism
		// Polymorphism means one interface or method call can produce different
		// behavior depending on the object or context.

		/*
		 * class Parent { void show() { System.out.println("Parent method"); } }
		 * 
		 * class Child extends Parent {
		 * 
		 * @Override void show() { System.out.println("Child method"); } }
		 * 
		 * public class PracticeQuestions { public static void main(String[] args) {
		 * Parent p = new Child(); p.show(); } }
		 */

		// overloading
		// Now let's learn another type of polymorphism: compile-time polymorphism,
		// commonly achieved through method overloading.
		/*
		 * class Calculator { int add(int a, int b) { return a + b; }
		 * 
		 * int add(int a, int b, int c) { return a + b + c; } }
		 */

		/*
		 * Notice that both methods have the same name, add, but their parameter lists
		 * are different. - First method: accepts 2 integers. - Second method: accepts 3
		 * integers. Java chooses which method to call based on the arguments you
		 * provide.
		 */

		// overloading
		/*
		 * class Calculator { int add(int a, int b) { return a + b; }
		 * 
		 * double add(double a, double b) { return a + b; } }
		 */

		/*
		 * Calculator c = new Calculator(); System.out.println(c.add(2.5, 3.5));
		 */

//		Java sees the arguments 2.5 and 3.5.
//		These are double values by default in Java.
//		Java finds the matching method add(double a, double b).
//		It calculates 2.5 + 3.5, which equals 6.0.
//		System.out.println() prints 6.0.

		// Abstraction
		/*
		 * Abstraction is another important OOP concept, and it is especially useful in
		 * Selenium automation frameworks.
		 * 
		 * Simple example: When you drive a car, you use the steering wheel and pedals
		 * without needing to understand every detail of how the engine works.
		 * 
		 * In Java, abstraction means showing essential functionality while hiding
		 * implementation details.
		 * 
		 * Java supports abstraction through: - Abstract classes - Interfaces
		 */

		/*
		 * abstract class Animal { abstract void sound(); }
		 * 
		 * class Dog extends Animal {
		 * 
		 * @Override void sound() { System.out.println("Dog barks"); } }
		 * 
		 * public class PracticeQuestions { public static void main(String[] args) {
		 * Animal a = new Dog(); a.sound(); } }
		 */

		// final
		/*
		 * Remember these three uses of final Where final is used Meaning final variable
		 * Cannot be reassigned final method Cannot be overridden final class Cannot be
		 * extended
		 */

	}
}
