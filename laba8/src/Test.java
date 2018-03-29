import java.util.*;
import java.lang.*;

class WorkWithString {
	static int notLetter = 0, vowel = 0, consonant = 0;
	
	static boolean checkVowel(char l){
		if(l == 'a' || l == 'e' || l == 'u' || l == 'i' || l == 'o'
			|| l == 'A' || l == 'E' || l == 'U' || l =='I' || l == 'O') return true;
		return false;
	}
	
	static StringBuilder[][] defineTypeOfString(StringBuilder[] strings){
		StringBuilder done[][] = new StringBuilder[3][strings.length];
		for(int i = 0; i < strings.length; i++){
			
			if(!Character.isLetter(strings[i].charAt(0))){
				done[2][notLetter] = strings[i];
				notLetter++;
				if(Test.debug)
					System.out.println("+1 to string which start not with a letter and total number of such string is " + notLetter);
				
			} else if(checkVowel(strings[i].charAt(0))){
				done[0][vowel] = strings[i];
				vowel++;
				if(Test.debug)
					System.out.println("+1 to string which start with a vowel and total number of such string is " + vowel);
						
			} else{
				done[1][consonant] = strings[i];
				consonant++;
				if(Test.debug)
					System.out.println("+1 to string which start  with a consonant and total number of such string is " + consonant);
			}
			
		}	
		return done;
	}
	
	
}


public class Test {

	static boolean debug = false;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			for(int i = 1; i < args.length; i++){
				if(args[i].equals("-h")){
					System.out.println("Made by Yura Danilovskyi from KN-107! \nProgram for distinguish types of String(first symbol is letter or not and is vowel or consonant.\n Write in command line -h for info ot -d for debug!");
				}else if(args[i].equals("-d")){
					System.out.println("You are in debug mode");
					debug = true;
				}
			
			}
		}catch(NullPointerException e){}
		
		System.out.println("How many strings do you want to enter?");
		StringBuilder[] text = new StringBuilder[(new Scanner(System.in)).nextInt()];
		System.out.println("Please, enter your strings\n");
		for(int i = 0; i < text.length ; i++){
			text[i] = new StringBuilder((new Scanner(System.in)).nextLine());
		}
		
		if(debug){
			System.out.println("\nYou had to enter " + text.length + " strings!");
			
			System.out.println("\nYour strings: ");
			for(int i = 0; i < text.length; i++)
				System.out.println(text[i] + "\n");
			
		}
		StringBuilder data[][] = WorkWithString.defineTypeOfString(text);
		
		try{
			StringBuilder theshortest = data[0][0];
			for(int i = 1; i < WorkWithString.vowel; i++)
				if(data[0][i].length() < theshortest.length())
					theshortest = data[0][i];
			System.out.println("\nThe shortest string that start with vowel is " + theshortest.toString());
			System.out.println("And the length of it is  " + theshortest.length() + '\n');
		} catch(NullPointerException e){
			System.out.println("\nYou didn't enter string that start with vowel :с\n" );
		}
	
		
		try{
			StringBuilder theshortest = data[1][0];
			for(int i = 1; i < WorkWithString.consonant; i++)
				if(data[1][i].length() < theshortest.length())
					theshortest = data[1][i];
			System.out.println("\nThe shortest string that start with consonant is " + theshortest.toString());
			System.out.println("And the length of it is  " + theshortest.length() + '\n');
		}catch(NullPointerException e){
			System.out.println("\nYou didn't enter string that start with consonant :с\n" );
		}
		
		try{
			StringBuilder theshortest = data[2][0];
			for(int i = 1; i < WorkWithString.notLetter; i++)
				if(data[2][i].length() < theshortest.length())
					theshortest = data[2][i];
			System.out.println("\nThe shortest string that start not with a letter " + theshortest.toString());
			System.out.println("And the length of it is  " + theshortest.length() + '\n');
		}catch(NullPointerException e){
			System.out.println("\nYou didn't enter string that start not with a letter :с\n" );
		}
		
	}

}
