// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		for(int i=0;i<T;i++){
			int h =in.nextInt();int c =in.nextInt();int t =in.nextInt();
			Solution s=new Solution();
			s.solution(h,c,t);
		}
	}

}

class Solution{
	public void solution(int h,int c,int T){
		double t=T;
		double avg=(h+0.0+c)/2;
		if(t<=avg){
			System.out.println(2);
			return;
		}
		if(t>=h){
			System.out.println(1);
			return;
		}
		long pos=-1;
		long l=2,r=Integer.MAX_VALUE;
		double sum=h+c;
		while(l<=r){
			long mid=l+(r-l)/2;
			double ave=((mid-1)*(sum)+h+0.0)/(mid*2-1);
			if(t>=ave){
				pos=mid;
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		//consider 2 case
		double p1=pos,p2=pos-1,p3=pos+1;
		PriorityQueue<BigDecimal[]>pq=new PriorityQueue<>((a1,a2)->{
			int val=a1[1].compareTo(a2[1]);
			if(val==0){
				return a1[0].compareTo(a2[0]);
			}
			else return val;
		});
		//System.out.println(p1+"  "+Math.abs(t-((p1-1)*(sum)+h+0.0)/(p1*2-1)));
		//System.out.println(p2+"  "+Math.abs(t-((p2-1)*(sum)+h+0.0)/(p2*2-1)));
		//System.out.println(p3+"  "+Math.abs(t-((p3-1)*(sum)+h+0.0)/(p3*2-1)));
		pq.add(new BigDecimal[]{new BigDecimal(p1),( new BigDecimal(t).subtract( (new BigDecimal(p1-1).multiply(new BigDecimal(sum))).add(new BigDecimal(h)).divide(new BigDecimal(p1*2-1),RoundingMode.CEILING)) ).abs()});
		pq.add(new BigDecimal[]{new BigDecimal(p2),(new BigDecimal(t).subtract(  (new BigDecimal(p2-1).multiply(new BigDecimal(sum))).add(new BigDecimal(h)).divide(new BigDecimal(p2*2-1),RoundingMode.CEILING)) ).abs()});
		//pq.add(new BigDecimal[]{new BigDecimal(p3),(new BigDecimal(t).subtract(  (new BigDecimal(p3-1).multiply(new BigDecimal(sum))).add(new BigDecimal(h)).divide(new BigDecimal(p3*2-1),RoundingMode.CEILING)) ).abs()});
		System.out.println((int)(pq.peek()[0].doubleValue()*2-1));
		while(pq.size()!=0){
			System.out.println
		}
		
	}
}