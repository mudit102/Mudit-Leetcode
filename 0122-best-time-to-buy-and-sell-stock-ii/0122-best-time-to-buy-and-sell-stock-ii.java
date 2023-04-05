class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length==1) return 0;
        int min=prices[0], profit=0, tot=0;

        for (int i=1; i<prices.length; i++){

            if (prices[i]- min > profit) profit = prices[i]-min;

            if (prices[i]<=min){
                tot+=profit;
                profit=0;
                min=prices[i];
            }

            //price dropped so should sell prev day and buy lower
            //do not buy if it is the last day
            if (prices[i]<prices[i-1] && i!=(prices.length-1)){
                tot+=profit;
                profit=0;
                min=prices[i];
            }
        }
        return tot+=profit; //add the last profit if there is

    }
}