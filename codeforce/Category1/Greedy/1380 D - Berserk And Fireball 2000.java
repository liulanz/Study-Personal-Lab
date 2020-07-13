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
			int n=in.nextInt();
			int m=in.nextInt();
			int x=in.nextInt();int k=in.nextInt();int y=in.nextInt();
			int A[]=new int[n];
			int B[]=new int[m];
		
			for(int i=0;i<n;i++)A[i]=in.nextInt();
			for(int i=0;i<m;i++)B[i]=in.nextInt();
			
			Solution s=new Solution();
			s.solution(A,B,x,k,y);
		//}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	
	public void solution(int A[],int B[],long x,long k,long y){
		//cost x: destroy k consecutive
		//cost y: destroy larger one in the two consecutive
		//min cost turn A to B
		if(A.length==B.length){
			if(same(A,B))System.out.println(0);
			else System.out.println(-1);
			return;
		}
		
		long res=0;
		List<Integer>list=new ArrayList<>();
		list.add(-1);
		int aIndex=0;
		for(int i=0;i<B.length;i++){
			while(aIndex<A.length){
				if(B[i]==A[aIndex]){
					list.add(aIndex);
					aIndex++;
					break;
				}else{
					aIndex++;
				}
			}
		}
		list.add(A.length);
		if(list.size()-2!=B.length){
			System.out.println(-1);
			return;
		}
		
		//System.out.println(list);
		
		for(int i=1;i<list.size();i++){
			int dis=list.get(i)-list.get(i-1)-1;
			if(dis==0)continue;
			long small=0,big=0;
			for(int l=list.get(i-1)+1;l<list.get(i);l++){
				if(A[l]<get(A,list.get(i-1))||A[l]<get(A,list.get(i)))small++;
				else big++;
			}//
			
			//two case to considerate about, big and small
			
						
			long bigmod=big%k;
			long smallmod=small%k;
			if(bigmod+small<k&&bigmod!=0){
				System.out.println(-1);
				return;
			}
			
			//single kill
			
			boolean found=false;
			if(bigmod!=0){
				found=true;
				res+=(x);
				small-=(k-bigmod);
				big-=bigmod;
			}
			
			
			bigmod=big%k;
			smallmod=small%k;
			long smallchunk=small/k;
			long bigchunk=big/k;
			
			res+=(y*smallmod);
			
			if(y*k<x){//one by one
				res+=(y*k*smallchunk);
				if(bigchunk!=0){
					if(!found){
						res+=x;
						res+=(y*k*(bigchunk-1));
					}else{
						//res+=x;
						res+=(y*k*(bigchunk));
					}
					
				}

				
			}else{
				res+=smallchunk*x;
				res+=bigchunk*x;
			}
			//System.out.println(res);
		}
		System.out.println(res);
	}
	
	public boolean same(int A[],int B[]){
		for(int i=0;i<A.length;i++){
			if(A[i]!=B[i])return false;
		}
		return true;
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
		if(i<0||i>=A.length)return Integer.MIN_VALUE;
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