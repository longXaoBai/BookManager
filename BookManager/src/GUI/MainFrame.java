package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton deleteBookButton;
	private JButton chargeBookButton;
	private JButton searchBookButton;
	private JButton exitButton;
	private JButton rightButton;
	private JButton leftButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBackground(Color.WHITE);
		setTitle("龙江的图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addBookButton = new JButton("增加图书");
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookFrame addBookFrame = new AddBookFrame();
				addBookFrame.setVisible(true);
				MainFrame.this.dispose();
			}
		});
		addBookButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 25));
		addBookButton.setForeground(Color.BLACK);
		addBookButton.setBackground(Color.WHITE);
		addBookButton.setBounds(146, 86, 145, 72);
		contentPane.add(addBookButton);
		
		deleteBookButton = new JButton("删除图书");
		deleteBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBookFrame deleteBookFrame = new DeleteBookFrame();
				deleteBookFrame.setVisible(true);
				MainFrame.this.dispose();
			}
		});
		deleteBookButton.setForeground(Color.BLACK);
		deleteBookButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 25));
		deleteBookButton.setBackground(Color.WHITE);
		deleteBookButton.setBounds(289, 86, 136, 72);
		contentPane.add(deleteBookButton);
		
		chargeBookButton = new JButton("修改图书");
		chargeBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChargeBookFrame chargeBookFrame = new ChargeBookFrame();
				chargeBookFrame.setVisible(true);
				MainFrame.this.dispose();
			}
		});
		chargeBookButton.setForeground(Color.BLACK);
		chargeBookButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 25));
		chargeBookButton.setBackground(Color.WHITE);
		chargeBookButton.setBounds(146, 156, 145, 65);
		contentPane.add(chargeBookButton);
		
		searchBookButton = new JButton("查找图书");
		searchBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBookFrame searchBookFrame = new SearchBookFrame();
				searchBookFrame.setVisible(true);
				MainFrame.this.dispose();
			}
		});
		
		searchBookButton.setForeground(Color.BLACK);
		searchBookButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 25));
		searchBookButton.setBackground(Color.WHITE);
		searchBookButton.setBounds(289, 156, 136, 65);
		contentPane.add(searchBookButton);
		
		exitButton = new JButton("退出");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setForeground(Color.BLACK);
		exitButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 27));
		exitButton.setBackground(Color.WHITE);
		exitButton.setBounds(225, 281, 126, 53);
		contentPane.add(exitButton);
		
		rightButton = new JButton("");
		rightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Foreach foreach = new Foreach();
				foreach.setVisible(true);
			}
		});
		rightButton.setBackground(Color.WHITE);
		rightButton.setBounds(491, 338, 93, 23);
		contentPane.add(rightButton);
		
		leftButton = new JButton("");
		leftButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchBookFrame regexSearchBookFrame = new RegexSearchBookFrame();
				regexSearchBookFrame.setVisible(true);
				MainFrame.this.dispose();
			}
		});
		leftButton.setBackground(Color.WHITE);
		leftButton.setBounds(0, 338, 93, 23);
		contentPane.add(leftButton);
		
		JLabel lblNewLabel = new JLabel("欢迎来到龙江的图书管理系统，么么哒~");
		lblNewLabel.setFont(new Font("方正咆哮简体", Font.PLAIN, 32));
		lblNewLabel.setBounds(10, 10, 570, 53);
		contentPane.add(lblNewLabel);
	}
}
