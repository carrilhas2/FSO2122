import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIServidor extends JFrame {

	private static final long serialVersionUID = 6753842018479579961L;
	private JPanel guiContentPane;
	private JTextField textFldNome;
	private JTextField textFldRaio;
	private JTextField textFldAngulo;
	private JTextField textFldDistancia;
	private JButton btnAbrir;
	private JButton btnFrente;
	private JButton btnTras;
	private JButton btnEsquerda;
	private JButton btnDireita;
	private JButton btnParar;
	private JTextArea textAreaConsola;
	private boolean abrir = false;
	private double zoom = 1;
	private Variaveis v;
	private int numeroInstrucao = 1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIServidor frame = new GUIServidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void inicializarVariaveis() {
		v = new Variaveis();
	}

	/**
	 * Create the frame.
	 */
	public GUIServidor() {
		inicializarVariaveis();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, (int) (900*zoom), (int) (600*zoom));
		guiContentPane = new JPanel();
		guiContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(guiContentPane);
		guiContentPane.setLayout(null);
		
		textFldNome = new JTextField(v.getNomeRobot());
		textFldNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setNomeRobot(textFldNome.getText());
				escreverConsola("Novo nome: " +  v.getNomeRobot());

			}
		});
		textFldNome.setBounds(86, 23, (int) (130*zoom), (int) (26*zoom));
		guiContentPane.add(textFldNome);
		textFldNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(6, 28, (int) (61*zoom), (int) (16*zoom));
		guiContentPane.add(lblNome);
		
		textFldRaio = new JTextField(v.getRaio() + "");
		textFldRaio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setRaio(Integer.parseInt(textFldRaio.getText()));
				escreverConsola("Novo raio: " +  v.getRaio());
			}
		});
		textFldRaio.setColumns(10);
		textFldRaio.setBounds(86, 61, (int) (130*zoom), (int) (26*zoom));
		guiContentPane.add(textFldRaio);
		
		textFldAngulo = new JTextField(v.getAngulo() + "");
		textFldAngulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setAngulo(Integer.parseInt(textFldAngulo.getText()));
				escreverConsola("Novo angulo: " +  v.getAngulo());

			}
		});
		textFldAngulo.setColumns(10);
		textFldAngulo.setBounds(86, 99, (int) (130*zoom), (int) (26*zoom));
		guiContentPane.add(textFldAngulo);
		
		JLabel lblRaio = new JLabel("Raio:");
		lblRaio.setBounds(6, 66, (int) (61*zoom), (int) (16*zoom));
		guiContentPane.add(lblRaio);
		
		JLabel lblAngulo = new JLabel("Angulo:");
		lblAngulo.setBounds(6, 108, (int) (61*zoom), (int) (16*zoom));
		guiContentPane.add(lblAngulo);
		
		JLabel lblDistncia = new JLabel("Dist??ncia:");
		lblDistncia.setBounds(6, 146, (int) (85*zoom), (int) (16*zoom));
		guiContentPane.add(lblDistncia);
		
		textFldDistancia = new JTextField(v.getDistancia() + "");
		textFldDistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.setDistancia(Integer.parseInt(textFldDistancia.getText()));
				escreverConsola("Nova distancia: " +  v.getDistancia());
			}
		});
		textFldDistancia.setColumns(10);
		textFldDistancia.setBounds(86, 141, (int) (130*zoom), (int) (26*zoom));
		guiContentPane.add(textFldDistancia);
		
		btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir = !abrir;
				escreverConsola(abrir ? "Abrir conex??o ao robot" + textFldNome.getText() : "Fechar conex??o ao robot" + textFldNome.getText());
				btnDireita.setEnabled(abrir);
				btnEsquerda.setEnabled(abrir);
				btnFrente.setEnabled(abrir);
				btnParar.setEnabled(abrir);
				btnTras.setEnabled(abrir);
			}
		});
		btnAbrir.setBounds(777, 23, (int) (117*zoom), (int) (29*zoom));
		guiContentPane.add(btnAbrir);
		
		btnFrente = new JButton("Frente");
		btnFrente.setEnabled(abrir);
		btnFrente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(abrir) {
				escreverConsola("Andar em frente. Distancia: " + textFldDistancia.getText());
			}}
		});
		btnFrente.setBounds(534, 80, (int) (148*zoom), (int) (45*zoom));
		guiContentPane.add(btnFrente);
		
		btnParar = new JButton("Parar");
		btnParar.setEnabled(abrir);
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(abrir) {
					escreverConsola("Parar");
			}}
		});
		btnParar.setBounds(534, 133, (int) (148*zoom), (int) (45*zoom));
		guiContentPane.add(btnParar);
		
		btnTras = new JButton("Tras");
		btnTras.setEnabled(abrir);
		btnTras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(abrir) {
					escreverConsola("Andar para tras. Distancia: " + textFldDistancia.getText());
				}
			}
		});
		btnTras.setBounds(534, 179, (int) (148*zoom), (int) (40*zoom));
		guiContentPane.add(btnTras);
		
		btnEsquerda = new JButton("Esquerda");
		btnEsquerda.setEnabled(abrir);
		btnEsquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(abrir) {
					escreverConsola("Andar para a esquerda. Angulo: " + textFldAngulo.getText() + " Raio: " + textFldRaio.getText());
				}
			}
		});
		btnEsquerda.setBounds(375, 133, (int) (147*zoom), (int) (45*zoom));
		guiContentPane.add(btnEsquerda);
		
		btnDireita = new JButton("Direita");
		btnDireita.setEnabled(abrir);
		btnDireita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(abrir) {
					escreverConsola("Andar para a direita. Angulo: " + textFldAngulo.getText() + " Raio: " + textFldRaio.getText());
				}
			}
		});
		btnDireita.setBounds(694, 133, (int) (148*zoom), (int) (45*zoom));
		guiContentPane.add(btnDireita);
		
		textAreaConsola = new JTextArea();
		textAreaConsola.setBounds(6, 244, (int) (888*zoom), (int) (328*zoom));
		guiContentPane.add(textAreaConsola);
		
	}
	
	private void escreverConsola(String texto) {
		textAreaConsola.setText("\n" +numeroInstrucao + ": " + texto + textAreaConsola.getText());
		numeroInstrucao++;
	}
}
