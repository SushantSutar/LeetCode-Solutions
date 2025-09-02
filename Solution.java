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
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

	
Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]



	
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
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
	
Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
	
Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


	
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
Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
	
Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"



	
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




// leetcode 143. Reorder List
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]
	
Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

	
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // Deque<Integer> que=new ArrayDeque<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     que.add(temp.val);temp=temp.next;
        // }
        // temp=head;
        // boolean fromFront = true;
        // while (!que.isEmpty()) {
        //     if (fromFront) {
        //         temp.val = que.removeFirst();
        //     } else {
        //         temp.val = que.removeLast();
        //     }
        //     temp = temp.next;
        //     fromFront = !fromFront;
        // }// this was bruteforce works fine
        // finding the mid of list
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //now reverse from the mid
        ListNode mid=slow;
        ListNode current=slow.next;
        while(current.next!=null){
            ListNode temp=current.next;
            current.next=temp.next;
            temp.next=mid.next;
            mid.next=temp;
        }

        // now start from reordering 
        slow = head;
        fast=mid.next;
        while(slow != mid){
            mid.next=fast.next;
            fast.next=slow.next;
            slow.next=fast;
            slow=fast.next;
            fast=mid.next;
        }
    }
}




// leetcode 225. Implement Stack using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. 
The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, 
peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. 
You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

Example 1:
Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]
Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False





class MyStack {
    public Queue<Integer> q;
    public MyStack() {
        q= new LinkedList<>();

    }
    
    public void push(int x) {
        q.add(x);
        for(int i=0;i<q.size()-1;i++){
            q.add(q.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */




// leetcode 19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
	
Example 2:
Input: head = [1], n = 1
Output: []
	
Example 3:
Input: head = [1,2], n = 1
Output: [1]

	
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1){
            head=null;
            return head;
        }
        
        ListNode trav=head;int size=0;
        while(trav!=null){
            trav=trav.next;
            size++;
        }
        if(n==size){
            head=head.next;
            return head;
        }
        trav=head;
        for(int i=0;i<size-n-1;i++){
            trav=trav.next;
        }
        trav.next=trav.next.next;
        return head;
    }
}



// leetcode 704. Binary Search
Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
	
Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

	
class Solution {
    public int search(int[] nums, int target) {
        int left=0;int right=nums.length-1;
        
        while(left <= right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }return -1;
    }
}


// leetcode 35. Search Insert Position
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
	
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
	
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

	
class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target)return i; 
        }

        return nums.length;
    }
}



// leetcode 13. Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, 
the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is 
before the five we subtract it making four. The same principle applies to the number nine, 
which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.
	
Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
	
Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

// class Solution {
//     public int romanToInt(String s) {
//         int sum=0;
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i) == 'I'){
//                 sum=sum+1;
//             }else if(s.charAt(i)=='V'){
//                 sum=sum+5;
//             }else if(s.charAt(i)=='X'){
//                 sum=sum+10;
//             }else if(s.charAt(i)=='L'){
//                 sum=sum+50;
//             }else if(s.charAt(i)=='C'){
//                 sum=sum+100;
//             }else if(s.charAt(i)=='D'){
//                 sum=sum+500;
//             }else if(s.charAt(i)=='M'){
//                 sum=sum+1000;
//             }
//         }return sum; 
//     }
// }

// class Solution {
//     public int romanToInt(String s) {
//         int sum = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == 'I') {
//                 if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
//                     sum -= 1;
//                 } else {
//                     sum += 1;
//                 }
//             } else if (s.charAt(i) == 'V') {
//                 sum += 5;
//             } else if (s.charAt(i) == 'X') {
//                 if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
//                     sum -= 10;
//                 } else {
//                     sum += 10;
//                 }
//             } else if (s.charAt(i) == 'L') {
//                 sum += 50;
//             } else if (s.charAt(i) == 'C') {
//                 if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
//                     sum -= 100;
//                 } else {
//                     sum += 100;
//                 }
//             } else if (s.charAt(i) == 'D') {
//                 sum += 500;
//             } else if (s.charAt(i) == 'M') {
//                 sum += 1000;
//             }
//         }
//         return sum;
//     }
// }



class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int value = getValue(s.charAt(i));
            // If the next character represents a bigger number, subtract current
            if (i < n - 1 && value < getValue(s.charAt(i + 1))) {
                sum -= value;
            } else {
                sum += value;
            }
        }
        return sum;
    }
    
    private int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0; // Safety net
        }
    }
}



// leetcode 739. Daily Temperatures 

iven an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to 
wait after the ith day to get a warmer temperature. If there is no future day 
for which this is possible, keep answer[i] == 0 instead.
	
Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
	
Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
	
Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]

	
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int []res=new int[temperatures.length];

        // for(int i=0;i<temperatures.length-1;i++){
        //     int count=0;
        //     for(int j=i+1;j<temperatures.length;j++){
        //         if(temperatures[i]<temperatures[j]){
        //             count++;break;
        //         }else{
        //             count++;
        //             if(j==temperatures.length-1){
        //                 count=0;
        //             }
        //             continue;
        //         }
        //     }
        //     res[i]=count;
        // }
        // return res; // works but time limit exceded 

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                res[stack.peek()] = i- stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}



// leetcode 82. Remove Duplicates from Sorted List II
Given the head of a sorted linked list, delete all nodes that have duplicate 
numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
	
Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;ListNode curr=head;
        while(curr!=null){
            if(curr.next!=null && curr.val==curr.next.val){
                // Skip all nodes with the same value
                while(curr.next != null && curr.val==curr.next.val){
                    curr=curr.next;
                }
                prev.next=curr.next;// Remove duplicates
            }else{
                prev=prev.next;// Move to next distinct node
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}



// leetcode 219. Contains Duplicate II
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true
	
Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true
	
Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false


	
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int diff=map.get(nums[i]);
                if((i-diff)<=k){
                    return true;
                }else{
                    map.put(nums[i],i);
                }
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}


