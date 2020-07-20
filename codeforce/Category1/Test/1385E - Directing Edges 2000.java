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
		int T =in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		for(int t=0;t<T;t++){
			int n=in.nextInt();
			int m=in.nextInt();
			List<Integer>undirect[]=new ArrayList[n];
			List<Integer>direct[]=new ArrayList[n];
			for(int i=0;i<n;i++){
				direct[i]=new ArrayList<>();
				undirect[i]=new ArrayList<>();
			}
			for(int i=0;i<m;i++){
				int flag=in.nextInt();
				int v1=in.nextInt()-1;int v2=in.nextInt()-1;
				if(flag==0){
					undirect[v1].add(v2);
				}else{
					direct[v1].add(v2);
				}
			}
					
			Solution s=new Solution();
			s.solution(n,undirect,direct);
		}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	List<Integer>undirect[];
	List<Integer>direct[];
	Set<Integer>set=new HashSet<>();
	boolean cycle=false;
	LinkedList<Integer>order=new LinkedList<>();
	public void solution(int n,List<Integer>undirect[],List<Integer>direct[]){
		this.undirect=undirect;
		this.direct=direct;

		
		for(int i=0;i<n;i++){
			if(set.contains(i))continue;
			set.add(i);
			Set<Integer>stack=new HashSet<>();
			dfs(i,new HashSet<>());
			if(cycle){
				msg("NO");
				return;
			}
		}
		
		msg("YES");
		//output direct
		for(int i=0;i<direct.length;i++){
			List<Integer>childs=direct[i];
			for(int c:childs){
				msg((i+1)+" "+(c+1));
			}
		}
		
		int priority=0;
		int rank[]=new int[n];
		while(order.size()!=0){
			int node=order.removeFirst();
			rank[node]=priority++;
		}
		
		//output undirect
		for(int i=0;i<undirect.length;i++){
			List<Integer>childs=undirect[i];
			for(int c:childs){
				if(rank[i]<=rank[c]){
					msg((i+1)+" "+(c+1));
				}else{
					msg((c+1)+" "+(i+1));
				}
			}
		}
		
	}
	
	public void dfs(int root,Set<Integer>stack){
		//msg((root+1)+"");
		//System.out.println(stack);
		stack.add(root);
		List<Integer>childs=direct[root];
		for(int c:childs){
			if(stack.contains(c)){
				cycle=true;
				return;
			}
			if(set.contains(c))continue;
			set.add(c);
			dfs(c,stack);
		}
		order.addFirst(root);
		stack.remove(root);
	}
	

	
	
	
 

	
		
	
	//helper function I would use
	
	public void msg(String s){
		System.out.println(s);
	}
	
	public int[] kmpPre(String p){
		int pre[]=new int[p.length()];
		int l=0,r=1;
		while(r<p.length()){
			if(p.charAt(l)==p.charAt(r)){
				pre[r]=l+1;
				l++;r++;
			}else{
				if(l==0)r++;
				else l=pre[l-1];
			}
		}
		return pre;
	}
	
	public boolean isP(String s){
		int l=0,r=s.length()-1;
		while(l<r){
			if(s.charAt(l)!=s.charAt(r))return false;
			l++;r--;
		}
		return true;
	}
	
	public int find(int nums[],int x){//union find => find method
		if(nums[x]==x)return x;
		int root=find(nums,nums[x]);
		nums[x]=root;
		return root;
	}
	
	public boolean check(int grid[][],int r,int c){
		if(r<0||c<0||r>=grid.length||c>=grid[0].length)return false;
		return true;
	}
	
	public int get(int A[],int i){
		if(i<0||i>=A.length)return -1;
		return A[i];
	}
	public int[] copy(int A[]){
		int a[]=new int[A.length];
		for(int i=0;i<a.length;i++)a[i]=A[i];
		return a;
	}
	public void print1(int A[]){
		for(int i:A)System.out.print(i+" ");
		System.out.println();
	}
	public void print2(long A[][]){
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.print(A[i][j]+" ");
			}System.out.println();
		}
	}
}