package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import MODEL.Book;
import MODEL.BookList;
import OPERATION.Operation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class UltimateFrame extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;
	private JTable resultTable;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UltimateFrame frame = new UltimateFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Book getBook(int rowCount){
		DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
		Book book=new Book((String)tableModel.getValueAt(rowCount, 0),(String)tableModel.getValueAt(rowCount, 1),(String)tableModel.getValueAt(rowCount, 2),Float.valueOf((String)tableModel.getValueAt(rowCount, 3)));
		return book;
	}

	public class DeleteButtonRender implements TableCellRenderer{
	    private JPanel panel;
	    private JButton button;
	    
	    public DeleteButtonRender(){
	        this.initButton();
	        this.initPanel();
	        this.panel.add(this.button);
	    }

	    private void initButton(){
	        this.button = new JButton();
	        this.button.setForeground(Color.BLACK);
	        this.button.setBackground(Color.WHITE);
	    }

	    private void initPanel(){
	        this.panel = new JPanel();
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,int column){
	        this.button.setText("ɾ��");
	        this.button.setFont(new Font("����", Font.PLAIN, 13));
	        return this.button;
	    }
	}
	
	public class DeleteButtonEditor extends DefaultCellEditor { 
	    /**
	     * serialVersionUID
	     */ 
	    private static final long serialVersionUID = -6546334664166791132L; 
	 
	    private JPanel panel; 
	 
	    private JButton button; 
	 
	    public DeleteButtonEditor() 
	    { 
	        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�  
	        super(new JTextField()); 
	 
	        // ���õ�����μ���༭��  
	        this.setClickCountToStart(1); 
	 
	        this.initButton(); 
	 
	        this.initPanel();
	        
	        // ��Ӱ�ť��  
	        this.panel.add(this.button); 
	    } 
	 
	    private void initButton() 
	    { 
	        this.button = new JButton(); 
	        
	        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��  
	        this.button.addActionListener(new ActionListener() 
	        { 
	            public void actionPerformed(ActionEvent e) 
	            { 
	                // ����ȡ���༭���¼����������tableModel��setValue������  
	                DeleteButtonEditor.this.fireEditingCanceled(); 
	                DefaultTableModel tableModel = (DefaultTableModel) UltimateFrame.this.resultTable.getModel();
	                String id=(String) tableModel.getValueAt(UltimateFrame.this.resultTable.getSelectedRow(), 0);
	                Book book = new Book(id,null,null,0);
	                Operation op = new Operation();
	                op.deleteById(book);
	                tableModel.removeRow(UltimateFrame.this.resultTable.getSelectedRow());
	                // ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�  
	            } 
	        }); 
	    } 
	 
	    private void initPanel() 
	    { 
	        this.panel = new JPanel(); 
	    } 
	 
	 
	    /**
	     * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ��
	     */ 
	    @Override 
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
	    { 
	        // ֻΪ��ť��ֵ���ɡ�Ҳ����������������  
	        this.button.setText("ɾ��");
	        this.button.setFont(new Font("����", Font.PLAIN, 13));
	        return this.button; 
	    } 
	 
	    /**
	     * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ��
	     */ 
	    @Override 
	    public Object getCellEditorValue() 
	    { 
	        return this.button.getText(); 
	    } 
	}  
	
	public class UpdateButtonRender implements TableCellRenderer{
		
	    private JPanel panel;
	    private JButton button;
	    
	    public UpdateButtonRender(){
	        this.initButton();
	        this.initPanel();
	        this.panel.add(this.button);
	    }

	    private void initButton(){
	        this.button = new JButton();
	        this.button.setForeground(Color.BLACK);
	        this.button.setBackground(Color.WHITE);
	    }

	    private void initPanel(){
	        this.panel = new JPanel();
	    }

	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,int column){
	        this.button.setText("�޸�");
	        this.button.setFont(new Font("����", Font.PLAIN, 13));
	        return this.button;
	    }
	}
	
	public class UpdateButtonEditor extends DefaultCellEditor { 
	    /**
	     * serialVersionUID
	     */ 
	    private static final long serialVersionUID = -6546334664166791132L; 
	 
	    private JPanel panel; 
	 
	    private JButton button; 
	 
	    public UpdateButtonEditor() 
	    { 
	        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�  
	        super(new JTextField()); 
	 
	        // ���õ�����μ���༭��  
	        this.setClickCountToStart(1); 
	 
	        this.initButton(); 
	 
	        this.initPanel();
	        
	        // ��Ӱ�ť��  
	        this.panel.add(this.button); 
	    } 
	 
	    private void initButton() 
	    { 
	        this.button = new JButton(); 
	        
	        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��  
	        this.button.addActionListener(new ActionListener() 
	        { 
	            public void actionPerformed(ActionEvent e) 
	            { 
	                // ����ȡ���༭���¼����������tableModel��setValue������  
	            	UpdateButtonEditor.this.fireEditingCanceled(); 
	            	DefaultTableModel tableModel = (DefaultTableModel) UltimateFrame.this.resultTable.getModel();
	            	String id=(String) tableModel.getValueAt(UltimateFrame.this.resultTable.getSelectedRow(), 0);
	            	Book book = UltimateFrame.this.getBook(UltimateFrame.this.resultTable.getSelectedRow());
	            	Book oldBook = new Book(id,null,null,0);
	            	Operation op = new Operation();
	            	if(op.searchById(oldBook).size() != 0)
	            		op.charge(book, id);
	            	else
	            		op.add(book);
	                // ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�  
	            } 
	        }); 
	    } 
	 
	    private void initPanel() 
	    { 
	        this.panel = new JPanel(); 
	    } 
	 
	 
	    /**
	     * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ��
	     */ 
	    @Override 
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
	    { 
	        // ֻΪ��ť��ֵ���ɡ�Ҳ����������������  
	        this.button.setText("�޸�");
	        this.button.setFont(new Font("����", Font.PLAIN, 13));
	        return this.button; 
	    } 
	 
	    /**
	     * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ��
	     */ 
	    @Override 
	    public Object getCellEditorValue() 
	    { 
	        return this.button.getText(); 
	    } 
	}  
	/**
	 * Create the frame.
	 */
	public UltimateFrame() {
		setTitle("ͼ�����ϵͳ");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchTextField = new JTextField();
		searchTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER){
					DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
					tableModel.setRowCount(0);
					BookList booklist = new Operation().regexSearch(searchTextField.getText());
					for(int i = 0; i<booklist.size(); i++)
						tableModel.addRow(new Object[]{ booklist.get(i).id, booklist.get(i).bookname, booklist.get(i).author, booklist.get(i).price});
				}
			}
		});
		searchTextField.setForeground(Color.BLACK);
		searchTextField.setBackground(Color.WHITE);
		searchTextField.setBounds(10, 10, 458, 41);
		contentPane.add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton searchButton = new JButton("����");
		searchButton.setFont(new Font("����", Font.PLAIN, 20));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
				tableModel.setRowCount(0);
				BookList booklist = new Operation().regexSearch(searchTextField.getText());
				for(int i = 0; i<booklist.size(); i++)
					tableModel.addRow(new Object[]{ booklist.get(i).id, booklist.get(i).bookname, booklist.get(i).author, booklist.get(i).price});
			}
		});
		searchButton.setForeground(Color.BLACK);
		searchButton.setBackground(Color.WHITE);
		searchButton.setBounds(478, 8, 93, 41);
		contentPane.add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 664, 390);
		contentPane.add(scrollPane);
		
		resultTable = new JTable();
		resultTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"���", "����", "����", "����", "", ""
			}
		));
		resultTable.getColumnModel().getColumn(5).setCellRenderer(new DeleteButtonRender());
		resultTable.getColumnModel().getColumn(5).setCellEditor(new DeleteButtonEditor());
		resultTable.getColumnModel().getColumn(4).setCellRenderer(new UpdateButtonRender());
		resultTable.getColumnModel().getColumn(4).setCellEditor(new UpdateButtonEditor());
		resultTable.setRowHeight(30);
		resultTable.setForeground(Color.BLACK);
		resultTable.setBackground(Color.WHITE);
		scrollPane.setViewportView(resultTable);
		
		button_1 = new JButton("�½�");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) resultTable.getModel();
				tableModel.addRow(new Object[]{"", "", "",""});
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("����", Font.PLAIN, 20));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(581, 8, 93, 41);
		contentPane.add(button_1);
		
		
	}
}