// leetcode 509. Fibonacci Number
Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
	
Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
	
Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

	
class Solution {
    public int fib(int n) {
        int a=0;int b=1;
        if(n==0)return a;
        for(int i=2;i<=n;i++){
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
    }
}


// leetcode 290. Word Pattern
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".
	
Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
	
Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

	
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ch=s.split(" ");boolean res=false;
        HashMap<Character,String> map=new HashMap<>();

        if (pattern.length() != ch.length) return false;

        for(int i=0;i<pattern.length();i++){

            if(map.containsKey(pattern.charAt(i))){

                if( !map.get(pattern.charAt(i)). equals( ch[i] ) ) {
                    return false;
                }
            }else{
                if (map.containsValue(ch[i])) return false;
                map.put(pattern.charAt(i),ch[i]);
            }
        }
        return true;
    }
}




//////////////////////////////////////////////////////////////////////////////////////////////////////


// BINARY to DECIMAL
import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input binary number as a string
        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        try {
            // Convert binary string to decimal using Integer.parseInt with radix 2
            int decimal = Integer.parseInt(binary, 2);
            System.out.println("Decimal equivalent: " + decimal);
        } catch (NumberFormatException e) {
            System.out.println("Invalid binary number.");
        }

        scanner.close();
    }
}



// DECIMAL to BINARY
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input decimal number
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        // Convert to binary using Integer.toBinaryString
        String binary = Integer.toBinaryString(decimal);

        System.out.println("Binary equivalent: " + binary);

        scanner.close();
    }
}


// OCTAL to DECIMAL
import java.util.Scanner;

public class OctalToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input octal number as a string
        System.out.print("Enter an octal number: ");
        String octal = scanner.nextLine();

        try {
            // Convert octal string to decimal using radix 8
            int decimal = Integer.parseInt(octal, 8);
            System.out.println("Decimal equivalent: " + decimal);
        } catch (NumberFormatException e) {
            System.out.println("Invalid octal number.");
        }

        scanner.close();
    }
}


// DECIMAL to OCTAL
import java.util.Scanner;

public class DecimalToOctal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input decimal number
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        // Convert to octal using Integer.toOctalString
        String octal = Integer.toOctalString(decimal);

        System.out.println("Octal equivalent: " + octal);

        scanner.close();
    }
}


// DECIMAL to HEXADECIMAL
import java.util.Scanner;

public class DecimalToHexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input decimal number
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        // Convert to hexadecimal using Integer.toHexString
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();

        System.out.println("Hexadecimal equivalent: " + hexadecimal);

        scanner.close();
    }
}


// DECIMAL to ALL(Octal , Hexa and Binary)
import java.util.Scanner;

public class DecimalToAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input decimal number
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        // Convert to binary
        String binary = Integer.toBinaryString(decimal);

        // Convert to octal
        String octal = Integer.toOctalString(decimal);

        // Convert to hexadecimal
        String hexadecimal = Integer.toHexString(decimal).toUpperCase();

        // Display results
        System.out.println("Binary equivalent     : " + binary);
        System.out.println("Octal equivalent      : " + octal);
        System.out.println("Hexadecimal equivalent: " + hexadecimal);

        scanner.close();
    }
}


// equilateral triangle * print
import java.util.Scanner;
publuc class equilateral{
	public static void main (String[] args) {
	        Scanner sc=new Scanner(System.in);	
	    	System.out.println("enter number : ");
	    	int n=sc.nextInt();
	    	for(int i=1;i<=n-1;i++){
	    		for(int j=1;j<=n-i;j++){
	    			System.out.print(" ");
	    		}
	    		for(int j=1;j<=i*2-1;j++){
	    			System.out.print("*");
	    		}
	    		System.out.println();
	    	}
    	}

}




// leetcode 367. Valid Perfect Square
Example 1:
Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
	
Example 2:
Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

	
class Solution {
    public boolean isPerfectSquare(int num) {
        double res=Math.sqrt(num);
        
        if(res % 1== 0){
            return true;
        }
        return false;
    }
}



// leetcode 74. Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity. 

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
	
Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false



	
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col=matrix[0].length -1;
        for(int i=0; i< matrix.length; i++){

            if(matrix[i][col] >= target){
                for(int j=0; j<matrix[i].length; j++){
                    if(matrix[i][j]== target)return true;
                }
            }else {
                continue;
            }
            
        }return false;

    }
}



// leetcode 153. Find Minimum in Rotated Sorted Array
Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
	
Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
	
Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

	
class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid] > nums[right]){
                left=mid+1;
            }else if(nums[mid] < nums[right]){
                right=mid;
            }
        }

        return nums[left];
    }
}



// leetcode 33. Search in Rotated Sorted Array
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
	
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
	
