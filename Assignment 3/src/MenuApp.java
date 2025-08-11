import java.util.Scanner;

public class MenuApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MathOperations mathOps = new MathOperations();
		
		int choice;
		do {
            System.out.println(" Math Utility Menu ");
            System.out.println("1. Print Multiplication Table");
            System.out.println("2. Calculate Factorial");
            System.out.println("3. Check Prime Number");
            System.out.println("4. Print Fibonacci Series");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    int tableNum = sc.nextInt();
                    MathOperations.printTable(tableNum);
                    break;

                case 2:
                    System.out.print("Enter a number: ");
                    int factNum = sc.nextInt();
                    MathOperations.calculateFactorial(factNum);
                    break;

                case 3:
                    System.out.print("Enter a number: ");
                    int primeNum = sc.nextInt();
                    MathOperations.checkPrime(primeNum);
                    break;

                case 4:
                    System.out.print("Enter number of terms: ");
                    int fibTerms = sc.nextInt();
                    mathOps.printFibonacci(fibTerms);
                    break;

                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
	}
}
