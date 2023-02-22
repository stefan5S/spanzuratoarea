package spanzuratoarea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Spanzuratoarea extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	Cuvant alege=new Cuvant();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spanzuratoarea frame = new Spanzuratoarea();
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
	public Spanzuratoarea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("apasati pe start pentru a incepe");
		lblNewLabel.setBounds(10, 29, 306, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("numar_vieti");
		lblNewLabel_2.setBounds(335, 186, 90, 14);
		contentPane.add(lblNewLabel_2);		
		
		textField = new JTextField();
		textField.setBounds(10, 183, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("incearca litera");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comportamentul butonului "incearca litera"
				
				
				/*!!ar mai fi o problema cand se apasa butonul, iar campul e gol*/
				
				try {
				
					/*prin if-ul de mai jos nu las utilizatorul sa mai continue jocul daca acesta a pierdut sau
					 * daca acesta a castigat*/					
						if(alege.vieti_posibile()==true&&alege.cuvant_gata_ghicit()==true)
						{
						
							alege.adauga_litera(textField.getText());
							lblNewLabel.setText(alege.get_cuvant_ghicit());
							lblNewLabel_2.setText(Integer.toString(alege.get_vieti()));
							
							
							
							if(alege.cuvant_gata_ghicit()==false)
							{
								lblNewLabel.setText("Ai castigat!");
							}
							
							if(alege.vieti_posibile()==false)
							{
								lblNewLabel.setText("Ai pierdut!");
							}
							
							textField.setText("");
							
						}				
				}
				
				catch(Exception ee)
				{
					System.out.println("eroare 2: "+ee);
					
				}
				
				
			}
		});
		btnNewButton.setBounds(7, 214, 144, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("vieti");
		lblNewLabel_1.setBounds(270, 186, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton_1 = new JButton("start");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//aleg un cuvant aleator
				alege.alege_cuvant();
				alege.criptare_initiala();
				alege.set_vieti();
				
				lblNewLabel.setText(alege.get_cuvant_ghicit());
				lblNewLabel_2.setText(Integer.toString(alege.get_vieti()));
				
				
				
			}
		});
		btnNewButton_1.setBounds(161, 214, 165, 23);
		contentPane.add(btnNewButton_1);
	}
}
