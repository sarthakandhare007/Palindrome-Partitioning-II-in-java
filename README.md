Problem

Given a string s, partition it into substrings such that every substring is a palindrome.
Return the minimum number of cuts needed.


---

Example

Input: s = "aab"
Output: 1
Explanation: "aab" → "aa" | "b"


---

🔹 Intuition

We need the minimum cuts → DP problem.

Precompute palindrome table using DP:

isPal[i][j] = true if s[i..j] is a palindrome.


Then compute min cuts:

dp[i] = minimum cuts needed for substring s[0..i].

If s[0..i] itself is a palindrome → dp[i] = 0.

Otherwise, try all j < i:

If s[j+1..i] is a palindrome → dp[i] = min(dp[i], dp[j] + 1).



# Palindrome-Partitioning-II-in-java
