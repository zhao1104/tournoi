///*
// * FenetreTrounois.java
// */
// 
//import java.awt.*;
//import javax.swing.*;
// 
//public class FenetreTrounois {
//    final static String BUTTONPANEL = "Gerer un tournois";
//    final static String TEXTPANEL = "Creer un tournois";
//    final static int extraWindowWidth = 100;
// 
//    public void addComponentToPane(Container pane) {
//        JTabbedPane tabbedPane = new JTabbedPane();
// 
//        //Create the "cards".
//        JPanel card1 = new JPanel() {
//            //Make the panel wider than it really needs, so
//            //the window's wide enough for the tabs to stay
//            //in one row.
//            public Dimension getPreferredSize() {
//                Dimension size = super.getPreferredSize();
//                size.width += extraWindowWidth;
//                return size;
//            }
//        };
//        card1.add(new JButton("Gerer"));
//        card1.add(new JButton("Modifier"));
//        JLabel lblTournois = new JLabel("Tournois :");
//        card1.add(lblTournois);
//        JComboBox comboBox = new JComboBox();
//        card1.add(comboBox);
// 
//        JPanel card2 = new JPanel();
//        
//        JLabel lblNomDuTournois = new JLabel("Nom du tournois");
//        card2.add(lblNomDuTournois);
//        card2.add(new JTextField("TextField", 20));
// 
//        tabbedPane.addTab(BUTTONPANEL, card1);
//        
//        
//        tabbedPane.addTab(TEXTPANEL, card2);
//        
//        JLabel lblNombreDquipes = new JLabel("Nombre d'\u00E9quipes");
//        card2.add(lblNombreDquipes);
//        
//        JSpinner spinner = new JSpinner();
//        card2.add(spinner);
//        
//        JLabel lblDate = new JLabel("date");
//        card2.add(lblDate);
//        
//        JFormattedTextField formattedTextField = new JFormattedTextField();
//        card2.add(formattedTextField);
// 
//        pane.add(tabbedPane, BorderLayout.CENTER);
//    }
// 
//    /**
//     * Create the GUI and show it.  For thread safety,
//     * this method should be invoked from the
//     * event dispatch thread.
//     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("FenetreTrounois");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        //Create and set up the content pane.
//        FenetreTrounois demo = new FenetreTrounois();
//        demo.addComponentToPane(frame.getContentPane());
// 
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
// 
//    public static void main(String[] args) {
//        /* Use an appropriate Look and Feel */
//        try {
//            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//        } catch (UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        } catch (IllegalAccessException ex) {
//            ex.printStackTrace();
//        } catch (InstantiationException ex) {
//            ex.printStackTrace();
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        /* Turn off metal's use of bold fonts */
//        UIManager.put("swing.boldMetal", Boolean.FALSE);
//         
//        //Schedule a job for the event dispatch thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//}

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class FenetreTrounois extends JFrame{
	private JFrame frame;
	private JTextField textFieldNom;
	private JTextField textFieldType;
	private JTextField textFieldDateF;
	private JTextField textFieldDateD;
	private JButton buttonCreer;
	private JButton btnGrerLeTrounois;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreTrounois window = new FenetreTrounois();
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
	public FenetreTrounois() {
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
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Gestion = new JPanel();
		Gestion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Connection con;
				try {
					System.out.println("Creation....");
					con = DriverManager.getConnection("jdbc:mysql://localhost/tournois","root","");
				
				Statement stm = con .createStatement();
				ResultSet set = stm.executeQuery("select * from tournois");
				while(set.next()){
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
					model.addRow((Vector) set);
				}
//				max = Integer.parseInt(set.getString("max(numa)"));
//				max++;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Erreur : "+e1);
				};
			}
		});
		tabbedPane.addTab("Gerer un tournois", null, Gestion, null);
		Gestion.setLayout(null);
		
		btnGrerLeTrounois = new JButton("Enregistrer les modifications");
		btnGrerLeTrounois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("test");
			}
		});
		String[] deux ={"Nom","Date de Début","Date de Fin","Nombre d'équipe","Type"};
		DefaultTableModel TM = new DefaultTableModel(deux,5);
		table = new JTable(TM);
		table.setMaximumSize(new Dimension(2147483647, 100));
		table.setMinimumSize(new Dimension(75, 100));
		table.setAutoCreateRowSorter(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 45, 409, 144);
		
		Connection con;
		try {
			System.out.println("chargement....");
			con = DriverManager.getConnection("jdbc:mysql://localhost/tournois","root","");
		
		Statement stm = con .createStatement();
		ResultSet set = stm.executeQuery("select * from tournois");
		while(set.next()){
			System.out.println(set);
			System.out.println(set.getString(1));
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
			model.addRow((Vector) set);
		}
//		max = Integer.parseInt(set.getString("max(numa)"));
//		max++;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Erreur : "+e1);
		};
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(409, 147);
		scrollPane.setLocation(10, 42);
		Gestion.add(scrollPane);
		btnGrerLeTrounois.setBounds(306, 200, 113, 23);
		Gestion.add(btnGrerLeTrounois);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(10, 11, 205, 20);
		Gestion.add(comboBox);
		
		JButton button = new JButton("New button");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("test1");
			}
		});
		button.setBounds(42, 200, 89, 23);
		Gestion.add(button);
		
		
		
		JPanel Creation = new JPanel();
		tabbedPane.addTab("Creer un tournois", null, Creation, null);
		Creation.setLayout(null);
		
		JLabel label = new JLabel("Nom du trounois");
		label.setBounds(10, 11, 137, 14);
		Creation.add(label);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(157, 11, 86, 20);
		textFieldNom.setColumns(10);
		Creation.add(textFieldNom);
		
		JLabel label_3 = new JLabel("Type de Tournois");
		label_3.setBounds(10, 42, 137, 14);
		Creation.add(label_3);
		
		textFieldType = new JTextField();
		textFieldType.setBounds(157, 42, 86, 20);
		textFieldType.setColumns(10);
		Creation.add(textFieldType);
		
		JLabel label_1 = new JLabel("Date de debut");
		label_1.setBounds(10, 73, 137, 14);
		Creation.add(label_1);
		
		textFieldDateF = new JTextField();
		textFieldDateF.setBounds(157, 101, 86, 20);
		textFieldDateF.setColumns(10);
		Creation.add(textFieldDateF);
		
		JLabel label_2 = new JLabel("Date fin");
		label_2.setBounds(10, 104, 137, 14);
		Creation.add(label_2);
		
		textFieldDateD = new JTextField();
		textFieldDateD.setBounds(157, 70, 86, 20);
		textFieldDateD.setColumns(10);
		Creation.add(textFieldDateD);
		
		JLabel label_4 = new JLabel("Nombre d'equipe");
		label_4.setBounds(10, 138, 137, 14);
		Creation.add(label_4);
		
		JSpinner spinnerNbEq = new JSpinner();
		spinnerNbEq.setBounds(157, 135, 86, 20);
		Creation.add(spinnerNbEq);
		
		buttonCreer = new JButton("Creer");
		buttonCreer.setBounds(338, 200, 81, 23);
		Creation.add(buttonCreer);
		buttonCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("BOUTON !");
