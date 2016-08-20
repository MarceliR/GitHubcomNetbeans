
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
      @Id
    @SequenceGenerator(name="seq_pessoa", sequenceName = "seq_pessoa_id",
        allocationSize = 1)
    
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
      
    @Length(max= 50, message ="o nome não pode ter mais de {max} caracteres")
    @NotNull(message ="o nomr não pode ser nulo")//exemplo
    @NotBlank(message="o nome não pode ser em branco")//exemplo
    @Column(name= "nome", length=50, nullable=false)//length eh soh para string   
    private String nome;
    
    @Length(max= 50, message ="o cpf não pode ter mais de {max} caracteres")
    @NotNull(message ="o cpf não pode ser nulo")//exemplo
    @NotBlank(message="o cpf não pode ser em branco")//exemplo
    @Column(name= "cpf", length=14, nullable=false)//length eh soh para string
    private String cpf;
    
    @Length(max= 50, message ="o telefone não pode ter mais de {max} caracteres")
    @NotNull(message ="o telefone não pode ser nulo")//exemplo
    @NotBlank(message="o telefone não pode ser em branco")//exemplo
    @Column(name= "telefone", length=20, nullable=false)//length eh soh para string
    private String telefone;
    
    @Length(max= 50, message ="o email não pode ter mais de {max} caracteres")
    @NotNull(message ="o email não pode ser nulo")//exemplo
    @NotBlank(message="o email não pode ser em branco")//exemplo
    @Column(name= "email", length=50, nullable=false)//length eh soh para string
    private String email;

    public Pessoa() {
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
