// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		int k =in.nextInt();
		int A[][]=new int[n][3];
		for(int i=0;i<n;i++){
			A[i][0]=in.nextInt();
			A[i][1]=in.nextInt();
			A[i][2]=in.nextInt();
		}
		Solution s=new Solution();
		s.solution(A,k);
	}

}

class Solution{
	public void solution(int A[][],int k){
		int x=0,y=0;
		for(int i=0;i<A.length;i++){
			if(A[i][1]==1){
				x++;
			}
			if(A[i][2]==1){
				y++;
			}
		}
		if(x<k||y<k){
			System.out.println(-1);
			return;
		}
		long res=Integer.MAX_VALUE;
		Arrays.sort(A,(a1,b1)->{
			return a1[0]-b1[0];
		});
		long a=0,b=0,ab=0;
		List<Long>l1=new ArrayList<>();
		List<Long>l2=new ArrayList<>();
		List<Long>l3=new ArrayList<>();
		for(int i=0;i<A.length;i++){
			//if(a<=0&&b<=0)break;
			int cost=A[i][0];
			if(A[i][1]==1&&A[i][2]==1){
				ab+=cost;
				l3.add(ab);
				
			}
			else if(A[i][1]==1){
				a+=cost;
				l1.add(a);
			}
			else if(A[i][2]==1){
				b+=cost;
				l2.add(b);
			}
		}
		//System.out.println(l1);
		//System.out.println(l2);
		//System.out.println(l3);
		if(l1.size()>=k&&l2.size()>=k){
			res=l1.get(k-1)+l2.get(k-1);
		}
		for(int i=0;i<l3.size();i++){
			if(i>=k)break;
			long both=l3.get(i);
			int single=k-(i+1);
			if(single==0){
				res=Math.min(res,both);
				continue;
			}
			if(l1.size()>=single&&l2.size()>=single){
				res=Math.min(l1.get(single-1)+l2.get(single-1)+both,res);
			}
		}
		System.out.println(res);
	}

	
}