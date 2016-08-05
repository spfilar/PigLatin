package com.piglatin;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatin {

	public static void main(String[] args) {
		
		Scanner pl = new Scanner(System.in);
		
		System.out.println("Please enter a word or phrase to be translated: \nPunctuation, numbers, special characters cannot be used.");

		String phrase = pl.nextLine();
			
		while(!phrase.equalsIgnoreCase("exit")) {
			
			System.out.println(convert(phrase));
			System.out.println("Please enter a word or phrase to be translated: ");
			phrase = pl.nextLine();
		}
	}

	public static String convert(String phrase) {
				
		String vowels = "aeiouAEIOU";
		String[] letters = phrase.split(" +");
		StringBuilder newWord = new StringBuilder();
		Pattern p = Pattern.compile("[a-z ]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(phrase);

		for (int i = 0; i < letters.length; i++) {
			
			if (!m.matches()) {
				System.out.println("Invalid input type.\nReminder that punctuation, numbers, \nand special characters cannot be used.\nPlease try again.");
				break;
				
			} else if (vowels.indexOf(letters[i].charAt(0)) >= 0) {
				newWord.append(letters[i] + "way ");
				
			} else if ((letters[i].indexOf("a") < 0) && 
					(letters[i].indexOf("e") < 0) &&
					(letters[i].indexOf("i") < 0) &&
					(letters[i].indexOf("o") < 0) &&
					(letters[i].indexOf("u") < 0) &&
					(letters[i].indexOf("A") < 0) && 
					(letters[i].indexOf("E") < 0) &&
					(letters[i].indexOf("I") < 0) &&
					(letters[i].indexOf("O") < 0) &&
					(letters[i].indexOf("U") < 0)) {
				newWord.append(letters[i] + "ay ");
				
			} else {
				
				for (int j = 1; j < letters[i].length(); j++) {
					
					if (vowels.indexOf(letters[i].charAt(j)) >= 0) {
						
						newWord.append(letters[i].substring(j) + letters[i].substring(0, j) + "ay ");
						break;
					}
				}
			}
		}
		return newWord.toString().toLowerCase();
	}
}