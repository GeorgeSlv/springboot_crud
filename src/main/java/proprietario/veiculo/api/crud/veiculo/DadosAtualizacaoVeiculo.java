package proprietario.veiculo.api.crud.veiculo;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoVeiculo(
		@NotNull
		Long id, 
		String modelo, 
		String placa, 
		String renavam, 
		Long id_prop) {

}
