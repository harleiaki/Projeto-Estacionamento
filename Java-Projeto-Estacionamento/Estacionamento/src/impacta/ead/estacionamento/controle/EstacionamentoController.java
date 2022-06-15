package impacta.ead.estacionamento.controle;

import java.time.LocalDateTime;
import java.util.List;

import impacta.ead.estacionamento.negocio.Movimentacao;

public class EstacionamentoController {
	
	public void processarEntrada(String placa, String marca, String modelo, String cor) {
		//TODO implementar
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
