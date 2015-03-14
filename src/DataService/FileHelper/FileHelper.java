package DataService.FileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class FileHelper {
	public static ArrayList<String> readByLine(File file){
		ArrayList<String> content=new ArrayList<String>();
		
		try {
			String tempString;
			BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath()),"UTF-8"));  
			while((tempString = reader.readLine()) != null){
				
				content.add(tempString);
				}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return content;
		
	}
	
	public static ArrayList<String> analysisOfOneLine(String oneLine){   //����ÿ�����ݣ�����Ա��Ϣ�������Ϣ�ļ���Ч��
		ArrayList<String> results=new ArrayList<String>();
		oneLine=oneLine.substring(1,oneLine.length()-1);//ȥ����β�ķǷ��ַ�
		String[] eachString=oneLine.split("��");
		for(int i=0;i<eachString.length;i++){     //ȥ���ո�
			results.add(eachString[i].trim());
		}
		
		return results;
		
	}
}
