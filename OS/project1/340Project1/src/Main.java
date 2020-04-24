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
		msg("Run");
		//2 clerk counter
		for(int i=0;i<counter;i++) {
			clerkpool.add(new Thread(new Clerk(i,numPassengers)));
		}
		for(Thread t:clerkpool) {
			t.start();
		}
		
		//passenger
		for(int i=0;i<numPassengers;i++) {
			Thread t=new Passenger(i);
			passengerpool.add(t);
		}
		for(Thread t:passengerpool) {
			t.start();
		}
		Thread a=new Attendant(numPassengers);
		a.start();
		try {
			a.join();
			for(Thread t:passengerpool)t.join();
			for(Thread t:clerkpool)t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg("The flight attendant cleans the aircraft and is the last to leave after all the passengers.");
	}
	
	
	
	public static String getName() {
		return "Main Thread";
	}
	
	public static void msg(String m) {
		 System.out.println("["+(System.currentTimeMillis()-time)+"] "+getName()+": "+m);
	}

}
