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
			int n=in.nextInt();int m=in.nextInt();
			String A[]=new String[n];
			for(int i=0;i<n;i++){
				A[i]=in.next();
			}
			if(n==1){
				System.out.println(A[0]);
				continue;
			}
			Solution s=new Solution();
			s.solution(A);
		}
	}

}

class Solution{
	public void solution(String A[]){
		int len=A[0].length();
		StringBuilder str=new StringBuilder();
		boolean found=false;
		for(int i=0;i<A.length;i++){
			for(int pos=0;pos<len;pos++){
				for(int c=0;c<26;c++){
					String s=A[i].substring(0,pos)+((char)(c+'a'))+A[i].substring(pos+1,A[i].length());
					found=true;
					for(int j=0;j<A.length;j++){
						if(i==j)continue;
						if(A[j].equals(A[i]))continue;
						int cnt=com(s,A[j]);
						if(cnt>1){
							found=false;
							break;
						}
					}
					if(found){
							System.out.println(s);
							return;
					}
				}
			}
		}
		System.out.println(-1);
	}
	
	public int com(String s1,String s2){
		int cnt=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)!=s2.charAt(i))cnt++;
		}
		return cnt;
	}
}