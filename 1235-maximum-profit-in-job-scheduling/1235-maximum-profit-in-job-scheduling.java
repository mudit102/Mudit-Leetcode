class JobItem implements Comparable<JobItem> {
    int startTime, endTime, profit;

    JobItem(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }

    public int compareTo(JobItem next) {
        return this.startTime - next.startTime;
    }

    public String toString() {
        return this.startTime + " -> " + this.endTime + " | " + this.profit;
    }
}

class Solution {
    private Integer dp[];

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        dp = new Integer[startTime.length];

        JobItem jobs[] = new JobItem[startTime.length];

        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new JobItem(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs);
        return getMaxProfit(jobs, 0);
    }

    private int getMaxProfit(JobItem[] jobs, int curIdx) {
        if (curIdx >= jobs.length) {
            return 0;
        }

        if (dp[curIdx] != null) {
            return dp[curIdx];
        }
        
        int profitIfNotIncluded = getMaxProfit(jobs, curIdx + 1);
        int nextPossibleIndex = findNextPossibleIndex(jobs, curIdx);
        int profitIfIncluded = jobs[curIdx].profit + getMaxProfit(jobs, nextPossibleIndex);

        return dp[curIdx] = Math.max(profitIfIncluded, profitIfNotIncluded);
    }

    private int findNextPossibleIndex(JobItem[] jobs, int curIdx) {
        int lastJobEndTime = jobs[curIdx].endTime;

        int start = curIdx + 1, end = jobs.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (jobs[mid].startTime < lastJobEndTime) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }


}