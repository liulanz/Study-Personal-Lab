// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Solution {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int N=in.nextInt();
			int K=in.nextInt();
			long A[]=new long[N];
			for(int i=0;i<N;i++)A[i]=in.nextInt();
			Sol sol=new Sol();
			sol.solution(A,K,t);
		}
	}
}
class Sol{
	public void solution(long A[],long K,int Case){
		int res=0;
		int cnt=1;
		for(int i=0;i<A.length-1;i++){
			if(A[i]==A[i+1]+1){
				cnt++;
			}else{
				if(A[i]==1){
					if(cnt>=K)res++;
				}
				cnt=1;
			}
		}
		if(A[A.length-1]==1){
			if(cnt>=K)res++;
		}
		
		System.out.println("Case #"+Case+": "+res);
	}
}