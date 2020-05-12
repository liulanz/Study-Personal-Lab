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
			String s=in.next();
			Sol sol=new Sol();
			sol.solution(s,t);
		}
	}
}
class Sol{
	public void solution(String s,int Case){
		//(1,1)
		Map<Character,Integer>map=new HashMap<>();
		map.put('N',0);map.put('S',1);map.put('E',2);map.put('W',3);
		Stack<Node>stack=new Stack<>();
		int cnt=0;
		int mod=1000000000;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(Character.isDigit(c)){
				cnt=Integer.parseInt(c+"");
				Node node=new Node();
				node.isN=true;
				node.val=cnt;
				stack.push(node);
			}
			else if(c=='('){
				Node node=new Node();
				node.open=true;
				stack.push(node);
			}
			else if(c==')'){
				Node node=new Node();
				while(stack.size()!=0&&!stack.peek().open){
					Node peek=stack.pop();
					for(int j=0;j<4;j++)node.A[j]+=(peek.A[j]);
				}
				stack.pop();
				if(stack.peek().isN){
					Node num=stack.pop();
					for(int j=0;j<4;j++){
						node.A[j]*=num.val;
						node.A[j]%=mod;
					}
				}
				stack.push(node);
				
			}else{
				Node node=new Node();
				int index=map.get(c);
				node.A[index]++;
				stack.push(node);
			}
			//System.out.println(stack);
			//System.out.println("*******");
		}
		
		Node node=new Node();
		//System.out.println(stack);
		while(stack.size()!=0){
			Node peek=stack.pop();
			for(int i=0;i<4;i++){
				node.A[i]+=(peek.A[i]);
				node.A[i]%=mod;
			}
		}
		//(1,1)
		int x=1,y=1;
		x+=(node.A[2]-node.A[3]);
		if(x<=0)x+=mod;
		y+=(node.A[1]-node.A[0]);
		if(y<=0)y+=mod;
		System.out.println("Case #"+Case+": "+x+" "+y);

	}
	
	class Node{
		boolean open=false;
		boolean isN=false;
		long val=-1;
		long A[]=new long[4];//N,S,E,W
		public String toString(){
			return "N:"+A[0]+","+"S:"+A[1]+", "+"E:"+A[2]+", "+"W:"+A[3]+"\n";
		}
	}
}
