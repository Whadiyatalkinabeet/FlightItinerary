
import java.util.LinkedList;




/** Main class for the Spell-Checker program */
public class SpellCheck {

	
				
		
		

	public String reversal(LinkedList<String> M1, String word) {//reverses each adjacent character pair
		
		
		
		int i;
		
		char temp;
		
		
		
		char[] charSwapper = word.toCharArray();//split the word into separate characters
		
		
		for (i = 0; i < charSwapper.length - 1; i++ ){// for each character in the word
			//swap adjacent characters
			temp = charSwapper[i];
			charSwapper[i] = charSwapper[i+1];
			charSwapper[i+1] = temp;
			
			String SwappedWord = new String(charSwapper);//turn char array back into string for equality testing

			if (M1.contains(SwappedWord)) {
				
				//if the newly modified word is contained in the hash table, not just the same as the misspelled word and not contained in our linked list then add the word to the linked list
				
				return SwappedWord;
			}
			
			else {
				//otherwise swap the adjacent characters back
				temp = charSwapper[i];
				charSwapper[i] = charSwapper[i+1];
				charSwapper[i+1] = temp;
			}
		}
		return "";
		
		
		
	}

	

	public String omission(LinkedList<String> M1, String word) {//deletes one character
		
		
		
		int i;
		
		
		
		StringBuilder MisspeltWord = new StringBuilder(word);//create a string builder to modify the word

		for (i = 0; i < MisspeltWord.length(); i++) {
			
			char placeholder = MisspeltWord.charAt(i);//make a copy of the character to be deleted so we can place it back later
			
			MisspeltWord.deleteCharAt(i);//remove the character
			
			String wordOmission = MisspeltWord.toString();//turn the string builder back into a string for equality testing

			if (M1.contains(wordOmission)) {//same test as before
				
				
				return wordOmission;
			}
			
			MisspeltWord.insert(i, placeholder);//replace the deleted character so we can continue
			
		}
		
		
		
		return "";
	}
	
	

	public String insertion(LinkedList<String> M1, String word) {//inserts one character
		
		
		
		int i, j;
		
		
		
		char[] alphabet = new char[26];//load the alphabet into an array of characters

		for (char ch = 'a'; ch <= 'z'; ++ch) {
			
			alphabet[ch - 'a'] = ch;
			
		}

		StringBuilder MisspeltWord = new StringBuilder(word);

		for (i = 0; i < MisspeltWord.length() + 1; i++) {//for each character in the word
			
			for (j = 0; j < alphabet.length; j++) {//for each letter in the alphabet
				
				MisspeltWord.insert(i, alphabet[j]);//insert each letter of the alphabet into a position of the word
				
				String wordInsertion = MisspeltWord.toString();

				if (M1.contains(wordInsertion)) {
					
					return wordInsertion;
					
				}
				
				MisspeltWord.deleteCharAt(i);//remove the inserted word so we can continue
			}
		}
		
		
		
		
		return "";

	}
	


	public String substitution(LinkedList<String> M1, String word) {//replaces a character in the word with a character from the alphabet
		
	
		
		int i, j;
		
		
		
		char charholder;//this will hold the character to be replaced to we can put it back later
		
		char[] alphabet = new char[26];

		for (char ch = 'a'; ch <= 'z'; ++ch) {
			
			alphabet[ch - 'a'] = ch;
			
		}

		StringBuilder MisspeltWord = new StringBuilder(word);

		for (i = 0; i < MisspeltWord.length(); i++) {//for each character in the word

			for (j = 0; j < alphabet.length; j++) {//for each letter in the alphabet

				charholder = MisspeltWord.charAt(i);

				MisspeltWord.setCharAt(i, alphabet[j]);//substitute a character in the word with each letter of the alphabet

				String wordSubstitution = MisspeltWord.toString();
				
				if (M1.contains(wordSubstitution)) {
					
					return wordSubstitution;
					
				}
				
				MisspeltWord.setCharAt(i, charholder);//replace the character with the original one to we can continue
				
			}

		}
		
		return "";
	}
}
