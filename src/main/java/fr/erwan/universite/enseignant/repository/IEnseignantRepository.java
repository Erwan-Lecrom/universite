package fr.erwan.universite.enseignant.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.erwan.universite.enseignant.domain.Enseignant;

@Repository
public interface IEnseignantRepository extends JpaRepository<Enseignant,Long>{
	@Modifying
	@Query("UPDATE t_enseignant SET grade=?1 , date_embauche=?2 WHERE id=?3")
	void modifier(String grade , Date dateEmbauche , Long id);
}
