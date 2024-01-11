package proprietario.veiculo.api.crud.veiculo;

public record DadosListagemVeiculo(Long id, String modelo, String placa, String renavam, Long id_prop) {
	public DadosListagemVeiculo(Veiculo dados) {
		this(dados.getId(), dados.getModelo(), dados.getPlaca(), dados.getRenavam(), dados.getId_prop());
	}
}
