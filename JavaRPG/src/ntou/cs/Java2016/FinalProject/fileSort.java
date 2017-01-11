package ntou.cs.Java2016.FinalProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class fileSort {
	/** �H�̫�ק����Ƨ� */
	public final static int FILE_DATE = 1;
	/** �H�ɮפj�p�Ƨ� */
	public final static int FILE_LENGTH = 2;
	/** �H�ɮצW�ٱƧ� */
	public final static int FILE_NAME = 3;

	public fileSort() {
	}

	/**
	 * �i�N�JFILE_DATE or FILE_LENGTH or FILE_NAME��ܱƧǪ��覡
	 * @param option �ƧǤ覡
	 * @param fliePath �ɮ׸��|
	 * @param asc ��� or ���
	 * @return
	 */
	public static ArrayList<File> sort(int option, String fliePath, boolean asc){
		ArrayList<File> ary = null;

		switch(option){
		case FILE_DATE:
			ary = sortByDate(fliePath, asc);
			break;
		case FILE_LENGTH:
			ary = sortByLength(fliePath, asc);
			break;
		case FILE_NAME:
			ary = sortByName(fliePath, asc);
			break;
		}
		return ary;
	}

	/**
	 * �H�ɮפj�p�i��Ƨ�(�`�N:�u��Ƨ��ɮסA�Ƹ�Ƨ��L�ĪG)
	 * @param fliePath fliePath �ɮ׸��|
	 * @param asc true:�Ѥj��p�Afalse:�Ѥp��j
	 * @return
	 */
	public static ArrayList<File> sortByLength(String fliePath, final boolean asc){ 
		ArrayList<File> aryList = new ArrayList<File>();
		List<File> files = Arrays.asList(new File(fliePath).listFiles());  
		Collections.sort(files, new Comparator<File>() {  
			public int compare(File f1, File f2) {  
				long diffLen = f1.length() - f2.length();  
				if(asc){
					if (diffLen > 0)  
						return -1;  
					else if (diffLen == 0)  
						return 0;  
					else  
						return 1;  
				}else{
					if (diffLen > 0)  
						return 1;  
					else if (diffLen == 0)  
						return 0;  
					else  
						return -1;  
				}
			}  
			public boolean equals(Object obj) {  
				return true;  
			}  
		});  
		for (File f : files) {  
			aryList.add(f);
		}  
		return aryList;
	}  

	/**
	 * �H�ɮצW�ٱƧ�
	 * @param fliePath fliePath �ɮ׸��|
	 * @param asc true:���V�Afalse:�ϦV
	 */
	public static ArrayList<File> sortByName(String fliePath, final boolean asc) {
		ArrayList<File> aryList = new ArrayList<File>();
		List<File> files = (List<File>)Arrays.asList(new File(fliePath).listFiles());  
		Collections.sort(files, new Comparator<File>() {  
			@Override  
			public int compare(File f1, File f2) {  
				if (f1.isDirectory() && f2.isFile())  
					return -1;  
				if (f1.isFile() && f2.isDirectory())  
					return 1; 
				if(asc){
					return f1.getName().compareTo(f2.getName());  
				}else{
					return f2.getName().compareTo(f1.getName());  
				}
			}  
		});  
		for (File f : files) {  
			aryList.add(f);
		}  
		return aryList;
	} 

	/**
	 * �H�ɮפ���Ƨ�
	 * @param fliePath fliePath �ɮ׸��|
	 * @param asc true:�ѷs���¡Afalse:���¨�s
	 */
	public static ArrayList<File> sortByDate(String fliePath, final boolean asc) {
		ArrayList<File> aryList = new ArrayList<File>();
		File file = new File(fliePath);  
		File[] fs = file.listFiles();  
		Arrays.sort(fs,new Comparator<File>(){  
			public int compare(File f2, File f1) {  
				long diffDate = f1.lastModified() - f2.lastModified();  
				if(asc){
					if (diffDate > 0)  
						return 1;  
					else if (diffDate == 0)  
						return 0;  
					else  
						return -1; 
				}else{
					if (diffDate > 0)  
						return -1;  
					else if (diffDate == 0)  
						return 0;  
					else  
						return 1; 
				}
			}  
			public boolean equals(Object obj) {  
				return true;  
			}  

		});  
		for (int i = fs.length-1; i >-1; i--) {
			aryList.add(fs[i]);
		}  
		return aryList;
	}

	/**
	 * ��ܥX�Ƨǫ᪺�ɮװ}�C����
	 * @param fileAry
	 */
	public static void showArrayList(ArrayList<File> fileAry){
		for (File f : fileAry) {  
			System.out.println("name:"+f.getName() + ",lastModified:" + f.lastModified() + "length:" + f.length());  
		} 
	}

}
