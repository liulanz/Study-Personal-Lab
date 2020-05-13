// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Solution {
	public static void main (String[] args){
	    Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
		   int N=in.nextInt();
		   int P=in.nextInt();
		   int A[]=new int[N];
		   for(int i=0;i<N;i++){
			   A[i]=in.nextInt();
		   }
		   S sol=new S();
		   sol.solution(A,P,t);
		}
	}
}

class S{

	public void solution(int A[],int P,int Case){
		//pick P student and train them with the same skill level
		Arrays.sort(A);
		int cnt=0;
		int sum=0;
		int res=Integer.MAX_VALUE;
		for(int i=0;i<A.length;i++){
			cnt++;
			sum+=A[i];
			if(cnt<P)continue;
			res=Math.min(res,A[i]*P-sum);
			sum-=A[i-cnt+1];
			cnt--;
			
		}
		System.out.println("Case #"+Case+": "+res);
	}

}