//				new CreerTournois();
//				frame.setVisible(false);
//				System.out.println("test");
				
				//Récupération des valeur des cases text et autre, ajout de cote simple : ' ' autour des valeurs
				String nom = '\''+textFieldNom.getText()+'\'';
				String type ='\''+textFieldType.getText()+'\'';
				String dateD = '\''+textFieldDateD.getText()+'\'';
				String dateF = '\''+textFieldDateF.getText()+'\'';
				String nbEq = '\''+textFieldDateD.getText()+'\'';
				nbEq = '\''+"12"+'\'';
//				String prop = '\''+(String)comboBoxP.getSelectedItem()+'\'';
				System.out.println("Insertion dans la table : "+nom+" | "+type+" | "+dateD+" | "+dateF+" | "+nbEq);
				//Partie sql TODO : SQL INSERT + UPDATE 
				Connection con;
				try {
					System.out.println("Creation....");
					con = DriverManager.getConnection("jdbc:mysql://localhost/tournois","root","");
				
				Statement stm = con .createStatement();
//				int max = 0;
//				ResultSet set = stm.executeQuery("select max(numa) from animal");
//				set.next();
//				max = Integer.parseInt(set.getString("max(numa)"));
//				max++;
				//Requete d'ajout d'un tournois
				stm.executeUpdate("insert into tournois values (NULL,"+nom+","+type+","+dateD+","+dateF+","+nbEq+");");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Erreur : "+e1);
				};
			}
		});
	}
}

