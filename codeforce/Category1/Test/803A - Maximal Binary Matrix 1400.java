// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
// Please name your class Main
public class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		//int T =in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		//for(int t=0;t<T;t++){
			//int n=in.nextInt();int h=in.nextInt();int l=in.nextInt();int r=in.nextInt();
			//int A[]=new int[n];
			//for(int i=0;i<n;i++){
				//A[i]=in.nextInt();
			//}
			
			int n =in.nextInt();int k =in.nextInt();
			Solution s=new Solution();
			s.solution(n,k);
			out.flush();
		//}
		
	}

}

class Solution{
	public void solution(int n,int k){
		//sleep n time
		//each day h hours
		if(n*n<k){
			System.out.println(-1);
			return;
		}
		int grid[][]=new int[n][n];
		if(k==0){
			print(grid);return;
		}
		int i=0,j=1;
		int dia=1;
		grid[0][0]=1;
		k--;
		while(k>0){			
			if(k==1){
				while(dia<n){
					if(grid[dia][dia]==1){
						dia++;
					}
					else break;
				}
				if(dia>=n){
					System.out.println(-1);
					return;
				}
				grid[dia][dia]=1;
				k--;
			}else{
				while(grid[i][j]==1){
					j++;
					if(j>=n){
						j=0;i++;
					}
					if(i>=n){
						System.out.println(-1);
						return;
					}
				}
				grid[i][j]=1;
				grid[j][i]=1;
				if(i==j)k--;
				else k-=2;
			}
		}
		print(grid);
		
	}
	public void print(int grid[][]){
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	

}
