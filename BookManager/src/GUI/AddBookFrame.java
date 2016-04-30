package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import MODEL.Book;
import OPERATION.Operation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AddBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField bookNameTextField;
	private JTextField authorTextField;
	private JTextField priceTextField;
	private JTextField idTextField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddBookFrame() {
		setTitle("增加图书");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bookNameTextField = new JTextField();
		bookNameTextField.setForeground(Color.BLACK);
		bookNameTextField.setBackground(Color.WHITE);
		bookNameTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		bookNameTextField.setBounds(214, 77, 289, 57);
		contentPane.add(bookNameTextField);
		bookNameTextField.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setForeground(Color.BLACK);
		authorTextField.setBackground(Color.WHITE);
		authorTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		authorTextField.setColumns(10);
		authorTextField.setBounds(214, 144, 289, 57);
		contentPane.add(authorTextField);
		
		priceTextField = new JTextField();
		priceTextField.setForeground(Color.BLACK);
		priceTextField.setBackground(Color.WHITE);
		priceTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		priceTextField.setColumns(10);
		priceTextField.setBounds(214, 211, 289, 57);
		contentPane.add(priceTextField);
		
		JButton saveButton = new JButton("保存");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operation op = new Operation();
				String id = idTextField.getText();
				String bookname = bookNameTextField.getText();
				String author = authorTextField.getText();
				String price = priceTextField.getText();
				Book book = new Book(id,bookname,author,Float.valueOf(price));
				if(op.add(book)){
					Success addBookSuccess = new Success();
					addBookSuccess.setVisible(true);
					idTextField.setText("");
					bookNameTextField.setText("");
					authorTextField.setText("");
					priceTextField.setText("");
				}
				else{
					Fail addBookFail = new Fail();
					addBookFail.setVisible(true);
				}
				AddBookFrame.this.dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		saveButton.setForeground(Color.BLACK);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		saveButton.setBounds(139, 288, 114, 48);
		contentPane.add(saveButton);
		
		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookFrame.this.dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		returnButton.setForeground(Color.BLACK);
		returnButton.setBackground(Color.WHITE);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		returnButton.setBounds(333, 288, 114, 48);
		contentPane.add(returnButton);
		
		idTextField = new JTextField();
		idTextField.setForeground(Color.BLACK);
		idTextField.setBackground(Color.WHITE);
		idTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		idTextField.setColumns(10);
		idTextField.setBounds(214, 10, 289, 57);
		contentPane.add(idTextField);
		
		lblNewLabel = new JLabel("编号：");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(124, 10, 90, 57);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("图书名：");
		lblNewLabel_1.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(94, 77, 120, 57);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1 = new JLabel("作者名：");
		lblNewLabel_1.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(94, 144, 120, 57);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("单价：");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(124, 211, 90, 57);
		contentPane.add(lblNewLabel);
	}

}
