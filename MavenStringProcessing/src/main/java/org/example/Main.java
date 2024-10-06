package org.example;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StringProcessor myStringProcessor = new StringProcessor();
        while(true)
        {
            System.out.println(" ");
            System.out.println("MavenStringProcessing:");
            System.out.println("Options:");
            System.out.println("0) Exit");
            System.out.println("1) Check Password");
            System.out.println("2) Calculate Digits");
            System.out.println("3) Calculate Words");
            System.out.println("4) Calculate Expression");

            int userInputInterface = scanner.nextInt();
            scanner.nextLine();

            System.out.println(" ");
            if(userInputInterface == 0)
            {
                break;
            }
            else if(userInputInterface == 1)
            {
                System.out.println("Check Password");
                System.out.println("Enter Password for Checking: ");
                String userInput = scanner.nextLine();
                scanner.nextLine();

                if(myStringProcessor.isStrongPassword(userInput))
                {
                    System.out.println("Password " + userInput + " is STRONG");
                }
                else if(!myStringProcessor.isStrongPassword(userInput))
                {
                    System.out.println("Password " + userInput + " is WEAK");
                }
            }
            else if (userInputInterface == 2)
            {
                System.out.println("Calculate Digits");
                System.out.println("Enter your sentence: ");
                String userInput = scanner.nextLine();
                scanner.nextLine();
                System.out.println("There are " + myStringProcessor.calculateDigits(userInput) + " digits in sentence: " + userInput);
            }
            else if(userInputInterface == 3)
            {
                System.out.println("Calculate Words");
                System.out.println("Enter your sentence:");
                String userInput = scanner.nextLine();
                scanner.nextLine();
                System.out.println("There are " + myStringProcessor.calculateWords(userInput) + " words in sentence: " + userInput);
            }
            else if (userInputInterface == 4)
            {
                System.out.println("Calculate Expression");
                System.out.println("Enter expression:");
                String userInput = scanner.nextLine();
                scanner.nextLine();
                System.out.println(userInput + " = " + myStringProcessor.calculateExpression(userInput));
            }
            else
            {
                System.out.println("Invalid Input");
            }

            Scanner waitScanner = new Scanner(System.in);
            System.out.println("\nPress Enter to continue...");
            waitScanner.nextLine();
        }
    }
}