import java.util.ArrayList;
import java.util.List;

public class MaximumScoreWordsFormedByLetters {
    List<List<String>> res = new ArrayList<>();
    int[] cnt = new int[26];

    public void generateSubsets(String[] set, int[] cnt) {

        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            List<String> tmp = new ArrayList<>();
            // Print current subset
            for (int j = 0; j < n; j++) {

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                // if (isValid(tmp, cnt) && ((i & (1 << j)) > 0)) tmp.add(set[j]);
                if ((i & (1 << j)) > 0) tmp.add(set[j]);
            }
            if(isValid(tmp, cnt)) res.add(tmp);
        }
    }

    public boolean isValid(List<String> tmp, int[] cnt) {
        int[] alpha = new int[26];
        for (String str : tmp) {
            for (char c : str.toCharArray()) {
                alpha[c - 'a'] += 1;
            }
        }
        for (int i = 0; i < tmp.size(); i++) {
            for(char c: tmp.get(i).toCharArray()){
                if (alpha[c-'a'] > cnt[c-'a']) return false;
            }
        }
        return true;
    }

    public int calculateScore(String str, int[] score) {
        int sco = 0;
        for (char c : str.toCharArray()) {
            sco += score[c - 'a'];
        }
        return sco;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for (char ele : letters) {
            cnt[ele - 'a'] += 1;
        }
        generateSubsets(words, cnt);
        int highestScore = 0;
        for (int i = 0; i < res.size(); i++) {
            int tmpScore = 0;
            for (int j = 0; j < res.get(i).size(); j++) {
                // System.out.println(res.get(i).get(j));
                tmpScore += calculateScore(res.get(i).get(j), score);
            }
            highestScore = Math.max(tmpScore, highestScore);
        }
        return highestScore;
    }
}