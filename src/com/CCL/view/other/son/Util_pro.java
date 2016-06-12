package com.CCL.view.other.son;

import java.io.BufferedInputStream;  
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.util.Properties;

 
public class Util_pro {  
	 
	private static String filePath = "config/sms_properties";

    private static Properties props = new Properties();  
	
	public static String readData(String key) {
		
        try {  
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));  
            props.load(in);  
            in.close();  
            String value = props.getProperty(key);  
            return value;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  

	}

	public  static void writeData(String key, String value) throws IOException {

		InputStream fis = new FileInputStream(filePath);
        //���������ж�ȡ�����б�����Ԫ�ضԣ�
        props.load(fis);
        //���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ������,ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
        OutputStream fos = new FileOutputStream(filePath);
        props.setProperty(key, value);
        //���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ������ Properties ���е������б�����Ԫ�ضԣ�д�������
        props.store(fos, "Update '" + key + "' value");
       
		
	}
      
}  