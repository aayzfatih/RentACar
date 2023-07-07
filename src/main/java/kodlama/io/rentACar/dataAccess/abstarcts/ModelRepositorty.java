package kodlama.io.rentACar.dataAccess.abstarcts;

import kodlama.io.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepositorty extends JpaRepository<Model, Integer> {
}
