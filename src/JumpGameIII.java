import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 *
 * Notice that you can not jump outside of the array at any time.
 */

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int curIndex = queue.peek();
            queue.poll();
            if(arr[curIndex]==0) return true;
            int leftIndex = curIndex - arr[curIndex];
            int rightIndex = curIndex + arr[curIndex];
            if(0<=leftIndex&& !visited[leftIndex]) {
                queue.offer(leftIndex);
                visited[leftIndex] = true;
            }
            if(rightIndex<arr.length && !visited[rightIndex]) {
                queue.offer(rightIndex);
                visited[rightIndex] = true;
            }
        }
        return false;

    }
}
