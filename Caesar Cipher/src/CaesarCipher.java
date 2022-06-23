public class CaesarCipher {
	
	//fields
	String plaintext;
	String ciphertext;
	String decrypted;
	int key;
	
	//constructor
	public CaesarCipher(String original, int key) {
		plaintext = original; //establish the plaintext as original message which will be inputed from CCMain
		this.key = key; //establish the key as the key which will be inputed from CCMain
		ciphertext = encrypt(key); //make the ciphertext the output of encrypt using the key
		decrypted = frequencyAnalysis(); //the decrypted message will be the output from frequencyAnalysis
	}
	
	//encoding method
	public String encrypt(int k) {
		String result = ""; //stores the encrypted characters
		
		for (int i = 0; i < plaintext.length(); i++) { //loop through each character of the plaintext
            if(Character.isLetter(plaintext.charAt(i))) { //check if the character is a letter
            	
            	//if the character is a letter, determine whether it's upper or lower case
            	//calculate with the key accordingly 
            	//add the encrypted letter to "result"
            	if (Character.isUpperCase(plaintext.charAt(i))) {
            		char c = (char) ((plaintext.charAt(i) + k - 'A') % 26 + 'A');
            		result+=c;
            	} else {
            		char c = (char) ((plaintext.charAt(i) + k - 'a') % 26 + 'a');
            		result+=c;
            	}
            	
            }else result+= plaintext.charAt(i); 
            //if the character is not a letter, add it directly to "result"
            
		}
        
		return result; //output the result
		
	}
	
	//decoding method
		public String decode(int k) {
			String result =""; //stores the decoded characters
			
	        for (int i = 0; i < ciphertext.length(); i++) { //loop though each character of the ciphertext 
	        	if(Character.isLetter(plaintext.charAt(i))){ //check if the character is a letter
	        		
	        		//if the character is a letter, determine whether it's upper or lower case
	            	//calculate with the key accordingly 
	            	//add the decoded letter to "result"
	        		if (Character.isUpperCase(ciphertext.charAt(i))) {
	        			char c = (char) ((ciphertext.charAt(i) + k - 'A') % 26 + 'A');
	        			result+=c;
	        		} else {
	        			char c = (char) ((ciphertext.charAt(i) + k - 'a') % 26 + 'a');
	        			result+=c;
	        		}
	        		
	        	}else result+= plaintext.charAt(i); //if the character is not a letter, add it directly to "result"
	        	
	        }
	        return result; //output the result
		
	}
		
	//frequency analysis method
	public String frequencyAnalysis() {
		
		int freq = 0; // most frequent letter
		int pk = 0; //potential key
		String text = ciphertext.toLowerCase(); //make ciphertext all lower case for simplicity and store it in "text"
		int[] frequency = new int[26]; //array which will store the frequency of each letter
		
		for(int i=0;i<text.length();i++) { //loop through each character of "text" 
			if(Character.isLetter(plaintext.charAt(i))){ //if the character is a letter...
				frequency[(int)(text.charAt(i)-'a')]++; //increase the element of "frequency" which represent the letter by 1
			}
		}
		
		int max = 0; //the maximum frequency
		for(int i=0;i<26;i++) { //loop through "frequency"
			if(frequency[i]>max) { //if the element is bigger than the pre-exsiting max frequency ("max")...
				max=frequency[i]; //make the element "max"
				freq = i+'a'; //make "freq" the unicode of the currently most frequent letter
			}
		}
		
		if(('e'-freq)<0) pk='e'-freq+26; //check if "freq" is before or after 'e' and calculate accordingly
		else pk = 'e'-freq;
	    
		//call the decoding function(decode) with "pk", the key discovered
		//output the output of decode 
		return (decode(pk)); 

	}
	
	

}
