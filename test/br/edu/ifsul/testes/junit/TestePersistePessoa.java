/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes.junit;

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
public class TestePersistePessoa {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistePessoa() {
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
            Pessoa p = new Pessoa();
            p.setNome("Maria");
            p.setCpf("042.436.266-80");
            p.setTelefone("98349834");
            p.setEmail("maria@hotmail.com");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
    
    }
    //comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
    }    
}
