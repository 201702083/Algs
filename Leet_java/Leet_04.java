class Leet_04 {
    public static void main(String[] args) {
        int[] n1 = {1,4,6,8,10};
        int[] n2 = {2,3,5,6,7};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double answer = 0;
        int sumIndex = nums1.length + nums2.length;
        int[] sorted = new int[sumIndex/2 + 1];
        int i = 0 ; // sorted index
        int j = 0 ; // nums1 index
        int k = 0 ; // nums2 index
        while ( i < sumIndex/2 + 1){
            if ( j == nums1.length) {sorted[i] = nums2[k]; k ++;}
            else if ( k == nums2.length) {sorted[i] = nums1[j]; j ++;}
            else if ( nums1[j] >= nums2[k] ) {
                sorted[i] = nums2[k];
                k ++;
            } else {
                sorted[i] = nums1[j];
                j++;
            }
            i ++;

        }
        if (sumIndex % 2 > 0){ // odd
            answer = sorted[sumIndex/2];
        } else {
            answer = (sorted[sumIndex/2] + sorted[sumIndex/2 - 1]) / 2.0;
        }
        return answer;
    }
}