Example 3:
Input: nums = [1], target = 0
Output: -1

	
class Solution {
    public int search(int[] nums, int target) {
        // for(int i=0; i<nums.length;i++){
        //     if(nums[i]==target)
        //     return i;
        // }
        // return -1;
        /////////////////////////////////////////////////////////
        int left=0;
        int right=nums.length-1;
        while (left<=right) {
            // int mid=left+(right-left)/2;
            int mid = (left + right) / 2;
            if (nums[mid]==target) {
                return mid;
            }
            if (nums[left]<=nums[mid]) {
                if (nums[left]<=target && target<nums[mid]) {
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if (nums[mid]<target && target <=nums[right]) {
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;

    }
}



// leetcode 875. Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has 
piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses 
some pile of bananas and eats k bananas from that pile. If the pile has less 
than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4
	
Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30
	
Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

	
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canEat(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // Equivalent to ceil(pile / k)
        }
        return hours <= h;
    }
}


// Leetcode 1004. Max Consecutive Ones III
Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
	
Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

	
class Solution {
    public int longestOnes(int[] nums, int k) {
        int zerocount= 0;
        int start=0;
        int max_ones=0;
        for(int end=0;end<nums.length ;end++){
            if(nums[end] == 0) zerocount++;
            while(zerocount > k){
                if(nums[start] == 0)zerocount--;
                start++;
            }
            max_ones=Math.max(max_ones, end - start +1);
        }
        return max_ones;
    }
}



// Leetcode 152. Maximum Product Subarray
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
	
Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

	
// Java implementation
class Solution {
    public int maxProduct(int[] nums) {
        int pre = 1, suf = 1;
        int res = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Product from the front
            pre *= nums[i];
            res = Math.max(res, pre);
            if (pre == 0) pre = 1;

            // Product from the back
            suf *= nums[n - 1 - i];
            res = Math.max(res, suf);
            if (suf == 0) suf = 1;
        }

        return res;
    }
}



// Leetcode 733. Flood Fill
Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), 
all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) 
are colored with the new color.
Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation:
The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.

	
// Runtime: 1 ms, faster than 90.98% of Java online submissions for Flood Fill.
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Avoid infinite loop if the new and old colors are the same...
        if(image[sr][sc] == color) return image;
        // Run the fill function starting at the position given...
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void fill(int[][] image, int sr, int sc, int color, int cur) {
        // If sr is less than 0 or greater equals to the length of image...
        // Or, If sc is less than 0 or greater equals to the length of image[0]...
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        // If image[sr][sc] is not equal to previous color...
        if(cur != image[sr][sc]) return;
        // Update the image[sr][sc] as a color...
        image[sr][sc] = color;
        // Make four recursive calls to the function with (sr-1, sc), (sr+1, sc), (sr, sc-1) and (sr, sc+1)...
        fill(image, sr-1, sc, color, cur);
        fill(image, sr+1, sc, color, cur);
        fill(image, sr, sc-1, color, cur);
        fill(image, sr, sc+1, color, cur);
    }
}



// Leetcode 463. Island Perimeter 
Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
	
Example 2:
Input: grid = [[1]]
Output: 4
	
Example 3:
Input: grid = [[1,0]]
Output: 4

	
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows=grid.length;
        int col=grid[0].length;
        int perimeter=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0)continue;
                if(i==0 || grid[i-1][j]==0)perimeter++;
                if(i==rows-1 || grid[i+1][j]==0)perimeter++;
                if(j==0 || grid[i][j-1]==0)perimeter++;
                if(j==col-1 || grid[i][j+1]==0)perimeter++;
            }
        }return perimeter;
    }
}



// leetcode 438. Find All Anagrams in a String

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
	
Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

	
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        char[] chp = p.toCharArray();
        Arrays.sort(chp);
        String sortedP = new String(chp);
        for(int i=0;i<=s.length()-p.length();i++){
            char[] c=new char[p.length()];
            for(int j=0;j<p.length();j++){
                c[j]=s.charAt(i+j);
            }
            Arrays.sort(c);
            String temp = new String(c);
            if (temp.equals(sortedP)) list.add(i);

        }
        return list;
    }
}




// leetcode 155. Min Stack
Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2




class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        stack=new Stack<>();
        minstack= new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if(minstack.isEmpty() || val<=minstack.peek()) 
            minstack.push(val);
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            int val = stack.pop();
            if (!minstack.isEmpty() && minstack.peek() == val)
                minstack.pop();
        }
    }
    
    public int top() {
        if (!stack.isEmpty())
            return stack.peek();
        return 0;
    }
    
    public int getMin() {
        if (!minstack.isEmpty())
            return minstack.peek();
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */





// leetcode 150. Evaluate Reverse Polish Notation
Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
	
Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
	
Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22



	
class Solution {
    Stack<Integer> stack=new Stack<>();


    public int evalRPN(String[] tokens) {        
        for(int i=0;i<tokens.length;i++){
            if(isNumeric(tokens[i]))
                stack.push(Integer.parseInt(tokens[i]));
            else Operator(tokens[i]);
                
        }
        return stack.peek();
    }

    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void Operator(String str){
        int val1=0;int val2=0;int res=0;
        switch(str){
            case "+":   val1=stack.pop();
                        val2=stack.pop();
                        res=val1+val2;
                        stack.push(res);
                        break;

            case "-":   val1=stack.pop();
                        val2=stack.pop();
                        res=val2-val1;
                        stack.push(res);
                        break;

            case "*":   val1=stack.pop();
                        val2=stack.pop();
                        res=val1*val2;
                        stack.push(res);
                        break;

            case "/":   val1=stack.pop();
                        val2=stack.pop();
                        res=val2/val1;
                        stack.push(res);
                        break;
        }
    }
}



// leetcode 424. Longest Repeating Character Replacement
Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
	
Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.



	
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0;int maxfreq=0;
        int maxwindow=0;

        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(right) - 'A']);
            int windowLength=right-left+1;
            if(windowLength-maxfreq>k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }    
            windowLength=right-left+1;
            maxwindow=Math.max(maxwindow,windowLength);
        }
        return maxwindow;
    }
}


// leetcode 61. Rotate List
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
	
Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
	
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode trav = head;
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int len = 1;
        while (trav.next != null) {
            trav = trav.next;
            len++;
        }

        trav.next = head;
        k = k % len;// handling the case of if k > length eg : 12%5 = still it is 2
        for (int i = 0; i < len - k; i++) {
            trav = trav.next;
            head = head.next;
        }

        trav.next = null;
        return head;
    }
}



// leetcode 109. Convert Sorted List to Binary Search Tree
Example 1:
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
	
Example 2:
Input: head = []
Output: []

///////////////////////////////////////////////////////////////////////

	
	case 1:
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:
	case 2:
