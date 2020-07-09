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
		PrintWriter out = new PrintWriter(System.out);
		//for(int t=0;t<T;t++){
			int n = in.nextInt();
			Solution s=new Solution();
			s.solution(n,in);
			
		//}
		in.close();
	}
 
}
 
class Solution{
	List<Integer>adjecent[];
	long cnt[];
	long dp[];
	Set<Integer>set=new HashSet<>();
	long total=0;long res=0;
	int N;
	public void solution(int n,Scanner in){
		cnt=new long[n+1];
		dp=new long[n+1];
		this.N=n;
		adjecent=new ArrayList[n+1];
		for(int i=0;i<adjecent.length;i++)adjecent[i]=new ArrayList<>();
		for(int i=0;i<n-1;i++){
			int v1=in.nextInt();int v2=in.nextInt();
			adjecent[v1].add(v2);adjecent[v2].add(v1);
		}
		set.add(1);
		dfs(1);
		res=total;
		set=new HashSet<>();
		set.add(1);
		dfs1(0,1);
		System.out.println(res);
	}
	
	public long[] dfs(int root){
		List<Integer>childs=adjecent[root];
		long res=1;
		long dpres=0;
		for(int c:childs){
			if(set.contains(c))continue;
			set.add(c);
			long pair[]=dfs(c);
			res+=pair[0];//cnt
			dpres+=pair[1];
		}
		total+=res;
		cnt[root]=res;
		dp[root]=dpres+res;
		return new long[]{res,dp[root]};
	}
	
	public void dfs1(int parent,int root){
		List<Integer>childs=adjecent[root];
		if(parent!=0){
			long ptotal=dp[parent];
			dp[root]=ptotal-dp[root]-cnt[root]+(N-cnt[root])+dp[root];
			res=Math.max(res,dp[root]);
		}
		for(int c:childs){
			if(set.contains(c))continue;
			set.add(c);
			dfs1(root,c);
		}
	}
}