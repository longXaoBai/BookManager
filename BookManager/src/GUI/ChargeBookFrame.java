package GUI;

import java.awt.EventQueue;

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

public class ChargeBookFrame extends JFrame {

	private JPanel contentPane;
	private JTextField oldIdTextField;
	private JButton yesButton;
	private JButton noButton;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public ChargeBookFrame() {
		setTitle("修改界面");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		oldIdTextField = new JTextField();
		oldIdTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		oldIdTextField.setForeground(Color.BLACK);
		oldIdTextField.setBackground(Color.WHITE);
		oldIdTextField.setBounds(165, 158, 269, 57);
		contentPane.add(oldIdTextField);
		oldIdTextField.setColumns(10);
		
		yesButton = new JButton("确定");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operation op = new Operation();
				String oldId = oldIdTextField.getText();
				if(op.searchById(new Book(oldId,null,null,0)).size() == 0){
					Fail noSearchBook = new Fail();
					noSearchBook.setVisible(true);
				}
				else{
					ChargeBook chargeBook = new ChargeBook(oldId);
					chargeBook.setVisible(true);
					oldIdTextField.setText("");
				}
			}
		});
		yesButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		yesButton.setBackground(Color.WHITE);
		yesButton.setForeground(Color.BLACK);
		yesButton.setBounds(139, 288, 114, 48);
		contentPane.add(yesButton);
		
		noButton = new JButton("取消");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChargeBookFrame.this.dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		noButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		noButton.setForeground(Color.BLACK);
		noButton.setBackground(Color.WHITE);
		noButton.setBounds(333, 288, 114, 48);
		contentPane.add(noButton);
		
		lblNewLabel = new JLabel("请输入所改图书编号：");
		lblNewLabel.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(155, 34, 323, 57);
		contentPane.add(lblNewLabel);
	}
}
