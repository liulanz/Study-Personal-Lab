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
			int A[]=new int[m];
			int B[]=new int[m];
			for(int i=0;i<m;i++){
				A[i]=in.nextInt();
				B[i]=in.nextInt();
			}
			
			//for(int i=0;i<n;i++)A[i]=in.nextInt();
			//for(int i=0;i<n;i++)B[i]=in.nextInt();
			Solution s=new Solution();
			s.solution(A,B,n);
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
	boolean res=false;
	public void solution(int A[],int B[],int upper){
		// if there exist two integers x and y (1≤x<y≤n) such that 
		//in each given pair at least one integer is equal to x or y.
		
		Set<Integer>set1=new HashSet<>();
		Set<Integer>set2=new HashSet<>();
		set1.add(A[0]);set2.add(B[0]);
		dfs(A,B,1,set1);
		dfs(A,B,1,set2);
		if(!res){
			msg("NO");
		}else{
			msg("YES");
		}
	}
	
	public void dfs(int A[],int B[],int index,Set<Integer>set){
		if(index>=A.length){
			if(set.size()<=2){
				//System.out.println(set);
				res=true;
			}
			return;
		}
		if(set.size()>2)return;
		int a=A[index];
		int b=B[index];
		if(set.contains(a)||set.contains(b)){
			dfs(A,B,index+1,set);
		}else{
			Set<Integer>s1=new HashSet<>();
			Set<Integer>s2=new HashSet<>();
			for(Integer i :set){
				s1.add(i);
				s2.add(i);
			}
			s1.add(a);s2.add(b);
			dfs(A,B,index+1,s1);
			dfs(A,B,index+1,s2);
		}
		
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