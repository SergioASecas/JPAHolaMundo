package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.*;

import jpa.Domain.Persona;

public class ClienteEntidadPersona {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        //Inicia la transacción
        et.begin();

        //Crear Objeto a persistir
        Persona persona = new Persona("Sergio", "Villalba", "sergio@gmail", "2342");
       
        log.debug("Objeto a persistir", persona);

        //Persistir Objeto
        em.persist(persona);

        //Ingresar objeto Persistido a la BD
        et.commit();

        log.debug("Objeto Persistido", persona);

        //Cerrar Transacción
        em.close();
    }
}