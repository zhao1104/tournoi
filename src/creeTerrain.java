import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class creeTerrain {

	private JFrame frame;
	private JTextField textFieldNom;
	private JTextField textFieldType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creeTerrain window = new creeTerrain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public creeTerrain() {
		System.out.println("test");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(158, 55, 173, 22);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldType = new JTextField();
		textFieldType.setColumns(10);
		textFieldType.setBounds(158, 108, 173, 22);
		frame.getContentPane().add(textFieldType);
		
		JButton btnNewButton_2 = new JButton("Creer");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				String nom = '\''+textFieldNom.getText()+'\'';
				String type ='\''+textFieldType.getText()+'\'';
				
				System.out.println("Insertion dans la table : "+nom+" | "+type+"");
				
				Connection con;
				try {
					System.out.println("Creation....Ok");
					con = DriverManager.getConnection("jdbc:mysql://localhost/tournois","root","");
				
				Statement stm = con .createStatement();
//				int max = 0;
//				ResultSet set = stm.executeQuery("select max(numa) from animal");
//				set.next();
//				max = Integer.parseInt(set.getString("max(numa)"));
//				max++;
				stm.executeUpdate("insert into terrain values (NULL,"+nom+","+type+");");
				new SuccesTerrain();
				frame.setVisible(false);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Erreur : "+e1);
				};
				
				
				
			}
		});
		btnNewButton_2.setBounds(59, 183, 148, 46);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Pr\u00E9c\u00E9dent");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new fenetreTerrain();
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(242, 206, 104, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Type du terrain :");
		lblNewLabel.setBounds(43, 112, 105, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNomDuTerrain = new JLabel("Nom du terrain :");
		lblNomDuTerrain.setBounds(43, 59, 105, 14);
		frame.getContentPane().add(lblNomDuTerrain);
		frame.setBounds(100, 100, 438, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
