/**
 *
 * @author Glen Kidwell
 */

import java.util.Scanner;

public class CryptologyProject1
{
	/**
	* @param args the command line arguments
	*/
   public static void main(String[] args)
	{
		int mainMenuChoice;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Hello!");
		System.out.println("This program will demonstrate a few simple ciphers.");
		System.out.println("All of the math involved will be done in Mod 26.");
		System.out.println("In general, please refrain from using punctuation or special characters in any text input.");
		System.out.println("Spaces are acceptable.\n");
		
		// Main Menu
		// Simple switch block, which presents the user with a choice
		// After done with the method of choice, will continue to the display the menu until the program is closed
		while (true)
		{							
			System.out.println("Please choose from the list below:\n");
			System.out.println("1 - Affine Cipher");
			System.out.println("2 - Vigenere Cipher");
			System.out.println("3 - Hill Cipher");
			System.out.println("4 - Rail Fence Cipher");
			System.out.println("5 - End program\n");
			System.out.println("Please enter the number of your choice followed by the Enter key.\n");
			mainMenuChoice = in.nextInt();
		
			switch(mainMenuChoice)
			{
				case 1:
				{
					affineCipher();
					break;
				}
				case 2:
				{
					vigenereCipher();
					break;
				}
				case 3:
				{
					hillCipher();
					break;
				}
				case 4:
				{
					railFenceCipher();
					break;
				}
				case 5:
				{
					System.out.println("Terminating program.\n");
					return;
				}
			}
		}
	}

	public static void affineCipher()
	{
		int m, b, messagelength;
		String plaintext;
		char[] CIPHERTEXT;
		int[] parray, carray;
		Scanner inputnumbers = new Scanner(System.in);
		Scanner inputtext = new Scanner(System.in);
		
		System.out.println("---AFFINE CIPHER---");
		System.out.println("This will demonstrate a simple affine cipher, which encrypts using a linear function.");
		System.out.println("It will encrypt a string using a function in the form f(x) = mx + b mod 26.");
		System.out.println("-DEFINING THE FUNCTION-");
		System.out.println("Please define m in the function f(x) = mx + b");
		m = inputnumbers.nextInt() % 26;
		System.out.println("Please define b in the function f(x) = mx + b");
		b = inputnumbers.nextInt() % 26;
		System.out.println("The function is f(x) = " + m + "x + " + b + "\n");
		System.out.println("-DEFINING THE MESSAGE-");
		System.out.println("Please specify the string you would like to encrypt.\n");
		plaintext = inputtext.nextLine();
		plaintext = plaintext.toUpperCase();
		
		messagelength = plaintext.length();
		parray = new int[messagelength];
		carray = new int[messagelength];
		CIPHERTEXT = new char[messagelength];
		
		for (int i = 0; i < messagelength; i++)
		{
			parray[i] = numCharConvert(plaintext.charAt(i));
		}
		
		for (int i = 0; i < messagelength; i++)
		{
			if (parray[i] != 32)
				carray[i] = (m * parray[i] + b) % 26;
			else
				carray[i] = parray[i];
		}
		
		System.out.println("-RESULTS-");
		System.out.println("plaintext =   " + plaintext.toLowerCase());
		System.out.print("CIPHERTEXT =  ");
		
		for (int i = 0; i < messagelength; i++)
		{
			CIPHERTEXT[i] = numCharConvert(carray[i]);
			System.out.print(CIPHERTEXT[i]);
		}
		System.out.println("\n");		
		return;
	}
	
	public static int numCharConvert(char a)
	{
		int x;
		if (a != 32)
			x = a - 65;
		else
			x = a;
		return x;
	}
	public static char numCharConvert(int x)
	{
		char a = ' ';
		if (x != 32)
			a = (char) (x + 65);
		return a;
	}
	
