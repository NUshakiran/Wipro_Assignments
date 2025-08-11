
public class StringUtility {
	public static int countVowels(String str) {
		String str1 = str.toUpperCase();
		int count =0;
		for (int i=0;i<str1.length();i++) {
			char ch = str1.charAt(i);
			if(ch == 'A' || ch=='E'|| ch =='I'|| ch=='O' || ch=='U' ) {
				count++;
			}
		}
	return count;
	}
    public static int countConsonants(String str) {
	String str2 = str.toUpperCase();
	int count1 =0;
	for (int i=0;i<str2.length();i++) {
		char ch = str2.charAt(i);
		if(ch != 'A' || ch!='E'|| ch !='I'|| ch!='O' || ch!='U' ) {
			count1++;
		}
	}
	return count1;	
    }

    public static String toUpperCase(String str) {
    	return str.toUpperCase();
    }

    public static String toLowerCase(String str) {
    	return str.toLowerCase();
    }

    public static String replace(String str,String oldWord,String newWord) {
    	return str.replace(oldWord, newWord);
    }
    
    public static String reverseString(String str) {
    	String reverse = "";
    	for (int i=str.length()-1; i>=0;i--) {
    		reverse += str.charAt(i);
    	}
    	return reverse;
    }
    
    public static boolean isPalindrome(String str) {
    	String reversed = reverseString(str);
    	return str.equalsIgnoreCase(reversed);
    }

}