Input: head = []
Output: [] 

	
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)return null;
        if(head.next == null)return new TreeNode(head.val);
        ListNode slow=head;ListNode fast=head;ListNode mid=slow;
        while(fast != null && fast.next != null){
           mid=slow; slow=slow.next;fast =fast.next.next;
        }
        TreeNode node=new TreeNode(slow.val);
        mid.next=null;
        node.left=sortedListToBST(head);
        node.right=sortedListToBST(slow.next);
        return node;
    }
}



// leetcode 3. Longest Substring Without Repeating Characters
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
	
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
	
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.



	
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                // Move the start just after the last occurrence of the duplicate
                start = Math.max(start, map.get(ch) + 1);
            }

            map.put(ch, i);
            max = Math.max(max, i - start + 1);
        }

        return max;

        
    }
}





// leetcode 88. Merge Sorted Array
Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
	
Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
	
Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


	
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int []arr=new int[m+n];
        int i=0;int j=0;int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                i++;k++;
            }else if(nums1[i]==nums2[j]){
                arr[k]=nums1[i];i++;k++;
            }else{
                arr[k]=nums2[j];j++;k++;
            }
        }
        while(j<n){
            arr[k]=nums2[j];j++;k++;
        }
        while(i<m){
            arr[k]=nums1[i];i++;k++;
        }
        for (int z=0; z<arr.length; z++){
            nums1[z]=arr[z];
        } 
    }

}// i did perfect but used extra space in this above code 

/*
best solution 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) {
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}

 */




// leetcode 189. Rotate Array
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
	
Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

	
class Solution {
    public void rotate(int[] nums, int k) {
////////////////////////////////////////////////////////
        // if(k>=nums.length)return;
        // int temp[]=new int[nums.length];int m=0;
        // for(int i=nums.length-k; i<nums.length;i++){
        //     temp[m]=nums[i];m++;
        // }
        // for(int i=0;i<nums.length-k;i++){
        //     temp[m]=nums[i];m++;
        // }
        // for(int i=0;i<nums.length;i++){
        //     nums[i]=temp[i];
        // }  //above solution passes only 28 / 39 testcases passed
///////////////////////////////////////////////////////
        // for(int i=0;i< k;i++){
        //     int temp=nums[nums.length-1];
        //     for(int j=nums.length-1;j >= 1;j--){
        //         nums[j]=nums[j-1];
        //     }
        //     nums[0]=temp;
        // }// above solution is perfect but Time Limit Exceeded 38 / 39 testcases passed
//////////////////////////////////////////////////////////
        int n=nums.length;
        k %= n;
        reversr(nums,0,n-1);
        reversr(nums,0,k-1);
        reversr(nums,k,n-1);
        
    }
    public void reversr(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[end];
            nums[end]=nums[start];
            nums[start]=temp;
            start++;end--;
        }
    }
}

// leetcode 5. Longest Palindromic Substring
Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
	
Example 2:
Input: s = "cbbd"
Output: "bb"

	
public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1)return s;
        String res="";
        for(int i=1;i<s.length();i++){
            int low =i;
            int high=i;
            while(s.charAt(low)== s.charAt(high)){
                low--;high++;
                if(low ==-1 || high == s.length())break;
            }
            String palandrome = s.substring(low+1,high);
            if(palandrome.length() > res.length())res=palandrome;


            low =i-1;
            high=i;
            while(s.charAt(low)== s.charAt(high)){
                low--;high++;
                if(low ==-1 || high == s.length())break;
            }
            palandrome = s.substring(low+1,high);
            if(palandrome.length() > res.length())res=palandrome;

        }
        return res;
//////////////////////////////////////////////////////////////
    //     if (s.length() <= 1) {
    //         return s;
    //     }

    //     int maxLen = 1;
    //     String maxStr = s.substring(0, 1);

    //     for (int i = 0; i < s.length(); i++) {
    //         for (int j = i + maxLen; j <= s.length(); j++) {
    //             if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
    //                 maxLen = j - i;
    //                 maxStr = s.substring(i, j);
    //             }
    //         }
    //     }

    //     return maxStr;
    // }

    // private boolean isPalindrome(String str) {
    //     int left = 0;
    //     int right = str.length() - 1;

    //     while (left < right) {
    //         if (str.charAt(left) != str.charAt(right)) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }

    //     return true;
    }
}



// leetcode 1456. Maximum Number of Vowels in a Substring of Given Length


Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
	
Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
	
Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

	
class Solution {
    public int maxVowels(String s, int k) {
        int window =0;int maxcount=0;
        Set<Character> vovels=new HashSet<>();
        vovels.add('a');vovels.add('e');
        vovels.add('i');vovels.add('o');vovels.add('u');
        for(int i=0;i<k;i++){
            if(vovels.contains(s.charAt(i)))
                window++;
        }
        maxcount=window;
        for(int i=k;i<s.length();i++){
            if(vovels.contains(s.charAt(i-k)))  
                window--;
            if(vovels.contains(s.charAt(i)))
                window++;
            maxcount=Math.max(maxcount,window);
            if(maxcount==k)return maxcount;
        }
        return maxcount;
    }
}



// leetcode 24. Swap Nodes in Pairs


Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]


Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]
	
Example 4:
Input: head = [1,2,3]
Output: [2,1,3]


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        head = head.next; // update head to second node after first swap

        while (curr != null && curr.next != null) {
            ListNode second = curr.next;
            ListNode nextPair = second.next;

            // Swap
            second.next = curr;
            curr.next = nextPair;

            // Link previous pair to current swapped pair
            if (prev != null) {
                prev.next = second;
            }

            // Move forward
            prev = curr;
            curr = nextPair;
        }

        return head;
    }
}




// leetcode 387. First Unique Character in a String

Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.
	
Example 2:
Input: s = "loveleetcode"
Output: 2
	
Example 3:
Input: s = "aabb"
Output: -1

	
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        // int max =-1;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
 
