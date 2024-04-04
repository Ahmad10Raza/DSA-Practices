// You are a poor person in an island. There is only one shop in this island, 
// this shop is open on all days of the week except for Sunday. Consider following constraints: 

// N – Maximum unit of food you can buy each day.
// S – Number of days you are required to survive.
// M – Unit of food required each day to survive.
// Currently, it’s Monday, and you need to survive for the next S days. 
// Find the minimum number of days on which you need to buy food from the shop so that you can survive the next S days, or determine that it isn’t possible to survive. 
// Examples: 

// Input : S = 10 N = 16 M = 2 
// Output : Yes 2 
// Explanation 1: One possible solution is to buy a box on the first day (Monday), it’s sufficient to eat from this box up to 8th day (Monday) inclusive. Now, on the 9th day (Tuesday), you buy another box and use the chocolates in it to survive the 9th and 10th day.
// Input : 10 20 30 
// Output : No 
// Explanation 2: You can’t survive even if you buy food because the maximum number of units you can buy in one day is less the required food for one day.


// Approach: 
// In this problem, the greedy approach of buying the food for some consecutive early days is the right direction. 
// If we can survive for the first 7 days then we can survive any number of days for that we need to check two things 
// -> Check whether we can survive one day or not. 
// -> (S >= 7) If we buy food in the first 6 days of the week and we can survive for the week i.e. total food we can buy in a week (6*N) is greater than or equal to total food we require to survive in a week (7*M) then we can survive. 

// Note : We are buying the food in the first 6 days because we are counting from Monday and the shop will remain close on Sunday.
// If any of the above conditions are not true then we can’t survive else 

// the equation can be derived as :

// the amount of food that we buy should >= the amount of food required to survive.—-> equation 1

// the amount of food that we buy =  number of times we buy (days) * amount of food that we get for one time buy (N)

// the amount of food required to survive = the number of days we need to survive(S) * amount of food required on each day(M).

// now from our equation 1:

// days * N >= S * M

// hence, days = ceil (S * M) / N


public class SurviveOnIsland {
    public static void main(String[] args) {
        int S = 10, N = 16, M = 2;
        System.out.println(survive(S, N, M));
    }

    public static String survive(int S, int N, int M) {
        if((6*N) < (7*M) && M > N) {
            return "No";
        }
        int days = (int)Math.ceil((double)(S*M)/N);
        return "Yes " + days;
    }

    // Another Approach:

        // Check whether the food required for S days can be bought 
        // or not by excluding the Sundays by taking all other days to buy.
        //  If can be bought then greedily buy from the initial day until 
        //  food acquired is greater than or equal to food required for S days.

         // function to find the minimum days 
   public  static int minimumDays(int S, int N, int M) 
    { 
  
        // Food required to survive S days 
        double req = S * M; 
  
        // If buying all possible days except sundays, but 
        // can't provide the sufficient food. If total can't 
        // provide then each week also can't provide. 
        if ((S - S / 7) * N < req) { 
            return -1; 
        } // If possible get the number of days. 
        else { 
            return (int)Math.ceil(req / N); 
        } 
  
        // Or Simply one line code: 
        // return ((S-S/7)*N<S*M) ? -1 : 
        // ceil(static_cast<double>(S*M)/N); 
    } 
  
    
    } 



