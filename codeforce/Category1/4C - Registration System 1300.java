// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String A[]=new String[N];
		for(int i=0;i<N;i++){
			String s=in.next();
			A[i]=s;
		}
		Map<String,Integer>map=new HashMap<>();
		for(String s:A){
			if(!map.containsKey(s)){
				System.out.println("OK");
				map.put(s,1);
			}else{
				int cnt=map.get(s);
				System.out.println(s+cnt);
				map.put(s,cnt+1);
			}
		}
	}

}