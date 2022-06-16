package impacta.ead.estacionamento.apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class TelaLogin extends JFrame implements ActionListener {
	
	private JPasswordField txtSenha;
	private JPanel panel_2;
	private JRadioButton rdbOperacional;
	private JRadioButton rdbRelatorio;
	private JButton btnOk;
	
	
	
	//TODO remover ao entregar o projeto
	public static void main(String[] args) {
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
	}
	
	public TelaLogin() {
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500,150));
		setResizable(false);
		setTitle("Login");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setActionCommand("ok");
		panel.add(btnOk);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Senha:");
		panel_2.add(lblNewLabel);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(20);
		panel_2.add(txtSenha);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		
		ButtonGroup grupo = new ButtonGroup();
		rdbOperacional = new JRadioButton("Operacional");
		rdbOperacional.setSelected(true);
		rdbOperacional.addActionListener(this);
		rdbOperacional.setActionCommand("operacional");
		grupo.add(rdbOperacional);
		panel_3.add(rdbOperacional);
		
		rdbRelatorio = new JRadioButton("Relatório");
		grupo.add(rdbRelatorio);
		rdbRelatorio.addActionListener(this);
		rdbRelatorio.setActionCommand("relatorio");
		panel_3.add(rdbRelatorio);
		
		panel_2.setVisible(false);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String cmd = evento.getActionCommand();
		JFrame tela = null;
		
		if(cmd.equals("operacional")) {
			panel_2.setVisible(false);
		}else if(cmd.equals("relatorio")) {
			txtSenha.setText("");
			panel_2.setVisible(true);
		}else if (cmd.equals("ok")) {
			if(rdbOperacional.isSelected()) {
				tela = new TelaInicialMovimentacao();
				tela.setVisible(true);

			}else {
				String senha = new String(txtSenha.getPassword());
				if(senha.equals("impacta")) {
					tela = new TelaInicialRelatorio();
					tela.setVisible(true);

				}else {
					JOptionPane.showMessageDialog(null, "Senha Invalida",
							"Falha Login", JOptionPane.ERROR_MESSAGE);
					txtSenha.setText("");
					return;
				}
			}
			this.dispose();
		}
	
		
	}

}
