
package libreria.servicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;



public class AutorServicio {
    
  
    
     EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
     
     public void crearAutor(Autor autor) throws Exception{
         try {
             if ( autor == null) {
                 System.out.println("debe indicar un autor");
                } 
         
                 em.getTransaction().begin();
                 em.persist(autor);
                 em.getTransaction().commit();
         
         } catch (Exception e) {
             throw  e;
         }
         
          
         
     }     
      
     
     
     
     
    public Autor consultarAutor(Autor autor) throws Exception{
        try {
            if (autor == null) {
                throw new Exception("deebe indicar un autor");
            }
           
            autor = em.find(Autor.class, autor.getId());
           
            
        } catch (Exception e) {
            throw e;
        }
        return autor;
    }  
    
    public void modificarAutor(String nombre , Boolean alta){
        try {
            
            Autor aut = new Autor();
            aut.setNombre(nombre);
            aut.setAlta(alta);
            
            em.getTransaction().begin();
            em.merge(aut);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            throw e;
        }
        
    }    
    
    public void eliminarAutorPorId(Integer id){
        try {
            if (id == null) {
                System.out.println("debe indicar un id");
            }
            Autor autor = new Autor();
            autor = em.find(Autor.class, autor.getId());
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
            throw e;
        }
    }   
    
        public Autor buscarAutorPorNombre(String nombre){
            try {
                if (nombre == null) {
                    System.out.println("debe indicar un nombre");
                }
                Autor autor;
                autor = (Autor) em.createQuery("SELECT a FROM Autor"+
                        " a WHERE a.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
               return autor;
                
            } catch (Exception e) {
                throw e;
            }
            
            
        }    
    
    
    
    
}
