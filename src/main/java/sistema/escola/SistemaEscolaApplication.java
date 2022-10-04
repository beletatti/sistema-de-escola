package sistema.escola;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sistema.escola.model.Aluno;
import sistema.escola.model.Nota;
import sistema.escola.repository.AlunoRepository;
import sistema.escola.repository.NotaRepository;

@SpringBootApplication
public class SistemaEscolaApplication implements CommandLineRunner {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private NotaRepository notaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaEscolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Nota n1 = new Nota(null,10, 10);
		Nota n2 = new Nota(null,10, 10);

		Aluno a1 = new Aluno(null, "Pedro", 0,n1);
		Aluno a2 = new Aluno(null, "Joâo", 0,n1);
		
		alunoRepository.saveAll(Arrays.asList(a1,a2));
		notaRepository.saveAll(Arrays.asList(n1,n2));
	}
}
