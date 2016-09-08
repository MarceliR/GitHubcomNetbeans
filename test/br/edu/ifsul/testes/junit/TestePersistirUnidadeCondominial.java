/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes.junit;


import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.UnidadeCondominial;
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
public class TestePersistirUnidadeCondominial {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirUnidadeCondominial() {
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
            UnidadeCondominial u = new UnidadeCondominial();
            u.setNumero("2");
            u.setDescricao("A");
            u.setArea(30.9);
            u.setNumeroQuarto(1);
            u.setPessoa(em.find(Pessoa.class, 1));
            u.setCondominio(em.find(Condominio.class, 1));
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
    
    }
    //comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
    }    
}
