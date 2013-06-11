import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Supprimequipe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldnumsup;
	private JTextField textFieldnomsup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supprimequipe frame = new Supprimequipe();
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
	public Supprimequipe() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Tapez votre num\u00E9ro d'\u00E9quipe");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 21, 181, 34);
		contentPane.add(label);
		
		textFieldnumsup = new JTextField();
		textFieldnumsup.setBounds(213, 29, 123, 20);
		contentPane.add(textFieldnumsup);
		textFieldnumsup.setColumns(10);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numsup = '\''+textFieldnumsup.getText()+'\'';
				String nomsup = '\''+textFieldnomsup.getText()+'\'';
				System.out.println("Delete dans la table : "+numsup+" | "+nomsup+" ");
				
				Connection con;
				try {
					System.out.println("Suppression....");
					con = DriverManager.getConnection("jdbc:mysql://localhost/tournois","root","");
				
				Statement stm = con .createStatement();
				stm.executeUpdate("delete from joueur where id_equipe= "+numsup+";");
				stm.executeUpdate("delete from equipe where id_equipe= "+numsup+" and nom_equipe= "+nomsup+";");
				
				System.out.println("Suppression finit");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Erreur : "+e1);
				};
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSupprimer.setBounds(75, 138, 116, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Gererequipe();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(228, 138, 108, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblTapezVotreNom = new JLabel("Tapez votre nom d'\u00E9quipe");
		lblTapezVotreNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTapezVotreNom.setBounds(10, 66, 170, 34);
		contentPane.add(lblTapezVotreNom);
		
		textFieldnomsup = new JTextField();
		textFieldnomsup.setBounds(213, 74, 123, 20);
		contentPane.add(textFieldnomsup);
		textFieldnomsup.setColumns(10);
		
		setVisible(true);
	}
}
