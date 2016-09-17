/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes.junit;


import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.mensalidades;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcely
 */
public class TestePersistirMensalidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirMensalidade() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("Trabalho_Modelo3_DAW");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try{
           // PessoaFisica pf = em.find(PessoaFisica.class, 1);
           mensalidades m = new mensalidades();
           m.setValor(100.00);
           m.setVencimento(Calendar.getInstance());
           m.setValorPagamento(200.00);
           m.setDataPagamento(Calendar.getInstance());
          Aluguel a = em.find(Aluguel.class, 9);
          a.adicionarMensalidade(m);
         
            em.getTransaction().begin();
            em.merge(m);//em.persist(pf)
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
    
    }
    //comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
    }    
}
