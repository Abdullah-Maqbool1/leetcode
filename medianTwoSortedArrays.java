// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 
// Constraints:
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106

class Solution {
 	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 		int[] arr = new int[nums1.length + nums2.length];
 		int index1 = 0, index2 = 0, index = 0;
 		while(index1 < nums1.length && index2 < nums2.length){
 			if(nums1[index1] <= nums2[index2]){
 				arr[index++] = nums1[index1++];
 			}else{
 				arr[index++] = nums2[index2++];
 			}
 		}
 		if(index1 == nums1.length){ 
 			for(; index < nums1.length + nums2.length; index++){
 				arr[index] = nums2[index2++];
 			}
 		}else{
 			for(; index < nums1.length + nums2.length; index++){
 				arr[index] = nums1[index1++];
 			}
 		}        
 		return arr.length % 2 == 1 ? (double)arr[arr.length/2]:
 			(double)(arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
 	}
}
