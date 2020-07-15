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
			int n=in.nextInt();
			long A[]=new long[n];
			for(int i=0;i<n;i++)A[i]=in.nextLong();			
			Solution s=new Solution();
			s.solution(A);
		//}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	
	public void solution(long A[]){
		//k element subsequence
		//least max(1,k-2) bit be set, for those bit, sumation(2^i)
		//find the max val for the subsequence
	if(A.length==1){
		System.out.println(A[0]);
		return;
	} 
	if(A.length==2){
		System.out.println(A[0]|A[1]);
		return;
	}
	
		long res=0;
		for(int i=0;i<A.length;i++){
			for(int j=i+1;j<A.length;j++){
				for(int k=j+1;k<A.length;k++){
					res=Math.max(res,(A[i]|A[j]|A[k]));
				}
			}
		}
		System.out.println(res);
		
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