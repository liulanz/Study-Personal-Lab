// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int N = in.nextInt();
			int A[]=new int[N];
			for(int i=0;i<N;i++)A[i]=in.nextInt();
			Solution s=new Solution();
			s.solution(A,t);
		}
	}

}

class Solution{
	public void solution(int A[],int Case){
		int cnt=0;
		for(int i=1;i<A.length-1;i++){
			if(A[i]>A[i-1]&&A[i]>A[i+1])cnt++;
		}
		System.out.println("Case #"+Case+": "+cnt);
	}
}