package impacta.ead.estacionamento.apresentacao;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TelaInicialMovimentacao  extends JFrame implements ActionListener{
	
	private JButton btnEntrar;
	private JButton btnSair;
	
	//TODO temporário
	
	public static void main(String[] args) {
		TelaInicialMovimentacao tela = new TelaInicialMovimentacao();
		tela.setVisible(true);;
	}
	
	public TelaInicialMovimentacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450,300));
		setResizable(false);
		setTitle("Sistema de Estacionamento");
		getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
		
		btnEntrar = new JButton("");
		btnEntrar.setIcon(new ImageIcon(TelaInicialMovimentacao.class.getResource("/recursos/getin.png")));
		btnEntrar.addActionListener(this);
		btnEntrar.setActionCommand("entrada");
		getContentPane().add(btnEntrar);
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(TelaInicialMovimentacao.class.getResource("/recursos/getout.png")));
		btnSair.addActionListener(this);
		btnSair.setActionCommand("saida");
		getContentPane().add(btnSair);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		JFrame tela = null;
		
		if(cmd.equals("entrada")) {
			tela = new TelaEntradaVeiculo(this);
		}else {
			tela = new TelaSaidaVeiculo(this);
		}
		
		tela.setVisible(true);
		this.setVisible(false);
		
		
	}

}
