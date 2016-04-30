package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import MODEL.Book;
import OPERATION.Operation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField booknameTextField;
	private JTextField authorTextField;

	/**
	 * Create the frame.
	 */
	public DeleteBookFrame() {
		setTitle("删除图书");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JRadioButton idRadioButton = new JRadioButton("编号");
		final JRadioButton booknameRadioButton = new JRadioButton("书名");
		final JRadioButton authorRadioButton = new JRadioButton("作者");
		
		idRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idRadioButton.isSelected()){
					idTextField.setEditable(true);
					booknameRadioButton.setSelected(false);
					booknameTextField.setText("");
					booknameTextField.setEditable(false);
					authorRadioButton.setSelected(false);
					authorTextField.setText("");
					authorTextField.setEditable(false);
				}
				else{
					idTextField.setText("");
					idTextField.setEditable(false);
				}
			}
		});
		idRadioButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		idRadioButton.setForeground(Color.BLACK);
		idRadioButton.setBackground(Color.WHITE);
		idRadioButton.setBounds(60, 47, 128, 49);
		contentPane.add(idRadioButton);
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		idTextField.setBounds(189, 47, 339, 49);
		contentPane.add(idTextField);
		idTextField.setColumns(10);
		
		booknameRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(booknameRadioButton.isSelected()){
					booknameTextField.setEditable(true);
					idRadioButton.setSelected(false);
					idTextField.setText("");
					idTextField.setEditable(false);
					authorRadioButton.setSelected(false);
					authorTextField.setText("");
					authorTextField.setEditable(false);
				}
				else{
					booknameTextField.setText("");
					booknameTextField.setEditable(false);
				}
			}
		});
		booknameRadioButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		booknameRadioButton.setForeground(Color.BLACK);
		booknameRadioButton.setBackground(Color.WHITE);
		booknameRadioButton.setBounds(60, 123, 128, 49);
		contentPane.add(booknameRadioButton);
		
		booknameTextField = new JTextField();
		booknameTextField.setEditable(false);
		booknameTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		booknameTextField.setColumns(10);
		booknameTextField.setBounds(189, 123, 339, 49);
		contentPane.add(booknameTextField);
		
		authorRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(authorRadioButton.isSelected()){
					authorTextField.setEditable(true);
					booknameRadioButton.setSelected(false);
					booknameTextField.setText("");
					booknameTextField.setEditable(false);
					idRadioButton.setSelected(false);
					idTextField.setText("");
					idTextField.setEditable(false);
				}
				else{
					authorTextField.setText("");
					authorTextField.setEditable(false);
				}
			}
		});
		authorRadioButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		authorRadioButton.setForeground(Color.BLACK);
		authorRadioButton.setBackground(Color.WHITE);
		authorRadioButton.setBounds(60, 198, 128, 49);
		contentPane.add(authorRadioButton);
		
		authorTextField = new JTextField();
		authorTextField.setEditable(false);
		authorTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		authorTextField.setColumns(10);
		authorTextField.setBounds(189, 198, 339, 49);
		contentPane.add(authorTextField);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operation op = new Operation();
				if(op.foreach().size() <= 0){
					Fail noSearchBook = new Fail();
					noSearchBook.setVisible(true);
				}
				if(idRadioButton.isSelected()){
					String id = idTextField.getText();
					Book book = new Book(id,null,null,0);
					if(op.searchById(book).size() == 0){
						System.out.println(op.searchById(book).size());
						NoSearchBook noSearchBook = new NoSearchBook();
						noSearchBook.setVisible(true);
					}else if(op.deleteById(book)){
						Success deleteBookSuccess = new Success();
						deleteBookSuccess.setVisible(true);
						idTextField.setText("");
					}
					else{
						Fail deleteBookFail = new Fail();
						deleteBookFail.setVisible(true);
					}
				}else if(booknameRadioButton.isSelected()){
					String bookname = booknameTextField.getText();
					Book book = new Book(null,bookname,null,0);
					if(op.searchByBookname(book).size() == 0){
						System.out.println(op.searchById(book).size());
						NoSearchBook noSearchBook = new NoSearchBook();
						noSearchBook.setVisible(true);
					}else if(op.deleteByBookname(book)){
						Success deleteBookSuccess = new Success();
						deleteBookSuccess.setVisible(true);
						booknameTextField.setText("");
					}
					else{
						Fail deleteBookFail = new Fail();
						deleteBookFail.setVisible(true);
					}
				}else if(authorRadioButton.isSelected()){
					String author = authorTextField.getText();
					Book book = new Book(null,null,author,0);
					if(op.searchByBookname(book).size() == 0){
						System.out.println(op.searchById(book).size());
						NoSearchBook noSearchBook = new NoSearchBook();
						noSearchBook.setVisible(true);
					}else if(op.deleteByAuthor(book)){
						Success deleteBookSuccess = new Success();
						deleteBookSuccess.setVisible(true);
						idTextField.setText("");
					}
					else{
						Fail deleteBookFail = new Fail();
						deleteBookFail.setVisible(true);
					}
				}
				DeleteBookFrame.this.dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		deleteButton.setForeground(Color.BLACK);
		deleteButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setBounds(139, 288, 114, 48);
		contentPane.add(deleteButton);
		
		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBookFrame.this.dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		returnButton.setForeground(Color.BLACK);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		returnButton.setBackground(Color.WHITE);
		returnButton.setBounds(333, 288, 114, 48);
		contentPane.add(returnButton);
	}
}
