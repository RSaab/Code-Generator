import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.TextArea;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2030401489121863229L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtField;
	private JTextField txtField_1;
	private JTextField txtField_2;
	private JTextField txtField_3;
	private JLabel lblVariable_7;
	private JTextField textField_4;
	private JTextField textField_7;
	private JLabel lblVariable_6;
	private JLabel lblVariable_5;
	private JTextField textField_8;
	private JTextField textField_11;
	private JLabel lblVariable_4;
	private JButton btnGenerateClass;
	private PrintStream out;
	private JSeparator separator;
	private JSeparator separator_1;
	private TextArea textArea;
	private JButton btnViewJavaFile;
	private JButton btnViewTextFile;
	private JMenuBar menuBar;
	private JMenuItem mntmNew;
	private JMenuItem mntmAbout;
	private JMenuItem mntmDeleteTextFile;
	private JMenuItem mntmDeleteJavaFile;
	JButton btnSolveMyProblem;
	private File info; private CodeGenerator c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setResizable(false);
		setTitle("Java Code Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClassName = new JLabel("Class Name:");
		lblClassName.setFont(new Font("Teen", Font.PLAIN, 27));
		lblClassName.setBounds(10, 104, 155, 23);
		contentPane.add(lblClassName);

		textField = new JTextField();
		textField.setBackground(new Color(102, 255, 255));
		textField.setForeground(Color.BLACK);
		textField.setBounds(171, 108, 168, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(this);

		JLabel lblCodeGeneratorv = new JLabel("CODE GENERATOR  ~V2.0~");
		lblCodeGeneratorv.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodeGeneratorv.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCodeGeneratorv.setBounds(0, 42, 666, 23);
		contentPane.add(lblCodeGeneratorv);

		JLabel lblVariable = new JLabel("Variable 1:");
		lblVariable.setFont(new Font("Teen", Font.PLAIN, 26));
		lblVariable.setBounds(16, 171, 140, 25);
		contentPane.add(lblVariable);

		JLabel lblVariable_1 = new JLabel("Variable 2:");
		lblVariable_1.setFont(new Font("Teen", Font.PLAIN, 26));
		lblVariable_1.setBounds(16, 207, 140, 25);
		contentPane.add(lblVariable_1);

		JLabel lblVariable_2 = new JLabel("Variable 3:");
		lblVariable_2.setFont(new Font("Teen", Font.PLAIN, 26));
		lblVariable_2.setBounds(16, 242, 140, 25);
		contentPane.add(lblVariable_2);

		JLabel lblVariable_3 = new JLabel("Variable 4:");
		lblVariable_3.setFont(new Font("Teen", Font.PLAIN, 26));
		lblVariable_3.setBounds(16, 278, 140, 25);
		contentPane.add(lblVariable_3);

		txtField = new JTextField();
		txtField.setBounds(145, 174, 184, 26);
		contentPane.add(txtField);
		txtField.setColumns(10);
		txtField.addActionListener(this);

		txtField_1 = new JTextField();
		txtField_1.setColumns(10);
		txtField_1.setBounds(145, 207, 184, 26);
		contentPane.add(txtField_1);
		txtField_1.addActionListener(this);

		txtField_2 = new JTextField();
		txtField_2.setColumns(10);
		txtField_2.setBounds(145, 243, 184, 26);
		contentPane.add(txtField_2);
		txtField_2.addActionListener(this);

		txtField_3 = new JTextField();
		txtField_3.setColumns(10);
		txtField_3.setBounds(145, 278, 184, 26);
		contentPane.add(txtField_3);
		txtField_3.addActionListener(this);

		btnGenerateClass = new JButton("Generate Class");
		btnGenerateClass.setForeground(UIManager.getColor("Button.disabledForeground"));
		btnGenerateClass.setEnabled(false);
		btnGenerateClass.setBackground(UIManager.getColor("Button.background"));
		btnGenerateClass.setBounds(10, 457, 323, 23);
		contentPane.add(btnGenerateClass);
		btnGenerateClass.addActionListener(this);

		JLabel lblType = new JLabel("Type Name (eg. int number)");
		lblType.setBounds(145, 152, 184, 23);
		contentPane.add(lblType);

		lblVariable_7 = new JLabel("Variable 8:");
		lblVariable_7.setFont(new Font("Teen", Font.PLAIN, 26));
		lblVariable_7.setBounds(16, 421, 140, 25);
		contentPane.add(lblVariable_7);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(145, 421, 184, 26);
		contentPane.add(textField_4);
		textField_4.addActionListener(this);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(145, 386, 184, 26);
		contentPane.add(textField_7);
		textField_7.addActionListener(this);

		lblVariable_6 = new JLabel("Variable 7:");
		lblVariable_6.setFont(new Font("Teen", Font.PLAIN, 26));
		lblVariable_6.setBounds(16, 385, 140, 25);
		contentPane.add(lblVariable_6);

		lblVariable_5 = new JLabel("Variable 6:");
		lblVariable_5.setFont(new Font("Teen", Font.PLAIN, 26));
		lblVariable_5.setBounds(16, 350, 140, 25);
		contentPane.add(lblVariable_5);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(145, 350, 184, 26);
		contentPane.add(textField_8);
		textField_8.addActionListener(this);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(145, 317, 184, 26);
		contentPane.add(textField_11);
		textField_11.addActionListener(this);

		lblVariable_4 = new JLabel("Variable 5:");
		lblVariable_4.setFont(new Font("Teen", Font.PLAIN, 26));
		lblVariable_4.setBounds(16, 314, 140, 25);
		contentPane.add(lblVariable_4);

		separator = new JSeparator();
		separator.setBounds(10, 71, 624, 13);
		contentPane.add(separator);

		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(359, 92, 15, 407);
		contentPane.add(separator_1);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 120, 339, 38);
		contentPane.add(horizontalStrut);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(10, 71, 339, 38);
		contentPane.add(horizontalStrut_1);

		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setBackground(new Color(0, 0, 0));
		textArea.setBounds(380, 104, 254, 382);
		contentPane.add(textArea);

		btnViewJavaFile = new JButton("View Java File");
		btnViewJavaFile.setEnabled(false);
		btnViewJavaFile.setBounds(10, 487, 155, 23);
		contentPane.add(btnViewJavaFile);
		btnViewJavaFile.addActionListener(this);

		btnViewTextFile = new JButton("View Text File");
		btnViewTextFile.setEnabled(false);
		btnViewTextFile.setBounds(171, 487, 161, 23);
		contentPane.add(btnViewTextFile);
		btnViewTextFile.addActionListener(this);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 655, 21);
		contentPane.add(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		mntmNew.addActionListener(this);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		mntmDeleteJavaFile = new JMenuItem("Delete Java File");
		mnEdit.add(mntmDeleteJavaFile);
		mntmDeleteJavaFile.addActionListener(this);
		mntmDeleteJavaFile.setEnabled(false);

		mntmDeleteTextFile = new JMenuItem("Delete text File");
		mnEdit.add(mntmDeleteTextFile);
		mntmDeleteTextFile.addActionListener(this);
		mntmDeleteTextFile.setEnabled(false);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		btnSolveMyProblem = new JButton("SOLVE MY PROBLEM");
		btnSolveMyProblem.setBounds(384, 492, 250, 23);
		contentPane.add(btnSolveMyProblem);
		btnSolveMyProblem.addActionListener(this);
		mntmAbout.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() instanceof JButton){
			JButton b=(JButton) e.getSource();
			if(b==btnGenerateClass)
			{		
				try {
					c = new CodeGenerator(textField.getText()+".txt");
					c.generateJavaCode();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mntmDeleteJavaFile.setEnabled(true);
				btnViewJavaFile.setEnabled(true);
				btnViewTextFile.setEnabled(true);
				JOptionPane.showMessageDialog(this, "Class Generated Successfully");
			}else if(b==btnViewJavaFile)
			{
				try {
					//Runtime.getRuntime().exec("notepad++ "+c.getClassName() );
					 Desktop dk=Desktop.getDesktop();

					 // Open a file
					 dk.open(new File(c.getClassName()));
				} catch (IOException e1) {
					e1.printStackTrace();
				} 

			}else if(b==btnViewTextFile)
			{

				try {
					//Runtime.getRuntime().exec("notepad "+textField.getText()+".txt" );
					 Desktop dk=Desktop.getDesktop();

					 // Open a file
					 dk.open(new File(textField.getText()+".txt"));
				} catch (IOException e1) {
				} 

			}else if(b==btnSolveMyProblem){
				JOptionPane.showMessageDialog(this, "HAHAHAHAHAHAHA Keep Working");
			}
		}else if(e.getSource() instanceof JTextField)
		{
			JTextField text=(JTextField) e.getSource();
			if(text==textField && text.getText().length()>0)
			{
				try {
					info=new File(textField.getText()+".txt");
					out=new PrintStream(info);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.append(text.getText()+"\n\n");
				out.println(text.getText());
				btnGenerateClass.setEnabled(true);
				btnViewTextFile.setEnabled(true);
				mntmDeleteTextFile.setEnabled(true);
			}else {
				out.println(text.getText());
				textArea.append(text.getText()+"\n");
			}
		}else if(e.getSource() instanceof JMenuItem)
		{
			JMenuItem m=(JMenuItem) e.getSource();
			if(m==mntmNew){
				resetFields();
				JOptionPane.showMessageDialog(this, "Enter new Class information");
			}else if(m==mntmAbout){
				JOptionPane.showMessageDialog(this, "CODE GENERATOR ~V2.0~\nBy Rashad Saab\ncopyright ©");
			}else if(m==mntmDeleteTextFile && JOptionPane.showConfirmDialog(this, "Are you sure you want to delete "+info.getName())==0){
				 deleteTextFile();
			}else if(m==mntmDeleteJavaFile && JOptionPane.showConfirmDialog(this, "Are you sure you want to delete "+c.getClassName())==0){
				deleteJavaFile();
			}
		}

	}
	
	private void deleteTextFile()
	{
		out.close();
		info.delete();
		mntmDeleteTextFile.setEnabled(false);
		btnViewTextFile.setEnabled(false);
		clearFields();
		JOptionPane.showMessageDialog(this, info.getName()+" was deleted");
	}
	
	private void deleteJavaFile()
	{
		c.deleteGeneratedJavaFile();
		mntmDeleteJavaFile.setEnabled(false);
		btnViewJavaFile.setEnabled(false);
		JOptionPane.showMessageDialog(this, c.getClassName()+" was deleted");
	}
	
	private void resetFields(){
		textField.setText("");
		textArea.setText("");
		txtField.setText("");
		txtField_1.setText("");
		txtField_2.setText("");
		txtField_3.setText("");
		textField_4.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_11.setText("");
		btnViewJavaFile.setEnabled(false);
		btnViewTextFile.setEnabled(false);
		btnGenerateClass.setEnabled(false);
		mntmDeleteTextFile.setEnabled(false);
		mntmDeleteJavaFile.setEnabled(false);
		out.close();
	}
	
	public void clearFields(){
		textField.setText("");
		textArea.setText("");
		txtField.setText("");
		txtField_1.setText("");
		txtField_2.setText("");
		txtField_3.setText("");
		textField_4.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_11.setText("");
		btnViewTextFile.setEnabled(false);
		btnGenerateClass.setEnabled(false);
	}
}
