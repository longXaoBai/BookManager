package GUI;
import java.util.Scanner;

import OPERATION.Operation;

public class MainClass {
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		new MainClass();
	}
	
	MainClass(){
		new Operation().foreach();
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
			case "5":new Operation().foreach();break;
			case "6":break;
			default:System.out.println("请输入正确序号！！");break;
			}
		}
		in.close();
		System.out.println("成功退出！");
	}
	
	public void add(){
		System.out.println("\n\n**********增加界面**********");
		String id = null;
		int temp = 0;
		do{
			System.out.println("请输入要添加图书的编号：");
			id = in.nextLine();
			if((temp = new Operation().search(id)) == 0)
				System.out.println("该书籍已存在，请重新输入！");
		}while(temp == 0);
		System.out.println("请输入要添加图书的书名：");
		String bookname = in.nextLine();
		System.out.println("请输入要添加图书的作者：");
		String author = in.nextLine();
		System.out.println("请输入要添加图书的单价：");
		float price = in.nextFloat();
		in.nextLine();
		new Operation().add(id, bookname, author, price);
		System.out.println("\n\n");
	}
	
	public void delete(){
		if(new Operation().bookCount() <= 0)
			System.out.println("图书已为0本，无法删除！");
		else{
			System.out.println("\n\n**********删除界面**********");
			System.out.println("请输入所改图书序号：");
			String id = in.nextLine();
			if(new Operation().search(id) == 0)
				System.out.println("数据库中没有该书籍！");
			else
				new Operation().delete(id);
			System.out.println("\n\n");
		}
	}
	
	public void charge(){
		System.out.println("\n\n**********修改界面**********");
		System.out.println("请输入改之前图书编号：");
		String oldId = in.nextLine();
		if(new Operation().search(oldId) == 0)
			System.out.println("数据库中没有该书籍！");
		else{
			System.out.println("请输入改之后图书编号：");
			String newId = in.nextLine();
			System.out.println("请输入所改图书名称:");
			String bookname = in.nextLine();
			System.out.println("请输入所改图书作者:");
			String author = in.nextLine();
			System.out.println("请输入所改图书单价:");
			float price = in.nextFloat();
			in.nextLine();
			new Operation().charge(bookname, author, price, newId, oldId);
		}
		System.out.println("\n\n");
	}
	
	public void search(){
		System.out.println("\n\n**********查找界面**********");
		System.out.println("1.按序号查          2.按图书名查          3.按作者查          4.按单价查");
		String choose = "0";
		choose = in.nextLine();
		switch(choose){
		case "1":{
			System.out.println("请输入所查图书序号：");
			String id = in.nextLine();
			new Operation().search(id);
		}break;
		case "2":{
			System.out.println("请输入所查图书名称：");
			String bookname = in.nextLine();
			new Operation().search(bookname);
		}break;
		case "3":{
			System.out.println("请输入所查图书作者：");
			String author = in.nextLine();
			new Operation().search(author);
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
			if(choose2.equals("n"))
				new Operation().search(lowPrice);
			else if(choose2.equals("y")){
				float highPrice = 0;
				do{
					System.out.println("请输入图书最高价：");
					highPrice = in.nextFloat();
					in.nextLine();
					if(highPrice <lowPrice)
						System.out.println("所输最高价低于所输最低价，请重新输入！");
				}while(highPrice <lowPrice);
				new Operation().search(lowPrice, highPrice);
			}
		}break;
		default:System.out.println("请输入正确序号！！");break;
		}
		System.out.print("\n\n");
	}
}
