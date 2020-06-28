// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		for(int t=0;t<T;t++){
			int n=in.nextInt();int k=in.nextInt();
			Solution s=new Solution();
			s.solution(n,k);
		}
	}

}

class Solution{
	public void solution(int n,int k){
		//total k types packages, i type has i capacity
		int M=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++){
			if(i>k)break;
			if(n%i==0){
				M=Math.min(M,n/i);
				if(n/i<=k)M=Math.min(M,i);
			}
		}
		System.out.println(M);
	}
	
}