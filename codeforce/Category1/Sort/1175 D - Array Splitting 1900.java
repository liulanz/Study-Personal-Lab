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
			int k=in.nextInt();
			int A[]=new int[n];
			for(int i=0;i<n;i++)A[i]=in.nextInt();
					
			Solution s=new Solution();
			s.solution(A,k);
		//}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	//constant variable
	final int MAX=Integer.MAX_VALUE;
	final int MIN=Integer.MIN_VALUE;
	//////////////////////////////
	
	
	//global variable
	
	public void solution(int A[],int k){
		//divide into k subarray
		//let f(i), to be the index of subarray [1..k] where element i belong to
		//maximize total cost : A[i]*f(i)
		
		long post[]=new long[A.length];
		long sum=0;
		for(int i=A.length-1;i>=0;i--){
			sum+=A[i];
			post[i]=sum;
		}
		
		long res=post[0];
		//msg(res+"");
		long newA[]=new long[A.length-1];
		for(int i=1;i<post.length;i++)newA[i-1]=post[i];
		PriorityQueue<Long>pq=new PriorityQueue<>((a,b)->{
			return Long.compare(b,a);
		});
		for(long i:newA)pq.add(i);
		
		for(int i=0;i<k-1;i++){
			res+=pq.poll();
		}
		msg(res+"");
	}

	

	
	
	
 

	
		
	
	//helper function I would use
	
	public void msg(String s){
		System.out.println(s);
	}
	
	public int[] kmpPre(String p){
		int pre[]=new int[p.length()];
		int l=0,r=1;
		while(r<p.length()){
			if(p.charAt(l)==p.charAt(r)){
				pre[r]=l+1;
				l++;r++;
			}else{
				if(l==0)r++;
				else l=pre[l-1];
			}
		}
		return pre;
	}
	
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
	public void print1(long A[]){
		for(long i:A)System.out.print(i+" ");
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