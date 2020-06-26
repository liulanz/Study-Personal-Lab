// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		for(int t=0;t<T;t++){
			int N=in.nextInt();
			int A[]=new int[N];
			for(int i=0;i<A.length;i++){
				A[i]=in.nextInt();
			}
			Solution s=new Solution();
			s.solution(A);
		}
	}

}

class Solution{
	public void solution(int A[]){
		//reverse a subarray, maximize the sum in even position
		
		//reverse odd number:no effect
		//reverse even number:has effect, odd->even     even->odd
		long res=0;
		PriorityQueue<Long>pq1=new PriorityQueue<>();
		PriorityQueue<Long>pq2=new PriorityQueue<>();
		long even[]=new long[A.length];//even prefix
		long odd[]=new long[A.length];//odd prefix
		long osum=0,esum=0;
		long total=0;
		for(int i=0;i<A.length;i++){
			if(i%2==0)res+=A[i];//not reversing == reversing odd number of subarray
		}
		total=res;
		for(int i=0;i<A.length;i++){
			if(i%2==0){
				esum+=A[i];
			}else{
				osum+=A[i];
			}
			odd[i]=osum;even[i]=esum;
		}
		long sum=0;
		pq1.add(0l);pq2.add(0l);
		for(int i=0;i<A.length;i++){
			sum=odd[i]-even[i];
			if(i%2==0){
				res=Math.max(res,total+(sum-pq1.peek()));
				pq1.add(sum);
			}else{
				res=Math.max(res,total+(sum-pq2.peek()));
				pq2.add(sum);
			}
		}
		System.out.println(res);
	}
	
	public void print(int A[]){
		for(int i:A)System.out.print(i+" ");
		System.out.println();
	}
}