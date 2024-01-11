package proprietario.veiculo.api.crud.proprietario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import proprietario.veiculo.api.crud.endereco.DadosEndereco;

public record DadosCadastroProprietario(
		
		@NotBlank
		String nome, 
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String cpf, 
		
		@NotNull
		@Valid
		DadosEndereco endereco) {

}
