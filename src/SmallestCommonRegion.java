import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SmallestCommonRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> curList : regions) {
            String curKey = curList.get(0);
            map.put(curKey, curList.subList(1, curList.size()));
        }
        return findCommon(regions.get(0).get(0), map, region1, region2);
    }

    public String findCommon(String curRegionHead, HashMap<String, List<String>> map, String region1, String region2) {
        if (curRegionHead.equals(region1) || curRegionHead.equals(region2)) {
            return curRegionHead;
        }

        if (map.get(curRegionHead) != null) {
            List<String> followers = map.get(curRegionHead);
            List<String> tmp = new ArrayList<>();
            for (String curFollower : followers) {
                String tmpRes = findCommon(curFollower, map, region1, region2);
                if (tmpRes != null) {
                    tmp.add(tmpRes);
                }
            }
            if (tmp.size() == 2) return curRegionHead;
            if (tmp.size() == 1) return tmp.get(0);
        }

        return null;
    }
}
