import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GestionnaireTournois {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionnaireTournois window = new GestionnaireTournois();
					window.frame.setVisible(true);
					
					/*
					 * 
					 * 
					 * 
					 * public void actionPerformed(ActionEvent e)
	{
		//Permet d'afficher la ligne selectionné dans un label (String) permet de forcer la conversion
		if(e.getSource() == btnAjout)
		{
			System.out.println("test");
			String nom = '\''+textNom.getText()+'\'';
			String naiss ='\''+txtAnne.getText()+'\'';
			String tat = '\''+textTat.getText()+'\'';
			String prop = '\''+(String)comboBoxP.getSelectedItem()+'\'';
			String race = '\''+textRace.getText()+'\'';
			Connection con;
			try {
				System.out.println("Creation....");
				con = DriverManager.getConnection("jdbc:mysql://localhost/veterinaire","root","");
			
			Statement stm = con .createStatement();
			int max = 0;
			ResultSet set = stm.executeQuery("select max(numa) from animal");
			set.next();
			max = Integer.parseInt(set.getString("max(numa)"));
			max++;
			stm.executeUpdate("insert into animal values ("+max+","+nom+","+naiss+","+tat+","+race+","+prop+");");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erreur : "+e1);
			};
		}
		else if (e.getSource() == comboBox) lblChoix.setText((String)comboBox.getSelectedItem());
	}
}
					 * 
					 * 
					 * */
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionnaireTournois() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGestionnaireDarbitres = new JButton("Gestionnaire d'arbitres");
		btnGestionnaireDarbitres.setBounds(42, 179, 160, 23);
		frame.getContentPane().add(btnGestionnaireDarbitres);
		
		JButton btnGrerLesquipes = new JButton("G\u00E9rer les \u00E9quipes");
		btnGrerLesquipes.setBounds(42, 56, 160, 23);
		frame.getContentPane().add(btnGrerLesquipes);
		
		JButton btnGrerLesPoules = new JButton("G\u00E9rer les poules");
		btnGrerLesPoules.setBounds(42, 101, 160, 23);
		frame.getContentPane().add(btnGrerLesPoules);
		
		JButton btnGrerLesTournois = new JButton("G\u00E9rer les tournois");
		btnGrerLesTournois.setBounds(42, 145, 160, 23);
		frame.getContentPane().add(btnGrerLesTournois);
	}
}