the students are given a string with multiple characters that 
are repeated consecutively. You're supposed to reduce the size of this 
string using mathematical logic given as in the example below:
Input:
aabbbbeeeeffggg
Output:
a2b4e4f2g3

*/
public class Main
{
    public static String findOccurence(String s){
        String res="";
        for (int i=0; i< s.length(); i++){
            char ch=s.charAt(i);
            int count=1;
            int j=i+1;
            // System.out.println(j);
            while(j<s.length() &&ch==(s.charAt(j)) ){
                j++;
                count++;
            }
            i=j-1;
            
            res=res+ch+count;
            // System.out.println(res);
        } 
        
        
        return res;
    }
	public static void main(String[] args) {
		System.out.println("Output : "+ findOccurence("aaabbbbbccddde"));
	}
}



/*
leetcode 54. Spiral Matrix
Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Write the code to traverse a matrix in a spiral format.
Sample Input:

 5   4 
  1  2  3  4
  5  6  7  8 
  9 10 11 12 
  13 14 15 16 
  17 18 19 20

Output
1 2 3 4 8 12 16 20 19 18 17 13 9 5 6 7 11 15 12 14 10

*/
//Note :  if the numbers of bike and cars are combined then do use formula for extracting cars and bikes 

import java.util.*;
public class Main
{
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> list=new ArrayList<>();
        int colbegin=0;int colend=matrix[0].length-1;
        int rowbegin=0;int rowend=matrix.length-1;
        while(colbegin<=colend && rowbegin<=rowend){
            for (int i=colbegin; i<=colend; i++){
                list.add(matrix[rowbegin][i]);
            } rowbegin++;
            for (int i=rowbegin; i<=rowend; i++){
                list.add(matrix[i][colend]);
            } colend--;
            
            // if(rowbegin<=rowend) ///////////
            for(int i=colend;i>=colbegin;i--){
                list.add(matrix[rowend][i]);
            }   rowend--;
            
            // if(colbegin<=colend)////////////
            for (int i= rowend; i>=rowbegin; i--){
                list.add(matrix[i][colbegin]);
            } colbegin++;
            
        }
        return list;
    }
	public static void main(String[] args) {
	    int [][]matrix={{1,2,3},{4,5,6},{7,8,9}};
	    List<Integer> list=spiralOrder(matrix);
		list.forEach(x->System.out.print(x + " "));
	}
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Problem Statement
Bela teaches her daughter to find the factors of a given number. 
When she provides a number to her daughter, she should tell the factors of that number. 
Help her to do this, by writing a program. Write a class FindFactor.java 
and write the main method in it
Note:
If the input provided is negative, ignore the sigh and provide the output. If the input is zero
If the input is zero the output should be "No Factors".
Sample Input 1:
54
Sample Output 1:
1, 2, 3, 6, 9, 18, 27, 54
*/


import java.util.*;
public class Main {
    
    public static String findFactor(int n){
        if(n==0)return "No Factors";
        String res=""+n;
        for (int i=n-1; i>=1; i--){
            if(n%i==0){
                res=i+","+res;
            }
        } 
        return res;
    }
    public static void main (String[] args) {
        System.out.println(findFactor(54));
    }
}

/*
You have write a function that accepts, a string which length is "len", 
the string has some "#", in it you have to move all the hashes to the front 
of the string and return the whole string back and print it
Input:
Movel#Hash#to#Front
Output:
###MovelHashtoFront


*/
import java.util.*;
public class Main {
    public static String HashesINFrount(String s){
        StringBuffer res=new StringBuffer();
        Deque<Character> q=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='#'){
                q.addFirst(ch);
            }else{
                q.addLast(ch);
            }
        }
        while (!q.isEmpty()) {
            res.append(q.removeFirst());
        } 
        return res.toString();
    }
    
    public static void main (String[] args) {
        System.out.print("Message : "+ HashesINFrount("MAP#sdggv#SUSHANT##GFG"));
    }
}

/*
Pythagorean Triplets: Problem: Generate all Pythagorean triplets with values 
smaller than a given limit. Input: Limit 20 Output: 0345 8618 0512 13 15 8:17. 12. 16 20
*/

public class PythagoreanTriplets {
    public static void main(String[] args) {
        int limit = 20;  // given limit

        for (int a = 1; a < limit; a++) {
            for (int b = a; b < limit; b++) { // b starts from a to avoid duplicates
                int cSquare = a * a + b * b;
                int c = (int) Math.sqrt(cSquare);

                if (c * c == cSquare && c < limit) {
                    System.out.println(a + " " + b + " " + c);
                }
            }
        }
    }
}






/*
String Rotation: Problem: Determine if one string is a rotation of another. 
Input : s1 :ABCD 
s2 : CDAB 
Output : true
*/
class Solution {
    public boolean isRotation(String s1, String s2) {
        // If lengths differ, can't be rotations
        if (s1.length() != s2.length()) {
            return false;
        }

        // Rotation trick: s1+s1 contains all rotations of s1
        String combined = s1 + s1; // ABCDABCD->AB CDAB CD

        return combined.contains(s2);
    }
}




class Main {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    

    public static ListNode reverseList(ListNode head) {
        if (head==null)return head;
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null ){
            ListNode sec=curr.next;
            curr.next=pre;
            pre=curr;
            curr=sec;
        }
        head =pre;
        return head;
    }
    
    
    
    
/*
Reverse Linked List problem from LeetCode (#206)	
*/
    
    
    

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        ListNode reversed = reverseList(head);

        System.out.println("Reversed List:");
        printList(reversed);
    }
}

