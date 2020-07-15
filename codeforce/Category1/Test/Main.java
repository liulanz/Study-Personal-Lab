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
		int T =in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		for(int t=0;t<T;t++){
			int n=in.nextInt();
			int A[]=new int[n];
			for(int i=0;i<n;i++)A[i]=in.nextInt();			
			Solution s=new Solution();
			s.solution(A,out);
		}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	
	public void solution(int A[],PrintWriter out){
		int res=0;
		int has[]=new int[8001];
		boolean visit[]=new boolean[8001];
		for(int i:A)has[i]++;
		
		for(int i=0;i<A.length;i++){
			int sum=0;
			for(int j=i;j<A.length;j++){
				sum+=A[j];
				if(j-i+1<2)continue;
				if(sum>8000)break;
				visit[sum]=true;
			}
		}
		for(int i=1;i<visit.length;i++){
			if(visit[i])res+=has[i];
		}
		out.println(res);
	
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