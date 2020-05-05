// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
	    List<Integer>list=new ArrayList<>();
	    int res=0;
	    Map<Integer,Integer>used=new HashMap<>();
	    Map<Integer,Integer>unused=new HashMap<>();
		int N = in.nextInt();
		for(int i=0;i<N;i++){
		    list.add(in.nextInt());
		    unused.put(list.get(i),0);

		    used.put(list.get(i),0);

		}
		for(int n:list){
		    if(unused.containsKey(n-1)){
		       unused.put(n,Math.max(unused.get(n),1+unused.get(n-1)));
		    }else{
		        unused.put(n,Math.max(unused.get(n),1)); 
		    }
		    
		    if(unused.containsKey(n-2)){
		        used.put(n,Math.max(used.get(n),1+unused.get(n-2)));    
		    }
		    if(used.containsKey(n-1)){
		        used.put(n,Math.max(used.get(n),1+used.get(n-1)));    
		    }
		}
		for(Integer key:unused.keySet())res=Math.max(res,unused.get(key)+1);
		for(Integer key:used.keySet())res=Math.max(res,used.get(key)+1);
		System.out.println(res);
	}
}