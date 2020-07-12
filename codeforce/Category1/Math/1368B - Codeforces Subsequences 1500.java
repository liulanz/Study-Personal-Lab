// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		//InputReader in = new InputReader(System.in);
		//int T =in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		//for(int t=0;t<T;t++){
			long k = in.nextLong();
			Solution s=new Solution();
			s.solution(k);
		//}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	
	public void solution(long k){
		if(k==1){
			System.out.println("codeforces");
			return;
		}
		String s="codeforces";
		int len=10;//fixed
		int dp[]=new int[10];
		Arrays.fill(dp,1);
		StringBuilder str=new StringBuilder();
		while(true){
			boolean found=false;
			for(int i=0;i<10;i++){
				dp[i]++;
				if(cal(dp)>=k){
					found=true;
					break;
				}
			}
			if(found)break;
		}
		System.out.println(cal(dp));
		for(int i=0;i<dp.length;i++){
			int T=dp[i];
			for(int t=0;t<T;t++){
				str.append(s.charAt(i));
			}
		}
		System.out.println(str.toString());
	}
	
	public long cal(int A[]){
		long pro=1;
		for(int i:A)pro*=i;
		return pro;
	}
	
	
	
	
	
	
	
	
	//helper function I would use
	public boolean isP(String s){
		int l=0,r=s.length()-1;
		while(l<r){
			if(s.charAt(l)!=s.charAt(r))return false;
			l++;r--;
		}
		return true;
	}
	
	public int find(int nums[],int x){//union find => find method
		if(nums[x]==x)return x;
		int root=find(nums,nums[x]);
		nums[x]=root;
		return root;
	}
	
	public boolean check(int grid[][],int r,int c){
		if(r<0||c<0||r>=grid.length||c>=grid[0].length)return false;
		return true;
	}
	
	public int get(int A[],int i){
		if(i<0||i>=A.length)return -1;
		return A[i];
	}
	public int[] copy(int A[]){
		int a[]=new int[A.length];
		for(int i=0;i<a.length;i++)a[i]=A[i];
		return a;
	}
	public void print1(int A[]){
		for(int i:A)System.out.print(i+" ");
		System.out.println();
	}
	public void print2(long A[][]){
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.print(A[i][j]+" ");
			}System.out.println();
		}
	}
}