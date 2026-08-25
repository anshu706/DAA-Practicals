/* 4
There is a new barn with N stalls and C cows. The stalls are located at positions x1, x2, ..., xN. Assign the cows to stalls such that the minimum distance between any two cows is as large as possible. Find the largest minimum distance.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Practical_4 // AggressiveCows
{

    static boolean canPlace(int[] stalls, int cows, int dist) {
        int count = 1;
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];

                if (count == cows)
                    return true;
            }
        }
        return false;
    }

    static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stalls: ");
        int n = sc.nextInt();

        int[] stalls = new int[n];

        System.out.print("Enter stall positions: ");
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        System.out.print("Enter number of cows: ");
        int cows = sc.nextInt();

        System.out.println("Largest Minimum Distance = "
                + aggressiveCows(stalls, cows));

        sc.close();
    }
}


/* ---- Leetcode Question 1552 ----

class Solution {
    public int maxDistance(int[] position, int m) {
        return aggressiveCows(position, m);
    }

    static boolean canPlace(int[] stalls, int cows, int dist) {
        int count = 1;
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];

                if (count == cows)
                    return true;
            }
        }
        return false;
    }

    static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stalls: ");
        int n = sc.nextInt();

        int[] stalls = new int[n];

        System.out.print("Enter stall positions: ");
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        System.out.print("Enter number of cows: ");
        int cows = sc.nextInt();

        System.out.println("Largest Minimum Distance = "
                + aggressiveCows(stalls, cows));

        sc.close();
    }
}

*/