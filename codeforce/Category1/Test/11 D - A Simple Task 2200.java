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
			int n = in.nextInt();
			int m = in.nextInt();
			int graph[][]=new int[n][n];
			for(int i=0;i<m;i++){
				int v1=in.nextInt()-1;
				int v2=in.nextInt()-1;
				graph[v1][v2]=1;
				graph[v2][v1]=1;
			}
			Solution s=new Solution();
			s.solution(graph);
		//}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	long dp[][];
	int graph[][];
	public void solution(int graph[][]){
		this.graph=graph;
		int n=graph.length;
		dp=new long[n][1<<n];//[curentNode,path]
		long res=0;
		
		for(int i=0;i<n;i++){ 
			
			for(int j=0;j<dp.length;j++)Arrays.fill(dp[j],-1);// reset dp
			long val=dfs(i,i,1<<i);
			res+=val;
		}
		System.out.println(res/2);
	}
	
	public long dfs(int root,int cur,int path){
		
		if(dp[cur][path]!=-1)return dp[cur][path];
		long res=0;
		for(int i=root;i<graph.length;i++){ //remove duplicate, dont meet with those smaller childs
			if(graph[cur][i]!=1)continue;
			if(i==root&&Integer.bitCount(path)>=2)res++;//cycle detect
			if((path&(1<<i))!=0)continue;
			res+=dfs(root,i,path|(1<<cur));
		}
		dp[cur][path]=res;
		return res;
	}
	
	
	
	
	//helper function I would use
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