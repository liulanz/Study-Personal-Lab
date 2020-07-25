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
			int m=in.nextInt();
			int A[]=new int[n];

			for(int i=0;i<n;i++){
				A[i]=in.nextInt();
			}
			
			//for(int i=0;i<n;i++)A[i]=in.nextInt();
			//for(int i=0;i<n;i++)B[i]=in.nextInt();
			Solution s=new Solution();
			s.solution(A,m);
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

	public void solution(int A[],int m){
		if(check(A)){
			msg("0");
			return;
		}
		
		int l=1,r=m;
		int res=-1;
		while(l<=r){
			int mid=l+(r-l)/2;
			if(make(A,mid,m)){
				res=mid;
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		msg(res+"");
		
	}
	
	public boolean make(int A[],int k,int m){
		int copy[]=new int[A.length];
		for(int i=0;i<A.length;i++){
			copy[i]=A[i];
		}
		
		if(copy[0]+k>=m){
			copy[0]=0;
		}
		for(int i=1;i<copy.length;i++){
			int pre=copy[i-1];
			if(copy[i]==pre)continue;
			//2 options, not change, change
			if(copy[i]>pre){
				int goal=pre+m;
				if(k+copy[i]>=goal){
					copy[i]=pre;
				}
			}else{
				if(copy[i]+k>=pre){
					copy[i]=pre;
				}else{
					return false;
				}
			}
			
		}
		return true;
	}
	
	public boolean check(int A[]){
		for(int i=1;i<A.length;i++){
			if(A[i]<A[i-1])return false;
		}
		return true;
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