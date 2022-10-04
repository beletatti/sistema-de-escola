package sistema.escola.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import sistema.escola.model.Aluno;
import sistema.escola.service.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> list = alunoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{cod}")
	public ResponseEntity<Aluno> find(@PathVariable Integer cod) {
		Aluno obj = alunoService.find(cod);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{cod}")
	public ResponseEntity<Aluno> delete(@PathVariable Integer cod) {
		alunoService.delete(cod);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{cod}")
	public ResponseEntity<?> update(@Valid @RequestBody Aluno aluno, @PathVariable Integer cod) {
		aluno.setCod(cod);
		aluno = alunoService.update(aluno);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody Aluno aluno) {
		Aluno obj = alunoService.insert(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCod()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
