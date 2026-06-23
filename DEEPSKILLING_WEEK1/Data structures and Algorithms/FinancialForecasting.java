import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {
    // Recursive future value: FV(P, r, n) = P * (1+r)^n
    public static double futureValueRecursive(double principal, double rate, int periods) {
        if (periods == 0) return principal;
        return futureValueRecursive(principal * (1 + rate), rate, periods - 1);
    }

    // Memoized version to avoid repeated computation of subproblems
    public static double futureValueMemo(double principal, double rate, int periods) {
        Map<Integer, Double> memo = new HashMap<>();
        return fvMemo(principal, rate, periods, memo);
    }

    private static double fvMemo(double principal, double rate, int periods, Map<Integer, Double> memo) {
        if (periods == 0) return principal;
        if (memo.containsKey(periods)) return memo.get(periods);
        double val = fvMemo(principal * (1 + rate), rate, periods - 1, memo);
        memo.put(periods, val);
        return val;
    }

    public static void main(String[] args) {
        double p = 1000.0; double r = 0.05; int n = 3;
        System.out.println("Recursive FV: " + futureValueRecursive(p, r, n));
        System.out.println("Memoized FV: " + futureValueMemo(p, r, n));
    }
}
