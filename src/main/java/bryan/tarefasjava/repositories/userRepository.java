package bryan.tarefasjava.repositories; // Organiza a classe dentro da hierarquia do projeto

import bryan.tarefasjava.models.User; // Dá acesso aos atributos e mapeamentos da tabela usuario
import org.springframework.data.jpa.repository.JpaRepository; // Permite que a interface herde operações do banco de dados a necessidade implementar SQL
import org.springframework.stereotype.Repository; // Importa a anotação do Spring que marca a camada de acesso dados

import java.util.Optional; // Importa a classe utilitaria Optional do Java (utilizada para evitar retornos nulos do Java)



@Repository

// Declara a Interface 'userRepository' herdando de 'JpaRepository', vinculando a entidade 'User' com chave Id do tipo 'Long'
public interface userRepository extends JpaRepository<User, Long> {

    // Declara um método de busca customizado(Derived Quer) que gera automaticamente o Sql "where username = ?"
    User findByUsername(String username);
    
}