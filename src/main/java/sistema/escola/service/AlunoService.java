package sistema.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
}
