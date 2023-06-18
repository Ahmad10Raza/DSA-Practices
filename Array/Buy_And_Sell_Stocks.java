public class Buy_And_Sell_Stocks {
    public static int Buy_and_Sell_Stocks(int price[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<price.length;i++){
            if(buyPrice<price[i]){ //profit case
            int profit = price[i]-buyPrice;
            maxprofit=Math.max(maxprofit,profit);
            }
            else //loss case
            {
                buyPrice=price[i];
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int price[] = {7,1,5,3,6,4};
    System.out.println(Buy_and_Sell_Stocks(price));
    }
}