/*
Merge Two Sorted Arrays:
Problem: Merge two sorted arrays into a single sorted array.
Input:{1,2,3,4,5}
    {1,3,4,5,6,7}
Output: 1 1 2 3 3 4 4 5 5 6 7 
*/
public class Main{
    public static void combinearray(int []arr1, int []arr2){
        int res[]=new int[arr1.length+arr2.length];
        int i=0;int j=0;int k=0;
        while(i<arr1.length && j<arr2.length){
            if (arr1[i]<=arr2[j] ){
                res[k]=arr1[i];
                i++;
            }else if(arr1[i]>arr2[j]){
                res[k]=arr2[j];
                j++;
            }
            k++;
        } 
        // System.out.println("i : "+i);
        // System.out.println("j : "+j);
        // System.out.println("k : "+k);
        if(i<arr1.length){
            for(int s=i;s<arr1.length;s++){
                res[k]=arr1[s];
            }
        }else{
            for(int s=j;s<arr2.length;s++){
                res[k]=arr2[s];k++;
            }
        }
        
        for (int z=0;z<res.length;z++ ){
            System.out.print(res[z]+" ");
        } 
    }
    public static void main (String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={1,3,4,5,6,7};
        combinearray(arr1,arr2);
    }
} 


/*
Iterating the Map with entrySet(), keySet(), value(), Lambda Expression
*/

import java.util.*;
public class Main
{
    public static List<Integer> findDuplicates(int []arr){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0; i<arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println("key :" + entry.getKey() + " value :"+ entry.getValue());
        } 
        System.out.println();

        for(int x: map.keySet()){
            System.out.print(" " + x);
        }
        System.out.println();
        map.forEach((x,y)-> {
            if (y >= 2) {
                list.add(x);
            }
        });
        return list;
        
    }
	public static void main(String[] args) {
        int []arr={1,1,2,3,4,5,5,6,7,7,7,7,8,8};
        List<Integer> res=findDuplicates(arr);
        res.forEach(x->System.out.print(x+" "));
	}
}

/*
validate balanced parentheses
checking whether every opening parenthesis '(' has a corresponding closing parenthesis ')' in the correct order.
*/


import java.util.*;
public class Main
{
    public static boolean checkParentheses(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                if (st.isEmpty()) {
                    return false; // unmatched closing parenthesis
                }
                st.pop();
            }
        }
        return st.isEmpty(); // true if all parentheses matched
        
    }
	public static void main(String[] args) {
        
        boolean res=checkParentheses("()((())())");
        if(res)System.out.print("valid");
        else System.out.print("invalid");
	}
}




// Leetcode 53. Maximum Subarray
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
	
Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
	
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


	
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<nums.length;i++){
            currentSum=currentSum+nums[i];
            if(currentSum>maxSum){
                maxSum=currentSum;
            }
            if(currentSum<0){
                currentSum=0;
            }
        }
        return maxSum;
    }
}

 
// Leetcode 350. Intersection of Two Arrays II

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
	
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

	
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // ArrayList<Integer> list=new ArrayList<>();
        // for(int i=0;i<nums1.length;i++){
        //     for(int j=0;j<nums2.length;j++){
        //         if(nums1[i]==nums2[j] && !list.contains(nums1[i]))list.add(nums1[i]);
        //     }
        // }
        // int[] arr=new int[list.size()];
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=list.get(i);
        // }
        // return arr; // this ligic is not iffecient and worong for test case 1 
////////////////////////////////////////////////////////////////
        // HashSet<Integer> set=new HashSet<>();
        // for(int i=0;i<nums1.length;i++){
        //     set.add(nums1[i]);
        // }
        // for(int i=0;i<nums2.length;i++){
        //     set.add(nums2[i]);
        // }

        // int[] arr=new int[set.size()];
        // int index = 0;
        // for (int element : set) {
        //     arr[index++] = element;
        // }
        // return arr; // this is google logic but wrong
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]== nums2[j]){
                list.add(nums1[i]);
                i++;j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int arr[] =new int[list.size()];
        for(int z=0;z<list.size();z++){
            arr[z]=list.get(z);
        }
        return arr;
    }
}



// Leetcode 349. Intersection of Two Arrays
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
	
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

	
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // int l1=nums1.length;
		// int l2=nums2.length;
		// int min=Integer.min(l1, l2);
		
        // int[] temp=new int[min];
        // int k=0;
		// for(int i=0;i<l1;i++) {
		// 	for(int j=0;j<l2;j++) {
		// 		if(nums1[i] == nums2[j]) {
		// 			boolean duplicate=false;
		// 			for(int x=0;x<k;x++) {
		// 				if(temp[x]==nums1[i]) {
		// 					duplicate=true;
		// 					break;

		// 				}
		// 			}
		// 			if(!duplicate) {
		// 				temp[k]=nums1[i];
		// 				k+=1;
		// 			}
					
		// 			break;
		// 		}
		// 	}
		// }
		
		// int[] result=new int[k];
		// for(int i=0;i<k;i++) {
		// 	result[i]=temp[i];
		// }
		// return result;// OR 
        Set<Integer> set=new HashSet<>();
        for (int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        } 
        List<Integer> list=new ArrayList<>();
        for (int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                if(!list.contains(nums2[i])){
                    list.add(nums2[i]);
                }
            }
        } 
        int []res=new int[list.size()];
        for (int i=0; i<res.length;i++ ){
            res[i]=list.get(i);
        }
        return res;// But same timecomplexity
    }
}



// Leetcode 125 Valid Palindrome

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
	
Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
	
Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

	
class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            char fromStart=s.charAt(i);
            char fromLast=s.charAt(j);
            if(!Character.isLetterOrDigit(fromStart)){
                i++;
            }else if(!Character.isLetterOrDigit(fromLast)){
                j--;
            }else{
                if(Character.toLowerCase(fromStart)!=Character.
                    toLowerCase(fromLast)){
                        return false;
                    }
                    i++;j--;
            }
        }
        return true;
    }
}

