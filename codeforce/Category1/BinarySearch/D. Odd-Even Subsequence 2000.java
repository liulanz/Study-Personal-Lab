// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int N =in.nextInt();
		int K=in.nextInt();
		int A[]=new int[N];
		for(int i=0;i<N;i++)A[i]=in.nextInt();
		Solution s=new Solution();
		s.solution(A,N,K);
	}

}

class Solution{
	public void solution(int A[],int N,int K){
		//Problem statement: 1. Find Minimum cost
		//					 2. The cost : In a subsequence of length K, the cost is the min(max(odd Index val),max(Even index val))
		
		//max in odd Index, max in even Index
		long res=-1;
		long l=Integer.MAX_VALUE,r=Integer.MIN_VALUE;
		for(int i:A){
			l=Math.min(l,i);
			r=Math.max(r,i);
		}
		while(l<=r){
			long mid=l+(r-l)/2;
			if(check(A,K,mid)){
				res=mid;
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		System.out.println(res);
	}
	
	public boolean check(int A[],int K,long T){ //Must:<=T
		//min(max(odd),max(even))
		//odd Index, Even index
		int odd=(K+1)/2;int even=K/2;
		List<Integer>oddlist=new ArrayList<>();
		List<Integer>evenlist=new ArrayList<>();
		oddlist.add(-2);
		evenlist.add(-1);
		for(int i=0;i<A.length;i++){
			int last=oddlist.get(oddlist.size()-1);
			if(A[i]<=T&&i-last>1){
				oddlist.add(i);
			}
		}
		for(int i=1;i<A.length;i++){
			int last=evenlist.get(evenlist.size()-1);
			if(A[i]<=T&&i-last>1){
				evenlist.add(i);
			}
		}
		//
		if(oddlist.size()-1>=odd){
			int size=oddlist.size()-1;
			if(size>odd)return true;
			if(even==odd){
				if(oddlist.get(size)!=A.length-1)return true;
			}else{
				return true;
			}
			
		}
		if(evenlist.size()-1>=even){
			int size=evenlist.size()-1;
			if(size>even)return true;
			if(even==odd){
				return true;
			}else{
				if(evenlist.get(size)!=A.length-1)return true;
			}
		}
		return false;
	}
}