
package libreria.servicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

public class EditorialServicio {
    
    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    
    public void crearEditorial(Editorial editorial){
        try {
            if (editorial == null) {
                System.out.println("debe indicar una editorial");
            }
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
             throw e;
        }
       
    }    
    
    public Editorial consultarEditorialPorId(Editorial editorial){
        try {
            if (editorial == null) {
                System.out.println("debe indicar una editorial");
            }
            editorial = em.find(Editorial.class, editorial.getId());
            
            
        } catch (Exception e) {
            throw e;
        }
        return editorial;
    }    
    
    
    public void modificarEditorial(String nombre, Boolean Alta){
        try {
            Editorial edit = new Editorial();
            edit.setNombre(nombre);
            edit.setAlta(Alta);
            
            em.getTransaction().begin();
            em.merge(edit);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            throw e;
        }
    }    
    
    public void eliminalEditorial(Integer id){
        try {
            if (id == null) {
                System.out.println("debe indicar una id");
            }
            Editorial editorial = em.find(Editorial.class, id);
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
            throw e;
        }
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
