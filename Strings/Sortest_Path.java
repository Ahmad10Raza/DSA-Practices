
// You are given a string path, where path[i] = 'N', 'S', 'E' or 'W',  
// representing moving one unit north, south, east, or west, respectively.
// You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
// Return the destination point after the path has been followed.
// A valid path can be formed from path.
// Example 1:
// Input: path = "NES"
// Output: true
// Explanation: Notice that there is no cycle.
// Example 2:
// Input: path = "NESWW"
// Output: false
// Explanation: Notice that there is cycle.



public class Sortest_Path {
    public static float getSortestPath(String path){
        int x=0, y=0;
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i) == 'N') y++;
            else if(path.charAt(i) == 'S') y--;
            else if(path.charAt(i) == 'E') x++;
            else if(path.charAt(i) == 'W') x--;
        }
        return (float)Math.sqrt(x*x + y*y);
    }

    public static boolean isPathCycle(String path){
        int x=0, y=0;
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i) == 'N') y++;
            else if(path.charAt(i) == 'S') y--;
            else if(path.charAt(i) == 'E') x++;
            else if(path.charAt(i) == 'W') x--;
        }
        return x==0 && y==0;
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getSortestPath(path));
    }
}