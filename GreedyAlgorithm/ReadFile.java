package GreedyAlgorithm;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public static String readfile(String file) {
		 FileInputStream fis = null;
		 String str = null;
	        try {
	            fis = new FileInputStream(file); // �����ǣ�abc
	            StringBuilder sb = new StringBuilder();
	            int temp = 0;
	            //��temp����-1ʱ����ʾ�Ѿ������ļ���β��ֹͣ��ȡ
	            while ((temp = fis.read()) != -1) {
	                sb.append((char) temp);
	            }
	            System.out.println(sb);
	            str = sb+"";
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                //����д������֤�˼�ʹ�����쳣�����Ҳ��ر�������
	                if (fis != null) {
	                    fis.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return str;
	}
	
	public static void main(String[] args) {
		String str = ReadFile.readfile("D:\\data file\\word.txt");
		System.out.println("main ---------- " + str);
	}
}
