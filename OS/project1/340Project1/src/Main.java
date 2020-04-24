import java.util.*;
public class Main {
	static int numPassengers=30;
	static int counter=2;
	public static long time = System.currentTimeMillis();
	public static void main(String[] args) {		
		//reading input from the command line
		if(args.length!=0)numPassengers=Integer.parseInt(args[0]);
		List<Thread>clerkpool=new ArrayList<>();
		List<Thread>passengerpool=new ArrayList<>();
		
		//2 clerk counter
		for(int i=0;i<counter;i++) {
			clerkpool.add(new Thread(new Clerk(i,numPassengers)));
		}
		for(Thread t:clerkpool)t.start();
		
		//passenger
		for(int i=0;i<numPassengers;i++) {
			passengerpool.add(new Thread(new Passenger(i)));
		}
		for(Thread t:passengerpool)t.start();
		
	}
	
	public String getName() {
		return "Main Thread";
	}
	
	public void msg(String m) {
		 //System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
	}

}
