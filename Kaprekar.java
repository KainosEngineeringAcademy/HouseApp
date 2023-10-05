import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;

/*
6174 is known as one of Kaprekar's constants, after the Indian mathematician D. R. Kaprekar. Number 6174 is notable for the following rule:

* Take any four-digit number, using at least two different digits (leading zeros are allowed).
* Arrange the digits in descending and then in ascending order to get two four-digit numbers, adding leading zeros if necessary.
* Subtract the smaller number from the bigger number.
* Go back to step 2 and repeat.
The above process, known as Kaprekar's routine, will always reach its fixed point, 6174, in at most 7 iterations. Once 6174 is reached, the process will continue yielding 7641 – 1467 = 6174. For example, choose 3524:

5432 – 2345 = 3087
8730 – 0378 = 8352
8532 – 2358 = 6174
7641 – 1467 = 6174

Write a function that will return the number of times it will take to get from a number to 6174 (the above example would equal 3).

(1)5432 – 2345 = 3087,
(2)8730 – 0378 = 8352,
(3)8532 – 2358 = 6174

495 would produce the following: 4950 to 9540 - 459, 9081 to 9810 - 189, 9621 to 9621 - 1269, 8352 to 8532 - 2358 answer: 4

For a 2 digit number, the following would be produced (stating with number 10 -> 100):

100 to 100 - 1, 990 to 990 - 99, 8910 to 9810 - 189, 9621 to 9621 - 1269, 8352 to 8532 - 2358 answer: 5

Examples
kaprekar(6621) ➞ 5
kaprekar(6554) ➞ 4
kaprekar(1234) ➞ 3

Notes
If the subtracted number is less than 1000, add an extra zero to that number. The number 1111 will equal 0000, so this number (1111) is invalid.

 */
public class Kaprekar {
    private static final int MAX_ITERATIONS = 10;
    private static final int KAPREKARS_CONSTANT = 6174;
    private static final int INVALID = 0;

    public static void main(String[] args) {
        String start = "3524";
        int ans = kaprekarRoutine(start);
        kaprekarRoutine(start);
        assert ans == 3;

        start = "495";
        ans = kaprekarRoutine(start);
        assert ans == 4;

        start = "6621";
        ans = kaprekarRoutine(start);
        assert ans == 5;

        start = "6554";
        ans = kaprekarRoutine(start);
        assert ans == 4;

        start = "1234";
        ans = kaprekarRoutine(start);
        assert ans == 3;

        start = "10";
        kaprekarRoutine(start);

        start = "1111";
        kaprekarRoutine(start);
    }

    private static int kaprekarRoutine(String start) {
        String next = singleKeprekarIteration(start);
        int i = 1;

        while (i < MAX_ITERATIONS &&
                !next.equals(String.valueOf(KAPREKARS_CONSTANT)) &&
                !next.equals(String.valueOf(0))) {
            next = singleKeprekarIteration(next);
            i++;
        }

        if (i >= MAX_ITERATIONS) {
            System.err.println("Reached max iterations: " + MAX_ITERATIONS + "\nExiting...");
        } else if (Integer.parseInt(next) == INVALID) {
            System.out.println("Invalid number!");
        } else {
            System.out.println("Finished routine after " + i + " iterations.\n");
        }
        return i;
    }

    protected static String singleKeprekarIteration(String input) {
        ArrayList<Integer> myList = stringToArray(input);

        int a = arrayToInt(getAscending(myList));
        int b = arrayToInt(getDescending(myList));

        int ans = subtract(a, b);
        return String.valueOf(ans);
    }

    protected static ArrayList<Integer> stringToArray(String input) {
        input = pad(input);
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            myList.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        return myList;
    }

    private static String pad(String input) {
        StringBuilder inputBuilder = new StringBuilder(input);
        while (inputBuilder.length() < 4) {
            inputBuilder.insert(0, "0");
        }
        return inputBuilder.toString();
    }

    protected static Integer arrayToInt(ArrayList<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (Integer value : list) {
            builder.append(value);
        }
        String text = builder.toString();
        assert text.length() == 4;
        return Integer.parseInt(text);
    }

    protected static ArrayList<Integer> getDescending(ArrayList<Integer> list) {
        Collections.sort(list);
        return list;
    }

    protected static ArrayList<Integer> getAscending(ArrayList<Integer> list) {
        list.sort(Collections.reverseOrder());
        return list;
    }

    protected static Integer subtract(Integer a, Integer b) {
        Integer ans = a - b;
        System.out.println(a + " - " + b + " = " + ans);
        return ans;
    }
}
