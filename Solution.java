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


/*56. Merge Intervals leetcode*/



class Solution {
    public int[][] merge(int[][] intervals) {
        // int [][] res=new int[intervals.length-1][2];
        // if(intervals.length ==1)return intervals;
        // for(int i =0; i<intervals.length-1;i++){
        //     if(intervals[i][1]>=intervals[i+1][0]){
        //         res[i][0]=intervals[i][0];
        //         res[i][1]=intervals[i+1][1];
        //     }else{
        //         res[i][0]=intervals[i+1][0];
        //         res[i][1]=intervals[i+1][1];
        //     }
        // }
        // return res; //written by me but not efficient
        if(intervals.length ==1)return intervals;
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        List<int[]> result=new ArrayList<>();
        int[] newInterval=intervals[0];
        result.add(newInterval);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                newInterval = intervals[i];
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}


/* leetcode 771. Jewels and Stones */




class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // char [] jwl=jewels.toCharArray();
        // char [] stn=stones.toCharArray();
        // int count=0;
        // for(int i=0;i<stn.length;i++){
        //     for(int j=0;j<jwl.length;j++){
        //         if(jwl[j]==stn[i])count++;
        //     }
        // }
        // return count;//this is bruteforce and works fine 

        Set<Character> set=new HashSet<>();
        int count =0;
        for(int i=0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        } 
        for(int i=0;i<stones.length();i++ ){
            if(set.contains(stones.charAt(i)))count++;
        }
        return count; 
    }
}




/*Write a program to check given number is EVEN or ODD? */
public class CheckEVEN_ODD{
	public static boolean Check(int num){
		if(num%2==0)return true;
		return false;
	}
	public static void main(String[] args){
		System.out.println(Check(22)?"the number is even":"the number is odd");
	}
}

/* Write a program to display PRIME NUMBERS from 1 to n? */
public class print_prime{
    public static boolean prime(int n){
		if(n<=1)return false;
		if(n==2)return true;
		if (n % 2 == 0) {
        return false;
        }
		for(int i=3;i<=Math.sqrt(n);i +=2){
			if(n%i==0 )
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		for (int i =0 ; i<=50;i++){
		    if(prime(i))System.out.println("no is = "+ i);
		} 
	}
}


/* Write a program to check whether the given number is PRIME or not? */
import java.util.Scanner;
public class isprime{
    public static boolean prime(int n){
		if(n<=1)return false;
		if(n==2)return true;
		if (n % 2 == 0) {
        return false;
        }
		for(int i=3;i<=Math.sqrt(n);i +=2){
			if(n%i==0 )
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println(prime(num)?num+" is prime":num + " is not prime");
	}
}

/* Write a program to find SUM OF PRIME numbers?*/

public class print_prime{
    public static boolean prime(int n){
		if(n<=1)return false;
		if(n==2)return true;
		if (n % 2 == 0) {
        return false;
        }
		for(int i=3;i<=Math.sqrt(n);i +=2){
			if(n%i==0 )
			return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		int sum=0;
		for (int i =0 ; i<=50;i++){
		    if(prime(i))sum=sum+i;
		} 
		System.out.println("sum is = "+sum);
	}
}

/*Write program weather the number is PERFECT NUMBER or not? Def: Perfect number, a positive integer that 
is equal to the sum of its proper divisors. The smallest perfect number is 6, which is the sum of 1, 2, and 3. */

public class Main{

	public static boolean positive_integer(int n){
	    int sum=0;
		for(int i=1;i<=n/2;i++){
			if(n%i==0)sum=sum+i;
		}
		if(sum==n)return true;
		return false;
		
	}
	public static void main(String[] args){
		int num=10000;
		for(int i=1;i<=num;i++){
		    if (positive_integer(i)) System.out.println("no is = "+ i);
		}
		
	}
}

/* Write a program to display RANGE of PERFECT NUMBERS? */

public class Main{

