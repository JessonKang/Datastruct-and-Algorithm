package GreedyAlgorithm;

import java.util.PriorityQueue;

import javax.security.auth.x500.X500Principal;
import javax.xml.soap.Node;

public class Huffman {
	private static int R = 256; //ASCII��ĸ��
	
	//huffman���ʲ������еĽ��
	private static class Node implements Comparable<Node>{
		private char ch; //��������ַ�
		private int freq; //�ַ����ֵ�Ƶ��
		private final Node left,right; //�����ӽڵ�
		
		Node(char ch,int freq,Node left,Node right){
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		//�Ƚ��������Ĵ�С
		public int compareTo(Node that) {
			return this.freq - that.freq;
		}
	}//class Node
	
	/*
	 * ���뺯����bit�� --> �ַ��� 
	 * ���������ڹ���huffman�����ַ�����Ƶ�����飬�������ļ�
	*/
	public static void expand(int[] freq,String file) {
		Node root = readTrie(freq);
		String s = ReadFile.readfile(file);
		char[] input = s.toCharArray();
		int N = input.length;
		
		for(int i=0;i<N;i++) {
			//չ����i����������Ӧ����ĸ
			Node x = root; //xָ����ڵ�
			while(!x.isLeaf()) { //����Ҷ�ڵ�
				if(input[i] == '0')
					x = x.left;
				else 	//Ϊ1ת���ұ�
					x = x.right;
			}
			System.out.print(x.ch); //��������Ҷ�ڵ㣬���Ҷ�ڵ��ʾ���ַ�
		}
	}
	
	/*
	 * ���뺯�����ַ��� --> bit��
	 * */
	private static String[] buildCode(Node root) {
		String[] st = new String[R];
		buildCode(st,root,"");
		return st;
	}
	
	private static void buildCode(String[] st,Node x,String s) {
		//ʹ�õ��ʲ��������������ݹ飩
		if(x.isLeaf()) {
			st[x.ch] = s;
			return;
		}
		buildCode(st,x.left,s+'0');
		buildCode(st,x.right,s+'1');
	}
	
	//����huffman��
	private static Node buildTrie(int[] freq) {
		//ʹ�ö�õ��ڵ�����ʼ�����ȼ�����
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(char c=0;c<R;c++) {
			if(freq[c]>0)
				pq.add(new Node(c, freq[c], null, null));
		}
		
		while(pq.size()>1) {
			//�ϲ�����Ƶ����С����
			Node x = pq.remove();
			Node y = pq.remove();
			Node parent = new Node('\0', x.freq+y.freq,x, y);
			pq.add(parent);
		}
		return pq.remove();
	}
	
	public static void compress() {
		//��ȡ����
		String s = ReadFile.readfile("D:\\data file\\word.txt");
		char[] input = s.toCharArray();
		
		//ͳ��Ƶ��
		int[] freq = new int[R];
		for(int i=0;i<input.length;++i)
			freq[input[i]]++;
		
		//����huffman��
		Node rootNode = buildTrie(freq);
		
		//(�ݹ��)��������
		String[] st = new String[R];
	
	}
	
	public static void main(String[] args) {
		
	}
}
