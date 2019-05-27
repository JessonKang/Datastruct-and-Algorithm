package GreedyAlgorithm;

import java.util.PriorityQueue;

import javax.security.auth.x500.X500Principal;
import javax.xml.soap.Node;

public class Huffman {
	private static int R = 256; //ASCII字母表
	
	//huffman单词查找树中的结点
	private static class Node implements Comparable<Node>{
		private char ch; //结点代表的字符
		private int freq; //字符出现的频率
		private final Node left,right; //左右子节点
		
		Node(char ch,int freq,Node left,Node right){
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		//比较两个结点的大小
		public int compareTo(Node that) {
			return this.freq - that.freq;
		}
	}//class Node
	
	/*
	 * 解码函数：bit流 --> 字符流 
	 * 参数：用于构建huffman树的字符出现频率数组，待解码文件
	*/
	public static void expand(int[] freq,String file) {
		Node root = readTrie(freq);
		String s = ReadFile.readfile(file);
		char[] input = s.toCharArray();
		int N = input.length;
		
		for(int i=0;i<N;i++) {
			//展开第i个编码所对应的字母
			Node x = root; //x指向根节点
			while(!x.isLeaf()) { //不是叶节点
				if(input[i] == '0')
					x = x.left;
				else 	//为1转向右边
					x = x.right;
			}
			System.out.print(x.ch); //遍历到了叶节点，输出叶节点表示的字符
		}
	}
	
	/*
	 * 编码函数：字符流 --> bit流
	 * */
	private static String[] buildCode(Node root) {
		String[] st = new String[R];
		buildCode(st,root,"");
		return st;
	}
	
	private static void buildCode(String[] st,Node x,String s) {
		//使用单词查找树构造编译表（递归）
		if(x.isLeaf()) {
			st[x.ch] = s;
			return;
		}
		buildCode(st,x.left,s+'0');
		buildCode(st,x.right,s+'1');
	}
	
	//构造huffman树
	private static Node buildTrie(int[] freq) {
		//使用多棵单节点树初始化优先级队列
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(char c=0;c<R;c++) {
			if(freq[c]>0)
				pq.add(new Node(c, freq[c], null, null));
		}
		
		while(pq.size()>1) {
			//合并两颗频率最小的树
			Node x = pq.remove();
			Node y = pq.remove();
			Node parent = new Node('\0', x.freq+y.freq,x, y);
			pq.add(parent);
		}
		return pq.remove();
	}
	
	public static void compress() {
		//读取输入
		String s = ReadFile.readfile("D:\\data file\\word.txt");
		char[] input = s.toCharArray();
		
		//统计频率
		int[] freq = new int[R];
		for(int i=0;i<input.length;++i)
			freq[input[i]]++;
		
		//构造huffman树
		Node rootNode = buildTrie(freq);
		
		//(递归地)构造编译表
		String[] st = new String[R];
	
	}
	
	public static void main(String[] args) {
		
	}
}
