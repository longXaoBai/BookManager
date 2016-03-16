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
		String choose = "0";
		
		while(!choose.equals("6")){
			System.out.println("欢迎来到图书管理系统！");
			System.out.println("***********************");
			System.out.println("1.增          2.删          3.改          4.查          5.显          6.退");
			System.out.println("请选择：");
			choose = in.nextLine();
			
			switch (choose){
			case "1":add();break;
			case "2":delete();break;
			case "3":charge();break;
			case "4":search();break;
			case "5":foreach();break;
			case "6":break;
			default:System.out.println("请输入正确序号！！");break;
			}
		}
		try {
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
		System.out.println("成功退出！");
	}
	
	public void add(){
		//Scanner in = new Scanner(System.in);
		System.out.println("\n\n**********增加界面**********");
		System.out.println("请输入要添加图书的书名：");
		String bookname = in.nextLine();
		System.out.println("请输入要添加图书的作者：");
		String author = in.nextLine();
		System.out.println("请输入要添加图书的单价：");
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
			System.out.println("图书已为0本，无法删除！");
		else{
			//Scanner in = new Scanner(System.in);
			System.out.println("\n\n**********删除界面**********");
			int id = 0;
			while(true){
				System.out.println("请输入所改图书序号：");
				id = in.nextInt();
				in.nextLine();
				if(id > bookCount || id-1 < 0)
					System.out.println("请输入正确的序号！");
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
		//Scanner in = new Scanner(System.in);
		System.out.println("\n\n**********修改界面**********");
		int id = 0;
		while(true){
			System.out.println("请输入所改图书序号：");
			id = in.nextInt();
			in.nextLine();
			if(id > bookCount || id-1 < 0)
				System.out.println("请输入正确的序号！");
			else
				break;
		}
		System.out.println("请输入所改图书名称:");
		String bookname = in.nextLine();
		System.out.println("请输入所改图书作者:");
		String author = in.nextLine();
		System.out.println("请输入所改图书单价:");
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
		//Scanner in = new Scanner(System.in);
		System.out.println("\n\n**********查找界面**********");
		System.out.println("1.按序号查          2.按图书名查          3.按作者查          4.按单价查");
		String choose = "0";
		choose = in.nextLine();
		switch(choose){
		case "1":{
			int id = 0;
			while(true){
				System.out.println("请输入所查图书序号：");
				id = in.nextInt();
				in.nextLine();
				if(id > bookCount || id-1 < 0)
					System.out.println("请输入正确的序号！");
				else
					break;
			}
			try {
				String sql = "select * from BookList where id = ?";
				PreparedStatement pstmt = dbConn.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
					System.out.println("第" + id + "本书为" + rs.getString("bookname") + ",作者为" + rs.getString("author") + ",单价为:" + rs.getFloat("price"));
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}break;
		case "2":{
			System.out.println("请输入所查图书名称：");
			String name = in.nextLine();
			String sql = "select * from BookList where bookname = ?";
			int count = 0;
			try {
				PreparedStatement pstmt = dbConn.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					System.out.println(name + "序号为：" + rs.getInt("id") + ",作者为" + rs.getString("author") + ",单价为:" + rs.getFloat("price"));
					count++;
				}
				if(count == 0)
					System.out.println("没有这本书！");
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}break;
		case "3":{
			System.out.println("请输入所查图书作者：");
			String name = in.nextLine();
			String sql = "select * from BookList where author = ?";
			int count = 0;
			try {
				PreparedStatement pstmt = dbConn.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					System.out.println(name + "序号为：" + rs.getInt("id") + ",书名为" + rs.getString("bookname") + ",单价为:" + rs.getFloat("price"));
					count++;
				}
				if(count == 0)
					System.out.println("没有这本书！");
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
				System.out.println("请输入所查图书最低价：");
				lowPrice = in.nextFloat();
				in.nextLine();
				if(lowPrice<0)
					System.out.println("请输入正确价格！");
			}while(lowPrice < 0);
			System.out.println("是否限制图书最高价？y or n");
			String choose2 = in.nextLine();
			if(choose2.equals("n")){
				try {
					String sql = "select * from BookList where price > ?";
					PreparedStatement pstmt = dbConn.prepareStatement(sql);
					pstmt.setFloat(1, lowPrice);
					ResultSet rs = pstmt.executeQuery();
					System.out.println("所查图书有：");
					int count = 0;
					while(rs.next()){
						System.out.println(rs.getString("bookname") + "，作者为：" + rs.getString("author") + "，单价为：" + rs.getFloat("price") +"，序号为：" + rs.getInt("id"));
						count++;
					}
					if(count == 0)
						System.out.println("没有这本书！");
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
					System.out.println("请输入图书最高价：");
					highPrice = in.nextFloat();
					in.nextLine();
					if(highPrice <lowPrice)
						System.out.println("所输最高价低于所输最低价，请重新输入！");
				}while(highPrice <lowPrice);
				try {
					String sql = "select * from BookList where price > ? and price < ?";
					PreparedStatement pstmt = dbConn.prepareStatement(sql);
					pstmt.setFloat(1, lowPrice);
					pstmt.setFloat(2, highPrice);
					ResultSet rs = pstmt.executeQuery();
					int count = 0;
					while(rs.next()){
						System.out.println(rs.getString("bookname") + "，作者为：" + rs.getString("author") + "，单价为：" + rs.getFloat("price") +"，序号为：" + rs.getInt("id"));
						count++;
					}
					if(count == 0)
						System.out.println("没有这本书！");
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}break;
		default:System.out.println("请输入正确序号！！");break;
		}
		System.out.print("\n\n");
	}
	
	public void foreach(){
		System.out.print("\n\n");
		String sql = "select * from BookList order by id";
		try {
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("当前图书为：");
			while(rs.next()){
				System.out.println("第" + rs.getInt("id") + "本书为" + rs.getString("bookname") + ",作者为" + rs.getString("author") + ",单价为:" + rs.getFloat("price"));
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














