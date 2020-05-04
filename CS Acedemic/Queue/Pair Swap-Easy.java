// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
	    List<Integer>list=new ArrayList<>();
		int n = in.nextInt();
		int k = in.nextInt();
		for(int i=0;i<n;i++){
		    int a = in.nextInt();
		    list.add(a);
		}//processing
		LinkedList<int[]>deque=new LinkedList<>();
		boolean found=false;
		for(int i=0;i<list.size();i++){
		    int pair[]=new int[]{list.get(i),i};
		    
		    while(deque.size()>0&&pair[0]<=deque.getLast()[0])deque.removeLast();
		    deque.add(pair);
		    if(i<k)continue;
		    
		    int front=list.get(i-k);
		    while(deque.size()>0&&deque.getFirst()[1]<i-k)deque.removeFirst();
		    int smallest[]=deque.getFirst();
		    if(smallest[0]<front){
		        list.set(i-k,smallest[0]);
		        list.set(smallest[1],front);
		        found=true;
		        break;
		    }
		}
		if(!found){
		    for(int i=list.size()-k;i<list.size();i++){
		        int f=list.get(i);
		        while(deque.size()>0&&deque.getFirst()[1]<=i)deque.removeFirst();
		        int smallest[]=deque.peek();
    		    if(smallest!=null&&smallest[0]<f){
    		        list.set(i,smallest[0]);
    		        list.set(smallest[1],f);
    		        break;
    		    }
		    }
		}
		for(int x:list)System.out.print(x+" ");
	}
}