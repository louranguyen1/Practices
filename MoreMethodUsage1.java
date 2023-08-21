package com.company;

public class MoreMethodUsage1 {
    //find perfect sums
    public static void main (String args[]) {
        for (int i = 2; i <= 1000; i++) {
            if (perfect(i)) {
                System.out.println(" " + i);
            }
        }
    }
    public static boolean perfect(int n) {
        int sum = 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        return sum == n;
    }
}
