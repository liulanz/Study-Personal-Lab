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
			String ss=in.next();
					
			Solution s=new Solution();
			s.solution(ss);
		}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	String s;
	public void solution(String s){
		this.s=s;
		int min=dfs(0,s.length()-1,0);
		System.out.println(min);
	}
	
	public int dfs(int l,int r,int c){
		if(l==r){
			int val=s.charAt(l)-'a';
			if(val!=c)return 1;	//change is needed
			return 0;
			
		}
		
		int mid=(r-l)/2+l;// [l,mid]  [mid+1,r]
		
		//two possibility
		int res1=cost(l,mid,c)+dfs(mid+1,r,c+1);
		int res2=dfs(l,mid,c+1)+cost(mid+1,r,c);
		//System.out.println(((char)(c+'a'))+"  "+l+"  "+r+"  "+Math.min(res1,res2));
		return Math.min(res1,res2);
	}
	
	public int cost(int l,int r,int c){
		int cnt=0;
		for(int i=l;i<=r;i++){
			if(s.charAt(i)-'a'!=c)cnt++;
		}
		return cnt;
	}
	
 

	
		
	
	//helper function I would use
	
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