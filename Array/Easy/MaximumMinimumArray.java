import java.util.*;

public class MaximumMinimumArray {
    public static ArrayList<Integer> getMinMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int item: arr) {
            if (item > max) {
                max = item;
            } else if (item < min) {
                min = item;
            }
        }

        return new ArrayList<>(List.of(max, min));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ArrayList<Integer> answer = getMinMax(arr);
        System.out.print(answer.get(0) + " " + answer.get(1));

        scanner.close();
    }
}