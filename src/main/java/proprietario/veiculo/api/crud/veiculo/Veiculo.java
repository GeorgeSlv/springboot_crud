package proprietario.veiculo.api.crud.veiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "veiculos")
@Entity(name = "veiculos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelo;
	private String placa;
	private String renavam;
	private Long id_prop;
	
	public Veiculo(DadosCadastroVeiculo dados) {
		this.modelo = dados.modelo();
		this.placa = dados.placa();
		this.renavam = dados.renavam();
		this.id_prop = dados.id_prop();
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoVeiculo dados) {
		if(dados.modelo() != null) {
			this.modelo = dados.modelo();
		}
		if(dados.placa() != null) {
			this.placa = dados.placa();
		}
		if(dados.renavam() != null) {
			this.renavam = dados.renavam();
		}
		if(dados.id_prop() != null) {
			this.id_prop = dados.id_prop();
		}
		
	}

}
