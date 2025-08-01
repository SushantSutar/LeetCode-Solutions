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

// the below code is easy level asked in the Thinkbridge company 
//the question 
/*
For encoding an even-length binary string into a sequence of A, T, C, and G, we iterate from left to
 right and replace the characters as follows 00 is replaced with A 01 is replaced with T 10 is replaced
 with C 11 is replaced with G Given a binary string S of length N (N is even), find the encoded
 sequence.
 Input Format : First line will contain T, number of test cases. Then the test cases follow. Each test case
 contains two lines of input. First line contains a single integer N, the length of the sequence. Second line
 contains binary string S of length N.
 Output Format : For each test case, output in a single line the encoded sequence
*/
import java.util.Arrays;
public class Main
{
	public static String findEncode(String bin) {
		int n=bin.length();
		String res="";
		for (int i=0; i<bin.length()-1; i++ ) {
			if (bin.charAt(i)=='0' && bin.charAt(i+1)=='0') res=res+"A";
			if (bin.charAt(i)=='0' && bin.charAt(i+1)=='1') res=res+"T";
		    if (bin.charAt(i)=='1' && bin.charAt(i+1)=='0') res=res+"C";
		    if (bin.charAt(i)=='1' && bin.charAt(i+1)=='1') res=res+"G";
		    i++;
		}
		return res;
	}

	public static void main (String[] args) {
		System.out.print("ans = "+ findEncode("1010"));
	}
}



/* medium level code company -Thinkbridge

✈️ Problem Statement: Chef and Her Bags
Chef is planning to take three bags on a flight. Their weights are A, B, and C kilograms respectively.
According to airline regulations:
She must check-in exactly two of the bags.
She must carry one of the bags with her.
The total weight of the two checked-in bags must not exceed D kilograms.
The weight of the carried bag must not exceed E kilograms.
Your task is to determine whether Chef can take all three bags on the flight without violating any airline weight restrictions.
    
📥 Input Format
The first line contains a single integer T — the number of test cases.
Each of the next T lines contains five space-separated integers: A B C D E — where A, B, C are the weights of the bags, 
    D is the maximum total weight allowed for the checked-in bags, and E is the maximum allowed weight for the carried bag.
    
📤 Output Format
For each test case, print "YES" if Chef can take all three bags according to the rules, otherwise print "NO".
You may print the output in any combination of uppercase and lowercase letters.*/


import java.util.Arrays;
public class Main
{
    public static boolean ChefandHerBags(String str){
        String[] tem=str.split(" ");
        // for(int i=0;i<tem.length;i++){
        //     System.out.println("Message = "+ tem[i]);
        // } 
        int temp=Integer.parseInt(tem[0])+Integer.parseInt(tem[1])+Integer.parseInt(tem[2]);
        // System.out.println(temp);
        if (temp-Integer.parseInt(tem[4])<Integer.parseInt(tem[3]) && (  
            Integer.parseInt(tem[0]) <Integer.parseInt(tem[4])  ||
            Integer.parseInt(tem[1]) <Integer.parseInt(tem[4])   ||
            Integer.parseInt(tem[2]) <Integer.parseInt(tem[4]))) {
            
            return true;
        }
        return false;
    }
	public static void main (String[] args) {
	    String st="8 5 7 15 6";
	    System.out.print("answer = "+ ChefandHerBags(st));
	}
}
