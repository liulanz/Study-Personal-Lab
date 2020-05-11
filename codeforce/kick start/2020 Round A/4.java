// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Solution {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++){
		   int N=in.nextInt();
		   int K=in.nextInt();
		   String A[]=new String[N];
		   for(int i=0;i<N;i++){
			   String s=in.next();
			   A[i]=s;
		   }
		   S s1=new S();
		   s1.solve(A,K,t);
		}
	}
}

class S{
	int res=0;
	int K;
	Node tries[]=new Node[26];
	public void solve(String A[],int K,int Case){
		//each group have K string
		this.K=K;
		for(String s:A){
			insert(s,0,tries);
		}
		dfs(tries);
		String ans="Case #"+Case+": "+res;
		System.out.println(ans);
	}
	
	public void dfs(Node Tries[]){
		for(int i=0;i<26;i++){
			Node node=Tries[i];
			if(node==null)continue;
			//System.out.println(node);
			int time=node.cnt/K;
			res+=(time);
			dfs(node.childs);
		}
	}
	
	//construct the datastructure
	public void insert(String word,int index,Node tries[]){
		if(index>=word.length())return;
		char c=word.charAt(index);
		if(tries[c-'A']==null){
			tries[c-'A']=new Node(c);
			tries[c-'A'].cnt++;
			insert(word,index+1,tries[c-'A'].childs);
		}else{
			tries[c-'A'].cnt++;
			insert(word,index+1,tries[c-'A'].childs);
		}
	}
}

class Node{
	char c;
	Node childs[]=new Node[26];
	int cnt=0;
	public Node(char c){
		this.c=c;
	}
	public String toString(){
		return this.c+"  "+cnt;
	}
}