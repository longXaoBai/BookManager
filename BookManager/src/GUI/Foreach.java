package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import MODEL.BookList;
import OPERATION.Operation;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Foreach extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable foreachTable;

	/**
	 * Create the dialog.
	 */
	public Foreach() {
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("图书列表");
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.BLACK);
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 402, 784, 59);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton yesButton = new JButton("确认");
			yesButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Foreach.this.dispose();
				}
			});
			yesButton.setForeground(Color.BLACK);
			yesButton.setFont(new Font("方正咆哮简体", Font.PLAIN, 30));
			yesButton.setBackground(Color.WHITE);
			yesButton.setActionCommand("OK");
			yesButton.setBounds(337, 10, 96, 39);
			buttonPane.add(yesButton);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 764, 382);
		contentPanel.add(scrollPane);
		
		foreachTable = new JTable();
		foreachTable.setFont(new Font("方正咆哮简体", Font.PLAIN, 20));
		foreachTable.setRowHeight(30);
		foreachTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"编号", "书名", "作者", "单价"
			}
		));
		foreachTable.setForeground(Color.BLACK);
		foreachTable.setBackground(Color.WHITE);
		scrollPane.setViewportView(foreachTable);
		
		BookList booklist = new Operation().foreach();
		for(int i = 0; i<booklist.size(); i++){
			DefaultTableModel tableModel = (DefaultTableModel) foreachTable.getModel();
			tableModel.addRow(new Object[]{ booklist.get(i).id, booklist.get(i).bookname, booklist.get(i).author, booklist.get(i).price});
		}
	}
}
