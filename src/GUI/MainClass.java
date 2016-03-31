package GUI;
import java.util.Scanner;

import MODEL.Book;
import MODEL.BookList;
import OPERATION.Operation;

public class MainClass {
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new MainClass();
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
		in.close();
		System.out.println("�ɹ��˳���");
	}
	
	public void add(){
		System.out.println("\n\n**********���ӽ���**********");
		String id = null;
		int temp = 0;
		Operation op = new Operation();
		do{
			System.out.println("������Ҫ���ͼ��ı�ţ�");
			id = in.nextLine();
			if(op.searchById(new Book(id,null,null,0)).size() != 0)
				System.out.println("���鼮�Ѵ��ڣ����������룡");
		}while(temp != 0);
		System.out.println("������Ҫ���ͼ���������");
		String bookname = in.nextLine();
		System.out.println("������Ҫ���ͼ������ߣ�");
		String author = in.nextLine();
		System.out.println("������Ҫ���ͼ��ĵ��ۣ�");
		float price = in.nextFloat();
		in.nextLine();
		Book book = new Book(id,bookname,author,price);
		if(op.add(book))
			System.out.println("��ӳɹ���");
		else
			System.out.println("���ʧ�ܡ���");
		System.out.println("\n\n");
	}
	
	public void delete(){
		Operation op = new Operation();
		if(op.foreach().size() <= 0)
			System.out.println("ͼ����Ϊ0�����޷�ɾ����");
		else{
			System.out.println("\n\n**********ɾ������**********");
			System.out.println("����������ͼ����ţ�");
			String id = in.nextLine();
			if(op.searchById(new Book(id,null,null,0)).size() == 0)
				System.out.println("���ݿ���û�и��鼮��");
			else{
				Book book = new Book(id,null,null,0);
				if(op.delete(book))
					System.out.println("ɾ���ɹ���");
				else
					System.out.println("ɾ��ʧ�ܡ���");
			}
			System.out.println("\n\n");
		}
	}
	
	public void charge(){
		Operation op = new Operation();
		System.out.println("\n\n**********�޸Ľ���**********");
		System.out.println("�������֮ǰͼ���ţ�");
		String oldId = in.nextLine();
		if(op.searchById(new Book(oldId,null,null,0)).size() == 0)
			System.out.println("���ݿ���û�и��鼮��");
		else{
			System.out.println("�������֮��ͼ���ţ�");
			String newId = in.nextLine();
			System.out.println("����������ͼ������:");
			String bookname = in.nextLine();
			System.out.println("����������ͼ������:");
			String author = in.nextLine();
			System.out.println("����������ͼ�鵥��:");
			float price = in.nextFloat();
			in.nextLine();
			Book book = new Book(newId,bookname,author,price);
			if(op.charge(book, oldId))
				System.out.println("�޸ĳɹ���");
			else
				System.out.println("�޸�ʧ�ܡ���");
		}
		System.out.println("\n\n");
	}
	
	public void search(){
		System.out.println("\n\n**********���ҽ���**********");
		System.out.println("1.����Ų�          2.��ͼ������          3.�����߲�          4.�����۲�");
		String choose = "0";
		choose = in.nextLine();
		switch(choose){
		case "1":{
			System.out.println("����������ͼ����ţ�");
			String id = in.nextLine();
			Book book = new Book(id,null,null,0);
			BookList booklist = new Operation().searchById(book);
			int count = booklist.size();
			if(count == 0)
				System.out.println("û���Ȿ�顣��");
			else
				for(int i = 0; i<booklist.size(); i++){
					System.out.println("���" + booklist.get(i).id + "������Ϊ��" + booklist.get(i).bookname + "��������Ϊ" + booklist.get(i).author + "������Ϊ��" + booklist.get(i).price);
				}
		}break;
		case "2":{
			System.out.println("����������ͼ��������");
			String bookname = in.nextLine();
			Book book = new Book(null,bookname,null,0);
			BookList booklist = new Operation().searchByBookname(book);
			int count = booklist.size();
			if(count == 0)
				System.out.println("û���Ȿ�顣��");
			else
				for(int i = 0; i<booklist.size(); i++){
					System.out.println("���" + booklist.get(i).id + "������Ϊ��" + booklist.get(i).bookname + "��������Ϊ" + booklist.get(i).author + "������Ϊ��" + booklist.get(i).price);
				}
		}break;
		case "3":{
			System.out.println("����������ͼ����������");
			String author = in.nextLine();
			Book book = new Book(null,null,author,0);
			BookList booklist = new Operation().searchByAuthor(book);
			int count = booklist.size();
			if(count == 0)
				System.out.println("û���Ȿ�顣��");
			else
				for(int i = 0; i<booklist.size(); i++){
					System.out.println("���" + booklist.get(i).id + "������Ϊ��" + booklist.get(i).bookname + "��������Ϊ" + booklist.get(i).author + "������Ϊ��" + booklist.get(i).price);
				}
		}break;
		case "4":{
			Operation op = new Operation();
			float lowPrice = 0;
			do{
				System.out.println("����������ͼ����ͼۣ�");
				lowPrice = in.nextFloat();
				in.nextLine();
				if(lowPrice<0)
					System.out.println("��������ȷ�۸�");
			}while(lowPrice < 0);
			Book lowBook = new Book(null,null,null,lowPrice);
			System.out.println("�Ƿ�����ͼ����߼ۣ�y or n");
			String choose2 = in.nextLine();
			if(choose2.equals("n")){
				BookList booklist = op.searchByPrice(lowBook);
				int count = booklist.size();
				if(count == 0)
					System.out.println("���޴��顣��");
				else
					for(int i = 0; i<booklist.size(); i++){
						System.out.println("���" + booklist.get(i).id + "������Ϊ��" + booklist.get(i).bookname + "��������Ϊ" + booklist.get(i).author + "������Ϊ��" + booklist.get(i).price);
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
				Book highBook = new Book(null,null,null,highPrice);
				BookList booklist = op.searchByPrice(lowBook, highBook);
				int count = booklist.size();
				if(count == 0)
					System.out.println("���޴��顣��");
				else
					for(int i = 0; i<booklist.size(); i++){
						System.out.println("���" + booklist.get(i).id + "������Ϊ��" + booklist.get(i).bookname + "��������Ϊ" + booklist.get(i).author + "������Ϊ��" + booklist.get(i).price);
					}
			}
		}break;
		default:System.out.println("��������ȷ��ţ���");break;
		}
		System.out.print("\n\n");
	}
	
	public void foreach(){
		System.out.println("\n\n");
		System.out.println("��ǰͼ��Ϊ��");
		BookList booklist = new Operation().foreach();
		int count = booklist.size();
		if(count == 0)
			System.out.println("���ݿ���û�д����κ��鼮��");
		else
			for(int i = 0; i<booklist.size(); i++){
				System.out.println("���" + booklist.get(i).id + "������Ϊ��" + booklist.get(i).bookname + "��������Ϊ��" + booklist.get(i).author + "������Ϊ��" + booklist.get(i).price);
			}
		System.out.println("\n\n");
	}
}













