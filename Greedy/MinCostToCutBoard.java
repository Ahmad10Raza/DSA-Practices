import java.util.Arrays;
// A board of length m and width n is given, we need to break this board into m*n 
// squares such that cost of breaking is minimum. cutting cost for each edge will 
// be given for the board. In short, we need to choose such a sequence of cutting such that cost is minimized. 
// Examples: 
//   // Link: https://www.geeksforgeeks.org/minimum-cost-cut-board-squares/

  


// // Approach: Minimum Cost to cut a board into squares using a greedy algorithm:
// This problem can be solved by greedy approach . To get minimum cost , 
// the idea is to cut the edge with highest cost first because we have less
// number of pieces and after every cut the number of pieces increase . 
// As the question stated Total_cost = Total_cost + edge_cost * total_pieces . 

// At first sort both the array in non-ascending order
// We keep count of two variables vert(keeps track of vertical pieces) and hzntl(keeps track of horizontal pieces). We will initialize both of them with 1.
// We will keep track of two pointers starting from 0th  index of both the array 
// Now we will take the highest cost edge from those pointers and multiply them with the corresponding variable. That is if we cut a horizontal cut we will add (edge_cost*hzntl) and increase vert by 1 and if we cut a vertical cut we will add(edge_cost*vert) and increase hzntl bt 1 .
// After cutting all the edges we will get the minimum cost


public class MinCostToCutBoard {
    
    public static void main(String[] args) {
        int m = 6, n = 4;
        int[] horizontal = {2, 1, 3, 1, 4};
        int[] vertical = {4, 1, 2};
        System.out.println(minCost(m-1, n-1, horizontal, vertical));
    }

    public static int minCost(int m, int n, int[] horizontal, int[] vertical) {
        int totalCost = 0;
        int vert = 1, hzntl = 1;
        Arrays.sort(horizontal);
        Arrays.sort(vertical);
        int i = m-1, j = n-1;
        while(i >= 0 && j >= 0) {
            if(horizontal[i] > vertical[j]) {
                totalCost += horizontal[i] * vert;
                hzntl++;
                i--;
            } else {
                totalCost += vertical[j] * hzntl;
                vert++;
                j--;
            }
        }
        while(i >= 0) {
            totalCost += horizontal[i] * vert;
            hzntl++;
            i--;
        }
        while(j >= 0) {
            totalCost += vertical[j] * hzntl;
            vert++;
            j--;
        }
        return totalCost;
    }
}