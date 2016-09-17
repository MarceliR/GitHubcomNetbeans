/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

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
@Table(name="mensalidades")
public class mensalidades {
     @Id
    @SequenceGenerator(name="seq_mensalidades", sequenceName = "seq_mensalidades_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_mensalidades", strategy = GenerationType.SEQUENCE)
    private Integer id;
     
    @Min(value=0)
    @NotNull(message ="o valor não pode ser nulo")
    @Column(name= "valor", nullable=false, columnDefinition = "numeric(12,2)")  
    private Double valor;
    
     
    @NotNull(message ="o vencimento deve ser informado")//exemplo
    @Temporal(TemporalType.DATE)
    @Column(name= "vencimento", nullable=false)
    private Calendar vencimento;
    
    @Min(value=0)
    @NotNull(message ="o valorPagamento não pode ser nulo")
    @Column(name= "valorPagamento", nullable=false, columnDefinition = "numeric(12,2)")  
    private Double valorPagamento;
    
    @NotNull(message ="a dataPagamento deve ser informado")//exemplo
    @Temporal(TemporalType.DATE)
    @Column(name= "dataPagamento", nullable=false)
    private Calendar dataPagamento;
    
    @NotNull(message = "o aluguel nao pode ser nulo")
    @ManyToOne//relacionamento muitos para um
    @JoinColumn(name = "aluguel_id", referencedColumnName = "id", nullable = false)
    private Aluguel aluguel;
    


    public mensalidades() {
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

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final mensalidades other = (mensalidades) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
