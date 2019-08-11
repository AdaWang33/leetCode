public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        int maxCnt = 0;
        int[] counter = new int[26];

        for (char c : tasks) {
            counter[c - 'A']++;
            if (counter[c - 'A'] > max) {
                maxCnt = 1;
                max = counter[c - 'A'];
            } else if (counter[c - 'A'] == max) {
                maxCnt++;
            }
        }

        int partCnt = max - 1;
        int slotPerPart = n - (maxCnt - 1);
        int availableSlot = partCnt * slotPerPart;
        int taskRemain = tasks.length - max * maxCnt;
        int idle = Math.max(0, availableSlot - taskRemain);
        return idle + tasks.length;
    }
}
