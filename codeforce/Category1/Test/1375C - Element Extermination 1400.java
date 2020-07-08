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
		PrintWriter out = new PrintWriter(System.out);
		for(int t=0;t<T;t++){
			int n = in.nextInt();
			int A[]=new int[n];
			for(int i=0;i<A.length;i++){
				A[i]=in.nextInt();
			}
			Solution s=new Solution();
			s.solution(A);
			out.flush();
		}
		
	}

}

class Solution{
	public void solution(int A[]){
		
		//i  and  i+1, if A[i]<A[i+1], we can remove one of them, 	return if the array can be length 1
		
		Stack<Integer>stack=new Stack<>();
		for(int i=0;i<A.length;i++){
			if(stack.size()==0||A[i]<stack.peek()){
				stack.push(A[i]);
			}else{
				int last=-1;
				while(stack.size()>0&&A[i]>stack.peek())last=stack.pop();
				stack.push(Math.min(A[i],last));
			}
		}
		if(stack.size()==1)System.out.println("YES");
		else System.out.println("NO");
	}
}
