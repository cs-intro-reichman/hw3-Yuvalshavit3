/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.

		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	   
	public static boolean isAnagram(String str1, String str2) {
		String str1_pro = preProcess(str1);
		String str2_pro = preProcess(str2);
		if(str1_pro.length()!=str2_pro.length()){
			return false;
		}
		boolean answer = false;
		char letter_str1;
		for(int i = 0; i < str1_pro.length() ; i++){
			letter_str1 = str1_pro.charAt(i);
			for(int j = 0 ; j < str2_pro.length() ; j++){
				if(letter_str1 == str2_pro.charAt(j)){
					str2_pro = str2_pro.substring(0, j) + str2_pro.substring(j+1, str2_pro.length());
					break;
				}
			}
		}
		if(str2_pro.length()==0){
			answer=true;
		}
		return answer;

	}

	
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String phrase = str;
		String newPhrase = "";
		for (int i = 0; i < phrase.length(); i ++) {
			if((phrase.charAt(i) > 96) && ((phrase.charAt(i) < 123))){
				newPhrase = newPhrase + phrase.charAt(i);
			} else if ((phrase.charAt(i) > 64) && ((phrase.charAt(i) < 91))) {
				newPhrase = newPhrase + (char)(phrase.charAt(i) + 32);
			} else if (phrase.charAt(i) == ' ') {
				newPhrase = newPhrase + phrase.charAt(i);
			}
		}
		return newPhrase;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	
	public static String randomAnagram(String str) {
		String newWord = "";
		char randomChar;
		while(str.length() > 0){
			int randomNum = (int) ((str.length() - 1) * Math.random());
			randomChar = str.charAt(randomNum);
			newWord = newWord + randomChar;
			str = str.substring(0, randomNum) + str.substring(randomNum + 1, str.length());
		}
		

		return newWord;
	}
}