	public static boolean positive_integer(int n){
	    int sum=0;
		for(int i=1;i<=n/2;i++){
			if(n%i==0)sum=sum+i;
		}
		if(sum==n)return true;
		return false;
		
	}
	public static void main(String[] args){
		int num=10000;
		for(int i=1;i<=num;i++){
		    if (positive_integer(i)) System.out.println("no is = "+ i);
		}
		
	}
}
/* Write a program to check the given number is PALINDROME or not? */
public class PALINDROME{

	public static boolean palandrome(int n){
	    int cpoy=n;
	    int reverse=0;
	    while(n!=0){
	        int temp=n%10;
	        reverse=reverse*10+temp;
	        n=n/10;
	    }
		
		if (cpoy==reverse)return true;
		return false;
	}
	public static void main(String[] args){
		System.out.print(palandrome(1235321)?"it is palandrome ": "it is not palandrome ");
		
	}
}
/* Write a program to find the FACTORIAL of a given number? */
public class Main{

	public static int factorial(int n){
	    int ans=1;
	    for (int i=n; i>=1;i--){
	        ans=i*ans;
	    } 
	    return ans;
	}
	public static void main(String[] args){
		System.out.print("the factorial of number is "+ factorial(5));
		
	}
}
/* Write a program to find the FACTORIAL of a given RANGE of numbers?*/
import java.util.Scanner;
public class Main{

	public static int factorial(int n){
	    int ans=1;
	    for (int i=n; i>=1;i--){
	        ans=i*ans;
	    } 
	    return ans;
	}
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
	    System.out.println("enter start no :");
	    int start=sc.nextInt();
	    System.out.println("enter end no :");
	    int end=sc.nextInt();
	    for (int i=5;i<=10 ;i++){
	        System.out.println("the factorial of number is "+ factorial(i));
	    } 
		
		
	}
}


// leetcode 48. Rotate Image 

//my solution 

class Solution {
    public void rotate(int[][] matrix) {
        int [][]res=new int[matrix.length][matrix[0].length];
        int k=0;
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=0;j<matrix[i].length;j++){
                res[j][matrix.length - 1 - i]=matrix[i][j];
            }
            k++;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                matrix[i][j]=res[i][j];
            }
        }
        
    }
}

// solution 2 by keetcode

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        //transpose
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                int temp=matrix[i][j];

                matrix[i][j]=matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        //reverse each row 
        for(int i=0;i<m;i++){
            int j=0,k=m-1;
            while(j<k){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[i][k];
                matrix[i][k]= temp;
                j++;
                k--;
            }
        }

    }
}


// leetcode 977. Squares of a Sorted Array

class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

// leetcode 128. Longest Consecutive Sequence


class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        int res=1;
        int temp=1;
        for(int i=1 ; i < nums.length; i++){
            if(nums[i]== nums[i-1])continue;

            if(nums[i-1]+1==nums[i]){
                temp++;
            }else {
                temp=1;
            }
            res=Math.max(res,temp);
        }
        return res;
    }
}


// leetcode 169. Majority Element

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int key=0;int majority=0;
        for(int i=0; i< nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            if(map.get(nums[i])> majority){
                key=nums[i];
                majority=map.get(nums[i]);
            }
        }
        return key;

    }
}



// leetcode - 242. Valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ch1=s.toCharArray();char[] ch2=t.toCharArray();
        Arrays.sort(ch1);Arrays.sort(ch2);
        s=new String(ch1);t=new String(ch2);
        if(s.equals(t))return true;
        return false;
    }
}




//  Write program to check the given number is STRONG or not? Def: Strong numbers are the numbers whose 
// sum of factorial of digits is equal to the original number. Example: 145 is a strong number. 

/*Examples of Strong Numbers:
1: 1! = 1
2: 2! = 2
145: 1! + 4! + 5! = 1 + 24 + 120 = 145
40585: 4! + 0! + 5! + 8! + 5! = 24 + 1 + 120 + 40320 + 120 = 40585
*/
public class Main{

