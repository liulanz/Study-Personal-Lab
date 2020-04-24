import java.util.*;
public class Clerk implements Runnable {
	int counterNum=3;
	int id=-1;
	int toProcess=0;
	Set<Integer>seatset=new HashSet<>();
	volatile List<Integer>seats=new ArrayList<>();
	static Queue<Passenger>queue=new LinkedList<>();
	volatile static int flag=1;
	volatile static Set<Integer>finish=new HashSet<>();
	public Clerk(int id,int toProcess) {
		this.id=id;
		this.toProcess=toProcess;
		//System.out.println(seats);
	}
	@Override
	//After all passengers receive their boarding pass, the check-in clerks are done for the day (they terminate)
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=toProcess/2;i++) {
			seatset.add(i+(id*(toProcess/2)));
		}
		seats=new ArrayList<>(seatset);
		Queue<Passenger>todo=new LinkedList<>();
		while(Clerk.finish.size()!=toProcess) {
			if(flag==this.id) {
				for(int i=0;i<counterNum;i++) {
					if(Clerk.queue.size()!=0&&seats.size()>todo.size()) {
						todo.add(get());
					}
					if(todo.size()==counterNum)break;
				}
				if(this.id==0)flag=1;
				else flag=0;
			}
			
			if(todo.size()!=0) {
				Passenger cur=todo.poll();
				int s=-1;
				s=seats.remove(seats.size()-1);
				cur.seat=s;
				Clerk.finish.add(cur.id);
			}
		}
		System.out.println("Clerk "+this.id+"  finish its job"+"  ");
		return;
	}
	
	  Passenger get() {
		if(Clerk.queue.size()!=0) {
			Passenger p=Clerk.queue.poll();
			return p;
		}
		return null;
	}

}
