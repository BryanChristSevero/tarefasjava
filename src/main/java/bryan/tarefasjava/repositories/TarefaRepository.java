package bryan.tarefasjava.repositories;

// Importa a entidade 'tarefa' que este repositório vai manipular
import bryan.tarefasjava.models.tarefa;
// Interface base do Spring com métodos prontos de CRUD e paginação
import org.springframework.data.jpa.repository.JpaRepository;
// Anotação para escrever consultas personalizadas (JPQL ou SQL Nativo)
import org.springframework.data.jpa.repository.Query;
// Anotação para vincular parâmetros do método às consultas da @Query
import org.springframework.data.repository.query.Param;
// Anotação que marca a interface como um repositório do Spring
import org.springframework.stereotype.Repository;

// Importa a classe List para retornar coleções de dados
import java.util.List;

// Indica que esta interface é um componente de repositório do Spring (camada de acesso a dados)
@Repository
public interface TarefaRepository extends JpaRepository<tarefa, Long> {

    // 1. Derived Query: Spring cria o SQL automaticamente pelo nome do método
    List<tarefa> findByUser_Id(Long id);

    // 2. JPQL: Consulta personalizada orientada a objetos Java/JPA
    @Query("SELECT t FROM tarefa t WHERE t.user.Id = :id")
    List<tarefa> findByUser_IdJpl(@Param("id") Long id);

    // 3. Native Query: Consulta personalizada escrita em SQL direto do banco de dados
    @Query(value = "SELECT * FROM tarefa WHERE user_id = :id", nativeQuery = true)
    List<tarefa> findByUser_IdNative(@Param("id") Long id);
}