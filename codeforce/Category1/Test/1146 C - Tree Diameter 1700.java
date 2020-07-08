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
			int n = in.nextInt();
			Solution s=new Solution();
			s.solution(n,out,in);
			
		}
		in.close();
	}
 
}
 
class Solution{
	public void solution(int n,PrintWriter out,Scanner in){
		//tree diameter algorithm : First, we choose an arbitrary node a in the tree and find the
		//farthest node b from a. Then, we find the farthest node c from b. The diameter
		//of the tree is the distance between b and c
		
		int bmax=q(in,out,1,2,n);
		int l=2,r=n;
		int bnode=-1;
		while(l<=r){//find which node is b
			int mid=l+(r-l)/2;
			if(q(in,out,1,l,mid)==bmax){
				bnode=mid;
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		out.println((-1)+" "+q(in,out,bnode,1,n));out.flush();
	}
	
	
	public int q(Scanner in,PrintWriter out, int node, int l, int r) {
			//Scanner in = new Scanner(System.in);
            int size = (r - l + 1);
            if (node >= l && node <= r) size--;
            out.print(1 + " " + (size) + " ");
            out.print(node + " ");
            for (int i = l; i <= r; i++) {
                if (i == node) continue;
                out.print(i + " ");
            }
            out.println();
            out.flush();
            return in.nextInt();
   }
	
	public int ask(int source,int l,int r,PrintWriter out){
		Scanner in = new Scanner(System.in);
		int n=(r-l+1)+1;
		out.print(1);out.print(" "+(n-1));
		out.print(" "+source);
		for(int i=l;i<=r;i++){
			out.print(" "+i);
		}
		out.println();
		out.flush();
		int d=in.nextInt();in.close();
		return d;
	}
	
	public int ask1(int source,int n,PrintWriter out){
		Scanner in = new Scanner(System.in);
		out.print(1);out.print(" "+(n-1));
		out.print(" "+source);
		for(int i=1;i<=n;i++){
			if(source==i)continue;
			out.print(" "+i);
		}
		out.println();out.flush();
		int d=in.nextInt();
		return d;
	}
	
}