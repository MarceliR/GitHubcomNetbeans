/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Marcely
 */
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)//
@Table(name="unidadecondominial")
public class UnidadeCondominial implements Serializable{
     @Id
    @SequenceGenerator(name="seq_unidadecondominial", sequenceName = "seq_unidadecondominial",
        allocationSize = 1)
    
    @GeneratedValue(generator = "seq_unidadecondominial", strategy = GenerationType.SEQUENCE)
    private Integer id;
     
    @Length(max= 50, message ="o numero não pode ter mais de {max} caracteres")
    @NotNull(message ="o numero não pode ser nulo")//exemplo
    @NotBlank(message="o numero não pode ser em branco")//exemplo
    @Column(name= "numero", length=50, nullable=false)//length eh soh para string 
    private String numero;
    
    @Length(min = 0, message ="a descricao deve ter no mínimo {min} caracteres")
    @NotNull(message ="a descricao não pode ser nulo")//exemplo
    @NotBlank(message="a descricao não pode ser em branco")//exemplo
    @Column(name= "descricao",  nullable=false)
    private String descricao;
    
    @Min(value=0)
    @NotNull(message ="a area não pode ser nula")
    @Column(name= "area", nullable=false, columnDefinition = "numeric(12,2)")
    private Double area;
    
    @Column(name= "numeroQuarto", nullable=false)
    private Integer numeroQuarto;
    
    @ManyToOne
    @JoinColumn(name="pessoa", referencedColumnName="id",nullable=false)
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name="condominio", referencedColumnName="id",nullable=false)
    private Condominio condominio;
    
    

    public UnidadeCondominial() {
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
