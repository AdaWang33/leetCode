import java.util.HashMap;
import java.util.Stack;

// 895. Maximum Frequency Stack
// two maps
// - val --> count, used to update Frequency and get maxFrequency
// - frequency --> stack of val, used for pop
public class MaximumFrequencyStack {
    // class FreqStack {
    HashMap<Integer, Integer> cntMap;
    HashMap<Integer, Stack<Integer>> frequencyMap;
    int curMaxFreq;

    public MaximumFrequencyStack() {
        cntMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        curMaxFreq = 0;
    }
    
    public void push(int val) {
        int curCnt = cntMap.getOrDefault(val, 0);
        cntMap.put(val, ++curCnt);
        curMaxFreq = Math.max(curMaxFreq, curCnt);

        Stack<Integer> stk = frequencyMap.getOrDefault(curCnt, new Stack<>());
        stk.push(val);
        frequencyMap.put(curCnt, stk);
    }
    
    public int pop() {
        int res = frequencyMap.get(curMaxFreq).pop();
        int curCnt = cntMap.get(res);
        cntMap.put(res, --curCnt);

        if (frequencyMap.get(curMaxFreq).size()==0) {
            curMaxFreq--;
        }
        return res;
    }
// }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
