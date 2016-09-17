/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcely
 */
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table

public class Aluguel implements Serializable{
    
     @Id
     @SequenceGenerator(name="seq_aluguel", sequenceName = "seq_aluguel_id",
        allocationSize = 1)
    
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    
    private Integer id;
     
    @Min(value=0, message = "valor não pode ser negativo")
    @NotNull(message ="o valor não pode ser nulo")
    @Column(name= "valor", nullable=false, columnDefinition="numeric(12,2)")
    private Double valor;
    
    @Temporal(TemporalType.TIMESTAMP)//data e hora
    @NotNull(message ="inicioContrato deve ser informado")//exemplo
    @Column(name= "inicioContrato", nullable=false)
    private Calendar inicioContrato;
     
    @Temporal(TemporalType.TIMESTAMP)//data e hora
    @NotNull(message ="fimContrato deve ser informado")//exemplo
    @Column(name= "fimContrato", nullable=false)
    private Calendar fimContrato;
    
    @Min(value=0)
    @NotNull(message ="dia de Vencimento não podem ser nulas")
    @Column(name= "dia_de_vencimento",nullable=false)
    private Integer diaVencimento;
    
    @NotNull(message ="a unidadecondominial deve ser informada")//exemplo
    @ManyToOne
    @JoinColumn(name="unidadecondominial", referencedColumnName="id",nullable=false)
    private UnidadeCondominial unidadecondominial;
    
    
    @NotNull(message ="a locatario deve ser informada")//exemplo
    @ManyToOne
    @JoinColumn(name="locatario", referencedColumnName="id",nullable=false)
    private Locatario locatario;

    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)//pessoa nome do atributo
    private List<mensalidades> mensalidades = new ArrayList<>();
    
    public Aluguel() {
    }
    
    public void adicionarMensalidade(mensalidades obj){
        obj.setAluguel(this);
        this.mensalidades.add(obj);     
    }
    
    public void removerMensalidade(int index){
        this.mensalidades.remove(index);
    } 
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Calendar getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   

    public UnidadeCondominial getUnidadecondominial() {
        return unidadecondominial;
    }

    public void setUnidadecondominial(UnidadeCondominial unidadecondominial) {
        this.unidadecondominial = unidadecondominial;
    }
    
    
    
}
