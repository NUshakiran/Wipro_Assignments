import java.util.Scanner;

public class StringAssignmentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a String : ");
		String input = sc.nextLine();
		int choice;
		do {
			System.out.println("1.Count Vowels");
			System.out.println("2.Count Consonants");
			System.out.println("3.Check Palindrome");
			System.out.println("4.Reverse String");
			System.out.println("5.Convert to UpperCase");
			System.out.println("6.Convert to LowerCase");
			System.out.println("7.Replace a word");
			System.out.println("8.Exit");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			
			switch(choice) {
				case 1: 
					System.out.println("Vowels : " + StringUtility.countVowels(input));
					break;
				case 2 : 
					System.out.println("Consonants : " + StringUtility.countConsonants(input));
					break;
				case 3 :
					if(StringUtility.isPalindrome(input)) {
						System.out.println("It is a Palindrome");
					}
					else {
						System.out.println("It is not a Palindrome");
					}
					break;
				case 4 :
					System.out.println("Reversed String: " + StringUtility.reverseString(input));
					break;
				case 5 : 
					System.out.println("UpperCase: " + StringUtility.toUpperCase(input));
					break;
				case 6 :
					System.out.println("LowerCase " + StringUtility.toLowerCase(input));
					break;
				case 7 :
					System.out.println("Enter a word to replace : ");
					String oldWord = sc.nextLine();
					System.out.println("Enter a new word : ");
					String NewWord = sc.nextLine();
					String modified = StringUtility.replace(input, oldWord, NewWord);
					System.out.println("Updated String: " +modified );
					break;
				case 8:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Invalid choice");
			}
		} while(choice != 8);
		
	}

}
