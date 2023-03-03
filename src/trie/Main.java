package trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public void run() throws FileNotFoundException {
		File myFile = new File("src/trie/words_alpha.txt");
		Scanner myScanner = new Scanner(myFile);
		
		Trie myTrie = new Trie(myScanner);
		
		myScanner.close();
		
		Scanner inputScanner = new Scanner(System.in);
		String input;
		
		boolean prefixMode = true;
		
		while (true) {
			if (prefixMode) {
				System.out.println("Enter prefix, * to switch mode, ** to quit:");
				input = inputScanner.nextLine();
				if (input.equals("*"))
					prefixMode = false;
				else if (input.equals("**"))
					break;
				else
					System.out.println(myTrie.findAll(input));
			} else {
				System.out.println("Enter word to check, * to switch mode, ** to quit:");
				input = inputScanner.nextLine();
				if (input.equals("*"))
					prefixMode = true;
				else if (input.equals("**"))
					break;
				else
					System.out.println(myTrie.existsWord(input));
			}
		}
		
		inputScanner.close();
	}
}
