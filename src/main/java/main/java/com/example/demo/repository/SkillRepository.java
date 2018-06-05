package main.java.com.example.demo.repository;

import main.java.com.example.demo.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ikovacic.
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    @Query("SELECT COUNT(s.ID) FROM Skill s")
    long count();

    @Query("SELECT s FROM Skill s WHERE LOWER(s.name) = LOWER(:name)")
    Skill findByName(@Param("name") String name);

}
