public class buyAndSellStock {
    //2ms beat 93.23% of users
    //Notes: when dealing with arrays, specifically two points, note that
    //you can start from end OR the beginning
    //also remember the point of dp is to always make progress
    public static int maxProfit(int[] prices) {
        int left=0,right=1;
        int max=0, temp;

        while(right<prices.length){ ///O(n)
            temp=prices[right]-prices[left];
            if(prices[left]<prices[right]){ //is non neg return that keep left point
                if(temp>max){
                    max=temp;
                }

            }else {
                left=right; //if neg return shift window completely bc no more progress can be made in that section
            }
            right++; //always make progress accross array
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices={2,1,2,0,1};
        int x = maxProfit(prices);
        System.out.println(x);
    }
}
