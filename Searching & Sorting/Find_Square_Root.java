// java code to implement the above approach
import java.lang.Math;

public class Find_Square_Root {
	public static int findSquareRoot(int x)
	{
		// using exponential and logarithmic function to
		// calculate square root of x
		double result = Math.exp(Math.log(x) / 2);
		// floor function to get integer part of the result
		int floorResult = (int)Math.floor(result);

		// If the integer square of the floor result is
		// equal to the input x, then x is a perfect square,
		// and floor result is the square root.
		if (floorResult * floorResult == x) {
			return floorResult;
		}
		else { // If not, then x is not a perfect square,
			// and floor result is the floor of the
			// square root.
			return floorResult;
		}
	}
	// Driver code
	public static void main(String[] args)
	{
		int x = 11;
		int squareRoot = findSquareRoot(x); // calling the findSquareRoot function to
				// calculate the square root

		System.out.println(squareRoot); // printing the result
	}
}

