package bryan.tarefasjava.repositories;

import bryan.tarefasjava.models.tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<tarefa, Long> {

    List<tarefa> findByUser_Id(Long id);

    @Query("SELECT t FROM tarefa t WHERE t.user.Id = :id")
    List<tarefa> findByUser_IdJpl(@Param("id") Long id);

    @Query(value = "SELECT * FROM tarefa WHERE user_id = :id", nativeQuery = true)
    List<tarefa> findByUser_IdNative(@Param("id") Long id);
}