	public static int factorial(int n){
	    int ans=1;
	    for (int i=n; i>=1;i--){
	        ans=i*ans;
	    } 
	    return ans;
	}
	public static void main(String[] args){
		int n=40585; int res=0;int copy=n;
		while(n!=0){
			int temp=n%10;
			res= factorial(temp) + res;
			n=n/10;
		}
		if(res==copy)System.out.print("true");
		else{System.out.print("false");
		}
	}
}

// Write program weather to find range of STRONG NUMBER? 

public class Main{

	public static int factorial(int n){
	    int ans=1;
	    for (int i=n; i>=1;i--){
	        ans=i*ans;
	    } 
	    return ans;
	}
	public static void StrongNumber(int start,int end ){
		
		for(int i=start;i<=end;i++){
			int res=0;int copy=i;
			while(copy!=0){
			int temp=copy%10;
			res= factorial(temp) + res;
			copy=copy/10;
			}
			if(res==i)System.out.println(i);
		}
		
	}
	public static void main(String[] args){
		StrongNumber(1,1000000);
		
	}
}



// Write a program to display FIBONACCI series of a number? 
public class Main{

	public static void FIBONACCI(int n){
		System.out.println("0 ");
		System.out.println("1 ");int a=0;int b=1;
		for(int i=1;i<=n;i++){
			
			int c=a+b;
			System.out.print(c+ " ");
			a=b;b=c;

		}
	}
	
	public static void main(String[] args){
		FIBONACCI(15);		
	}
}

// Write a program to display range of FIBONACCI numbers? 
public class Main{

	public static void FIBONACCI(int start,int end){
		int a=0;int b=1;
		for(int i=start;i<=end;i++){			
			int c=a+b;
		            if (c >= start && c<= end) {
		                System.out.print(c+" ");
		            }
			a=b;b=c;
		}
	}
	
	public static void main(String[] args){
		FIBONACCI(5,100);
		
	}
}




// Write a program to REVERSE the number? 
public class Main{

	public static void REVERSE(int num){
		String s="";
		while(num!=0){
			int temp=num%10;
			s=s+temp;
			num=num/10;
		}
		int result=Integer.parseInt(s);
		System.out.print(result);
	}
	
	public static void main(String[] args){
		
		REVERSE(123);
	}
}



// Write a program to display GCD of two numbers?

public class Main {

    public static int findGCD(int a, int b) {
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + findGCD(num1, num2));
    }
}

// leetcode 54. Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int colbegin=0;int colend=matrix[0].length-1;
        int rowbegin=0;int rowend=matrix.length-1;
        List<Integer> list=new ArrayList<>();

        while(colbegin<=colend && rowbegin<=rowend){
            //for forward
            for(int i=colbegin;i<=colend;i++){
                list.add(matrix[rowbegin][i]);
            }rowbegin++;
            // for downward
            for(int i=rowbegin;i<=rowend;i++){
                list.add(matrix[i][colend]);
            }colend--;
            //for backward
            if(rowbegin<=rowend)
            for(int i=colend;i>=colbegin;i--){
                list.add(matrix[rowend][i]);
            }rowend--;
            if(colbegin<=colend)
            // for upward
            for(int i=rowend;i>=rowbegin;i--){
                list.add(matrix[i][colbegin]);
            }colbegin++;

        }return list;
    }
}

// leetcode 15 3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length<3)return new ArrayList<>();
        // lets first sort the array
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left< right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;right--;
                }else if(sum <0){
                    left++;
                }else{
                    right--;
                }
            }
            
        }return new ArrayList<>(set);
    }
}



// leetcode 228. Summary Ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            // int x = 0;

            while (i+1 < nums.length && nums[i+1] - nums[i] == 1) {
                
                i++;
            }

            if (temp != nums[i]) 
            list.add(temp + "->" + nums[i]);
            else list.add(temp+"");
        }

        return list;
    }
}
