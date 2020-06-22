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
			Solution s=new Solution();
			s.solution(n);
		}
	}

}

class Solution{
	public void solution(int n){
		//Ashishgup
		//FastestFinger
		if(n==1){
			System.out.println("FastestFinger");
			return;
		}
		if(n==2){
			System.out.println("Ashishgup");
			return;
		}
		if(n%2==1){
			System.out.println("Ashishgup");
			return;
		}
		//n!=2
		n/=2;
		if(n%2==0){
			if(hasodd(n)){
				System.out.println("Ashishgup");
			}else{
				System.out.println("FastestFinger");
			}
		}else{//2*odd
			if(isP(n)){ //one odd
				System.out.println("FastestFinger");
			}else{
				System.out.println("Ashishgup");
			}
		}		
	}
	boolean hasodd(int n){
		while(n%2==0)n/=2;
		return n!=1;
	}
	public boolean isP(int n){
		for(int i=2;i<=Math.sqrt(n);i++){
			if(n%i==0)return false;
		}
		return true;
	}
}