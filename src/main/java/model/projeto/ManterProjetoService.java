package model.projeto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManterProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	public Projeto inserir (Projeto novoProjeto) {
		if(projetoRepository.findById(novoProjeto.getId()).isPresent()) {
			throw new RuntimeException("O projeto já existe!");
		}
		return projetoRepository.save(novoProjeto);
	}
	
	public Projeto editar (Projeto editarProjeto) {
		Projeto projetoEditado = projetoRepository.findById(editarProjeto.getId())
				.orElseThrow(() -> { throw new RuntimeException("Projeto não encontrado!");});
		
		projetoEditado.setNome(editarProjeto.getNome());
		projetoEditado.setIdentificador(editarProjeto.getIdentificador());
		projetoEditado.setParticipantes(editarProjeto.getParticipantes());
		projetoEditado.setProprietario(editarProjeto.getProprietario());
		
		return projetoRepository.save(projetoEditado);
	}
	
	public void excluirProjeto(String id) {
		if(!projetoRepository.findById(id).isPresent()) {
			throw new RuntimeException("O projeto com este id não existe!");
		}
		projetoRepository.deleteById(id);
	}
	
	public Projeto encontrarPorId(String id) {
		Optional<Projeto> projetoEncontrado = projetoRepository.findById(id);
		if(!projetoEncontrado.isPresent()) {
			throw new RuntimeException("O projeto não existe!");
		}
		return projetoEncontrado.get();
	}
	
	public List<Projeto> encontrarTodos() {
		return projetoRepository.findAll();
	}
	
}

