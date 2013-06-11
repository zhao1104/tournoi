import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ajoutArbitre {

	private JFrame frame;
	private JTextField textFielnomArbitre;
	private JTextField textFielprenomArbitre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutArbitre window = new ajoutArbitre();
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
	public ajoutArbitre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 400, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFielnomArbitre = new JTextField();
		textFielnomArbitre.setBounds(205, 58, 131, 26);
		frame.getContentPane().add(textFielnomArbitre);
		textFielnomArbitre.setColumns(10);
		
		textFielprenomArbitre = new JTextField();
		textFielprenomArbitre.setBounds(205, 112, 131, 26);
		frame.getContentPane().add(textFielprenomArbitre);
		textFielprenomArbitre.setColumns(10);
		
		JLabel lblNomArbitre = new JLabel("Nom Arbitre :");
		lblNomArbitre.setBounds(41, 64, 107, 14);
		frame.getContentPane().add(lblNomArbitre);
		
		JLabel lblPrenomArbitre = new JLabel("Prenom Arbitre :");
		lblPrenomArbitre.setBounds(41, 118, 107, 14);
		frame.getContentPane().add(lblPrenomArbitre);
		
		JButton btnNewButton = new JButton("Ajout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				
				String nom = '\''+textFielnomArbitre.getText()+'\'';
				String prenom ='\''+textFielprenomArbitre.getText()+'\'';
				
				System.out.println("Insertion dans la table : "+nom+" | "+prenom+"");
				
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
				stm.executeUpdate("insert into arbitre values (NULL,"+nom+","+prenom+",3);");
				new SuccesTerrain();
				frame.setVisible(false);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Erreur : "+e1);
				};
				
				
				
			
				
			}
		});
		btnNewButton.setBounds(41, 182, 147, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new fenetreArbitre();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(217, 182, 147, 43);
		frame.getContentPane().add(btnNewButton_1);
	}
}
