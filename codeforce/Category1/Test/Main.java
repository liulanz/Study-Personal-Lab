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
		long N=n;
		double sum=0;
		for(long i:A)sum+=i;
		if(sum<n){
			out.println(-1);
			return;
		}
		TreeMap<Integer,Integer>treemap=new TreeMap<>();
		int res=0;
		int neg[]=new int[64];
		int pos[]=new int[64];
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
			neg[i]--;
			pos[i]--;
		}
		int last=-1;
		for(int i=0;i<neg.length;i++){//fill from small
			if(neg[i]==0){
				if(last>i)pos[i]++;
				continue;
			}
			int cnt=1;
			boolean found=false;
			for(int j=i-1;j>=0;j--){
				cnt*=2;
				if(pos[j]>=cnt){
					neg[i]=0;
					found=true;
					break;
				}else{
					cnt-=pos[j];
				}
			}
			
			if(found){
				cnt=1;
				for(int j=i-1;j>=0;j--){
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
			}
			else {//problemetic 
				if(last>i)continue;
				treemap=new TreeMap<>();
				for(int k=0;k<pos.length;k++){
					if(pos[k]!=0)treemap.put(k,1);
				}
				Integer ceil=treemap.ceilingKey(i);
				last=ceil;
				res+=(ceil-i);
				pos[ceil]--;
				neg[i]=0;
			}
		}
		out.println(res);
	}
	
	
	
	//helper function I would use
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
	public void print2(int A[][]){
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.print(A[i][j]+" ");
			}System.out.println();
		}
	}
}