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
		for(int t=0;t<T;t++){
			int n=in.nextInt();int k=in.nextInt();
			int A[]=new int[n];
			for(int i=0;i<A.length;i++)A[i]=in.nextInt();
			Solution s=new Solution();
			s.solution(A,k);
		}
	}

}

class Solution{
	public void solution(int A[],int k){
		//Find minimum step (Each element in A is divisible by k)
		//Each step: A[i]+=x x++    or x++    x=0;
		Arrays.sort(A);
		if(check(A,k)){
			System.out.println(0);
			return;
		}
		int total=0;
		long res=0;
		Map<Integer,Integer>map=new HashMap<>();
		for(int i=0;i<A.length;i++){
			int mod=A[i]%k;
			if(mod==0)continue;
			total++;
			int com=k-mod;
			if(!map.containsKey(com))map.put(com,0);
			map.put(com,map.get(com)+1);
		}
		List<int[]>list=new ArrayList<>();
		for(Integer key:map.keySet()){
			list.add(new int[]{key,map.get(key)});
		}
		long M=0,index=-1;
		Collections.sort(list,(a,b)->{
			return a[0]-b[0];
		});
		for(int i=0;i<list.size();i++){
			int pair[]=list.get(i);
			if(pair[1]>=M){
				M=pair[1];
				index=pair[0];
			}
		}
		System.out.println((M-1)*k+index+1);
		
		
	}
	public boolean check(int A[],int k){
		for(int i:A){
			if(i%k!=0)return false;
		}
		return true;
	}
	
}