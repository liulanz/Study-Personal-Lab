import java.util.*;
public class Passenger implements Runnable {
	int id=-1;
	int seat=-1;
	Random rand=new Random();
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
		System.out.println("Passenger "+id+"  arrive and go straight to the check-in counter ");
		Clerk.queue.add(this);
		while(!Clerk.finish.contains(this.id)){
			//happy waiting
			continue;//it is necessary to call the checking
		}
		System.out.println("Passenger "+id+" get a seat number "+seat+"  is zone :"+getZone());
		return;
	}
	public int getZone() {
		return seat/10;
	}
	
	public String toString() {
		return "Passenger "+id+" \n";
	}

}
