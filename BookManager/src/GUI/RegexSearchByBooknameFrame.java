package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegexSearchByBooknameFrame extends JFrame {

	private JPanel contentPane;
	private JTextField booknameTextField;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public RegexSearchByBooknameFrame() {
		setTitle("书名查找");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		{
			label = new JLabel("图书名：");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			label.setBackground(Color.BLACK);
			label.setBounds(44, 36, 120, 57);
			contentPane.add(label);
		}
		
		booknameTextField = new JTextField();
		booknameTextField.setForeground(Color.WHITE);
		booknameTextField.setBackground(Color.BLACK);
		booknameTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		booknameTextField.setColumns(10);
		booknameTextField.setBounds(163, 36, 246, 57);
		contentPane.add(booknameTextField);
		
		JButton searchButton = new JButton("查找");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchByBooknameResult regexSearchByBooknameResult = new RegexSearchByBooknameResult(booknameTextField.getText());
				regexSearchByBooknameResult.setVisible(true);
			}
		});
		searchButton.setForeground(Color.WHITE);
		searchButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 35));
		searchButton.setBackground(Color.BLACK);
		searchButton.setBounds(61, 177, 114, 48);
		contentPane.add(searchButton);
		
		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchBookFrame regexSearchBookFrame = new RegexSearchBookFrame();
				regexSearchBookFrame.setVisible(true);
				RegexSearchByBooknameFrame.this.dispose();
			}
		});
		returnButton.setForeground(Color.WHITE);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 35));
		returnButton.setBackground(Color.BLACK);
		returnButton.setBounds(255, 177, 114, 48);
		contentPane.add(returnButton);
	}
}
