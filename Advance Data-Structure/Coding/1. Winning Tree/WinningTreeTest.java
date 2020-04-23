import java.util.*;
public class WinningTreeTest{
	public static void main(String [ ] args){
		int nums[]=new int[]{4,3,6,8,1,5,7,3,2,6,9,4,5,2,5,8};
		WinnerTree w=new WinnerTree(nums);
		w.print();
		w.replaceWinner(6);
		w.print();
	}
}

class WinnerTree{
	int trees[];
	public WinnerTree(int nums[]){//input 16 numbers
		System.out.println("Smallest is the winner");
		int external=nums.length;
		int internal=external-1;
		trees=new int[external+internal];//initialize ther tree with (n) external node + (n-1)external nodes
		
		//initialization
		int index=trees.length-1;
		for(int i=external-1;i>=0;i--){
			trees[index]=nums[i];
			index--;
		}
		//play
		for(int i=index;i>=0;i--){
			int left=i*2+1;
			int right=i*2+2;
			trees[i]=Math.min(trees[left],trees[right]);
		}
	}
	public int getWinner(){
		return trees[0];
	}
	
	public void replaceWinner(int val){
		int prewinner=trees[0];
		int curIndex=0;
		List<Integer>path=new ArrayList<>();
		while(true){
			path.add(curIndex);
			trees[curIndex]=val;
			int left=curIndex*2+1;
			int right=curIndex*2+2;
			if(left>=trees.length||right>=trees.length)break;
			if(trees[left]==prewinner){
				curIndex=left;
			}
			else if(trees[right]==prewinner){
				curIndex=right;
			}
		}
		//replay
		for(int i=path.size()-2;i>=0;i--){
			int index=path.get(i);
			int left=index*2+1;
			int right=index*2+2;
			trees[index]=Math.min(trees[left],trees[right]);
		}
	}
	
	public void print(){
		for(int n:trees)System.out.print(n+"  ");
		System.out.println();
	}
	

}