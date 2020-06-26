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
			int a=in.nextInt();int b=in.nextInt();
			Solution s=new Solution();
			s.solution(n,m,a,b);
		}
	}

}

class Solution{
	public void solution(int r,int c,int a,int b){
		if(r*a!=c*b){
			System.out.println("NO");
			return;
		}
		int grid[][]=new int[r][c];
		long d=0;
		for(int i=0;i<r;i++){
			for(int j=0;j<a;j++){
				grid[i][(d)%c]=1;d++;
			}
		}
		System.out.println("YES");
		print(grid);
	}
	public void print(int grid[][]){
		for(int i=0;i<grid.length;i++){
			StringBuilder str=new StringBuilder();
			for(int j=0;j<grid[0].length;j++){
				str.append(""+grid[i][j]);
			}
			System.out.println(str.toString());
		}
	}
}