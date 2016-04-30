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

public class SearchByIdFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public SearchByIdFrame() {
		setTitle("编号查找");
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
			label = new JLabel("编号：");
			label.setForeground(Color.BLACK);
			label.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			label.setBackground(Color.WHITE);
			label.setBounds(46, 36, 90, 57);
			contentPane.add(label);
		}
		
		idTextField = new JTextField();
		idTextField.setForeground(Color.BLACK);
		idTextField.setBackground(Color.WHITE);
		idTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		idTextField.setColumns(10);
		idTextField.setBounds(136, 36, 273, 57);
		contentPane.add(idTextField);
		
		JButton searchButton = new JButton("查找");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchByIdResult searchByIdResult = new SearchByIdResult(idTextField.getText());
				searchByIdResult.setVisible(true);
			}
		});
		searchButton.setForeground(Color.BLACK);
		searchButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 35));
		searchButton.setBackground(Color.WHITE);
		searchButton.setBounds(61, 177, 114, 48);
		contentPane.add(searchButton);
		
		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBookFrame searchBookFrame = new SearchBookFrame();
				searchBookFrame.setVisible(true);
				SearchByIdFrame.this.dispose();
			}
		});
		returnButton.setForeground(Color.BLACK);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 35));
		returnButton.setBackground(Color.WHITE);
		returnButton.setBounds(255, 177, 114, 48);
		contentPane.add(returnButton);
	}
}
