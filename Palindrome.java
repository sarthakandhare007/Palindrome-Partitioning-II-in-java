public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        
        // Precompute palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPal[i+1][j-1])) {
                    isPal[i][j] = true;
                }
            }
        }
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i; // max cuts
                for (int j = 0; j < i; j++) {
                    if (isPal[j+1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n-1];
    }

    // Quick test
    public static void main(String[] args) {
        PalindromePartitioningII sol = new PalindromePartitioningII();
        System.out.println(sol.minCut("aab")); // Output: 1
        System.out.println(sol.minCut("a"));   // Output: 0
        System.out.println(sol.minCut("ab"));  // Output: 1
    }
}
