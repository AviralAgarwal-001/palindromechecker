import java.util.*;

public class PalindromeCheckerApp {

    public static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeMethod(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static boolean recursiveMethod(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursiveMethod(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        long start1 = System.nanoTime();
        boolean stackResult = stackMethod(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean dequeResult = dequeMethod(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean recursiveResult = recursiveMethod(input, 0, input.length() - 1);
        long end3 = System.nanoTime();

        System.out.println("Stack Method Result: " + stackResult + " Time: " + (end1 - start1) + " ns");
        System.out.println("Deque Method Result: " + dequeResult + " Time: " + (end2 - start2) + " ns");
        System.out.println("Recursive Method Result: " + recursiveResult + " Time: " + (end3 - start3) + " ns");

        sc.close();
    }
}