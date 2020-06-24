// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int N =in.nextInt();int M =in.nextInt();
		int A1[]=new int[N];int A2[]=new int[M];
		for(int i=0;i<N;i++)A1[i]=in.nextInt();
		for(int i=0;i<M;i++)A2[i]=in.nextInt();
		Solution s=new Solution();
		s.solution(A1,A2);
	}

}

class Solution{
	public void solution(int A[],int B[]){
		int mod=998244353;
		long res=1;
		A=reverse(A);
		B=reverse(B);//in decreasing order for more convinient
		int dp[]=new int[B.length];
		Arrays.fill(dp,-1);
		int j=0;
		for(int i=0;i<B.length;i++){
			int M=Integer.MAX_VALUE;
			while(j<A.length){
				M=Math.min(A[j],M);
				if(M==B[i]){
					dp[i]=j;
					break;
				}
				j++;
			}
		}
		if(check(dp)){
			System.out.println(0);
			return;
		}
		int last=dp[dp.length-1];
		for(int i=last;i<A.length;i++){
			if(A[i]<B[B.length-1]){
				System.out.println(0);
				return;
			}
		}
		List<Integer>list=new ArrayList<>();
		for(int i=1;i<dp.length;i++){
			int pre=dp[i-1],cur=dp[i];
			int cnt=0;
			for(j=pre;j<cur;j++){
				if(A[j]>=B[i-1]){
					cnt++;
				}else{
					break;
				}
			}
			list.add(cnt);
		}
		for(int i:list){
			res*=i;
			res%=mod;
		}
		System.out.println(res);
	}
	
	public void print(int dp[]){
		for(int i:dp)System.out.print(i+"  ");
		System.out.println();
	}
	
	public boolean check(int A[]){
		for(int i:A)if(i==-1)return true;
		return false;
	}
	
	public int[] reverse(int A[]){
		int res[]=new int[A.length];
		for(int i=0;i<res.length;i++){
			res[i]=A[A.length-i-1];
		}
		return res;
	}
	
}