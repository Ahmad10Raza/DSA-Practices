public class Tiling_Problem {
    public static int Tiling(int n){
        //base case if n=0 then still 1 ways to do work
        if(n==0 || n==1){
            return 1;
        }
        int hori_ways=Tiling(n-2);
        int vert_ways=Tiling(n-1);
        return hori_ways+vert_ways;
    }
    public static void main(String[] args) {
        int n=4;
        int ways=Tiling(n);
        System.out.println(ways);
    }
}