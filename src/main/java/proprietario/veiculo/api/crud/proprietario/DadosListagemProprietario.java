package proprietario.veiculo.api.crud.proprietario;

import proprietario.veiculo.api.crud.endereco.Endereco;

public record DadosListagemProprietario(Long id, String nome, String cpf, Endereco endereco) {
	
	public DadosListagemProprietario(Proprietario proprietario) {
		this(proprietario.getId(), proprietario.getNome(), proprietario.getCpf(), proprietario.getEndereco());
	}
	
}
