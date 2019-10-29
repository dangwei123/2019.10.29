1.
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在
一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-duplicate-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findDuplicate(int[] nums) {
        int[] res=new int[nums.length];
        for(int i:nums){
            res[i]++;
        }
        for(int i=1;i<res.length;i++){
            if(res[i]!=1&&res[i]!=0){
                return i;
            }
        }
        return 0;
    }
}


class Solution {
    public int findDuplicate(int[] nums) {
       int fast=nums[0];
        int slow=nums[0];
        do{
            fast=nums[nums[fast]];
            slow=nums[slow];
        }while(fast!=slow);
        int ptr1=nums[0];
        int ptr2=slow;
        while(ptr1!=ptr2){
            ptr1=nums[ptr1];
            ptr2=nums[ptr2];
        }
        return ptr1;
    }
}

2.
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后
数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]!=nums[i-1]){
                count=0;
            }
            if(i!=0&&nums[i]==nums[i-1]){
                count++;
            }
            if(count<2){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}

3.
