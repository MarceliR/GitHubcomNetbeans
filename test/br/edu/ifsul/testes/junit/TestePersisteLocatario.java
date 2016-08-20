/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Pessoa;

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
public class TestePersisteLocatario {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersisteLocatario() {
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
            Locatario l = new Locatario();
           
            l.setNome("Joao");
            l.setCpf("053.543.123-50");
            l.setTelefone("54 33113244");
            l.setEmail("joao@hotmail.com");
           
            l.setLocalTrabalho("setor A");
            l.setTelefoneTrabalho("54 33112131");
            l.setRenda(880.00);
            
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
    
    }
    //comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
    }    
}
