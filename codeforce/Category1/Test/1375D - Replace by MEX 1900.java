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
			int n = in.nextInt();
			int A[]=new int[n];
			for(int i=0;i<A.length;i++){
				A[i]=in.nextInt();
			}
			Solution s=new Solution();
			s.solution(A,out);
			out.flush();
		}
		
	}

}

class Solution{
	public void solution(int A[],PrintWriter out){
		//output: k operations, the 1-index you chose for each operation
		//MEX: smallest elements that is not in the array
		//each time, chose mex and replace any element in the array,make array non-decreasing=> a1<=a2<=a3...<=an 
		
		
		
		//Algo: 1. find MEX
		//      2. try to make [0 1 ... n-1]
		//		3. place MEX in unfix point, if n, place in any unfix point (Why it works?  as you place a new val, old value would disappear,there is always choice!)
		if(check(A)){
			out.println(0);
			out.println();
			return;
		}
		int k=0;
		List<Integer>res=new ArrayList<>();
		int N=A.length;
		while(!check(A)){
			k++;
			Set<Integer>set=new HashSet<>();
			int MEX=-1;
			for(int i:A){
				set.add(i);
			}
			for(int i=0;i<=A.length;i++){
				if(!set.contains(i)){
					MEX=i;
					break;
				}
			}//find the MEX
			if(MEX==N){
				for(int i=0;i<A.length;i++){
					if(A[i]!=i){
						A[i]=MEX;
						res.add(i+1);
						break;
					}
				}
			}else{
				A[MEX]=MEX;
				res.add(MEX+1);
			}
			
		}
		
		
		
		
		////////////////////////////printing
		out.println(k);
		for(int i:res){
			out.print(i+" ");
		}
		out.println();
		///////////////////////////
	}
	
	
	
	public boolean check(int A[]){
		for(int i=1;i<A.length;i++){
			if(A[i]<A[i-1])return false;
		}
		return true;
	}
}
