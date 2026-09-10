package bryan.tarefasjava.services;

//importa a classe Optional do Java para tratar retornos que não podem ser nulos
import java.util.Optional;

import org.apache.catalina.User;
//importa a anotação para injeção automatica de dependencias do Spring
import org.springframework.beans.factory.annotation.Autowired;
//importa a anotação que marca a classe como um componente de serviço gerenciado pelo
import org.springframework.stereotype.Service;

//importa a anotação que gerencia transações com o banco de dados(rolback automatico)
import org.springframework.transaction.annotation.Transactional;

//importa a classe/modelo User
import bryan.tarefasjava.models.user;

//importa a interface do repositorio tarefas
import bryan.tarefasjava.repositories.TarefaRepository;

//importa a interface do repositorio tarefas
import bryan.tarefasjava.repositories.UserRepository;

/* Camada de serviço responsavel pelas regras de negocio da entidade User */

// Indica ao Spring que essa classe faz parte da camada de serviço/negócio
@Service
public class UserService{

    // Solicita ao Spring Boot que injeta a instancia do UserRepository automaticamente
    @Autowired
    private UserRepository UserRepository;

    // Solicita ao Spring Boot que injeta a instancia do TarefaRepository automaticamente
    @Autowired
    private TarefaRepository TarefaRepository;

    @Param id //Identificador do usuário
    @return //Objeto user encontrado

    public user findBy(Long id){
        Optional<bryan.tarefasjava.models.user> user =this.UserRepository.findBy(id);

        return user.orElseThrow(()-> new RuntimeException(
            "Usuario não encontrado id:" + id + ", tipo: " + User.class.getName()
        ));
    }

    @Param Objeto
    @return

    @Transactional 

    public User create(User obj){

        obj.setId(null);

        obj = this.UserRepository.save(obj);

        this.TarefaRepository.saveall(obj.getClass());

        return obj;
    }

}