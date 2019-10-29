1.
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3){
            return -1;
        }
        int min=Math.abs(nums[0]+nums[1]+nums[2]-target);
        int res=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    if(Math.abs(sum-target)<min){
                        min=Math.abs(sum-target);
                        if(min==0){
                            return target;
                        }
                        res=nums[i]+nums[j]+nums[k];
                    }
                    
                }
            }
        }
        return res;
    }
}

2.
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条
垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴
共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。
示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxArea(int[] height) {
        int res=Math.min(height[0],height[1]);
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                if(Math.min(height[i],height[j])*(j-i)>res){
                    res=Math.min(height[i],height[j])*(j-i);
                }
            }
        }
        return res;
    }
}


class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int res=0;
        while(l<r){
            res=Math.max(res,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}