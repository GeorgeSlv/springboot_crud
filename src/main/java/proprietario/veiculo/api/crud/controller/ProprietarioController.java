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
import proprietario.veiculo.api.crud.proprietario.DadosAtualizacaoProprietario;
import proprietario.veiculo.api.crud.proprietario.DadosCadastroProprietario;
import proprietario.veiculo.api.crud.proprietario.DadosListagemProprietario;
import proprietario.veiculo.api.crud.proprietario.Proprietario;
import proprietario.veiculo.api.crud.proprietario.ProprietarioRepository;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {
	
	@Autowired
	private ProprietarioRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroProprietario dados) {
		repository.save(new Proprietario(dados));
	}
	
	@GetMapping
	public Page<DadosListagemProprietario> listar(Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemProprietario::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoProprietario dados) {
		var proprietario = repository.getReferenceById(dados.id());
		proprietario.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
		
	}
	
}
