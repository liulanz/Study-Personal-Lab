// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Solution {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
		    List<List<Integer>>list=new ArrayList<>();
		    int N=in.nextInt();
		    int K=in.nextInt();
		    int P=in.nextInt();
		    for(int i=0;i<N;i++){
		        List<Integer>l=new ArrayList<>();
		        for(int k=0;k<K;k++){
		            int x=in.nextInt();
		            l.add(x);
		        }
				//Collections.reverse(l);
		        list.add(l);
		    }
		    solve(list,P,t);
		}
	}
	public static void solve(List<List<Integer>>A,int PA,int Case){
		//System.out.println(A);
		int dp[][]=new int[A.size()+1][PA+1];
		int pre[][]=new int[A.size()][A.get(0).size()];
		for(int i=0;i<A.size();i++){//which stack
			List<Integer>list=A.get(i);
			int sum=0;
			for(int j=0;j<list.size();j++){
				sum+=list.get(j);
				pre[i][j]=sum;
			}
		}
		
		for(int i=1;i<=A.size();i++){
			List<Integer>stack=A.get(i-1);
			int prefix[]=pre[i-1];
			for(int p=1;p<=PA;p++){
				for(int k=0;k<=Math.min(stack.size(),p);k++){
					int sum=0;
					if(k>0)sum=prefix[k-1];
					dp[i][p]=Math.max(dp[i][p],sum+dp[i-1][p-k]);
				}
			}
		}
		/*for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j]+"  ");
			}System.out.println();
		}*/
		String res="Case #"+Case+": "+dp[dp.length-1][dp[0].length-1];
		System.out.println(res);
	}
}