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
			case "5":new Operation().foreach();break;
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
		do{
			System.out.println("������Ҫ���ͼ��ı�ţ�");
			id = in.nextLine();
			if((temp = new Operation().search(id)) == 0)
				System.out.println("���鼮�Ѵ��ڣ����������룡");
		}while(temp == 0);
		System.out.println("������Ҫ���ͼ���������");
		String bookname = in.nextLine();
		System.out.println("������Ҫ���ͼ������ߣ�");
		String author = in.nextLine();
		System.out.println("������Ҫ���ͼ��ĵ��ۣ�");
		float price = in.nextFloat();
		in.nextLine();
		new Operation().add(id, bookname, author, price);
		System.out.println("\n\n");
	}
	
	public void delete(){
		if(new Operation().bookCount() <= 0)
			System.out.println("ͼ����Ϊ0�����޷�ɾ����");
		else{
			System.out.println("\n\n**********ɾ������**********");
			System.out.println("����������ͼ����ţ�");
			String id = in.nextLine();
			if(new Operation().search(id) == 0)
				System.out.println("���ݿ���û�и��鼮��");
			else
				new Operation().delete(id);
			System.out.println("\n\n");
		}
	}
	
	public void charge(){
		System.out.println("\n\n**********�޸Ľ���**********");
		System.out.println("�������֮ǰͼ���ţ�");
		String oldId = in.nextLine();
		if(new Operation().search(oldId) == 0)
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
			new Operation().charge(bookname, author, price, newId, oldId);
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
			new Operation().search(id);
		}break;
		case "2":{
			System.out.println("����������ͼ�����ƣ�");
			String bookname = in.nextLine();
			new Operation().search(bookname);
		}break;
		case "3":{
			System.out.println("����������ͼ�����ߣ�");
			String author = in.nextLine();
			new Operation().search(author);
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
			if(choose2.equals("n"))
				new Operation().search(lowPrice);
			else if(choose2.equals("y")){
				float highPrice = 0;
				do{
					System.out.println("������ͼ����߼ۣ�");
					highPrice = in.nextFloat();
					in.nextLine();
					if(highPrice <lowPrice)
						System.out.println("������߼۵���������ͼۣ����������룡");
				}while(highPrice <lowPrice);
				new Operation().search(lowPrice, highPrice);
			}
		}break;
		default:System.out.println("��������ȷ��ţ���");break;
		}
		System.out.print("\n\n");
	}
}
