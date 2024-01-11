package proprietario.veiculo.api.crud.proprietario;

import jakarta.validation.constraints.NotNull;
import proprietario.veiculo.api.crud.endereco.DadosEndereco;

public record DadosAtualizacaoProprietario(
		@NotNull
		Long id,
		String nome, 
		String cpf, 
		DadosEndereco endereco) {

}
