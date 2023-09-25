public class Friends_Pairing_Problem {
    public static int friend_pair(int n){
        //base case 
        if(n==1 || n==2){
            return n;
        }
        // choice first not want to pair with anyone
        int single=friend_pair(n-1);

        // choice second want to pair with anyone
        int pair=friend_pair(n-2)*(n-1);
        int total_ways=single+pair;
        return total_ways;
    }
    public static int pair(int n){
        if(n==1 || n==2){
            return n;
        }
        return pair(n-1)+pair(n-2)*(n-1);
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(friend_pair(n));
        System.out.println(pair(n));

    }
}