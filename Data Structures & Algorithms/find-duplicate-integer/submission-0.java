class Solution {
    public int findDuplicate(int[] nums) {
        int f = 0;
        int l = 0;

        do {
            l = nums[l];
            f = nums[nums[f]];
        } while (l != f);

        l = 0;
        while (l != f) {
            l = nums[l];
            f = nums[f];
        }

        return l;
    }
}
