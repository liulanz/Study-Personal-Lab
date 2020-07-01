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
		
		for(int t=0;t<n;t++){
			int n=in.nextInt();
			int A[]=new int[n];int B=new int[n];
			for(int i=0;i<n;i++)A[i]=in.nextInt();
			for(int i=0;i<n;i++)B[i]=in.nextInt();
			Solution s=new Solution();
			s.solution(A,B);
		}
	}

}

class Solution{
	public void solution(int A[],int B[]){
		//sort subarray A any number of time to see if can obtain B
	}

	
}