
package libreria.servicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Prestamo;

public class prestamoServicio {
     EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
     
       public void crearPrestamo(Prestamo prestamo){
         try {
             if (prestamo == null ) {
                 System.out.println("debe indicar un prestamo");
             }
             em.getTransaction().begin();
             em.persist(prestamo);
             em.getTransaction().commit();
             
         } catch (Exception e) {
             throw e;
         }
     }     
     
      
     public Prestamo consultarPrestamoPorId(Integer id){
         try {
             Prestamo prestamo = null;
             prestamo = em.find(Prestamo.class, id);
            return prestamo; 
         } catch (Exception e) {
             throw e;
         }
     }    
     
      public void modificarPrestamo(Prestamo prestamo){
         try {
             if (prestamo == null) {
                 System.out.println("debe indicar un prestamo");
             }
             em.getTransaction().begin();
             em.merge(prestamo);
             em.getTransaction().commit();
             
             
         } catch (Exception e) {
             throw e;
         }
     }  
     
     public void eliminarPrestamoPorId(Integer id){
         try {
             if (id == null) {
                 System.out.println("debe indicar el id del prestamo a eliminar");
             }
             Prestamo prestamo = new Prestamo();
             prestamo = em.find(Prestamo.class,id);
             
             em.getTransaction().begin();
             em.remove(prestamo);
             em.getTransaction().commit();
             
         } catch (Exception e) {
             throw e;
         }
     }     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
