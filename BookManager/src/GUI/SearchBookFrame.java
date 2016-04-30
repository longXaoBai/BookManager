package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBookFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SearchBookFrame() {
		setTitle("查询界面");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton idButton = new JButton("编号");
		idButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchByIdFrame searchByIdFrame = new SearchByIdFrame();
				searchByIdFrame.setVisible(true);
				SearchBookFrame.this.dispose();
			}
		});
		idButton.setForeground(Color.BLACK);
		idButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		idButton.setBackground(Color.WHITE);
		idButton.setBounds(114, 47, 179, 86);
		contentPane.add(idButton);
		
		JButton booknameButton = new JButton("书名");
		booknameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchByBooknameFrame searchByBooknameFrame = new SearchByBooknameFrame();
				searchByBooknameFrame.setVisible(true);
				SearchBookFrame.this.dispose();
			}
		});
		booknameButton.setForeground(Color.BLACK);
		booknameButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		booknameButton.setBackground(Color.WHITE);
		booknameButton.setBounds(291, 47, 179, 86);
		contentPane.add(booknameButton);
		
		JButton authorButton = new JButton("作者");
		authorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchByAuthorFrame searchByAuthorFrame = new SearchByAuthorFrame();
				searchByAuthorFrame.setVisible(true);
				SearchBookFrame.this.dispose();
			}
		});
		authorButton.setForeground(Color.BLACK);
		authorButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		authorButton.setBackground(Color.WHITE);
		authorButton.setBounds(114, 131, 179, 86);
		contentPane.add(authorButton);
		
		JButton priceButton = new JButton("价格");
		priceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchByPriceFrame searchByPriceFrame = new SearchByPriceFrame();
				searchByPriceFrame.setVisible(true);
				SearchBookFrame.this.dispose();
			}
		});
		priceButton.setForeground(Color.BLACK);
		priceButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		priceButton.setBackground(Color.WHITE);
		priceButton.setBounds(291, 131, 179, 86);
		contentPane.add(priceButton);
		
		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBookFrame.this.dispose();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		returnButton.setForeground(Color.BLACK);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 40));
		returnButton.setBackground(Color.WHITE);
		returnButton.setBounds(235, 273, 114, 48);
		contentPane.add(returnButton);
	}
}
