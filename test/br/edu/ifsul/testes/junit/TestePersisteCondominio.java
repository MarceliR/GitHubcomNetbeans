/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Condominio;

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
public class TestePersisteCondominio {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersisteCondominio() {
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
            Condominio c = new Condominio();
            c.setNome("Maria");
            c.setEndereco("Rua A");
            c.setCep("99150000");
            c.setNumero("11");
           
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
    
    }
    //comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
    }    
}
