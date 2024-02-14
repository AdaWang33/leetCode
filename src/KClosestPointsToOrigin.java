import java.util.Arrays;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /* 
        first
        */
        // Arrays.sort(points, (p1, p2)->p1[0]*p1[0]+p1[1]*p1[1] - p2[0]*p2[0]-p2[1]*p2[1]);
        // return Arrays.copyOfRange(points, 0, k);

        /* 
        Second
        */
        // int[][] res = new int[k][2];
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Double.compare(getDistance(a), getDistance(b)));
        // for(int[] point : points) {
        //     pq.add(point);
        // }
        // for(int i =0;i<k;i++) {
        //     res[i] = pq.poll();
        // }
        // return res;

        /* 
        third -> max heap with priority queue
        */
    //     int[][] res = new int[k][2];
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Double.compare(getDistance(b), getDistance(a)));
    //     for(int[] point : points) {
    //         pq.offer(point);
    //         if(pq.size()>k) {
    //             pq.poll();
    //         }
    //     }
    //     for(int i =0;i<k;i++) {
    //         res[i] = pq.poll();
    //     }
    //     return res;
    // }

    /*
    forth: quick select! most effient but unstable, worst case time complexity O(N*N), average O(N). how?
    */
        int length = points.length;
        int pivotIndex = -1;
        int left = 0, right = length-1;

        while ( left<right ) {
            pivotIndex = getIndexOfPivot(points, left, right);
            if(pivotIndex==k){
                break;
            }
            else if (pivotIndex > k) {
                right = pivotIndex-1;
            } else {
                left = pivotIndex+1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }
        


    private int getIndexOfPivot(int[][] points, int left, int right){
        int[] pivot = points[left]; // vacant it
        while(left<right) {
            while(left<right && getDistance(pivot) <= getDistance(points[right])) {
                right--;
            }
            points[left] = points[right]; //assign it to make in order
            while(left<right && getDistance(pivot) >= getDistance(points[left])) {
                left++;
            }
            points[right] = points[left]; // finish a swap
        }
        points[left] = pivot;
        return left;
    }

    private int getDistance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}