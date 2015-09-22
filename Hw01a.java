// *****************************************************************************
// * Student Name: Mark Land                          Moorpark College         *
// * Program Name: Hw01.java                          CS M10J (Intro Java)     *
// * Comment     : Control Structures Program         Intro to Prog using Java *
// *               Homework 1a, due 9-22-15           Fall of 2015             *
// *               Stock Tickers                      Prof. John C. Reynolds   *
// *****************************************************************************

// Program Purpose:

// Packages~Libraries~Modules:

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Hw01a
{
	// Class-Global Constants ~ Variables ~ Object Instantiation:
	
	static Scanner console = new Scanner(System.in);
	
	static int menu_choice;
	
	static double stock_ticker_1_price, stock_ticker_2_price, price_input;
	
	static String stock_ticker_1_name, stock_ticker_2_name, name_input;
	
	static final String menu_display = "Enter \'1\' to get price by stock " +
		"ticker\nEnter \'2\' to get stocks greater than or equal to specified "
		+ "price\nEnter \'3\' to quit\nYour choice: ";
	
	// Methods~Functions:
	
	public static void main(String[] args) throws FileNotFoundException
	{
		// Local Variable Definitions ~ Initializations ~ Object Instantiating:
		
		// program:
		
		Header();
		Purpose();
		Read_File_Data();
		Program();
	}
	
	public static void Header()
	{
		// Header Info Displayment:
		
		System.out.println("\n\n****************************************" +
			"****************************************");
		System.out.println("* Student Name: Mark Land                        " +
			"     Moorpark College         *");
		System.out.println("* Program Name: Hw01.java                          "
			+ "   CS M10J (Intro Java)     *");
		System.out.println("* Comment     : Control Structures Program         "
			+ "   Intro to Prog using Java *");
		System.out.println("*               Homework 1a, due 9-22-15           "
			+ "   Fall of 2015             *");
		System.out.println("*               Stock Tickers                      "
			+ "   Prof. John C. Reynolds   *");
		System.out.println("****************************************" +
			"****************************************\n\n");
	}
	
	public static void Purpose()
	{
		// Purpose Displayment:
		
		System.out.println("The purpose of this program is to compare user \n" +
			"inputs of stock ticker names or prices, with data from a file, \n"
			+ "displaying the current price of the specified stock ticker or \n"
			+ "in whether any of the stock tickers\' current price is over \n" +
			"the user\'s inputed price.\n\n");
	}
	
	public static void Read_File_Data() throws FileNotFoundException
	{
		Scanner read_file = new Scanner(new FileReader("stocks.txt"));
		
		// just for segmenting these file prompts from rest of program:
		
		System.out.println("----------------------------------------" +
			"----------------------------------------\n\n");
		
		// prompting the user that the 'stocks.txt' file is opened, and being
		// 		read by the program:
		
		System.out.println("The \'stocks.txt\' file has been opened, and is " +
			"being read by the program.\n\n");
		
		// reading and temporarily storing the data from the 'inData.txt' file:
		
		stock_ticker_1_name = read_file.next();
		stock_ticker_1_price = read_file.nextDouble();
		
		stock_ticker_2_name = read_file.next();
		stock_ticker_2_price = read_file.nextDouble();
		
		// close the 'stocks.txt' File:
		
		read_file.close();
		
		// prompt the user that the 'stocks.txt' file has been closed:
		
		System.out.println("The \'stocks.txt\' file's data has been read and \n"
			+ "stored, and the file has been closed.\n\n");
			
		// no simple way of clearing the console screen with java, so I am just
		//		separating the file prompts from actual stock ticker program:
			
		System.out.println("----------------------------------------" +
			"----------------------------------------\n\n");
	}
	
	public static void Program()
	{
		// main menu functionality:
		
		System.out.print(menu_display);
		menu_choice = console.nextInt();
		switch (menu_choice)
		{
			case 1:
				System.out.print("\n\nEnter a stock ticker: ");
				name_input = console.next();
				Name_Check(name_input);
				break;
			case 2:
				System.out.print("\n\nEnter a price: $");
				price_input = console.nextDouble();
				Price_Check(price_input);
				break;
			case 3:
				System.out.println("\n\nGoodbye\n");
				System.exit(0);
			default:
				System.out.println("\n\nUnrecognized menu option, exiting\n");
		}
	}
	
	public static void Name_Check(String name_parameter)
	{
		// check name input and (display and~or handle) results for menu
		
		if (name_parameter.compareToIgnoreCase(stock_ticker_1_name) == 0)
		{
			System.out.printf("%n%n%s current price is $%.2f%n%n",
				stock_ticker_1_name, stock_ticker_1_price);
		}
		else if (name_parameter.compareToIgnoreCase(stock_ticker_2_name) == 0)
		{
			System.out.printf("%n%n%s current price is $%.2f%n%n",
				stock_ticker_2_name, stock_ticker_2_price);
		}
		else
		{
			System.out.println("\n\n\nWrong input, try again\n\n");
			Program();
		}
	}
	
	public static void Price_Check(double price_parameter)
	{
		// check price input and (display and~or handle) results for menu
		
		if (price_parameter <= stock_ticker_1_price &&
			price_parameter <= stock_ticker_2_price)
		{
			System.out.printf("%n%n%s is more than $%.2f%n%s is more than $" +
				"%.2f%n%n", stock_ticker_1_name, price_parameter,
				stock_ticker_2_name, price_parameter);
		}
		else if (price_parameter <= stock_ticker_1_price)
		{
			System.out.printf("%n%n%s is more than $%.2f%n%n",
				stock_ticker_1_name, price_parameter);
		}
		else if (price_parameter <= stock_ticker_2_price)
		{
			System.out.printf("%n%n%s is more than $%.2f%n%n",
				stock_ticker_2_name, price_parameter);
		}
		else
		{
			System.out.printf("%n%nNeither %s nor %s is more than $%.2f%n%n",
				stock_ticker_1_name, stock_ticker_2_name, price_parameter);
		}
	}
}
