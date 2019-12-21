public class K_thSymbolInGrammar {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (N == 2 && K == 1) return 0;
        if (N == 2 && K == 2) return 1;

        if (K % 2 == 1) {
            return kthGrammar(N - 1, K / 2 + 1);
        } else {
            return 1 - kthGrammar(N - 1, K / 2);
        }
    }
}
