package com.CCL.Dao.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//�����������ݿ��������򣬲����ṩ�����͹ر����ݿ�ķ���
public class JDBC {
	// ���ݿ�����
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	// ���ݿ��ַ
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:YMDB";
	// �û���
	private static String DBUSER = "YM";
	// ����
	private static String PASSWORD = "admin";

	private static Connection conn = null;

	// �������ļ��м�������
	static {
		Properties profile = new Properties();
		FileReader fileReader = null;
		;
		try {
			// fileReader = new FileReader("config/db.properties");
			// profile.load(fileReader);
			// DRIVER = profile.getProperty("database.driverClassName");
			// URL = profile.getProperty("database.url");
			// DBUSER = profile.getProperty("database.username");
			// PASSWORD = profile.getProperty("database.password");
			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static Connection openCon() {
		// Connection conn = null;
		if (conn == null) {

			try {
				conn = DriverManager.getConnection(URL, DBUSER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return conn;
	}

	public static void closeCon() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		Connection openCon = openCon();

		System.out.println(openCon);
		System.out.println(URL);
		System.out.println(DBUSER);
		System.out.println(PASSWORD);

		closeCon();

	}
}
