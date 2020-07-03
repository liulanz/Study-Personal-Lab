// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		//int T =in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		//for(int t=0;t<T;t++){
			int n=in.nextInt();
			int colors[]=new int[n+1];
			List<Integer>adjecent[]=new ArrayList[n+1];
			for(int i=0;i<adjecent.length;i++)adjecent[i]=new ArrayList<>();
			for(int i=1;i<colors.length;i++)colors[i]=in.nextInt();
			for(int i=0;i<n-1;i++){
				int v1=in.nextInt();int v2=in.nextInt();
				adjecent[v1].add(v2);
				adjecent[v2].add(v1);
			}
			Solution s=new Solution();
			s.solution(adjecent,colors,out);
			out.flush();
		//}
		
	}

}

class Solution{
	List<Integer>adjecent[];
	int colors[];
	int dp[];
	boolean visit[];
	PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
		return a[0]-b[0];
	});
	public void solution(List<Integer>adjecent[],int colors[],PrintWriter out){
		this.adjecent=adjecent;
		this.colors=colors;
		dp=new int[colors.length];
		visit=new boolean[colors.length];
		visit[1]=true;
		dfs(1);
		Arrays.fill(visit,false);
		visit[1]=true;
		dfs2(-1,1);
		while(pq.size()!=0){
			out.print(pq.peek()[1]+" ");
			pq.poll();
		}
	}
	
	public void dfs2(int parent,int root){
		int res=dp[root];
		List<Integer>childs=adjecent[root];
		if(parent!=-1){
			int other=dp[parent]-Math.max(0,res);
			res+=Math.max(0,other);
		}
		dp[root]=res;
		pq.add(new int[]{root,res});
		for(int child:childs){
			if(visit[child])continue;
			visit[child]=true;
			dfs2(root,child);
		}
		
	}
	
	
	public int dfs(int root){
		List<Integer>childs=adjecent[root];
		int res=0;
		for(int child:childs){
			if(visit[child])continue;
			visit[child]=true;
			int val=dfs(child);
			res+=Math.max(0,val);
		}
		if(colors[root]==1)res++;
		else res--;
		dp[root]=res;
		return res;
	}
}
