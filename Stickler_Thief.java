
class Stickler_Thief {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking count of testcases
        int t = sc.nextInt();
        while (t-- > 0) {

            // taking count of houses
            int n = sc.nextInt();
            int arr[] = new int[n];

            // inserting money present in
            // each house in the array
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            // calling method FindMaxSum() of class solve
            System.out.println(new Solution().FindMaxSum(arr, n));
        }
    }
}


class Solution {
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        // Your code here
        int DP[] = new int[n + 1];
        Arrays.fill(DP, -1);
        DP[0] = arr[0];
        int neg = 0;
        int pick = 0;
        for (int i = 1; i < n; i++) {
            if (i - 2 >= 0) {
                pick = arr[i] + DP[i - 2];
            } else if (i - 2 < 0) {
                pick = neg + arr[i];
            }
            int not_pick = 0 + DP[i - 1];
            DP[i] = Math.max(pick, not_pick);
        }
        return DP[n - 1];

    }
}
