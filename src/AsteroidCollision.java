import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        if (asteroids.length == 0) return asteroids;
        List<Integer> ans;

        boolean hasPositive = false;

        for (int aster : asteroids) {
            if (aster < 0) {
                if (!hasPositive) stk.push(aster);
                else {
                    while (!stk.isEmpty() && stk.peek() > 0 && stk.peek() < -aster) {
                        stk.pop();
                    }
                    if (!stk.isEmpty() && stk.peek() == -aster) {
                        stk.pop();
                        continue;
                    }
                    if (stk.isEmpty() || stk.peek() < 0) {
                        hasPositive = false;
                        stk.push(aster);
                    }
                }
            } else {
                stk.push(aster);
                hasPositive = true;
            }
        }

        ans = new ArrayList<>(stk);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }
}
