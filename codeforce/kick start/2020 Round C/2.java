// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Solution {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
			int r=in.nextInt();//how many letter
			int c=in.nextInt();//number of string
			char grid[][]=new char[r][c];
			for(int i=0;i<r;i++){
				String s=in.next().toLowerCase();
				for(int j=0;j<c;j++){
					grid[i][j]=s.charAt(j);
				}
			}
			Sol sol=new Sol();
			sol.solution(grid,t);
		}
	}
}
class Sol{
	Set<Integer>has=new HashSet<>();
	boolean visit[][];
	Node nodes[]=new Node[26];
	public void solution(char grid[][],int Case){
		String res="";
		StringBuilder str=new StringBuilder();
		for(int i=0;i<nodes.length;i++){
			char c=(char)(i+'a');
			nodes[i]=new Node(c);
		}
		visit=new boolean[grid.length][grid[0].length];
		for(int r=0;r<grid.length;r++){
			for(int c=0;c<grid[0].length;c++){
				if(visit[r][c])continue;
				dfs(grid,r,c,grid[r][c]);
				has.add(grid[r][c]-'a');
			}
		}
		Queue<Node>queue=new LinkedList<>();
		Set<Integer>set=new HashSet<>();
		for(int i=0;i<nodes.length;i++){
			if(nodes[i].parents.size()==0&&has.contains(i)){
				queue.add(nodes[i]);
				set.add(i);
			}
		}
		
		if(queue.size()==0){
			System.out.println("Case #"+Case+": "+"-1");
			return;
		}
		while(queue.size()!=0){
			Node parent=queue.poll();
			str.append(parent.c+"");
			Set<Character>childs=parent.childs;
			for(Character c:childs){
				if(set.contains(c-'a')){
					System.out.println("Case #"+Case+": "+"-1");
					return;
				}
				nodes[c-'a'].parents.remove(parent.c);
				if(nodes[c-'a'].parents.size()==0){
					queue.add(nodes[c-'a']);
					set.add(c-'a');
				}
			}
		}
		
		if(str.toString().length()!=has.size()){
			System.out.println("Case #"+Case+": "+"-1");
			return;
		}
		System.out.println("Case #"+Case+": "+str.toString().toUpperCase());
	}
	
	public void dfs(char grid[][],int r,int c,char T){
		if(r<0||c<0||r>=grid.length||c>=grid[0].length)return;
		if(visit[r][c])return;
		if(grid[r][c]!=T)return;
		visit[r][c]=true;
		if(r+1<grid.length&&grid[r+1][c]!=T){//the bottom one must place before the current
			nodes[T-'a'].parents.add(grid[r+1][c]);
			nodes[grid[r+1][c]-'a'].childs.add(T);
		}
		dfs(grid,r+1,c,T);
		dfs(grid,r-1,c,T);
		dfs(grid,r,c+1,T);
		dfs(grid,r,c-1,T);
	}
	
	class Node{
		Set<Character>childs;
		Set<Character>parents;
		char c;
		public Node(char c){
			this.c=c;
			childs=new HashSet<>();
			parents=new HashSet<>();
		}
	}
}