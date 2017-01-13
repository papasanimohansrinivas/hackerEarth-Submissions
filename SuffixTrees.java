import java.util.*;
import java.lang.*;
import java.math.BigInteger;

class SuffixTrees{
	Node head;
	int array[];
	int k;
	int currentMax;
	public  SuffixTrees(int temp[]){
		if (temp.length<100000) {
			array=temp;
		}
		else{
			try{
				array =temp;
			}
			catch (OutOfMemoryError e) {
				System.out.println(e);
			}
		}
		//array = new int[100000];
		head =  new Node(array,0,array.length-1);
		currentMax=0;

	}
	public void thiSolution(){
		
		Queue levels = new Queue((int) Math.pow(2,k));
		levels.enque(head);
		//System.out.println(k);
		for (int d=0;d<k+1 ;d++ ) {
			Queue temporary = new Queue((int) Math.pow(2,k));
			while(!levels.isEmpty()){
				Node temp = levels.deque();
				//System.out.println(temp.pro);
				if (currentMax<temp.pro) {
					currentMax=temp.pro;
					//System.out.println("f");
				}
				temp.left = new Node(array,temp.front+1,temp.end);
				temp.right = new Node(array,temp.front,temp.end-1);
				temporary.enque(temp.left);
				temporary.enque(temp.right);
			}
			while(!temporary.isEmpty()){
				//System.out.println("level "+d);
				levels.enque(temporary.deque());
			}
			
		}
		System.out.println(currentMax);



	}
	public void alternative(){
		int front =0;
		int end =array.length-1;
		while(k>0){
			//System.out.println(array[front+1]*array[end]+" "+array[front]*array[end-1]);

			if (array[front+1]*array[end]>array[front]*array[end-1]) {
				front=front+1;
			}
			else{
				//System.out.println(front);
				end=end-1;
			}
			k--;
		}
		System.out.println(array[front]*array[end]);
	}
	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		int tests = Integer.parseInt(input.nextLine());
		for (int z=0;z<tests ;z++ ) {
			String line1=input.nextLine();
			int n,k;
			n=Integer.parseInt(line1.split(" ")[0]);
			k=Integer.parseInt(line1.split(" ")[1]);
			String line2=input.nextLine();
			StringTokenizer proces = new StringTokenizer(line2);
			try{
				try{
					int temporary[] = new int[n];
					int size=0;
					while(proces.hasMoreTokens()){
						temporary[size]=Integer.parseInt(proces.nextToken());
						size++;
					}
					SuffixTrees sample = new SuffixTrees(temporary);
					sample.k=k;
					//sample.alternative();
					sample.thiSolution();
					//new Thread(null, new Main(), "Main", 1<<26).start();
				}
				catch(OutOfMemoryError e){
					System.out.println("out of memory error");
				}
			}
			catch(NumberFormatException w){
				System.out.println("BIgIntger Recommended");
			}
		}
	}
}

class Node{
	int arr[];
	int front;
	int end;
	Node left;
	Node right;
	BigInteger product;
	int pro;
	public Node(int arr[],int front,int end){
		this.arr = arr;
		this.front=front;
		this.end=end;
		pro = arr[front]*arr[end];

	}

	
}
class Queue{
	Node array[];
	int size;
	public Queue(int siz){
		array =  new Node[siz];
		size=0;
	}
	public void enque(Node node){
		if (size==array.length) {
			grow();
		}
		array[size]=node;
		size++;
	}
	public Node deque(){

		Node temp = array[0];
		//System.out.println("size "+size);
		for (int c=0;c<array.length-1 ;c++ ) {
			array[c]=array[c+1];
		}
		size--;
		return temp;
	}
	public void grow(){
		Node tempo[] = new Node[2*array.length];
		for (int m=0;m<array.length ;m++ ) {
			tempo[m]=array[m];
		}
		array=tempo;
		size++;
	}
	public boolean isEmpty(){

		if (size==0) {
			
			return true;
		}
		else{

			return false;
		}
	}
}
