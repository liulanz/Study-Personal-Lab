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
			String s1=in.next();
			String s2=in.next();
			String evil=in.next();			
			Solution s=new Solution();
			s.solution(s1,s2,evil);
		//}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	int dp[][][];
	String s1,s2,evil;
	int pre[];
	Map<String,String>map=new HashMap<>();
	public void solution(String s1,String s2,String evil){
		//find longest common subsequence of s1+s2 without substring evil
		this.s1=s1;
		this.s2=s2;
		this.evil=evil;
		dp=new int[s1.length()][s2.length()][evil.length()];
		pre=kmpPre(evil);
		
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++)Arrays.fill(dp[i][j],-1);
		}
		String res = dfs(0,0,0);
		int val=Integer.parseInt(res.split(",")[0]);
		if(val==0)System.out.println(0);
		else System.out.println(res.split(",")[1].split(" ")[0]);
	}
	
 
	public String dfs(int i, int j, int e){
		
		if(e>=evil.length())return "-1, ";
		if(i>=s1.length())return "0, ";
		if(j>=s2.length())return "0, ";
		
		int ee=e;
		String state=i+","+j+","+e;
		if(map.containsKey(state))return map.get(state);
		char c1=s1.charAt(i);
		char c2=s2.charAt(j);
		
		
		int max=0;
		String MAX=" ";
		
		
		if(c1==c2){
			if(evil.charAt(e)==c1){
				String res = dfs(i+1,j+1,e+1);
				int val=Integer.parseInt(res.split(",")[0]);
				String VAL=res.split(",")[1];
				
				if(val!=-1){
					max=1+val;
					MAX=c1+VAL;
				}
			}else{
				while(e!=0&&evil.charAt(e)!=c1)e=pre[e-1];
				if(evil.charAt(e)==c1)e++;
				
				String res=dfs(i+1,j+1,e);
				int val=Integer.parseInt(res.split(",")[0]);
				String VAL=res.split(",")[1];
				
				if(val!=-1){
					max=1+val;
					MAX=c1+VAL;
				}
				
			}
		}
		
		String res1=dfs(i+1,j,ee); 
		String res2=dfs(i,j+1,ee);
		int v1=Integer.parseInt(res1.split(",")[0]);
		int v2=Integer.parseInt(res2.split(",")[0]);
		
		String V1=res1.split(",")[1];
		String V2=res2.split(",")[1];
		
		if(v1>max){
			max=v1;
			MAX=V1;
		}
		if(v2>max){
			max=v2;
			MAX=V2;
		}
		
		
		map.put(state,max+","+MAX);
		return map.get(state);
	}
	
		
	
	//helper function I would use
	
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