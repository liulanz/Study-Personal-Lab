// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		//int T =in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		//for(int t=0;t<T;t++){
			int n=in.nextInt();int h=in.nextInt();int l=in.nextInt();int r=in.nextInt();
			int A[]=new int[n];
			for(int i=0;i<n;i++){
				A[i]=in.nextInt();
			}
			
			
			Solution s=new Solution();
			s.solution(A,h,l,r);
			out.flush();
		//}
		
	}

}

class Solution{
	int A[];int h;int l;int r;
	int dp[][];
	public void solution(int A[],int h,int l,int r){
		//sleep n time
		//each day h hours
		this.A=A;this.h=h;
		this.l=l;this.r=r;
		int n=A.length;
		dp=new int[n][h];
		for(int i=0;i<dp.length;i++){
			Arrays.fill(dp[i],-1);
		}
		int res=dfs(0,0);
		System.out.println(res);
	}
	
	public int dfs(int index,int cur){
		if(index>=A.length)return 0;
		if(dp[index][cur]!=-1)return dp[index][cur];
		
		int val1=A[index];
		int val2=A[index]-1;
		int res1=0;int res2=0;
		
		int next1=(cur+val1)%h;int next2=(cur+val2)%h;
		if(next1>=l&&next1<=r)res1++;
		if(next2>=l&&next2<=r)res2++;
		res1+=dfs(index+1,next1);
		res2+=dfs(index+1,next2);
		
		dp[index][cur]=Math.max(res1,res2);
		return Math.max(res1,res2);
	}
	
	public void print(int dp[][]){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
	}
}
