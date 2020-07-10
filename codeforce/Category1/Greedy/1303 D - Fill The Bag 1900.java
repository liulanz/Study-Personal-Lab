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
			long n = in.nextLong();
			int m = in.nextInt();
			int A[]=new int[m];
			for(int i=0;i<m;i++)A[i]=in.nextInt();
			Solution s=new Solution();
			s.solution(n,A,t,out);
		}
		out.flush();
		in.close();
	}
 
}
 
class Solution{
	public void solution(long n,int A[],int t,PrintWriter out){
		double sum=0;
		for(long i:A)sum+=i;
		/*if(t==351){
			System.out.println("test  "+n);
			print1(A);
		}*/
		if(sum<n){
			System.out.println(-1);
			return;
		}
		TreeMap<Integer,Integer>treemap=new TreeMap<>();
		int res=0;
		int neg[]=new int[64];
		int pos[]=new int[32];
		for(int i=0;i<64;i++){
			long bit=n&1;
			n>>=1;
			neg[i]+=bit;
		}
		for(int i=0;i<A.length;i++){
			int num=A[i];
			for(int j=0;j<32;j++){
				int bit=num&1;num>>=1;
				pos[j]+=bit;
			}
		}
		
		
		for(int i=0;i<pos.length;i++){//negate those  prior   bit first
			if(neg[i]==0||pos[i]==0)continue;
			neg[i]--;pos[i]--;
		}
		
		for(int i=0;i<32;i++){
			if(pos[i]!=0){
				if(!treemap.containsKey(i))treemap.put(i,0);
				treemap.put(i,treemap.get(i)+1);
			}
		}
		
		int last=-1;
		for(int i=0;i<neg.length;i++){//fill from small
			if(neg[i]==0)continue;
			int cnt=1;
			boolean found=false;
			for(int j=i-1;j>=0;j--){
				if(j>=pos.length)break;
				cnt*=2;
				if(pos[j]>=cnt){
					neg[i]=0;
					pos[j]-=cnt;
					found=true;
					break;
				}else{
					cnt-=pos[j];
				}
			}
			if(!found){//problemetic 
				if(last>=i)continue;
				Integer ceil=treemap.ceilingKey(i);
				if(ceil==null)continue;
				if(ceil!=null)last=ceil;
				res+=(ceil-i);
				/*if(ceil==i){
					treemap.put(i,treemap.get(i)-1);
					if(treemap.get(i)==0)treemap.remove(i);
				}else{
					treemap.put(i,1);
				}*/
				pos[ceil]--;
				neg[i]=0;
			}
		}
		System.out.println(res);
	}
	
	//helper function I would use
	public int get(int A[],int i){
		if(i<0||i>=A.length)return -1;
		return A[i];
	}
	
	public void print1(int A[]){
		for(int i:A)System.out.print(i+" ");
		System.out.println();
	}
	public void print2(int A[][]){
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.print(A[i][j]+" ");
			}System.out.println();
		}
	}
}