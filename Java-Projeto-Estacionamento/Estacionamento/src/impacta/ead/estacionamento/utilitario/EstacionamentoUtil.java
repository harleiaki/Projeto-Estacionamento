package impacta.ead.estacionamento.utilitario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import impacta.ead.estacionamento.negocio.Movimentacao;

/**
 * REPRESENTA uma classe de apoio as demais do sistema. 
 */

public class EstacionamentoUtil {
	
	/*
	 * Valida a placa com o padrao LLL-NNNN
	 * L = Letra
	 * N = Numero
	 * 
	 * @param placa Placa do veiculo
	 * @return true se atender o padrao e false senão
	 */
	
	public boolean validaPadraoPlaca(String placa) {
		//TODO implementar
		return false;
	}
	
	/**
	 * o calculo do valor da estada do veiculo baseado no tarifário
	 * e na hora de entrada e saida do veiculo
	 * 
	 * altera a propria instancia do parametro
	 * 
	 * @ param movimentacao Instancia da movimentacao
	 */
	
	public void calcularPagamento(Movimentacao movimentacao) {
		//TODO implementar
	}

	public static boolean validarPadraoPlaca(String placa) {
		String padrao = "[A_Z][A_Z][A_Z]-\\d\\d\\d\\d";
		Pattern p = Pattern.compile(padrao);
		Matcher m = p.matcher(placa);
		
		return m.matches();
	}

}
