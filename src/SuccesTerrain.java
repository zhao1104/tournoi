import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;


public class SuccesTerrain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuccesTerrain window = new SuccesTerrain();
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
	public SuccesTerrain() {
		System.out.println("test SuccesTerrain");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 332, 247);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTerrainsAjouterAvec = new JLabel("Terrains Ajouter avec succes");
		lblTerrainsAjouterAvec.setBounds(84, 69, 167, 49);
		frame.getContentPane().add(lblTerrainsAjouterAvec);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new fenetreTerrain();
				frame.setVisible(false);
			}
		});
		btnRetour.setBounds(108, 150, 89, 23);
		frame.getContentPane().add(btnRetour);
	}
}
