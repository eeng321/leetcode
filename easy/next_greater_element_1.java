class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[] {};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            int j = i + 1;
            while(j < nums2.length && nums2[j] < nums2[i]){
                j++;
            }
            if(j < nums2.length){
                map.put(nums2[i], nums2[j]);
            } else {
                map.put(nums2[i], -1);
            }
        }
        for(int i = 0; i < nums1.length; i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}