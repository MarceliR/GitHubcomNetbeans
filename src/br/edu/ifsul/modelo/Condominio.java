/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marcely
 */
@Entity
@Table(name="condominio")

public class Condominio implements Serializable{
   @Id
    @SequenceGenerator(name="seq_condominio", sequenceName = "seq_condominio_id",
        allocationSize = 1)
    
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    
    private Integer id;
   
    @Length(max= 50, message ="o nome não pode ter mais de {max} caracteres")
    @NotNull(message ="o nomr não pode ser nulo")//exemplo
    @NotBlank(message="o nome não pode ser em branco")//exemplo
    @Column(name= "nome", length=50, nullable=false)//length eh soh para string   
    private String nome;
    
    @Length(max= 50, message ="o endereco não pode ter mais de {max} caracteres")
    @NotNull(message ="o endereco não pode ser nulo")//exemplo
    @NotBlank(message="o endereco não pode ser em branco")//exemplo
    @Column(name= "endereco", length=50, nullable=false)//length eh soh para string   
    private String endereco;
    
    @Length(max= 50, message ="o numero não pode ter mais de {max} caracteres")
    @NotNull(message ="o numero não pode ser nulo")//exemplo
    @NotBlank(message="o numero não pode ser em branco")//exemplo
    @Column(name= "numero", length=50, nullable=false)//length eh soh para string   
    
    private String numero;
    @Length(max= 50, message ="o cep não pode ter mais de {max} caracteres")
    @NotNull(message ="o cep não pode ser nulo")//exemplo
    @NotBlank(message="o cep não pode ser em branco")//exemplo
    @Column(name= "cep", length=50, nullable=false)//length eh soh para string   
    private String cep;
    
    @ManyToMany
    @JoinTable(name = "requisicao",
            joinColumns = 
            @JoinColumn(name = "condominio", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "recurso", referencedColumnName = "id",
                    nullable = false))    
    private List<Recurso> requerem = new ArrayList<>();//arrumar p recursos
    
      @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)//pessoa nome do atributo
    private List<UnidadeCondominial> unidadecondominial = new ArrayList<>();

    public Condominio() {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Recurso> getRequerem() {
        return requerem;
    }

    public void setRequerem(List<Recurso> requerem) {
        this.requerem = requerem;
    }

    public List<UnidadeCondominial> getUnidadecondominial() {
        return unidadecondominial;
    }

    public void setUnidadecondominial(List<UnidadeCondominial> unidadecondominial) {
        this.unidadecondominial = unidadecondominial;
    }
    
    
}
