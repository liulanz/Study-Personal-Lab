// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		for(int i=0;i<T;i++){
			int n=in.nextInt();
			int A[]=new int[2*n];
			for(int j=0;j<A.length;j++){
				A[j]=in.nextInt();
			}
			Solution s=new Solution();
			s.solution(A,n);
		}
	}

}

class Solution{
	public void solution(int A[],int n){
		List<Integer>odd=new ArrayList<>();
		List<Integer>even=new ArrayList<>();
		for(int i=0;i<A.length;i++){
			if(A[i]%2==0)even.add(i);
			else odd.add(i);
		}
		if(odd.size()%2==1)odd.remove(odd.size()-1);
		if(even.size()%2==1)even.remove(even.size()-1);
		int cnt=0;
		while(cnt<n-1){
			for(int i=0;i<odd.size();i+=2){
				if(cnt==n-1)break;
				cnt++;
				System.out.println((odd.get(i)+1)+" "+(odd.get(i+1)+1));
			}
			if(cnt==n-1)break;
			for(int i=0;i<even.size();i+=2){
				if(cnt==n-1)break;
				cnt++;
				System.out.println((even.get(i)+1)+" "+(even.get(i+1)+1));
			}
		}
	}
	
}