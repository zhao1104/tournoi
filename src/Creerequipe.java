import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Creerequipe extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6835360852875820280L;
	private JTextField textFieldnomeq;
	private JTextField textFieldentrain;
	private JTextField textFieldcapitain;
	private JTextField textFieldjoue_1;
	private JTextField textFieldjoue_2;
	private JTextField textFieldjoue_3;
	private JTextField textFieldjoue_4;
	private JTextField textFieldjoue_5;
	private JTextField textFieldremp_1;
	private JTextField textFieldremp_2;
	private JTextField textFieldremp_3;
	private JLabel lblLeIdDe;
	private JTextField textFieldidequipe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Creerequipe dialog = new Creerequipe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			// dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Creerequipe() {
		final JFrame frame= new JFrame();
		
		frame.setBounds(100, 100, 398, 469);
		frame.getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 339, 372, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			frame.getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nomeq = '\''+textFieldnomeq.getText()+'\'';
						String entrain ='\''+textFieldentrain.getText()+'\'';
						String capitain = '\''+textFieldcapitain.getText()+'\'';
						
						System.out.println("Insertion dans la table : "+nomeq+" | "+entrain+" | "+capitain+" ");
						
						String joue_1 = '\''+textFieldjoue_1.getText()+'\'';
						String joue_2 = '\''+textFieldjoue_2.getText()+'\'';
						String joue_3 = '\''+textFieldjoue_3.getText()+'\'';
						String joue_4 = '\''+textFieldjoue_4.getText()+'\'';
						String joue_5 = '\''+textFieldjoue_5.getText()+'\'';
						System.out.println("Insertion dans la table : "+joue_1+" | "+joue_2+" | "+joue_3+"| "+joue_4+"| "+joue_5+" ");
						
						Connection con;
						try {
							System.out.println("Creation....");
							con = DriverManager.getConnection("jdbc:mysql://localhost/tournois","root","");
						
						Statement stm = con .createStatement();
						stm.executeUpdate("insert into equipe values (NULL,"+nomeq+","+entrain+","+capitain+",9,NULL);");
						
						ResultSet rs = stm.executeQuery("select id_equipe from equipe where nom_equipe = "+nomeq+";");
						String id_eq = null;
						while(rs.next()){
							id_eq = rs.getString("id_equipe");
						}
						
						stm.executeUpdate("insert into joueur values (NULL,"+joue_1+",NULL,"+nomeq+","+id_eq+");");
						stm.executeUpdate("insert into joueur values (NULL,"+joue_2+",NULL,"+nomeq+","+id_eq+");");
						stm.executeUpdate("insert into joueur values (NULL,"+joue_3+",NULL,"+nomeq+","+id_eq+");");
						stm.executeUpdate("insert into joueur values (NULL,"+joue_4+",NULL,"+nomeq+","+id_eq+");");
						stm.executeUpdate("insert into joueur values (NULL,"+joue_5+",NULL,"+nomeq+","+id_eq+");");
						
						if( textFieldremp_1 != null){
							String remp_1 = '\''+textFieldremp_1.getText()+'\'';
							stm.executeUpdate("insert into joueur values (NULL,"+remp_1+",NULL,"+nomeq+","+id_eq+");");
							}
						if( textFieldremp_2 != null){
							String remp_2 = '\''+textFieldremp_2.getText()+'\'';
							stm.executeUpdate("insert into joueur values (NULL,"+remp_2+",NULL,"+nomeq+","+id_eq+");");
							}
						if( textFieldremp_3 != null){
							String remp_3 = '\''+textFieldremp_3.getText()+'\'';
							stm.executeUpdate("insert into joueur values (NULL,"+remp_3+",NULL,"+nomeq+","+id_eq+");");
							}
						textFieldidequipe.setText(id_eq);
						rs.close();
						System.out.println("Creation finit");
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							System.out.println("Erreur : "+e1);
						};
						
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						new Gererequipe();
						frame.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblCrerVotrequipe = new JLabel("Cr\u00E9er votre \u00E9quipe");
		lblCrerVotrequipe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCrerVotrequipe.setBounds(58, 11, 128, 25);
		frame.getContentPane().add(lblCrerVotrequipe);
		
		JLabel lblNomDquipe = new JLabel("Nom d'\u00E9quipe");
		lblNomDquipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomDquipe.setBounds(10, 53, 98, 24);
		frame.getContentPane().add(lblNomDquipe);
		
		textFieldnomeq = new JTextField();
		textFieldnomeq.setBounds(143, 57, 86, 20);
		frame.getContentPane().add(textFieldnomeq);
		textFieldnomeq.setColumns(10);
		
		JLabel lblEntraineDquipe = new JLabel("Entraine d'\u00E9quipe");
		lblEntraineDquipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEntraineDquipe.setBounds(10, 88, 115, 24);
		frame.getContentPane().add(lblEntraineDquipe);
		
		textFieldentrain = new JTextField();
		textFieldentrain.setBounds(143, 92, 86, 20);
		frame.getContentPane().add(textFieldentrain);
		textFieldentrain.setColumns(10);
		
		JLabel lblCapitaineDquipe = new JLabel("Capitaine d'\u00E9quipe");
		lblCapitaineDquipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCapitaineDquipe.setBounds(10, 123, 115, 20);
		frame.getContentPane().add(lblCapitaineDquipe);
		
		textFieldcapitain = new JTextField();
		textFieldcapitain.setBounds(143, 125, 86, 20);
		frame.getContentPane().add(textFieldcapitain);
		textFieldcapitain.setColumns(10);
		
		JLabel lblJoueur = new JLabel("Joueur");
		lblJoueur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJoueur.setBounds(10, 170, 73, 14);
		frame.getContentPane().add(lblJoueur);
		
		textFieldjoue_1 = new JTextField();
		textFieldjoue_1.setBounds(143, 169, 86, 20);
		frame.getContentPane().add(textFieldjoue_1);
		textFieldjoue_1.setColumns(10);
		
		textFieldjoue_2 = new JTextField();
		textFieldjoue_2.setBounds(262, 169, 86, 20);
		frame.getContentPane().add(textFieldjoue_2);
		textFieldjoue_2.setColumns(10);
		
		textFieldjoue_3 = new JTextField();
		textFieldjoue_3.setBounds(143, 200, 86, 20);
		frame.getContentPane().add(textFieldjoue_3);
		textFieldjoue_3.setColumns(10);
		
		textFieldjoue_4 = new JTextField();
		textFieldjoue_4.setBounds(262, 200, 86, 20);
		frame.getContentPane().add(textFieldjoue_4);
		textFieldjoue_4.setColumns(10);
		
		textFieldjoue_5 = new JTextField();
		textFieldjoue_5.setBounds(143, 231, 86, 20);
		frame.getContentPane().add(textFieldjoue_5);
		textFieldjoue_5.setColumns(10);
		
		JLabel lblRemplaant = new JLabel("Rempla\u00E7ant");
		lblRemplaant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemplaant.setBounds(10, 268, 73, 14);
		frame.getContentPane().add(lblRemplaant);
		
		textFieldremp_1 = new JTextField();
		textFieldremp_1.setBounds(143, 267, 86, 20);
		frame.getContentPane().add(textFieldremp_1);
		textFieldremp_1.setColumns(10);
		
		textFieldremp_2 = new JTextField();
		textFieldremp_2.setBounds(262, 267, 86, 20);
		frame.getContentPane().add(textFieldremp_2);
		textFieldremp_2.setColumns(10);
		
		textFieldremp_3 = new JTextField();
		textFieldremp_3.setBounds(143, 308, 86, 20);
		frame.getContentPane().add(textFieldremp_3);
		textFieldremp_3.setColumns(10);
		
		lblLeIdDe = new JLabel("Le ID de votre \u00E9quipe");
		lblLeIdDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLeIdDe.setBounds(20, 393, 153, 14);
		frame.getContentPane().add(lblLeIdDe);
		
		textFieldidequipe = new JTextField();
		textFieldidequipe.setBounds(183, 392, 86, 20);
		frame.getContentPane().add(textFieldidequipe);
		textFieldidequipe.setColumns(10);

		frame.setVisible(true);
	}
}
