// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Solution {
	public static void main (String[] args){
	    Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
		   int R=in.nextInt();
		   int C=in.nextInt();
		   //System.out.println("R"+R+"  C"+C);
		   int grid[][]=new int[R][C];
		   for(int r=0;r<R;r++){
			   String num=in.next();
			   //System.out.println(num);
			   for(int c=0;c<C;c++){
				   grid[r][c]=Integer.parseInt(num.charAt(c)+"");
			   }
		   }
		   S sol=new S();
		   sol.solution(grid,t);
		}
	}
}

class S{
	boolean visit[][];
	int cost[][];
	int max=0;
	Queue<int[]>queue=new LinkedList<>();
	public void solution(int grid[][],int Case){
		int res=0;
		visit=new boolean[grid.length][grid[0].length];
		cost=new int[grid.length][grid[0].length];
		for(int r=0;r<grid.length;r++){
			for(int c=0;c<grid[0].length;c++){
				if(grid[r][c]==1){
					queue.add(new int[]{r,c,0});
					visit[r][c]=true;
				}
			}
		}
		//pre processing
		while(queue.size()!=0){
			int tuple[]=queue.poll();
			int r=tuple[0];
			int c=tuple[1];
			int level=tuple[2];
			max=Math.max(max,level);
			add(grid,r+1,c,level+1);
			add(grid,r-1,c,level+1);
			add(grid,r,c+1,level+1);
			add(grid,r,c-1,level+1);
		}
		int l=0;
		int e=grid.length+grid[0].length;
		while(l<=e){
			int mid=l+(e-l)/2;
			boolean found=false;
			int points[]=new int[4];
			Arrays.fill(points,Integer.MIN_VALUE/2);
			for(int r=0;r<grid.length;r++){
				for(int c=0;c<grid[0].length;c++){
					if(cost[r][c]>mid){//point we need to deal
						points[0]=Math.max(points[0],-r-c);
						points[1]=Math.max(points[1],c-r);
						points[2]=Math.max(points[2],r-c);
						points[3]=Math.max(points[3],r+c);
					}
				}
			}
			//
			for(int r=0;r<grid.length;r++){
				for(int c=0;c<grid[0].length;c++){
					if(grid[r][c]==1)continue;
					//possible place
					int dis=Integer.MIN_VALUE/2;
					int one=r+c;
					int two=r-c;
					int three=c-r;
					int four=-c-r;
					dis=Math.max(dis,one+points[0]);
					dis=Math.max(dis,two+points[1]);
					dis=Math.max(dis,three+points[2]);
					dis=Math.max(dis,four+points[3]);
					if(dis<=mid){//can place here
						found=true;
						break;
					}
				}
			}
			if(found){
				res=mid;
				e=mid-1;
			}else{
				l=mid+1;
			}
		}//while
		System.out.println("Case #"+Case+": "+res);
	}
	public void add(int grid[][],int r,int c,int level){
		if(r<0||c<0||r>=grid.length||c>=grid[0].length)return;
		if(visit[r][c])return;
		visit[r][c]=true;
		queue.add(new int[]{r,c,level});
		cost[r][c]=level;
	}
}

