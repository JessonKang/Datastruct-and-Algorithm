package GreedyAlgorithm;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public static String readfile(String file) {
		 FileInputStream fis = null;
		 String str = null;
	        try {
	            fis = new FileInputStream(file); // 内容是：abc
	            StringBuilder sb = new StringBuilder();
	            int temp = 0;
	            //当temp等于-1时，表示已经到了文件结尾，停止读取
	            while ((temp = fis.read()) != -1) {
	                sb.append((char) temp);
	            }
	            System.out.println(sb);
	            str = sb+"";
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                //这种写法，保证了即使遇到异常情况，也会关闭流对象。
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
