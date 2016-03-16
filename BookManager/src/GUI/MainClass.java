package GUI;
import java.util.Scanner;
import java.sql.*;

public class MainClass {
	Connection dbConn;
	int bookCount = 0;
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new MainClass();
	}
	
	{
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Book";
		String userName="sa";
		String userPwd="jiang1689";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	MainClass(){
		foreach();
		String choose = "0";
		
		while(!choose.equals("6")){
			System.out.println("��ӭ����ͼ�����ϵͳ��");
			System.out.println("***********************");
			System.out.println("1.��          2.ɾ          3.��          4.��          5.��          6.��");
			System.out.println("��ѡ��");
			choose = in.nextLine();
			
			switch (choose){
			case "1":add();break;
			case "2":delete();break;
			case "3":charge();break;
			case "4":search();break;
			case "5":foreach();break;
			case "6":break;
			default:System.out.println("��������ȷ��ţ���");break;
			}
		}
		try {
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
		System.out.println("�ɹ��˳���");
	}
	
	public void add(){
		System.out.println("\n\n**********���ӽ���**********");
		System.out.println("������Ҫ���ͼ���������");
		String bookname = in.nextLine();
		System.out.println("������Ҫ���ͼ������ߣ�");
		String author = in.nextLine();
		System.out.println("������Ҫ���ͼ��ĵ��ۣ�");
		float price = in.nextFloat();
		in.nextLine();
		try {
			String sql="insert into BookList (id,bookname,author,price) values (?,?,?,?)";
			PreparedStatement pstmt=dbConn.prepareStatement(sql);
			pstmt.setInt(1, bookCount+1);
			pstmt.setString(2, bookname);
			pstmt.setString(3, author);
			pstmt.setFloat(4, price);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			bookCount++;
			System.out.println("\n\n");
		}
	}
	
	public void delete(){
		if(bookCount <= 0)
			System.out.println("ͼ����Ϊ0�����޷�ɾ����");
		else{
			System.out.println("\n\n**********ɾ������**********");
			int id = 0;
			while(true){
				System.out.println("����������ͼ����ţ�");
				id = in.nextInt();
				in.nextLine();
				if(id > bookCount || id-1 < 0)
					System.out.println("��������ȷ����ţ�");
				else
					break;
			}
			try {
				String delSql = "delete BookList where id = ?";
				PreparedStatement delPstmt = dbConn.prepareStatement(delSql);
				delPstmt.setInt(1, id);
				delPstmt.executeUpdate();
				String idReturnSql = "update BookList set id = id - 1 where id > ?";
				PreparedStatement idReturnPstmt = dbConn.prepareStatement(idReturnSql);
				idReturnPstmt.setInt(1, id);
				idReturnPstmt.executeUpdate();
				delPstmt.close();
				idReturnPstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				bookCount--;
				System.out.println("\n\n");
			}
		}
	}
	
	public void charge(){
		System.out.println("\n\n**********�޸Ľ���**********");
		int id = 0;
		while(true){
			System.out.println("����������ͼ����ţ�");
			id = in.nextInt();
			in.nextLine();
			if(id > bookCount || id-1 < 0)
				System.out.println("��������ȷ����ţ�");
			else
				break;
		}
		System.out.println("����������ͼ������:");
		String bookname = in.nextLine();
		System.out.println("����������ͼ������:");
		String author = in.nextLine();
		System.out.println("����������ͼ�鵥��:");
		float price = in.nextFloat();
		in.nextLine();
		try {
			String sql = "update BookList set bookname = ?, author = ?, price = ? where id = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, bookname);
			pstmt.setString(2, author);
			pstmt.setFloat(3, price);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			System.out.println("\n\n");
		}
	}
	
	public void search(){
		System.out.println("\n\n**********���ҽ���**********");
		System.out.println("1.����Ų�          2.��ͼ������          3.�����߲�          4.�����۲�");
		String choose = "0";
		choose = in.nextLine();
		switch(choose){
		case "1":{
			int id = 0;
			while(true){
				System.out.println("����������ͼ����ţ�");
				id = in.nextInt();
				in.nextLine();
				if(id > bookCount || id-1 < 0)
					System.out.println("��������ȷ����ţ�");
				else
					break;
			}
			try {
				String sql = "select * from BookList where id = ?";
				PreparedStatement pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
					System.out.println("��" + id + "����Ϊ" + rs.getString("bookname") + ",����Ϊ" + rs.getString("author") + ",����Ϊ:" + rs.getFloat("price"));
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}break;
		case "2":{
			System.out.println("����������ͼ�����ƣ�");
			String name = in.nextLine();
			String sql = "select * from BookList where bookname = ?";
			int count = 0;
			try {
				PreparedStatement pstmt = dbConn.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					System.out.println(name + "���Ϊ��" + rs.getInt("id") + ",����Ϊ" + rs.getString("author") + ",����Ϊ:" + rs.getFloat("price"));
					count++;
				}
				if(count == 0)
					System.out.println("û���Ȿ�飡");
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}break;
		case "3":{
			System.out.println("����������ͼ�����ߣ�");
			String name = in.nextLine();
			String sql = "select * from BookList where author = ?";
			int count = 0;
			try {
				PreparedStatement pstmt = dbConn.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					System.out.println(name + "���Ϊ��" + rs.getInt("id") + ",����Ϊ" + rs.getString("bookname") + ",����Ϊ:" + rs.getFloat("price"));
					count++;
				}
				if(count == 0)
					System.out.println("û���Ȿ�飡");
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}break;
		case "4":{
			float lowPrice = 0;
			do{
				System.out.println("����������ͼ����ͼۣ�");
				lowPrice = in.nextFloat();
				in.nextLine();
				if(lowPrice<0)
					System.out.println("��������ȷ�۸�");
			}while(lowPrice < 0);
			System.out.println("�Ƿ�����ͼ����߼ۣ�y or n");
			String choose2 = in.nextLine();
			if(choose2.equals("n")){
				try {
					String sql = "select * from BookList where price > ?";
					PreparedStatement pstmt = dbConn.prepareStatement(sql);
					pstmt.setFloat(1, lowPrice);
					ResultSet rs = pstmt.executeQuery();
					System.out.println("����ͼ���У�");
					int count = 0;
					while(rs.next()){
						System.out.println(rs.getString("bookname") + "������Ϊ��" + rs.getString("author") + "������Ϊ��" + rs.getFloat("price") +"�����Ϊ��" + rs.getInt("id"));
						count++;
					}
					if(count == 0)
						System.out.println("û���Ȿ�飡");
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(choose2.equals("y")){
				float highPrice = 0;
				do{
					System.out.println("������ͼ����߼ۣ�");
					highPrice = in.nextFloat();
					in.nextLine();
					if(highPrice <lowPrice)
						System.out.println("������߼۵���������ͼۣ����������룡");
				}while(highPrice <lowPrice);
				try {
					String sql = "select * from BookList where price > ? and price < ?";
					PreparedStatement pstmt = dbConn.prepareStatement(sql);
					pstmt.setFloat(1, lowPrice);
					pstmt.setFloat(2, highPrice);
					ResultSet rs = pstmt.executeQuery();
					int count = 0;
					while(rs.next()){
						System.out.println(rs.getString("bookname") + "������Ϊ��" + rs.getString("author") + "������Ϊ��" + rs.getFloat("price") +"�����Ϊ��" + rs.getInt("id"));
						count++;
					}
					if(count == 0)
						System.out.println("û���Ȿ�飡");
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}break;
		default:System.out.println("��������ȷ��ţ���");break;
		}
		System.out.print("\n\n");
	}
	
	public void foreach(){
		System.out.print("\n\n");
		String sql = "select * from BookList order by id";
		try {
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("��ǰͼ��Ϊ��");
			while(rs.next()){
				System.out.println("��" + rs.getInt("id") + "����Ϊ" + rs.getString("bookname") + ",����Ϊ" + rs.getString("author") + ",����Ϊ:" + rs.getFloat("price"));
				bookCount++;
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("\n\n");
	}
}














