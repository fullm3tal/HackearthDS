package arrays;

import java.util.Scanner;

public class BracketSequence {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] arr = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = String.valueOf(input.charAt(i));
        }
        getTotalShift(arr);
    }


    private static void getTotalShift(String[] arr) {
        int firstCount = 0;
        int secondCount = 0;
        String[] newArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
            if ("(".equals(arr[i])) {
                firstCount++;
            } else if (")".equals(arr[i])) {
                secondCount++;
            }
        }

        if (firstCount == secondCount && arr.length % 2 == 0) {
            int shift = 0;
            int loopCount = firstCount;
            while (loopCount > 0) {
                arr = newArr;
                int index = 0;
                newArr = new String[arr.length - 2];
                String initialValue = arr[arr.length - 1];
                for (int i = arr.length - 2; i >= 0; i--) {
                    if ((arr[i] + initialValue).equals("()")) {
                        for (int j = i - 1; j >= 0; j--) {
                            newArr[index] = arr[j];
                            index++;
                        }
                        break;
                    }
                    if (initialValue == arr[i]) {
                        newArr[index] = arr[i];
                        shift++;
                    } else {
                        shift++;
                        for (int j = i - 1; j >= 0; j--) {
                            newArr[index] = arr[j];
                            index++;
                        }
                        break;
                    }
                }
                loopCount--;
            }
            System.out.println(shift);
        } else {
            System.out.println(0);
        }
    }
}
