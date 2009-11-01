/**
 * 
 */
package pl.interia.w.kowalczyk.jacek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * @author kowalczykj
 * 
 */
public class Base64SimpleEncoderTool {

	public static void menu() {
		System.out
		.println("\t****************************************************");
		System.out.println("\tWelcome in Base64 Simple Encoder Tool");
		System.out.println("\tWhat do you want to do next?");
		System.out.println("\tOptions:\n\n" +
				"\th - help\n" +
				"\t1 - encode one string\n" +
				"\tq - quit tool");
		
		System.out
		.println("\n\t****************************************************");
	}

	public static void encode() {
		Base64SimpleEncoder b64 = new Base64SimpleEncoder();
		String output = null;
		String inputS = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			inputS = in.readLine();
		} catch (IOException io) {
			System.err
					.println("\tIOException while reading from standard in - keyboard");
		}

		System.out.println("\t"+ inputS + " \n\t\t--Base64--> \n\t\t\t" + b64.encodeBase64(inputS));
		System.out.println("\n\t");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		menu();

		/**
		 * komenda - this string represents user's command, correct commends
		 * are: 1, q <br/>
		 */
		String komenda = new String();
		boolean continueB = true;
		
		while (continueB) {
			
			System.out
					.println("\t* What do you want to do ?                         *\n ");
			System.out.print("\tselect option>\t");
			
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				komenda = in.readLine();
			} catch (IOException io) {
				System.err
						.println("\tIOException while reading from standard in - keyboard");
			}

			if (komenda.equalsIgnoreCase("q")) {
				continueB = false;
			}// exit

			else if (komenda.equalsIgnoreCase("1")) {
				System.out.println("\tPlease type the text to encode\n ");
				System.out.print("\tencode>\t");
				encode();
			} else if (komenda.equalsIgnoreCase("h")) {
				menu();
			}

			else {
				System.out.println("\tCommand not known!!!");
			}

		}
		if (komenda.startsWith("q")) {
			System.out.println("\tYou have exited Base 64Simple Encoder\n");
		}

	}

}
