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
			int A[]=new int[N];
			for(int i=0;i<N;i++){
				A[i]=in.nextInt();
			}
			Sol sol=new Sol();
			sol.solution(A,t);
		}
	}
}
class Sol{
	public void solution(int A[],int Case){
		Map<Integer,Integer>map=new HashMap<>();
		int sum=0;
		long res=0;
		int max=0;
		for(int n:A)max+=Math.abs(n);
		for(int i=0;i<A.length;i++){
			sum+=A[i];
			for(int j=0;j*j<=max;j++){
				int square=j*j;
				if(sum==square)res++;
				if(map.containsKey(sum-square))res+=map.get(sum-square);
			}
			if(!map.containsKey(sum))map.put(sum,0);
			map.put(sum,map.get(sum)+1);
		}
		
		System.out.println("Case #"+Case+": "+res);
	}

}