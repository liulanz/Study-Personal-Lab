// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int N =in.nextInt();
		int A[]=new int[N];
		for(int i=0;i<N;i++)A[i]=in.nextInt();
		Solution s=new Solution();
		s.solution(A);
	}

}

class Solution{
	public void solution(int A[]){
		long res=0; 
		int bits[]=new int[22];
		for(int i=0;i<A.length;i++){
			int n=A[i];
			for(int j=0;j<bits.length;j++){
				int b=n&1;n>>=1;
				bits[j]+=b;
			}
		}
		while(sum(bits)!=0){
			long n=0;
			//System.out.println(sum(bits));
			for(int i=0;i<bits.length;i++){
				if(bits[i]!=0){
					bits[i]--;
					n^=(1<<i);
				}
			}
			res+=(n*n);
		}
		System.out.println(res);
		
	}
	
	public int sum(int A[]){
		int res=0;for(int i:A)res+=i;return res;
	}
}