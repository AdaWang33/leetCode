import java.util.ArrayList;
import java.util.List;

public class IteratorForCombination {
    List<String> res;
    int nextIndex = 0;

    public IteratorForCombination(String characters, int combinationLength) {
        res = new ArrayList<>();
        generateCombination(characters, 0, combinationLength, new StringBuilder());
    }

    public void generateCombination(String characters, int index, int combinationLength, StringBuilder sb) {
        if (sb.length() == combinationLength) {
            res.add(sb.toString());
            return;
        }

        if (index == characters.length()) return;

        for (int i = index; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            generateCombination(characters, i+1, combinationLength, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    public String next() {
        String ans = res.get(nextIndex);
        nextIndex++;
        return ans;
    }

    public boolean hasNext() {
        if (nextIndex < res.size()) return true;
        else return false;
    }
}
