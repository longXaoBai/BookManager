package GUI;

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

public class SearchByBooknameFrame extends JFrame {

	private JPanel contentPane;
	private JTextField booknameTextField;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public SearchByBooknameFrame() {
		setTitle("��������");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		{
			label = new JLabel("ͼ������");
			label.setForeground(Color.BLACK);
			label.setFont(new Font("������������", Font.PLAIN, 30));
			label.setBackground(Color.WHITE);
			label.setBounds(28, 36, 120, 57);
			contentPane.add(label);
		}
		
		booknameTextField = new JTextField();
		booknameTextField.setForeground(Color.BLACK);
		booknameTextField.setBackground(Color.WHITE);
		booknameTextField.setFont(new Font("������������", Font.PLAIN, 30));
		booknameTextField.setColumns(10);
		booknameTextField.setBounds(147, 36, 262, 57);
		contentPane.add(booknameTextField);
		
		JButton searchButton = new JButton("����");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchByBooknameResult searchByBooknameResult = new SearchByBooknameResult(booknameTextField.getText());
				searchByBooknameResult.setVisible(true);
			}
		});
		searchButton.setForeground(Color.BLACK);
		searchButton.setFont(new Font("������������", Font.PLAIN, 35));
		searchButton.setBackground(Color.WHITE);
		searchButton.setBounds(61, 177, 114, 48);
		contentPane.add(searchButton);
		
		JButton returnButton = new JButton("����");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBookFrame searchBookFrame = new SearchBookFrame();
				searchBookFrame.setVisible(true);
				SearchByBooknameFrame.this.dispose();
			}
		});
		returnButton.setForeground(Color.BLACK);
		returnButton.setFont(new Font("������������", Font.PLAIN, 35));
		returnButton.setBackground(Color.WHITE);
		returnButton.setBounds(255, 177, 114, 48);
		contentPane.add(returnButton);
	}
}
