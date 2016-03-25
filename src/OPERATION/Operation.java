package OPERATION;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DATABASE.DBConnection;

public class Operation {
	
	public void add(String id,String bookname,String author,Float price){
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql="insert into BookList (id,bookname,author,price) values (?,?,?,?)";
			PreparedStatement pstmt=dbConn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, bookname);
			pstmt.setString(3, author);
			pstmt.setFloat(4, price);
			pstmt.executeUpdate();
			DBConnection.closeConnection(dbConn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ӳɹ�!");
		} 
	}
	
	public void delete(String id){
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "delete BookList where id = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			DBConnection.closeConnection(dbConn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			System.out.println("ɾ���ɹ�!");
		}
	}
	
	public void charge(String bookname,String author,Float price,String newId,String oldId){
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "update BookList set bookname = ?, author = ?, price = ?, id = ? where id = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, bookname);
			pstmt.setString(2, author);
			pstmt.setFloat(3, price);
			pstmt.setString(4, newId);
			pstmt.setString(5, oldId);
			pstmt.executeUpdate();
			DBConnection.closeConnection(dbConn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			System.out.println("�޸ĳɹ���");
		}
	}
	
	public int search(String str){
		int count = 0;
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "select * from BookList where id = ? or bookname = ? or author = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, str);
			pstmt.setString(2, str);
			pstmt.setString(3, str);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				System.out.println("���" + rs.getString("id") + "������Ϊ" + rs.getString("bookname") + ",����Ϊ" + rs.getString("author") + ",����Ϊ:" + rs.getFloat("price"));
				count++;
			}
			if(count == 0)
				System.out.println("û���Ȿ�飡");
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public void search(float lowPrice){
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "select * from BookList where price = ? or price > ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setFloat(1, lowPrice);
			pstmt.setFloat(2, lowPrice);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("����ͼ���У�");
			int count = 0;
			while(rs.next()){
				System.out.println(rs.getString("bookname") + "������Ϊ��" + rs.getString("author") + "������Ϊ��" + rs.getFloat("price") +"�����Ϊ��" + rs.getString("id"));
				count++;
			}
			if(count == 0)
				System.out.println("û���Ȿ�飡");
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void search(float lowPrice,float highPrice){
		try {
			Connection dbConn = DBConnection.getConnection();
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
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void foreach(){
		System.out.print("\n\n");
		String sql = "select * from BookList order by id";
		try {
			Connection dbConn = DBConnection.getConnection();
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("��ǰͼ��Ϊ��");
			while(rs.next()){
				System.out.println("���" + rs.getString("id") + "������Ϊ" + rs.getString("bookname") + ",����Ϊ" + rs.getString("author") + ",����Ϊ:" + rs.getFloat("price"));
			}
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("\n\n");
	}
	
	public int bookCount(){
		String sql = "select * from BookList order by id";
		int count = 0;
		try {
			Connection dbConn = DBConnection.getConnection();
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				count++;
			}
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}









