package sistema.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.escola.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer>{

}
