package GUI;
import java.util.*;
import java.io.*;
import java.nio.file.Paths;

import MODEL.Book;

public class MainClass {
	static ArrayList<Book> book = new ArrayList<Book>();
	static File file = new File("C:\\Users\\����\\Desktop\\file.txt");
	
	public static void main(String[] args) {
		loadData();
		String choose = "0";
		while(!choose.equals("6")){
			Scanner in = new Scanner(System.in);
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
		saveData();
		System.out.println("�ɹ��˳���");
	}
	
	public static void add(){
			Scanner in1 = new Scanner(System.in);
			Scanner in2 = new Scanner(System.in);
			System.out.println("\n\n**********���ӽ���**********");
			System.out.println("������Ҫ���ͼ���������");
			String bookname = in1.nextLine();
			System.out.println("������Ҫ���ͼ������ߣ�");
			String author = in1.nextLine();
			System.out.println("������Ҫ���ͼ��ĵ��ۣ�");
			float price = in1.nextFloat();
			int num = 0;
			while(true){
				System.out.println("������Ҫ�������λ�ã�");
				num = in2.nextInt();
				if((num-1) > book.size() || (num-1) < 0)
					System.out.println("��������ȷ����ţ�");
				else
					break;
			}
			book.add((num-1), new Book(bookname,author,price));
		System.out.print("\n\n");
	}
	
	public static void delete(){
		if(book.size() <= 0)
			System.out.println("ͼ����Ϊ0�����޷�ɾ����");
		else{
			Scanner in = new Scanner(System.in);
			System.out.println("\n\n**********ɾ������**********");
			int num = 0;
			while(true){
				System.out.println("��������ɾͼ����ţ�");
				num = in.nextInt();
				if(num-1 > book.size() || num-1 < 0)
					System.out.println("��������ȷ����ţ�");
				else
					break;
			}
			book.remove(num-1);
		}
		System.out.print("\n\n");
	}
	
	public static void charge(){
		Scanner in1 = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		System.out.println("\n\n**********�޸Ľ���**********");
		int num = 0;
		while(true){
			System.out.println("����������ͼ����ţ�");
			num = in1.nextInt();
			if(num-1 > book.size() || num-1 < 0)
				System.out.println("��������ȷ����ţ�");
			else
				break;
		}
		System.out.println("����������ͼ������:");
		String bookname = in2.nextLine();
		System.out.println("����������ͼ������:");
		String author = in2.nextLine();
		System.out.println("����������ͼ�鵥��:");
		float price = in2.nextFloat();
		book.set(num-1, new Book(bookname,author,price));
		System.out.print("\n\n");
	}
	
	public static void search(){
		Scanner in1 = new Scanner(System.in);
		System.out.println("\n\n**********���ҽ���**********");
		System.out.println("1.����Ų�          2.��ͼ������          3.�����߲�          4.�����۲�");
		String choose = "0";
		choose = in1.nextLine();
		switch(choose){
		case "1":{
			int num = 0;
			while(true){
				System.out.println("����������ͼ����ţ�");
				num = in1.nextInt();
				if(num-1 > book.size() || num-1 < 0)
					System.out.println("��������ȷ����ţ�");
				else
					break;
			}
			System.out.println("��" + num + "����Ϊ" +book.get(num-1).bookname + ",����Ϊ" + book.get(num-1).author + ",����Ϊ" + book.get(num-1).price);
		}break;
		case "2":{
			Scanner in2 = new Scanner(System.in);
			System.out.println("����������ͼ�����ƣ�");
			String name = in2.nextLine();
			int i = 0,count = 0,temp = book.size();
			
			while(i < temp){
				Book aBook = book.get(i);
				if(aBook.bookname.equals(name)){
					System.out.println(name + "���Ϊ��" + (i+1) + ",����Ϊ" + aBook.author + ",����Ϊ" + aBook.price);
					count++;
				}
				i++;
			}
			if(count == 0)
				System.out.println("û���Ȿ�飡");
		}break;
		case "3":{
			Scanner in3 = new Scanner(System.in);
			System.out.println("�����������������ƣ�");
			String author = in3.nextLine();
			int i = 0,count = 0,temp = book.size();
			while(i < temp){
				Book aBook = book.get(i);
				if(aBook.author.equals(author)){
					System.out.println(author + "��Ʒ�У�" + aBook.bookname + "������Ϊ��" + aBook.price + "�����Ϊ��" + (i+1));
					count++;
				}
				i++;
			}
			if(count == 0)
				System.out.println("û���Ȿ�飡");
		}break;
		case "4":{
			Scanner in4 = new Scanner(System.in);
			float lowPrice = 0;
			do{
				System.out.println("����������ͼ����ͼۣ�");
				lowPrice = in4.nextFloat();
				if(lowPrice<0)
					System.out.println("��������ȷ�۸�");
			}while(lowPrice < 0);
			System.out.println("�Ƿ�����ͼ����߼ۣ�y or n");
			Scanner in5 = new Scanner(System.in);
			String choose2 = in5.nextLine();
			if(choose2.equals("n")){
				int count = 0,temp = book.size();
				System.out.println("����ͼ���У�");

				for(int i = 0;i<temp;i++){
					Book aBook = book.get(i);
					if(aBook.price>lowPrice){
						System.out.println(aBook.bookname + "������Ϊ��" + aBook.author + "������Ϊ��" + aBook.price +"�����Ϊ��" + (i+1));
						count++;
					}
				}
				if(count == 0)
					System.out.println("û���Ȿ�飡");
			}
			else if(choose2.equals("y")){
				int count = 0,temp = book.size();
				float highPrice = 0;
				do{
					System.out.println("������ͼ����߼ۣ�");
					highPrice = in4.nextFloat();
					if(highPrice <lowPrice)
						System.out.println("������߼۵���������ͼۣ����������룡");
				}while(highPrice <lowPrice);
				for(int i = 0;i<temp;i++){
					Book aBook = book.get(i);
					if(aBook.price>lowPrice && aBook.price<highPrice){
						System.out.println(aBook.bookname + "����Ϊ��" + aBook.author + "������Ϊ��" + aBook.price + "�����Ϊ��" + (i+1));
						count++;
					}
				}
				if(count == 0)
					System.out.println("û���Ȿ�飡");
			}
		}break;
		default:System.out.println("��������ȷ��ţ���");break;
		}
		System.out.print("\n\n");
	}
	
	public static void foreach(){
		System.out.print("\n\n");
		int temp = book.size();
		for(int i = 0;i < temp;i++){
			Book aBook = book.get(i);
			System.out.println("��" + (i+1) + "����Ϊ��" + aBook.bookname + ",����Ϊ" + aBook.author + ",����Ϊ" + aBook.price);
		}
			
		System.out.print("\n\n");
	}
	
	public static void loadData(){
		File file = new File("C:\\Users\\����\\Desktop\\file.txt");
		Scanner READ = null;
		try {
			if(!file.exists())
				file.createNewFile();
			READ = new Scanner(file);
			READ.useDelimiter("[,\\n]");
			String name,author,aPrice;
			float price;
			try{
				do{
				name = READ.next();
				author = READ.next();
				aPrice = READ.next();
				price = Float.valueOf(aPrice);
				book.add(new Book(name,author,price));
				} while(READ.hasNextLine());
					
			} catch(NoSuchElementException e){
				System.out.println("�ļ���û�����ݣ�");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(READ != null) READ.close();
		}
	}
	
	public static void saveData(){
		File file = new File("C:\\Users\\����\\Desktop\\file.txt");
		FileWriter WRITER =null;
		try {
			if(!file.exists())
				file.createNewFile();
			WRITER = new FileWriter(file);
			int temp = book.size();
			for(int i = 0;i<temp;i++){
				Book aBook = book.get(i);
				WRITER.write(aBook.bookname + "," + aBook.author + "," + aBook.price + "\r\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(WRITER != null) WRITER.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}










