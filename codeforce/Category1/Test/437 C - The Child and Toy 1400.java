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
			//int n=in.nextInt();int h=in.nextInt();int l=in.nextInt();int r=in.nextInt();
			//int A[]=new int[n];
			//for(int i=0;i<n;i++){
				//A[i]=in.nextInt();
			//}
			
			int m =in.nextInt();int n = in.nextInt();
			int A[]=new int[m];
			for(int i=0;i<A.length;i++){
				A[i]=in.nextInt();
			}
			int res=0;
			for(int i=0;i<n;i++){
				int v1=in.nextInt()-1;
				int v2=in.nextInt()-1;
				res+=Math.min(A[v1],A[v2]);
			}
			System.out.println(res);
			//Solution s=new Solution();
			//s.solution(A,adjecent);
			//out.flush();
		//}
		
	}

}

class Solution{
	public void solution(int A[],Set<Integer>adjecent[]){
		//sleep n time
		//each day h hours
		
	}
	
}
