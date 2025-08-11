
public class MathOperations {
	
	public static void printTable(int number) {
		for (int i=1;i<=10;i++) {
			System.out.println(number + " x " + i + " = " + number*i);
		}
	}
	
	public static void calculateFactorial(int number) {
		int fact =1;
		if(number == 0) {
			System.out.println("The factorial of 0 is 1");
		}
		else {
			for (int i=1;i<=number;i++) 
			{
				fact*=i;
			}
			System.out.println("Factorial of "+number+" is "+fact);
		}
	}
	
	public static void checkPrime(int number) {
	    if (number <= 1) {
	        System.out.println(number + " is not a prime number");
	        return;
	    }

	    boolean isPrime = true;
	    for (int i = 2; i <= Math.sqrt(number); i++) {
	        if (number % i == 0) {
	            isPrime = false;
	            break;
	        }
	    }

	    if (isPrime) {
	        System.out.println(number + " is a prime number");
	    } else {
	        System.out.println(number + " is not a prime number");
	    }
	}
	
	public void printFibonacci(int terms) {
        if (terms <= 0) {
            System.out.println("Please enter a positive number of terms.");
            return;
        }else {
	        int a = 0, b = 1;
	        System.out.print("Fibonacci Series: " + a + "," + b);
	        for (int i = 2; i < terms; i++) {
	        	int next = a + b;
	            System.out.print(", " + next);
	            a = b;
	            b = next;
	        }
	        System.out.println();
        }
    }
}

