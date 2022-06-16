package impacta.ead.estacionamento.apresentacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import impacta.ead.estacionamento.controle.EstacionamentoController;
import impacta.ead.estacionamento.controle.EstacionamentoException;
import impacta.ead.estacionamento.controle.VeiculoException;

public class TelaEntradaVeiculo extends JFrame implements ActionListener{
	
	private JFrame parent;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JButton btnOk;
	private JButton btnCancelar;
	private JFormattedTextField txfPlaca;
	private JFormattedTextField formattedTextField;
	
	//TODO temporario
	public static void main(String[] args) {
		TelaEntradaVeiculo tela= new TelaEntradaVeiculo(null);
		tela.setVisible(true);
	}
	
	public TelaEntradaVeiculo(JFrame parent) {
		setResizable(false);
		setSize(400,300);
		setTitle("Entrada de Veiculo");
		
		this.parent = parent;
		getContentPane().setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(125, 96, 45, 13);
		getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBackground(Color.WHITE);
		lblModelo.setBounds(125, 136, 45, 13);
		getContentPane().add(lblModelo);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(125, 56, 45, 13);
		getContentPane().add(lblPlaca);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(125, 176, 45, 13);
		getContentPane().add(lblCor);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(205, 90, 96, 19);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(205, 133, 96, 19);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(205, 170, 96, 19);
		getContentPane().add(txtCor);
		txtCor.setColumns(10);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(121, 232, 85, 21);
		btnOk.addActionListener(this);
		btnOk.setActionCommand("ok");
		getContentPane().add(btnOk);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(216, 232, 85, 21);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("cancelar");
		getContentPane().add(btnCancelar);
		
		try {
		txfPlaca = new JFormattedTextField(new MaskFormatter ("UUU-####"));
	
		
		}catch (ParseException e) {
			assert false : "Padrao de placa errado!";
		}
		txfPlaca.setBounds(210, 50, 86, 20);
		getContentPane().add(txfPlaca);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		if(evento.getActionCommand().equals("ok")) {
		  EstacionamentoController controle = new EstacionamentoController();
		  try {
			controle.processarEntrada(txfPlaca.getText(), 
					  								txtMarca.getText(), 
					  						        txtModelo.getText(), 
					  						        txtCor.getText());
			JOptionPane.showMessageDialog(null,	"Veiculo registrado com sucesso",
					"Entrada de veiculo", JOptionPane.INFORMATION_MESSAGE);
		} catch (EstacionamentoException | VeiculoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Falha na Entrada", JOptionPane.ERROR_MESSAGE);
		}
		 
		  
		}
		 this.parent.setVisible(true);
		  this.dispose();
		
	}
}
