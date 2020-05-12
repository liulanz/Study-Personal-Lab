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
			String s=in.next();
			Sol sol=new Sol();
			sol.solution(s,t);
		}
	}
}
class Sol{
	public void solution(String s,int Case){
		//(1,1)
		Stack<Node>stack=new Stack<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
		}
	}
	
	class Node{
		int A[]=new int[4];//W E N S
	}
}
