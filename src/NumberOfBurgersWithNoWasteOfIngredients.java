import java.util.ArrayList;
import java.util.List;

public class NumberOfBurgersWithNoWasteOfIngredients {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        double x = (tomatoSlices - 2 * cheeseSlices) / 2.;
        double y = (4 * cheeseSlices - tomatoSlices) / 2.;
        if (x < 0 || y < 0 || x != Math.round(x) || y != Math.round(y)) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add((int) x);
        res.add((int) y);
        return res;
    }
}
