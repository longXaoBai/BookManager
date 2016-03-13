package GUI;
import java.util.*;

import MODEL.Book;

public class MainClass {
	static ArrayList<Book> book = new ArrayList<Book>();
	public static void main(String[] args) {
		String choose = "0";
		while(!choose.equals("6")){
			Scanner in = new Scanner(System.in);
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
		System.out.println("成功退出！");
	}
	
	public static void add(){
			Scanner in1 = new Scanner(System.in);
			Scanner in2 = new Scanner(System.in);
			System.out.println("\n\n**********增加界面**********");
			System.out.println("请输入要添加图书的书名：");
			String bookname = in1.nextLine();
			System.out.println("请输入要添加图书的作者：");
			String author = in1.nextLine();
			System.out.println("请输入要添加图书的单价：");
			float price = in1.nextFloat();
			int num = 0;
			while(true){
				System.out.println("请输入要添加至的位置：");
				num = in2.nextInt();
				if((num-1) > book.size() || (num-1) < 0)
					System.out.println("请输入正确的序号！");
				else
					break;
			}
			book.add((num-1), new Book(bookname,author,price));
		System.out.print("\n\n");
	}
	
	public static void delete(){
		if(book.size() <= 0)
			System.out.println("图书已为0本，无法删除！");
		else{
			Scanner in = new Scanner(System.in);
			System.out.println("\n\n**********删除界面**********");
			int num = 0;
			while(true){
				System.out.println("请输入所删图书序号：");
				num = in.nextInt();
				if(num-1 > book.size() || num-1 < 0)
					System.out.println("请输入正确的序号！");
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
		System.out.println("\n\n**********修改界面**********");
		int num = 0;
		while(true){
			System.out.println("请输入所改图书序号：");
			num = in1.nextInt();
			if(num-1 > book.size() || num-1 < 0)
				System.out.println("请输入正确的序号！");
			else
				break;
		}
		System.out.println("请输入所改图书名称:");
		String bookname = in2.nextLine();
		System.out.println("请输入所改图书作者:");
		String author = in2.nextLine();
		System.out.println("请输入所改图书单价:");
		float price = in2.nextFloat();
		book.set(num-1, new Book(bookname,author,price));
		System.out.print("\n\n");
	}
	
	public static void search(){
		Scanner in1 = new Scanner(System.in);
		System.out.println("\n\n**********查找界面**********");
		System.out.println("1.按序号查          2.按图书名查          3.按作者查          4.按单价查");
		String choose = "0";
		choose = in1.nextLine();
		switch(choose){
		case "1":{
			int num = 0;
			while(true){
				System.out.println("请输入所查图书序号：");
				num = in1.nextInt();
				if(num-1 > book.size() || num-1 < 0)
					System.out.println("请输入正确的序号！");
				else
					break;
			}
			System.out.println("第" + num + "本书为" +book.get(num-1).bookname + ",作者为" + book.get(num-1).author + ",单价为" + book.get(num-1).price);
		}break;
		case "2":{
			Scanner in2 = new Scanner(System.in);
			System.out.println("请输入所查图书名称：");
			String name = in2.nextLine();
			int i = 0,count = 0,temp = book.size();
			
			while(i < temp){
				Book aBook = book.get(i);
				if(aBook.bookname.equals(name)){
					System.out.println(name + "序号为：" + (i+1) + ",作者为" + aBook.author + ",单价为" + aBook.price);
					count++;
				}
				i++;
			}
			if(count == 0)
				System.out.println("没有这本书！");
		}break;
		case "3":{
			Scanner in3 = new Scanner(System.in);
			System.out.println("请输入所查作者名称：");
			String author = in3.nextLine();
			int i = 0,count = 0,temp = book.size();
			while(i < temp){
				Book aBook = book.get(i);
				if(aBook.author.equals(author)){
					System.out.println(author + "作品有：" + aBook.bookname + "，单价为：" + aBook.price + "，序号为：" + (i+1));
					count++;
				}
				i++;
			}
			if(count == 0)
				System.out.println("没有这本书！");
		}break;
		case "4":{
			Scanner in4 = new Scanner(System.in);
			float lowPrice = 0;
			do{
				System.out.println("请输入所查图书最低价：");
				lowPrice = in4.nextFloat();
				if(lowPrice<0)
					System.out.println("请输入正确价格！");
			}while(lowPrice < 0);
			System.out.println("是否限制图书最高价？y or n");
			Scanner in5 = new Scanner(System.in);
			String choose2 = in5.nextLine();
			if(choose2.equals("n")){
				int count = 0,temp = book.size();
				System.out.println("所查图书有：");

				for(int i = 0;i<temp;i++){
					Book aBook = book.get(i);
					if(aBook.price>lowPrice){
						System.out.println(aBook.bookname + "，作者为：" + aBook.author + "，单价为：" + aBook.price +"，序号为：" + (i+1));
						count++;
					}
				}
				if(count == 0)
					System.out.println("没有这本书！");
			}
			else if(choose2.equals("y")){
				int count = 0,temp = book.size();
				float highPrice = 0;
				do{
					System.out.println("请输入图书最高价：");
					highPrice = in4.nextFloat();
					if(highPrice <lowPrice)
						System.out.println("所输最高价低于所输最低价，请重新输入！");
				}while(highPrice <lowPrice);
				for(int i = 0;i<temp;i++){
					Book aBook = book.get(i);
					if(aBook.price>lowPrice && aBook.price<highPrice){
						System.out.println(aBook.bookname + "作者为：" + aBook.author + "，单价为：" + aBook.price + "，序号为：" + (i+1));
						count++;
					}
				}
				if(count == 0)
					System.out.println("没有这本书！");
			}
		}break;
		default:System.out.println("请输入正确序号！！");break;
		}
		System.out.print("\n\n");
	}
	
	public static void foreach(){
		System.out.print("\n\n");
		int temp = book.size();
		for(int i = 0;i < temp;i++){
			Book aBook = book.get(i);
			System.out.println("第" + (i+1) + "本书为：" + aBook.bookname + ",作者为" + aBook.author + ",单价为" + aBook.price);
		}
			
		System.out.print("\n\n");
	}
}



