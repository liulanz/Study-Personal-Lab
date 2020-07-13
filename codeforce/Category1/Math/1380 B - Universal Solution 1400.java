
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
			String input=in.next();
			//int A[]=new int[n];
			//for(int i=0;i<n;i++)A[i]=in.nextInt();
			
			Solution s=new Solution();
			s.solution(input);
		}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	
	public void solution(String ss){
		// R  => paper
		// S  => rock
		// P  => siscor
		Map<Character,String>map=new HashMap<>();
		int r=0,s=0,p=0;
		map.put('R',"P");map.put('S',"R");map.put('P',"S");
		StringBuilder str=new StringBuilder();
		for(int i=0;i<ss.length();i++){
			char c=ss.charAt(i);
			if(c=='R')r++;
			else if(c=='P')p++;
			else s++;
		}
		PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
			return b-a;
		});
		pq.add(r);pq.add(s);pq.add(p);
		int top=pq.poll();
		if(top==r){
			for(int i=0;i<ss.length();i++){
				str.append("P");
			}
		}
		else if(top==s){
			for(int i=0;i<ss.length();i++){
				str.append("R");
			}
		}
		else{
			for(int i=0;i<ss.length();i++){
				str.append("S");
			}
		}
		System.out.println(str.toString());
		
	}
	
 
	
	
	
	
	
	
	
	//helper function I would use
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