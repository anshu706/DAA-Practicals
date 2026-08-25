/* 3
 * There are N children standing in a line with some rating value. Distribute a minimum number of candies such that:
 * Each child has at least one candy.
 * Children with higher ratings get more candies than their neighbors.
 * Write a program to calculate the minimum candies required.
 */

import java.util.Scanner;

public class Practical_3 //CandyDistribution
{

    public static int minCandies(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];

        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i],
                                      candies[i + 1] + 1);
            }
        }

        int total = 0;

        for (int candy : candies) {
            total += candy;
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of children: ");
        int n = sc.nextInt();

        int[] ratings = new int[n];

        System.out.print("Enter ratings: ");
        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }

        System.out.println("Minimum Candies Required: "
                           + minCandies(ratings));

        sc.close();
    }
}

/*   ---- Leetcode Question 135 -----

class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i=1; i<n; i++){
            if (ratings[i] > ratings[i-1]){
                ans[i] = ans[i-1] + 1;
            }
        }

        for (int i = n-2; i>=0; i--){
            if (ratings[i] > ratings[i+1]){
                ans[i] = Math.max(ans[i], ans[i+1] + 1);
            }
        }

        int sum = 0;
        for(int num: ans) {
            sum += num;
        }

        return sum;
    }
}

*/