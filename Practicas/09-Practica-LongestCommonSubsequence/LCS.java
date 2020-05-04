// Longest Common Subsequence
public class LCS {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        System.out.println("length of LCS is " + lcsLenght(X, Y, X.length(), Y.length())); // prints: 7
        System.out.println("LCS=" + lcs(X, Y, X.length(), Y.length())); // prints: BDAB
    }

    // Function to find length of longest Common Subsequence of X[0..m-1] and
    // Y[0..n-1]
    public static int lcsLenght(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return lcsLenght(X, Y, m - 1, n - 1) + 1;
        }
        return Integer.max(lcsLenght(X, Y, m - 1, n), lcsLenght(X, Y, m, n - 1));
    }

    // Function to find the Longest Common Subsequence of X[0..m-1] and Y[0..n-1]
    public static String lcs(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) {
            return "";
        }
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return lcs(X, Y, m - 1, n - 1) + X.charAt(m - 1);
        }

        return maxString(lcs(X, Y, m - 1, n), lcs(X, Y, m, n - 1));
    }

    public static String maxString(String s1, String s2) {
        if (s1.length() > s2.length())
            return s1;
        else
            return s2;
    }
}
