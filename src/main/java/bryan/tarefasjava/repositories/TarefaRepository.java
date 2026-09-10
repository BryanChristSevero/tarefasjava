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

    // Método 1: Derived Query Method (padrão recomendado pelo Spring)
    /* O Spring gera o SQL automaticamente navegando na relação 'user' até o atributo 'id'
    busca na lista de tarefas aquelas atribuidas a um determinado usuario */ 
    List<tarefa> findByUser_Id(Long id);

    // Método 2: JPQL(Java Persistance Qurey Language)
    /* Consulta baseada na classe tarefa e no atributo 't.user.id', usando o parametro: 'id' ,
    o atributo id do usuario é passado como argumento do método */
  // @Query("SELECT t FROM tarefa t WHERE t.user.Id = :id")
  // List<tarefa> findByUser_IdJpl(@Param("id") Long id);

    // Método 3: SQL Nativo( Native SQL Query)
    /* Consulta SQL Puro direto na tabela tarefas e na coluna de chave estrangeira 'user_id'
    usa SQL Puro para buscar as tarefas associadas ao id do usuario fornecido */
   // @Query(value = "SELECT * FROM tarefa WHERE user_id = :id", nativeQuery = true)
   // List<tarefa> findByUser_IdNative(@Param("id") Long id);
}