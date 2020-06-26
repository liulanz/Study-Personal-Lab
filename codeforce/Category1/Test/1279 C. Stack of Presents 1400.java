// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		for(int t=0;t<T;t++){
			int n=in.nextInt();int m=in.nextInt();
			int A[]=new int[n];int B[]=new int[m];
			for(int i=0;i<n;i++){
				A[i]=in.nextInt();
			}
			for(int i=0;i<m;i++){
				B[i]=in.nextInt();
			}
			Solution s=new Solution();
			s.solution(A,B);
		}
	}

}

class Solution{
	public void solution(int A[],int B[]){
		//2k+1
		long res=0;
		Stack<Integer>stack=new Stack<>();
		Map<Integer,Integer>map=new HashMap<>();
		for(int i=A.length-1;i>=0;i--)stack.push(A[i]);
		for(int i=0;i<B.length;i++){
			if(map.containsKey(B[i])){
				map.put(B[i],map.get(B[i])-1);
				if(map.get(B[i])==0)map.remove(B[i]);
				res++;
			}else{
				int cnt=0;
				while(stack.peek()!=B[i]){
					cnt++;
					int top=stack.pop();
					if(!map.containsKey(top))map.put(top,0);
					map.put(top,map.get(top)+1);
				}
				stack.pop();
				res++;
				res+=map.size()*2;
			}
		}
		System.out.println(res);
		
	}
}