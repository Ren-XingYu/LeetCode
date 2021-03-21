package x.y.z;

public class LeetCode_0509 {
    // 递归方式
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 迭代方式
    public int fib_for(int n) {
        if (n < 2) {
            return n;
        }
        int prev = 0, curr = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    // 备忘录方式：自顶向下
    private Integer[] cache;

    public int fib_memo(int n) {
        if (n < 2) {
            return n;
        }
        cache = new Integer[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        return memo_fib(n);
    }

    public int memo_fib(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        cache[n] = memo_fib(n - 1) + memo_fib(n - 2);
        return cache[n];
    }

    // dp：自底向上
    public int fib_dp(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
