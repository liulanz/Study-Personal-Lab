import java.util.*;
public class Passenger extends Thread {
	int id=-1;
	int seat=-1;
	Random rand=new Random();
	Thread t;
	public Passenger(int id) {
		this.id=id;
		
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(rand.nextInt(1500)); //randomly arrive
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg(("Passenger "+id+"  arrive and go straight to the check-in counter "));
		Clerk.queue.add(this);
		while(!Clerk.finish.contains(this.id)){
			//happy waiting
			continue;//it is necessary to call the checking
		}
		msg(("Passenger "+id+" get a seat number "+seat+"  is zone :"+getZone()+" and rushing"));
		rushing();
		while(!Attendant.finish.contains(this.id)){
			//happy waiting
			continue;//it is necessary to call the checking
		}
		msg("Passenger"+id+" arrive door");
		Thread.yield();
		msg(("Passenger "+id+"  with seat"+seat+" zone"+getZone()+"  stwo belonging"));
		Thread.yield();
		msg(("Passenger "+id+"  with seat"+seat+" zone"+getZone()+"  scaning and enter the plane"));
		finalsleep();
		return;
	}
	
	private void rushing() {
		int oldp=this.getPriority();
		this.setPriority(oldp+1);
		try {
			Thread.sleep(rand.nextInt(1500));
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setPriority(oldp);
		msg(("Passenger "+id+"  with seat"+seat+"  arrive the gate"));
		Attendant.queue.add(this);
		
	}
	
	private void finalsleep() {
		try {
			msg("Passenger"+id+" long sleep");
			Thread.sleep(10000000);
		} catch (InterruptedException e) {
			msg("Passenger "+id+" seatNum"+seat+" wake up and leave the plane");
		}
	}
	
	public int getZone() {
		return (seat-1)/10;
	}
	
	public String toString() {
		return "[P "+seat+"]";
	}
	
	public void msg(String m) {
		 System.out.println("["+(System.currentTimeMillis()-Main.time)+"] "+": "+m);
	}

}
