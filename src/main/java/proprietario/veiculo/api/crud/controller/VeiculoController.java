package proprietario.veiculo.api.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import proprietario.veiculo.api.crud.veiculo.DadosAtualizacaoVeiculo;
import proprietario.veiculo.api.crud.veiculo.DadosCadastroVeiculo;
import proprietario.veiculo.api.crud.veiculo.DadosListagemVeiculo;
import proprietario.veiculo.api.crud.veiculo.Veiculo;
import proprietario.veiculo.api.crud.veiculo.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroVeiculo dados) {
		repository.save(new Veiculo(dados));
	}
	
	@GetMapping
	public Page<DadosListagemVeiculo> listar(Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemVeiculo::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoVeiculo dados) {
		var veiculo = repository.getReferenceById(dados.id());
		veiculo.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
