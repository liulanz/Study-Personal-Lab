// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		for(int t=0;t<T;t++){
			int n=in.nextInt();
			int A[]=new int[n];int B[]=new int[n];
			for(int i=0;i<n;i++)A[i]=in.nextInt();
			for(int i=0;i<n;i++)B[i]=in.nextInt();
			Solution s=new Solution();
			boolean val=s.solution(A,B);
			if(val)out.println("Yes");
			else out.println("No");
		}
		out.flush();
	}

}

class Solution{
	int A[];
	public Solution(){
		
	}
	public boolean solution(int A[],int B[]){
		//sort subarray A any number of time to see if can obtain B	
		if(A.length==1){
			return true;
		}
		this.A=A;
		Seg root=new Seg(0,A.length-1);
		Map<Integer,Queue<Integer>>map=new HashMap<>();
		for(int i=0;i<A.length;i++){
			if(!map.containsKey(A[i]))map.put(A[i],new LinkedList<>());
			map.get(A[i]).add(i);
		}
		for(int i=0;i<B.length;i++){
			if(!map.containsKey(B[i])||map.get(B[i]).size()==0){
				return false;
			}
			int index=map.get(B[i]).poll();
			int min=Integer.MAX_VALUE;
			if(index>0)min=root.query(0,index-1);
			if(min<B[i]){
				return false;
			}else{
				A[index]=Integer.MAX_VALUE;
				root.update(index);
			}
		}
		return true;
	}

	class Seg{
	int l,r;
	int min=Integer.MAX_VALUE;
	Seg left=null,right=null;
	public Seg(int l,int r){
		this.l=l;
		this.r=r;
		if(l!=r){
			int mid=l+(r-l)/2;
			if(l<=mid)left=new Seg(l,mid);
			if(r>=mid+1)right=new Seg(mid+1,r);
			if(left!=null)min=Math.min(left.min,min);
			if(right!=null)min=Math.min(right.min,min);
		}else{
			min=A[l];
		}
	}
	public int query(int s,int e){
		if(l==s&&r==e){
			return min;
		}
		int mid=l+(r-l)/2; //left :  to mid-1,
		if(e<=mid){
			return left.query(s,e);
		}
		else if(s>=mid+1){
			return right.query(s,e);
		}else{
			return Math.min(left.query(s,mid),right.query(mid+1,e));
		}
	}
	
	public void update(int index){
		if(l==r){
			min=A[l];
			return;
		}
		int mid=l+(r-l)/2;
		if(index<=mid){
			left.update(index);
		}else{
			right.update(index);
		}
		this.min=Math.min(left.min,right.min);
	}
}
	
}
