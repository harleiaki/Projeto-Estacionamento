package impacta.ead.estacionamento.negocio;

import java.time.LocalDateTime;

/* Representa o fluco do veiculo dentro do estacionaento, ou seja,
 * ele contem as informações de entrada e saida do veiculo e o valor pago na estada. 
 * */

public class Movimentacao {
	
	private Veiculo veiculo;
	private LocalDateTime dataHoraEntrada;
	private LocalDateTime dataHoraSaida;
	private double valor;
	
	/* Ctrl+Shift+O 
	 * importa as classes não resolvidas no projeto
	 * */
	
	public Movimentacao(Veiculo veiculo, LocalDateTime dataEntrada) {
		this.veiculo = veiculo;
		this.dataHoraEntrada = dataEntrada;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public LocalDateTime getDataHoraEntrada() {
		return dataHoraEntrada;
	}
	public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}
	public LocalDateTime getDataHoraSaida() {
		return dataHoraSaida;
	}
	public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
