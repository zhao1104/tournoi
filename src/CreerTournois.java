import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;


public class CreerTournois {

	private JFrame frame;
	private JTextField textFieldNom;
	private JTextField textFieldDD;
	private JTextField textFieldDF;
	private JTextField textFieldType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerTournois window = new CreerTournois();
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
	public CreerTournois() {
		System.out.println("test");

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
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(171, 36, 86, 20);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblNomDuTrounois = new JLabel("Nom du trounois");
		lblNomDuTrounois.setBounds(10, 39, 105, 14);
		frame.getContentPane().add(lblNomDuTrounois);
		
		JButton btnCreer = new JButton("Creer");
		btnCreer.setBounds(314, 228, 89, 23);
		frame.getContentPane().add(btnCreer);
		
		textFieldDD = new JTextField();
		textFieldDD.setBounds(171, 67, 86, 20);
		frame.getContentPane().add(textFieldDD);
		textFieldDD.setColumns(10);
		
		textFieldDF = new JTextField();
		textFieldDF.setBounds(171, 98, 86, 20);
		frame.getContentPane().add(textFieldDF);
		textFieldDF.setColumns(10);
		
		JLabel lblDateDeDebut = new JLabel("Date de debut");
		lblDateDeDebut.setBounds(10, 70, 105, 14);
		frame.getContentPane().add(lblDateDeDebut);
		
		JLabel lblDateFin = new JLabel("Date fin");
		lblDateFin.setBounds(10, 101, 105, 14);
		frame.getContentPane().add(lblDateFin);
		
		textFieldType = new JTextField();
		textFieldType.setBounds(171, 129, 86, 20);
		frame.getContentPane().add(textFieldType);
		textFieldType.setColumns(10);
		
		JLabel lblTypeDeTournois = new JLabel("Type de Tournois");
		lblTypeDeTournois.setBounds(10, 132, 105, 14);
		frame.getContentPane().add(lblTypeDeTournois);
		
		JSpinner spinnerNbEquipe = new JSpinner();
		spinnerNbEquipe.setBounds(171, 160, 29, 20);
		frame.getContentPane().add(spinnerNbEquipe);
		
		JLabel lblNombreDequipe = new JLabel("Nombre d'equipe");
		lblNombreDequipe.setBounds(10, 163, 105, 14);
		frame.getContentPane().add(lblNombreDequipe);
		frame.setVisible(true);
	}
}
