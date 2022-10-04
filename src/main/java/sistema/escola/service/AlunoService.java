package sistema.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.escola.exception.ObjectNotFoundException;
import sistema.escola.model.Aluno;
import sistema.escola.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		List<Aluno> obj = alunoRepository.findAll();
		return obj;
	}

	public Aluno find(Integer cod) {
		Optional<Aluno> obj = alunoRepository.findById(cod);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Cod: " + cod + ", Tipo: " + Aluno.class.getName()));
	}

	public void delete(Integer cod) {
		alunoRepository.deleteById(cod);
	}

	public Aluno update(Aluno obj) {
		Aluno newObj = find(obj.getCod());
		updateDate(newObj, obj);
		return alunoRepository.save(newObj);
	}

	private void updateDate(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setNotaEFalta(obj.getNotaEFalta());
	}

	public Aluno insert(Aluno obj) {
		obj.setCod(null);
		return alunoRepository.save(obj);
	}
}