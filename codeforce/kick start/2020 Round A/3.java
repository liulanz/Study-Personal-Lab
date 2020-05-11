// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Solution {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
		    int M = in.nextInt();
			int K = in.nextInt();
			int A[]=new int[M];
			for(int i=0;i<M;i++){
				int x=in.nextInt();
				A[i]=x;
			}
			
		    solve(A,K,t);
		}
	}
	public static void solve(int A[],int K,int Case){
		long r=0;
		long l=1;
		long res=-1;
		r=A[A.length-1]-A[0];
		while(l<=r){
			long mid=l+(r-l)/2;
			long cnt=0;
			for(int i=1;i<A.length;i++){
				int dif=A[i]-A[i-1];
				cnt+=(long)(Math.ceil((dif+0.0)/mid))-1;
			}
			if(cnt<=K){
				res=mid;
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		String s="Case #"+Case+": "+res;
		System.out.println(s);
	}
}