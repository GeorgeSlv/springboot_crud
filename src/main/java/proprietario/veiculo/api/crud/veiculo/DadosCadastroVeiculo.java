package proprietario.veiculo.api.crud.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroVeiculo(
		
		@NotBlank
		String modelo, 
		
		@NotBlank
		String placa, 
		
		@NotBlank
		@Pattern(regexp = "\\d{9}")
		String renavam,
		
		@NotNull
		Long id_prop) {

}
