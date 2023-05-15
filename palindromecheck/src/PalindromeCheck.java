import java.util.Scanner;

public class PalindromeCheck {

//all numbers,symbols, and spaces are ignored, only counts upper and lowercase letters
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to see if it is a palindrome: ");
        String input = scanner.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();// finds and replaces all characters not in the brackets to ""
        if (isPalindrome(input)) {
            System.out.println("\nThe input IS a palindrome!");
        } else {
            System.out.println("\nThe input IS NOT a palindrome.");
        }
    }
    //function which checks first and last letters until the substring gets smaller and smaller and reaches 1
    //if first and last letter of string or substring do not match, returns false
    public static boolean isPalindrome(String input) {
        if (input.length() <= 1) {
            return true;
        } else if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return false;
        } else {
            return isPalindrome(input.substring(1, input.length() - 1));
        }
    }
}



