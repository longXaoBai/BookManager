package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegexSearchBookFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RegexSearchBookFrame() {
		setTitle("模糊查询");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton idButton = new JButton("编号");
		idButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchByIdFrame regexSearchByIdFrame = new RegexSearchByIdFrame();
				regexSearchByIdFrame.setVisible(true);
				RegexSearchBookFrame.this.dispose();
			}
		});
		idButton.setForeground(Color.WHITE);
		idButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		idButton.setBackground(Color.BLACK);
		idButton.setBounds(114, 47, 179, 86);
		contentPane.add(idButton);
		
		JButton booknameButton = new JButton("书名");
		booknameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchByBooknameFrame regexSearchByBooknameFrame = new RegexSearchByBooknameFrame();
				regexSearchByBooknameFrame.setVisible(true);
				RegexSearchBookFrame.this.dispose();
			}
		});
		booknameButton.setForeground(Color.WHITE);
		booknameButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		booknameButton.setBackground(Color.BLACK);
		booknameButton.setBounds(291, 47, 179, 86);
		contentPane.add(booknameButton);
		
		JButton authorButton = new JButton("作者");
		authorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchByAuthorFrame regexSearchByAuthorFrame = new RegexSearchByAuthorFrame();
				regexSearchByAuthorFrame.setVisible(true);
				RegexSearchBookFrame.this.dispose();
			}
		});
		authorButton.setForeground(Color.WHITE);
		authorButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		authorButton.setBackground(Color.BLACK);
		authorButton.setBounds(114, 132, 179, 86);
		contentPane.add(authorButton);
		
		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegexSearchBookFrame.this.dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		returnButton.setForeground(Color.WHITE);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		returnButton.setBackground(Color.BLACK);
		returnButton.setBounds(241, 274, 114, 48);
		contentPane.add(returnButton);
		
		JButton button = new JButton("价格");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eggshell eggshell = new Eggshell();
				eggshell.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		button.setBackground(Color.BLACK);
		button.setBounds(291, 132, 179, 86);
		contentPane.add(button);
	}
}