/* // bellow code is same as above 

public class Main
{
    public static boolean isPalindrome(String s) {
        int left=0;int right=s.length()-1;
        while(left<right){
            while(!Character.isLetterOrDigit(s.charAt(left)))left++;
            while(!Character.isLetterOrDigit(s.charAt(right)))right--;
            if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            } 
            left++;right--;
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println("answer is : " + isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println("answer is : " + isPalindrome("race a car"));
		System.out.println("answer is : " + isPalindrome(" "));
	}
}
 */



// Leetcode 49. Group Anagrams
/*
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
*/
import java.util.*;
public class Main
{
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (int i=0; i<strs.length; i++){
            String temp=strs[i];
            char[] c=temp.toCharArray();
            Arrays.sort(c);
            temp=new String(c);
            if(!map.containsKey(temp)){
                map.put(temp,new ArrayList());
            }
            map.get(temp).add(strs[i]);
        } 
        return new ArrayList<>(map.values());
        
    }

	public static void main(String[] args) {
	    String []arr1={"eat","tea","tan","ate","nat","bat"};
		List<List<String>> list=groupAnagrams(arr1);
		System.out.println(list);
	    String []arr2={""};
		List<List<String>> list2=groupAnagrams(arr2);
		System.out.println(list2);
	}
}

 


// Leetcode 2273. Find Resultant Array After Removing Anagrams
/*
Input: words = ["abba","baba","bbaa","cd","cd"]
Output: ["abba","cd"]
Explanation:
One of the ways we can obtain the resultant array is by using the following operations:
- Since words[2] = "bbaa" and words[1] = "baba" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","baba","cd","cd"].
- Since words[1] = "baba" and words[0] = "abba" are anagrams, we choose index 1 and delete words[1].
  Now words = ["abba","cd","cd"].
- Since words[2] = "cd" and words[1] = "cd" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","cd"].
We can no longer perform any operations, so ["abba","cd"] is the final answer.
Example 2:

Input: words = ["a","b","c","d","e"]
Output: ["a","b","c","d","e"]
Explanation:
No two adjacent strings in words are anagrams of each other, so no operations are performed.
	*/
// class Solution {
//     public List<String> removeAnagrams(String[] words) {
//         Set<String> set=new HashSet<>();
//         List<String> list=new ArrayList<>();

//         for(int i=0;i<words.length;i++){
//             char[] ch =words[i].toCharArray();
//             Arrays.sort(ch);
//             String res=new String(ch);
//             if(set.isEmpty()){
//                 set.add(res);
//                 list.add(words[i]);
//             }else if(set.contains(res)){
//                 continue;
//             }else{
//                 set.add(res);
//                 list.add(words[i]);
//             }

//         }
//         return list;
//     }
// } // this approach is good but it checks all the previous anagrams also so the 
// question said to just see its previous one not all previous ones
// so now this code fails on eg :["a","b","a"]
/*
Output
["a","b"]
Expected
["a","b","a"]
 */

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        String prev = "";

        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if (sorted.equals(prev)) {
                continue;
            }
            list.add(words[i]);
            prev = sorted;
        }
        return list;
    }
}




// Leetcode 316. Remove Duplicate Letters
Given a string s, remove duplicate letters so that every letter appears once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.
Example 1:
Input: s = "bcabc"
Output: "abc"
	
Example 2:
Input: s = "cbacdcbc"
Output: "acdb"



// class Solution {
//     public String removeDuplicateLetters(String s) {
//         Stack<Character> stack=new Stack<>();
//         for(int i=0; i< s.length(); i++ ){
//             char c=s.charAt(i);
//             if(stack.isEmpty()){
//                 stack.push(c);
//                 continue;
//             }
//             if(stack.peek()==c)continue;
//             if( stack.peek()-c >= 1 && s.indexOf(stack.peek(),0) <= findNextIndex(stack.peek(), i, s)){
//                 stack.pop();
//                 stack.push(c); continue;
//             }
//             stack.push(c);
//         }
//         String res="";
//         while(!stack.isEmpty())res=res+stack.pop(); 
//         StringBuilder sb = new StringBuilder(res);
//         String reversedString = sb.reverse().toString();
//         return reversedString;
//     }

//     public int findNextIndex(char c ,int i , String s){
//         int temp=i;
//         for(int j=i;j<s.length();j++){
//             if(s.charAt(j) == c)temp = j;
//         }
//         return temp;
//     }
// }// i tried my best but good logic but i was not maintaining the occured element 


class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        String res = "";
        while (!stack.isEmpty()) res = stack.pop()+ res;
        return res;
    }

    public int findNextIndex(char c, int i, String s) {
        int temp = i;
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) == c) temp = j;
        }
        return temp;
    }
}


// bellow code is for remove duplicates but not with lexicographical
import java.util.*;
public class Main
{
    public static String removeDuplicateLetters(String s){
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0; i<s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        String res="";
        for (int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)>1){
                    map.put(c,map.get(c)-1);
                }else if (map.get(c) ==1){
                    res=res+c;
                } 
            }
        }
        return res;
    }

	public static void main(String[] args) {
	    System.out.print(removeDuplicateLetters("cbacdcbc"));
	}
}




// Leetcode 1047. Remove All Adjacent Duplicates In String
Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, 
and this is the only possible move.  The result of this move is that the string is "aaca", 
of which only "aa" is possible, so the final string is "ca".
	
Example 2:
Input: s = "azxxzy"
Output: "ay"
	
class Solution {
    public String removeDuplicates(String s) {
        char[] st=new char[s.length()];
		int top=-1;
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if (top>-1 && c==st[top]) {
				top--;
			}else {
				top++;
				st[top]=c;
			}
		}
        return new String(st, 0, top+1);
    }
}



//Leetcode 3120. Count the Number of Special Characters I
You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
Return the number of special letters in word.

