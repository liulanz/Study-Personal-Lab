// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int A[]=new int[N];
		for(int i=0;i<N;i++)A[i]=in.nextInt();
		Solution s=new Solution();
		s.solution(A);
		
	}

}

class Solution{
	public void solution(int A[]){
		//shortest unordered subsequence
		if(A.length<3){
			System.out.println(0);
			return;
		}
		if(A[1]>=A[0]){
			for(int i=2;i<A.length;i++){
				if(A[i]<A[i-1]){
					System.out.println(3);
					System.out.print(1+" ");
					System.out.print(i+" ");
					System.out.print(i+1);
					return;
				}
			}
		}
		if(A[1]<=A[0]){
			for(int i=2;i<A.length;i++){
				if(A[i]>A[i-1]){
					System.out.println(3);
					System.out.print(1+" ");
					System.out.print(i+" ");
					System.out.print(i+1);
				}
			}
		}
	}
}