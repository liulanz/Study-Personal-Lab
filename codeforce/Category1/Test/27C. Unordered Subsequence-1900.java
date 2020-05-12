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
			boolean increase=false;
			int index=-1;
			int start=-1;
			for(int i=1;i<A.length;i++){
				if(A[i]>A[i-1]){
					increase=true;
					start=i;
					index=i+1;
				}
				if(A[i]<A[i-1]&&increase){
					System.out.println(3);
					System.out.print(start+" ");
					System.out.print(index+" ");
					System.out.print(i+1);
					return;
				}
			}
		
		
			boolean decrease=false;
			for(int i=1;i<A.length;i++){
				if(A[i]<A[i-1]){
					decrease=true;
					start=i;
					index=i+1;
				}
				if(A[i]>A[i-1]&&decrease){
					System.out.println(3);
					System.out.print(start+" ");
					System.out.print(i+" ");
					System.out.print(i+1);
					return;
				}
			}
		
			System.out.println(0);
	}
}