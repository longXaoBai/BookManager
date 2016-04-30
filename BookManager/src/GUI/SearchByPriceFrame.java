package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchByPriceFrame extends JFrame {

	private JPanel contentPane;
	private JTextField lowPriceTextField;
	private JTextField highPriceTextField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the frame.
	 */
	public SearchByPriceFrame() {
		setTitle("价格查找");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lowPriceTextField = new JTextField("0");
		lowPriceTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lowPriceTextField.getText().equals("0"))
					lowPriceTextField.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(lowPriceTextField.getText().equals(""))
					lowPriceTextField.setText("0");
			}
		});
		lowPriceTextField.setForeground(Color.BLACK);
		lowPriceTextField.setBackground(Color.WHITE);
		lowPriceTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		lowPriceTextField.setBounds(56, 94, 139, 57);
		contentPane.add(lowPriceTextField);
		lowPriceTextField.setColumns(10);
		
		highPriceTextField = new JTextField(String.valueOf(Float.MAX_VALUE));
		highPriceTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(highPriceTextField.getText().equals(String.valueOf(Float.MAX_VALUE)))
					highPriceTextField.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(highPriceTextField.getText().equals(""))
					highPriceTextField.setText(String.valueOf(Float.MAX_VALUE));
			}
		});
		highPriceTextField.setForeground(Color.BLACK);
		highPriceTextField.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		highPriceTextField.setBackground(Color.WHITE);
		highPriceTextField.setBounds(239, 94, 139, 57);
		contentPane.add(highPriceTextField);
		highPriceTextField.setColumns(10);
		
		JButton searchButton = new JButton("查找");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(highPriceTextField.getText().equals("")){
					SearchByPriceResult searchByPriceResult = new SearchByPriceResult(lowPriceTextField.getText(),"@");
					searchByPriceResult.setVisible(true);
				}
				else{
					SearchByPriceResult searchByPriceResult = new SearchByPriceResult(lowPriceTextField.getText(),highPriceTextField.getText());
					searchByPriceResult.setVisible(true);
				}
			}
		});
		searchButton.setForeground(Color.BLACK);
		searchButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 35));
		searchButton.setBackground(Color.WHITE);
		searchButton.setBounds(56, 183, 114, 48);
		contentPane.add(searchButton);
		
		JButton returnButton = new JButton("返回");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchBookFrame searchBookFrame = new SearchBookFrame();
				searchBookFrame.setVisible(true);
				SearchByPriceFrame.this.dispose();
			}
		});
		returnButton.setForeground(Color.BLACK);
		returnButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 35));
		returnButton.setBackground(Color.WHITE);
		returnButton.setBounds(264, 183, 114, 48);
		contentPane.add(returnButton);
		
		lblNewLabel = new JLabel("价格区间：");
		lblNewLabel.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
		lblNewLabel.setBounds(152, 10, 162, 57);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("--");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("SimSun-ExtB", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(197, 94, 40, 57);
		contentPane.add(lblNewLabel_1);
	}
}
