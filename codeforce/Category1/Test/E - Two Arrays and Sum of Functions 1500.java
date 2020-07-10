// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		//InputReader in = new InputReader(System.in);
		//int T =in.nextInt();
		//for(int t=0;t<T;t++){
			int n = in.nextInt();
			int A[]=new int[n];int B[]=new int[n];
			for(int i=0;i<n;i++)A[i]=in.nextInt();
			for(int i=0;i<n;i++)B[i]=in.nextInt();
			Solution s=new Solution();
			s.solution(A,B);
			
		//}
		in.close();
	}
 
}
 
class Solution{
	public void solution(int A[],int B[]){
		PrintWriter out = new PrintWriter(System.out);
		int mod=998244353;
		long res=0;
		long n=A.length;
		
		PriorityQueue<Long>pq=new PriorityQueue<>();
		PriorityQueue<Integer>pq1=new PriorityQueue<>((a,b)->{
			return b-a;
		});
		for(int i:B)pq1.add(i);
		for(int i=1;i<=A.length;i++){
			//times[i-1]=i*(n-i+1);
			//times[i-1]*=A[i-1];
			pq.add((i*(n-i+1l))*A[i-1]);
		}
		for(int i=0;i<A.length;i++){
			res+=(((pq.poll())%mod)*pq1.poll())%mod;
			res%=mod;
		}
		out.println(res);out.flush();
	}
	
	
	
	
	
	
	
	
	//helper function I would use
	public int get(int A[],int i){
		if(i<0||i>=A.length)return -1;
		return A[i];
	}
	
	public void print1(int A[]){
		for(int i:A)System.out.print(i+" ");
		System.out.println();
	}
	public void print2(int A[][]){
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.print(A[i][j]+" ");
			}System.out.println();
		}
	}
}