	public static void vigenereCipher()
	{
		Scanner inputtext = new Scanner(System.in);
		
		int keylength, messagelength, j=0;
		String key, plaintext;
		char[] CIPHERTEXT;
		int[] parray, carray, karray;
	
		System.out.println("---VIGENERE CIPHER---");
		System.out.println("This will demonstrate a Vigenere cipher, which encrypts with a keyword.");
		System.out.println("-DEFINING THE PARAMETERS-");
		System.out.println("Please specify the keyword you would like to use to encrypt the message.");
		System.out.println("Please use only letters, and do not include any spaces, punctuation, or special characters.\n");		
		key = inputtext.nextLine();
		key = key.toUpperCase();
		keylength = key.length();
		System.out.println("Please specify the string you would like to encrypt.\n");
		plaintext = inputtext.nextLine();
		plaintext = plaintext.toUpperCase();
		messagelength = plaintext.length();
		
		karray = new int[keylength];
		parray = new int[messagelength];
		carray = new int[messagelength];
		CIPHERTEXT = new char[messagelength];
		
		for (int i = 0; i < keylength; i++)
		{
			karray[i] = numCharConvert(key.charAt(i));
		}

		for (int i = 0; i < messagelength; i++)
		{
			parray[i] = numCharConvert(plaintext.charAt(i));
		}
		
		for (int i = 0; i < messagelength; i++)
		{
			if (parray[i] != 32)
			{
				carray[i] = (parray[i] + karray[j]) % 26;
				j++;
				if (j == keylength)
				{
					j = 0;
				}
			}
			else
			{
				carray[i] = parray[i];
			}
		}
		
		System.out.println("-RESULTS-");
		System.out.println("plaintext =   " + plaintext.toLowerCase());
		System.out.println("Key =         " + key);
		System.out.print("CIPHERTEXT =  ");
		
		for (int i = 0; i < messagelength; i++)
		{
			CIPHERTEXT[i] = numCharConvert(carray[i]);
			System.out.print(CIPHERTEXT[i]);
		}
		System.out.println("\n");		
		return;
	}
	
	public static void hillCipher()
	{
		System.out.println("---HILL CIPHER---");
		System.out.println("This will demonstrate a Hill cipher, which encrypts using matrix multiplication.");
		System.out.println("--This part of the program has yet to be completed.--\n");
		return;
	}
	
	public static void railFenceCipher()
	{
		Scanner inputnumbers = new Scanner(System.in);
		Scanner inputtext = new Scanner(System.in);

		int height, messagelength, k=0, i=0, j=0, x=0, y=0, z=0;		
		String plaintext;
		char[] CIPHERTEXT;
		char[][] rails;

		System.out.println("---RAIL FENCE CIPHER---");
		System.out.println("This will demonstrate a rail fence cipher, which rearranges letters.");
		System.out.println("-DEFINING THE PARAMETERS-");		
		System.out.println("Please define the height of the fence.");
		height = inputnumbers.nextInt();
		System.out.println("Please specify the string you would like to encrypt.\n");
		plaintext = inputtext.nextLine();
		plaintext = plaintext.toUpperCase();
		messagelength = plaintext.length();
		
		rails = new char[height][messagelength];
		for (x = 0; x < height; x++)
		{
			for (y = 0; y < messagelength; y++)
			{
				rails[x][y] = '.';
			}
		}
		
		CIPHERTEXT = new char[messagelength];
		
		while(k < height && i < messagelength)
		{
			rails[k][i] = plaintext.charAt(i);
			k++;
			i++;
			if (k == height)
			{
				k = k - 2;
				while(k > 0 && i < messagelength)
				{
					rails[k][i] = plaintext.charAt(i);
					k--;
					i++;
				}
			}
		}
		
		System.out.println("-RESULTS-");		
		for (i = 0; i < height; i++)
		{
			for (j = 0; j < messagelength; j++)
			{
				System.out.print(rails[i][j]);
				if (rails[i][j] != '.')
				{
					CIPHERTEXT[z] = rails[i][j];
					z++;
				}
			}
			System.out.println("\n");
		}
		for (i = 0; i < messagelength; i++)
		{
			System.out.print(CIPHERTEXT[i]);
		}
		System.out.println("\n");
	}
}
			
		
		
	