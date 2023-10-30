// Java code to implement the approach

class GFG {

	// Function to check if it is possible
	// to position the cow x distance apart
	static boolean ok(int[] v, int x, int c)
	{
		int n = v.length;

		// We already place it at the first
		// available slot i.e v[0](Greedy)
		int count = 1;
		int d = v[0];
		for (int i = 1; i < n; i++) {
			if (v[i] - d >= x) {
				d = v[i];
				count++;
			}
			else {
				continue;
			}
		}
		if (count >= c) {
			return true;
		}
		return false;
	}
	// Function to find the maximum possible
	// minimum distance between the cows
	static int aggressive_cows(int[] v, int n, int k)
	{
		// Just take l = 1 and high = 1000000
		// or any large number
		int l = 1;
		int r = 1000000000;
		int ans = -1;

		// Applying Binary search
		while (r >= l) {
			int mid = l + (r - l) / 2;
			if (ok(v, mid, k)) {
				ans = mid;
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
		}

		return ans;
	}

     static int aggressive_cowss(int[] v, int n, int k) // T(n) = O(nlogn)
    {
        // Just take l = 1 and high = 1000000
        // or any large number
        int l = 1;
        int r = 1000000000;
        int ans = -1;

        // Applying Binary search
        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (ok(v, mid, k)) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return ans;
    }




	// Driver code
	public static void main(String[] args)
	{
		int K = 3;
		int[] arr = new int[] { 1, 2, 8, 4, 9 };
		int N = arr.length;

		// Function call
		System.out.println(aggressive_cows(arr, N, K));
        System.out.println(aggressive_cowss(arr, N, K));
	}
}

