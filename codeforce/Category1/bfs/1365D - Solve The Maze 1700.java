// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T =in.nextInt();
		for(int t=0;t<T;t++){
			int n=in.nextInt();int m=in.nextInt();
			char grid[][]=new char[n][m];
			for(int i=0;i<n;i++){
				String ss=in.next();
				for(int j=0;j<m;j++){
					grid[i][j]=ss.charAt(j);
				}
			}
			Solution s=new Solution();
			s.solution(grid);
			
		}
	}

}

class Solution{
	boolean visit[][];
	Queue<int[]>q=new LinkedList<>();
	public void solution(char grid[][]){
		//We can block all empty neighbouring cells of bad people and then check if all good people can escape and no bad people are able to escape.
		int r=grid.length,c=grid[0].length;
		int cnt=0;int meet=0;int bad=0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='B'){//block all bad guy
					replace(grid,i+1,j);
					replace(grid,i-1,j);
					replace(grid,i,j+1);
					replace(grid,i,j-1);
				}
				if(grid[i][j]=='G'){
					cnt++;
				}
			}
		}
		if(cnt==0){
			System.out.println("Yes");
			return;
		}
		if(grid[r-1][c-1]!='.'&&cnt!=0){//must open
			System.out.println("No");
			return;
		}
		visit=new boolean[r][c];
		q.add(new int[]{r-1,c-1});
		visit[r-1][c-1]=true;
		while(q.size()!=0){
			int pos[]=q.poll();
			int pr=pos[0],pc=pos[1];
			if(grid[pr][pc]=='G')meet++;
			if(grid[pr][pc]=='B')bad++;
			add(grid,pr+1,pc);
			add(grid,pr-1,pc);
			add(grid,pr,pc+1);
			add(grid,pr,pc-1);
		}
		if(meet==cnt&&bad==0){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
	public void add(char grid[][],int r,int c){
		if(r<0||c<0||r>=grid.length||c>=grid[0].length)return;
		if(grid[r][c]=='#'||visit[r][c])return;
		visit[r][c]=true;
		q.add(new int[]{r,c});
	}
	
	public void replace(char grid[][],int r,int c){
		if(r<0||c<0||r>=grid.length||c>=grid[0].length)return;
		if(grid[r][c]!='.')return;
		grid[r][c]='#';
	}
	
	
}