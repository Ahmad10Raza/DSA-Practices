
// Given a array find two sum

// Example 1:
// Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
// Result: YES (for 1st variant)
//        [1, 3] (for 2nd variant)
// Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.

// Example 2:
// Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
// Result: NO (for 1st variant)
// 	[-1, -1] (for 2nd variant)
// Explanation: There exist no such two numbers whose sum is equal to the target.


// Approach: Hashing
// Time Complexity: O(N)
// Space Complexity: O(N)

// Following is the code implementation of the above approach:
// 1. Create a map to store the index of the elements.
// 2. Traverse the array and check if the target – arr[i] is present in the map or not.
// 3. If it is present, then return the index of the current element and the index of the target – arr[i].
// 4. If it is not present, then insert the current element in the map.
// 5. If no such pair is found, return -1.

#include <bits/stdc++.h>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> mp;
    for(int i=0; i<nums.size(); i++) {
        if(mp.find(target - nums[i]) != mp.end()) {
            return {mp[target - nums[i]], i};
        }
        mp[nums[i]] = i;
    }
    return {-1, -1};
}

int main() {
    int n, target;
    cin >> n >> target;
    vector<int> nums(n);
    for(int i=0; i<n; i++) {
        cin >> nums[i];
    }
    vector<int> ans = twoSum(nums, target);
    if(ans[0] == -1) {
        cout << "NO" << endl;
    } else {
        cout << "YES" << endl;
        cout << ans[0] << " " << ans[1] << endl;
    }
    return 0;
}