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
			long D=in.nextLong();
			long A[]=new long[N];
			for(int i=0;i<N;i++)A[i]=in.nextLong();
			Sol sol=new Sol();
			sol.solution(A,D,t);
		}
	}
}
class Sol{
	public void solution(long A[],long D,int Case){
		long res=0;
		res=(D/A[A.length-1])*A[A.length-1];
		for(int i=A.length-2;i>=0;i--){
			long t=res/A[i];
			res=A[i]*t;
		}
		System.out.println("Case #"+Case+": "+res);
	}
}
