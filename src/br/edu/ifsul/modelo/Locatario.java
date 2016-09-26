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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table
public class Locatario extends Pessoa implements Serializable{
    @Min(value=0)
    @NotNull(message ="a renda não pode ser nula")
    @Column(name= "renda", nullable=false, columnDefinition = "numeric(12,2)")
    private Double renda;
    
    @Length(max= 50, message ="o localTrabalho não pode ter mais de {max} caracteres")
    @NotNull(message ="o localTrabalho não pode ser nulo")//exemplo
    @NotBlank(message="o localTrabalho não pode ser em branco")//exemplo
    @Column(name= "localTrabalho", length=50, nullable=false) 
    private String localTrabalho;
    
    @Length(max= 50, message ="o telefoneTrabalho não pode ter mais de {max} caracteres")
    @NotNull(message ="o telefoneTrabalho não pode ser nulo")//exemplo
    @NotBlank(message="o telefoneTrabalho não pode ser em branco")//exemplo
    @Column(name= "telefoneTrabalho", length=20, nullable=false) 
    private String telefoneTrabalho;

    public Locatario() {
    }
    
    

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.renda);
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
        final Locatario other = (Locatario) obj;
        if (!Objects.equals(this.renda, other.renda)) {
            return false;
        }
        return true;
    }
    
}
