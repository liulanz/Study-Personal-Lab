import java.util.*;
public class Attendant extends Thread {
	volatile static Queue<Passenger>queue=new LinkedList<>();
	volatile static Set<Integer>finish=new HashSet<>();
	List<Passenger>list=new ArrayList<>();
	int total=0;
	public Attendant(int total) {
		this.total=total;
	}
	
	//The yield() method of thread class causes the currently executing thread object to temporarily pause and allow other threads to execute.
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(Attendant.queue.size()!=total) {
			continue;
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		msg("Attendent start calling with queue:");
		System.out.println(queue);
		
		TreeMap<Integer,Queue<Passenger>>map=new TreeMap<>();
		while(Attendant.queue.size()!=0) {
			Passenger p=Attendant.queue.poll();
			int zone=p.getZone();
			if(!map.containsKey(zone)) {
				Queue<Passenger>q=new LinkedList<>();
				map.put(zone,q);
			}
			map.get(zone).add(p);
		}
		for(Integer zone:map.keySet()) {
			msg("Calling zone"+zone+" to the door");
			Queue<Passenger>q=map.get(zone);
			while(q.size()!=0) {
				Passenger p=q.poll();
				Attendant.finish.add(p.id);
				list.add(p);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Collections.sort(list,(p1,p2)->{
			return p1.seat-p2.seat;
		});
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg("Attendent call leaving from ascending odder");
		for(Passenger p:list) {
			try {
				//Thread.sleep(100);
				p.interrupt();
				p.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void msg(String m) {
		 System.out.println("["+(System.currentTimeMillis()-Main.time)+"] "+": "+m);
	}
}
