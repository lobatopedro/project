package model.projeto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "api/projetos")
public class GerenciadorManterProjetoController {
	
	@Autowired
	private ManterProjetoService manterProjetoService;
	
	@PostMapping
	public ResponseEntity<Projeto> inserir (@RequestBody Projeto novoProjeto) {
		return new ResponseEntity<>(manterProjetoService.inserir(novoProjeto), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Projeto> editar (@RequestBody Projeto editarProjeto) {
		return new ResponseEntity<>(manterProjetoService.inserir(editarProjeto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir (@PathVariable String id) {
		manterProjetoService.excluirProjeto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Projeto> encontrarPorId(@PathVariable String id) {
		return new ResponseEntity<>(manterProjetoService.encontrarPorId(id), HttpStatus.OK);
	}
	
	@GetMapping
	public List<Projeto> encontrarTodos() {
		return manterProjetoService.encontrarTodos();
	}

}
