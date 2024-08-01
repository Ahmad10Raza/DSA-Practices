
// Ques: The program is supposed to calculate the sum of  distance between three points from each other.

// For
// x1 = 1 y1 = 1
// x2 = 2 y2 = 4
// x3 = 3 y3 = 6

// Distance is calculated as : sqrt(x2-x1)2 + (y2-y1)2

// The output of the program should be 7.73

// Approach: We need to calculate the distance between three points. We will calculate the distance between the first two points and add it to the distance between the second and third points. We will return the sum of the distances between the three points.

// Follow the below steps to solve the problem:
// 1. Calculate the distance between the first two points using the formula sqrt((x2-x1)^2 + (y2-y1)^2).
// 2. Calculate the distance between the second and third points using the formula sqrt((x3-x2)^2 + (y3-y2)^2).
// 3. Calculate the distance between the first and third points using the formula sqrt((x3-x1)^2 + (y3-y1)^2).
// 4. Return the sum of the distances between the three points.

public class DistancebwThreePoints {

    public static double distancebwThreePoints(int x1, int y1, int x2, int y2, int x3, int y3) {
        double distance1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double distance2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double distance3 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        return distance1 + distance2 + distance3;
    }

    public static void main(String[] args) {
        int x1 = 1;
        int y1 = 1;
        int x2 = 2;
        int y2 = 4;
        int x3 = 3;
        int y3 = 6;
        System.out.println(distancebwThreePoints(x1, y1, x2, y2, x3, y3));
    }
}