Example 1:
Input: word = "aaAbcBC"
Output: 3
Explanation:
The special characters in word are 'a', 'b', and 'c'.
Example 2:
Input: word = "abc"
Output: 0
Explanation:
No character in word appears in uppercase.
Example 3:
Input: word = "abBCab"
Output: 1
Explanation:
The only special character in word is 'b'.

	
class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> smallSet = new HashSet<>();
        Set<Character> capitalSet = new HashSet<>();
        
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                smallSet.add(c);
            } else {
                capitalSet.add(c);
            }
        }
        
        int count = 0;
        for (char c : smallSet) {
            if (capitalSet.contains(Character.toUpperCase(c))) {
                count++;
            }
        }
        
        return count;
    }
}


// Leetcode 1592. Rearrange Spaces Between Words
Example 1:
Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly 
	divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
	
Example 2:
Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces 
	plus 1 extra space. We place this extra space at the end of the string.


	
class Solution {
    public String reorderSpaces(String text) {
        int length=text.length();
        List<String> list=new ArrayList<>();
        int total_words=0;   // here this will count chars of words
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)!=' '){
                String temp="";
                while(i<text.length() && text.charAt(i)!=' '){ // fix condition
                    temp=temp+text.charAt(i);
                    i++;
                    total_words++;   // counts characters of words
                }
                list.add(temp);
            }             
        }
        int wordsLength=list.size();
        int total_spaces=length-total_words;   // spaces = total length - chars of words
        String res="";        
        if(wordsLength==1){   // special case: only one word
            res=res+list.get(0);
            for(int i=0;i<total_spaces;i++){
                res=res+" ";
            }
            return res;
        }
        int space=total_spaces/(wordsLength-1);
        int remainder=total_spaces%(wordsLength-1);
        for(int i=0;i<list.size();i++){
            res=res+list.get(i);
            if(i!=list.size()-1){
                for(int j=0;j<space;j++){
                    res=res+" ";
                }
            }            
        }
        for(int i=0;i<remainder;i++){
            res=res+" ";
        }
        
        return res;
    }
}



// Leetcode 58. Length of Last Word
Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
	
Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
	
Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

	


class Solution {
    public int lengthOfLastWord(String s) {
        String[] st=s.split(" +");
        return st[st.length-1].length();
    }
}



// Leetcode 3340. Check Balanced String


Example 1:
Input: num = "1234"
Output: false
Explanation:
The sum of digits at even indices is 1 + 3 == 4, and the sum of digits at odd indices is 2 + 4 == 6.
Since 4 is not equal to 6, num is not balanced.
	
Example 2:
Input: num = "24123"
Output: true
Explanation:
The sum of digits at even indices is 2 + 1 + 3 == 6, and the sum of digits at odd indices is 4 + 2 == 6.
Since both are equal the num is balanced.



	// class Solution {
//     public boolean isBalanced(String num) {
//         int original=Integer.parseInt(num);
//         int i=num.length();
//         int sum1=0;
//         int temp=original;
//         while(i>0){
//             int val=temp%10;
//             sum1=sum1+val;
//             i -= 2;temp=temp/100;
//         }        
        
//         temp=original/10;
//         i=num.length();
//         int sum2=0;
//         while(i>0){
//             int val=temp%10;
//             sum2=sum2+val;
//             i -= 2;temp=temp/100;
//         }

//         if(sum1==sum2)return true;
//         return false;
//     }
// }// above logic is good but fails at int original=Integer.parseInt(num);
//if the input is 7123816724 greater than the integer range

class Solution {
    public boolean isBalanced(String num) {
        int sum1=0;
        int sum2=0;
        for(int i=0;i<num.length();i++){
            char temp=num.charAt(i);
            int s=temp- '0';
            sum1=sum1+s;
            i++;
        }
        for(int i=1;i<num.length();i++){
            char temp=num.charAt(i);
            int s=temp- '0';
            sum2=sum2+s;
            i++;
        }

        if(sum1==sum2)return true;
        return false;
    }
}



// Leetcode 1910. Remove All Occurrences of a Substring


Example 1:

Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
Example 2:

Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
- s = "axyb", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".


	
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuffer sb = new StringBuffer(s);        
        while (sb.indexOf(part) != -1) { 
            int index = sb.indexOf(part);
            sb.delete(index, index + part.length()); 
        }        
        return sb.toString();
    }
}





// Leetcode 27. Remove Element

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).



class Solution {
    public int removeElement(int[] nums, int val) {
        
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }
        }
        return index;

        // ArrayList<Integer> arr=new ArrayList<>();
		// int j=nums.length-1;
		// if (nums.length==1 && nums[0]!=val) {
		// 	return 1;
		// }else {
			
		
		// for (int i = 0; i < nums.length/2; i++) {
			
		// 		if (nums[i]!=val) {
		// 			arr.add(nums[i]);;
		// 		}
		// 		if (nums[j]!=val) {
		// 			arr.add(nums[j]);
					
		// 		}j--;			
		// }
		// int size=arr.size();
		// for (int i = 0; i < nums.length; i++) {
		// 	if(!arr.isEmpty()) {
		// 		nums[i]=arr.removeFirst();
		// 	}else {
		// 		break;
		// 	}
			
		// }
		// return size;
		// }
    }
}



// Leetcode 567. Permutation in String

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();//
        int n=s2.length();
        if(n<m)return false;
        int[] map1=new int[26];
        for(int i=0; i<m;i++){
            map1[s1.charAt(i) - 'a']++;
        }
        for(int i=0;i<=n-m;i++){
            int map2[]=new int[26];
            for(int j=0;j<m;j++){
                map2[s2.charAt(i+j)-'a']++;
            }
            if(helper(map1,map2))return true;
        }
        return false;
    }

    private boolean helper(int[] num1,int []num2){
        for(int i=0;i<26;i++){
            if(num1[i]!=num2[i])return false; 
        }return true;
    }
}

// ref : https://www.youtube.com/watch?v=3QbafTQaBQk&t=830s


// Leetcode 796. Rotate String

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false


class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }
}
	
