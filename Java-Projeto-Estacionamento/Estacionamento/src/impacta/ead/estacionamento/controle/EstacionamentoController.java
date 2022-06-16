package impacta.ead.estacionamento.controle;

import java.time.LocalDateTime;
import java.util.List;

import impacta.ead.estacionamento.negocio.Movimentacao;
import impacta.ead.estacionamento.negocio.Vaga;
import impacta.ead.estacionamento.negocio.Veiculo;
import impacta.ead.estacionamento.persistencia.DAOEstacionamento;
import impacta.ead.estacionamento.utilitario.EstacionamentoUtil;

public class EstacionamentoController {
	
	/*
	 * A partir dos dados do veiculo informados pelo operador realiza 
	 * o fluxo de entrada do veiculo no estacionamento registrando
	 * a movimentação gerada
	 * 
	 * @param placa Placa do veiculo
	 * @param marca Marca do veiculo
	 * @param model Modelo do veiculo
	 * @param cor Cor do veiculo
	 * @throws EstacionamentoException Quando estacionamento estiver lotado.
	 * @throws VeiculoException quando o padrao da placa for invalido
	 */
	
	public void processarEntrada(String placa, String marca, String modelo, String cor) throws EstacionamentoException, VeiculoException {
		
		//verificar se o estacionamento esta lotado
		if(!Vaga.temVagaLivre()) {
			throw new EstacionamentoException("Estacionamento lotado!");
		}
		
		//verificar o padrao de string da placa
		if (EstacionamentoUtil.validarPadraoPlaca(placa)) {
			throw new VeiculoException("Placa informada inválida!");
		}
		
		//criar uma instancia do veiculo
		Veiculo veiculo = new Veiculo(placa,marca,modelo,cor);
		//criar a movimentacao vinculando o veiculo e com a data de entrada corrente
		Movimentacao movimentacao = new Movimentacao(veiculo,LocalDateTime.now());
		//registrar na base de dados a informacao
		DAOEstacionamento dao = new DAOEstacionamento();
		dao.criar(movimentacao);
		//atualizar o numero de vagas ocupadas
		Vaga.entrou();
		//fim
		
	}
	
	public Movimentacao processarSaida(String placa) {
		//TODO implementar
		return null;
	}
	
	public List<Movimentacao> emitirRelatorio(LocalDateTime data) {
		//TODO implementar
		return null;
	}

}
