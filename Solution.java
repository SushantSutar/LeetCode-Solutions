// 14. Longest Common Prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];
        int idx=0;
        while(idx<s1.length() && idx<s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            }else{
                break;
            }
        }return s1.substring(0,idx);
    }
}

// 121. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        // int res=0;
        // for(int left=0;left<prices.length-1;left++){
        //     int right=left+1;
        //     if(left>right){
        //         continue;
        //     }
        //     while(right>left){
        //         int price=prices[right]-prices[left];
        //         res=Math.max(res,price);
        //         right++;
        //         if(right==prices.length)break;
        //     }
        // }
        // return res;// brute force but time limit excedded
        int buyPrice=prices[0];
        int profit=0;
        for(int i = 1; i < prices.length; i++){
            if(buyPrice>prices[i])buyPrice=prices[i];
            profit=Math.max(profit,prices[i]-buyPrice);
        }
        return profit;
    }
}


// 238. Product of Array Except Self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res[]=new int[nums.length];
        // for(int i=0;i<nums.length;i++){
        //     int temp=1;
        //     for(int j=0;j<nums.length;j++){
        //         if(i==j)continue;                
        //         temp=temp*nums[j];
        //     }
        //     res[i]=temp;
        // }
        // return res;// this was bruteforce which exceded the time limit
        Arrays.fill(res,1);
        int curr=1;
        for(int i = 0; i < nums.length; i++){
            res[i]=res[i]*curr;
            curr=curr*nums[i];
        }
        curr=1;
        for(int i = nums.length-1; i>=0; i--){
            res[i]=res[i]*curr;
            curr=curr*nums[i];
        }
        return res;
    }
}

