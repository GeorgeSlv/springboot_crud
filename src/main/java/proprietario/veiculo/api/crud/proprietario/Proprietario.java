package proprietario.veiculo.api.crud.proprietario;

import jakarta.persistence.Embedded;
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
import proprietario.veiculo.api.crud.endereco.Endereco;


@Table(name = "proprietarios")
@Entity(name = "proprietarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Proprietario {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	
	@Embedded
	private Endereco endereco;
	
	public Proprietario(DadosCadastroProprietario dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());

	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoProprietario dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.cpf() != null) {
			this.cpf = dados.cpf();
		}
		if(dados.endereco() != null)
			this.endereco.atualizarInformações(dados.endereco());
	}
}
