import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CCMain {

	public static void main(String[] args) throws Exception {
		
		//Preparation for input and output files
		Scanner in = new Scanner(new File("cipher.in"));
		PrintWriter out = new PrintWriter(new File("cipher.out"));
		
		double accuracy = 0; //record the amount of successful cases
		
		for(int i=1;i<11;i++) { //loop through the 10 cases from cipher.in
			String test = in.nextLine(); //read in the line from the file and store it in "test"
			
			// create a new CaesarCipher Object with "test" and an integer randomly selected from 1 to 25 as the key
			CaesarCipher a = new CaesarCipher(test, (int) (1 + Math.random()*(25))); 
			
			
			out.println("Test "+i); //print the test case number
			out.println("Random key: "+a.key); //print the selected key
			out.println("Plaintext: "+a.plaintext); //print the plaintext
			out.println("Ciphertext: "+a.ciphertext); //print the ciphertext
			out.println("Decrypted: "+a.decrypted); //print the decrypted message 
			
			if(a.plaintext.equals(a.decrypted)) { //checks if the decrypted message is correct and print the related message
				out.println("The decrypted text matches the plaintext.");
				accuracy++; //add one to "accuracy" if the message is decoded correctly
			}else out.println("The decrypted text does not match the plaintext.");
			
			out.println();
		}
		
		
		out.println("Correct decryption: " + accuracy); //print the total amount of successful cases stored in "accuracy"
		accuracy/=10; //divide "accuracy" by 10 which gives a decimal percentage
		out.println("Total accuracy: " + accuracy); //print out percentage
		in.close();
		out.close();
		
	}

}
