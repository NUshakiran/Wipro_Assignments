import java.util.Scanner;

public class MenuDrivenMathOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char continueChoice ;
		do {
			System.out.println("Menu");
			System.out.println("1.Print the table");
			System.out.println("2.Calculate Factorial");
			System.out.println("3.Check Prime number");
			System.out.println("4.Fibonacci Series");
			System.out.println("5.Exit");
			
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			switch(choice) 
			
			{
			case 1 : 
				System.out.println("Enter the number");
				int num = sc.nextInt();
				for (int i=1;i<=10;i++) {
					System.out.println(num+" x "+i+" = "+ num*i);
				}
				break;
			case 2 :
				System.out.println("Enter the number");
				int num1 = sc.nextInt();
				int fact =1;
				if (num1 ==0) {
					System.out.println("Factorial is 1");
				}
				else 
				{
					for (int i=1;i<=num1;i++) 
					{
						fact*=i;
					}
					System.out.println("Factorial of "+num1+"is "+fact);
				}
				break;
			case 3 :
				System.out.println("Enter a number");
				int num2 = sc.nextInt();
				int count =0;
				if (num2<=1) {
					System.out.println(num2+" is not a prime number");
				}
				else {
					int i = 2;
					while (i < num2) {
					    if (num2 % i == 0) {
					        count++;
					    }
					    i++;
					}
					if(count == 0) {
						System.out.println(num2 + " is a prime number");
					}
					else {
						System.out.println(num2 + " is not a prime number");
					}
				}
				break;
			case 4: 
				System.out.print("Enter how many terms of Fibonacci to print: ");
				int num3 = sc.nextInt();
				if (num3 <= 0) {
			            System.out.println("Please enter a positive number of terms.");
			        } else if (num3 == 1) {
			            System.out.println("Fibonacci Series: 0");
			        } else {
			            int a = 0, b = 1;
			            System.out.print("Fibonacci Series: " + a + ", " + b);
			            for (int i = 2; i < num3; i++) {
			                int next = a + b;
			                System.out.print(", " + next);
			                a = b;
			                b = next;
			            }
			            System.out.println();
			        }
				break;
			case 5: System.out.println("Exit"); 
				break;
			default:System.out.println("Enter the correct number");
			}
			System.out.print("Back to menu (Y/N): ");
			continueChoice = sc.next().charAt(0);
		} while(continueChoice == 'Y');

	}

}
