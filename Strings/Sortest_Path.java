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
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getSortestPath(path));
    }
}