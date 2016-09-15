/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;

import br.edu.ifsul.modelo.UnidadeCondominial;
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
public class TestePersisteAluguel {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersisteAluguel() {
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
            Aluguel a = new Aluguel();
            a.setValor(550.00);
            a.setLocatario(em.find(Locatario.class, 8));
            a.setUnidadecondominial(em.find(UnidadeCondominial.class, 1));
            a.setFimContrato(Calendar.getInstance());
            a.setInicioContrato(Calendar.getInstance());
            a.setDiaVencimento(12);
            
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
    
    }
    //comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
    }    
}
