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

public class RegexSearchByIdFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public RegexSearchByIdFrame() {
		setTitle("编号查找");
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
			label = new JLabel("编号：");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			label.setBackground(Color.BLACK);
			label.setBounds(45, 36, 90, 57);
			contentPane.add(label);
		}
		
		idTextField = new JTextField();
		idTextField.setForeground(Color.WHITE);
		idTextField.setBackground(Color.BLACK);
		idTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		idTextField.setColumns(10);
		idTextField.setBounds(134, 36, 273, 57);
		contentPane.add(idTextField);
		
		JButton searchButton = new JButton("查找");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchByIdResult regexSearchByIdResult = new RegexSearchByIdResult(idTextField.getText());
				regexSearchByIdResult.setVisible(true);
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
				RegexSearchByIdFrame.this.dispose();
			}
		});
		returnButton.setForeground(Color.WHITE);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 35));
		returnButton.setBackground(Color.BLACK);
		returnButton.setBounds(255, 177, 114, 48);
		contentPane.add(returnButton);
	}
}
