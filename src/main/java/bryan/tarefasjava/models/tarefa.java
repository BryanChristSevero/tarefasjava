package bryan.tarefasjava.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Column; //Anotações para configurar restrições de coluna de tabela
import jakarta.persistence.Entity; //Anotação para sinalizar que a classe é uma entidade JPA
import jakarta.persistence.GeneratedValue; //Anotação para persistir a estretégia de geração de ID
import jakarta.persistence.GenerationType; //Anotação para geração automática de chaves
import jakarta.persistence.Id; //Anotação para indicar chave primária
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; // Anotação para especificar o nome da tabela
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "tarefa")
public class tarefa {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "descricao", length = 255, nullable = false)
    @NotBlank
    @Size(min = 1, max = 255)
    private String descricao;

    public tarefa(){

    }

    public tarefa(Long id, User user, String descricao){
        this.Id = id;
        this.user = user;
        this.descricao = descricao;
    }


    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() !=o.getClass())return false;
        tarefa tarefa =(tarefa) o;
            return Objects.equals(Id, tarefa.Id) &&
            Objects.equals(user, tarefa.user) &&
            Objects.equals(descricao, tarefa.descricao);
    }

    @Override
    public int hashCode(){
        return Objects.hash(Id, user, descricao);
    }

}