package OPERATION;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DATABASE.DBConnection;
import MODEL.Book;
import MODEL.BookList;

public class Operation {
	
	public boolean add(Book book){
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql="insert into BookList (id,bookname,author,price) values (?,?,?,?)";
			PreparedStatement pstmt=dbConn.prepareStatement(sql);
			pstmt.setString(1, book.id);
			pstmt.setString(2, book.bookname);
			pstmt.setString(3, book.author);
			pstmt.setFloat(4, book.price);
			pstmt.executeUpdate();
			DBConnection.closeConnection(dbConn, pstmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean delete(Book book){
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "delete from BookList where id = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, book.id);
			pstmt.executeUpdate();
			DBConnection.closeConnection(dbConn, pstmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean charge(Book book,String oldId){
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "update BookList set bookname = ?, author = ?, price = ?, id = ? where id = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, book.bookname);
			pstmt.setString(2, book.author);
			pstmt.setFloat(3, book.price);
			pstmt.setString(4, book.id);
			pstmt.setString(5, oldId);
			pstmt.executeUpdate();
			DBConnection.closeConnection(dbConn, pstmt);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public BookList searchById(Book book){
		BookList booklist = new BookList();
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "select * from BookList where id = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, book.id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Book abook = new Book(rs.getString("id"),rs.getString("bookname"),rs.getString("author"),rs.getFloat("price"));
				booklist.add(abook);
			}
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}
	
	public BookList searchByBookname(Book book){
		BookList booklist = new BookList();
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "select * from BookList where bookname = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, book.bookname);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Book abook = new Book(rs.getString("id"),rs.getString("bookname"),rs.getString("author"),rs.getFloat("price"));
				booklist.add(abook);
			}
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}
	
	public BookList searchByAuthor(Book book){
		BookList booklist = new BookList();
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "select * from BookList where author = ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setString(1, book.author);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Book abook = new Book(rs.getString("id"),rs.getString("bookname"),rs.getString("author"),rs.getFloat("price"));
				booklist.add(abook);
			}
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}
	
	public BookList searchByPrice(Book book){
		BookList booklist = new BookList();
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "select * from BookList where price = ? or price > ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setFloat(1, book.price);
			pstmt.setFloat(2, book.price);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Book abook = new Book(rs.getString("id"),rs.getString("bookname"),rs.getString("author"),rs.getFloat("price"));
				booklist.add(abook);
			}
			DBConnection.closeConnection(dbConn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}
	
	public BookList searchByPrice(Book lowBook,Book highBook){
		BookList booklist = new BookList();
		try {
			Connection dbConn = DBConnection.getConnection();
			String sql = "select * from BookList where price > ? and price < ?";
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			pstmt.setFloat(1, lowBook.price);
			pstmt.setFloat(2, highBook.price);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Book abook = new Book(rs.getString("id"),rs.getString("bookname"),rs.getString("author"),rs.getFloat("price"));
				booklist.add(abook);
			}
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}
	
	public BookList foreach(){
		BookList booklist = new BookList();
		String sql = "select * from BookList order by id";
		try {
			Connection dbConn = DBConnection.getConnection();
			PreparedStatement pstmt = dbConn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book(rs.getString("id"),rs.getString("bookname"),rs.getString("author"),rs.getFloat("price"));
				booklist.add(book);
			}
			DBConnection.closeConnection(dbConn, pstmt,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}
}









