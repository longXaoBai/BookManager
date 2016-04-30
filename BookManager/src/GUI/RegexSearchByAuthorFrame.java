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

public class RegexSearchByAuthorFrame extends JFrame {

	private JPanel contentPane;
	private JTextField authorTextField;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public RegexSearchByAuthorFrame() {
		setTitle("作者名查找");
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
			label = new JLabel("作者名：");
			label.setForeground(Color.WHITE);
			label.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			label.setBackground(Color.BLACK);
			label.setBounds(37, 36, 120, 57);
			contentPane.add(label);
		}
		
		authorTextField = new JTextField();
		authorTextField.setForeground(Color.WHITE);
		authorTextField.setBackground(Color.BLACK);
		authorTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		authorTextField.setColumns(10);
		authorTextField.setBounds(157, 36, 252, 57);
		contentPane.add(authorTextField);
		
		JButton searchButton = new JButton("查找");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchByAuthorResult regexSearchByAuthorResult = new RegexSearchByAuthorResult(authorTextField.getText());
				regexSearchByAuthorResult.setVisible(true);
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
				RegexSearchByAuthorFrame.this.dispose();
			}
		});
		returnButton.setForeground(Color.WHITE);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 35));
		returnButton.setBackground(Color.BLACK);
		returnButton.setBounds(255, 177, 114, 48);
		contentPane.add(returnButton);
	}
}
