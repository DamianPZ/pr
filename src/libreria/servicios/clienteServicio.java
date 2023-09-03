
package libreria.servicios;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Cliente;


public class clienteServicio {
    //(consulta, creación, modificación y eliminación).
    
     EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
     
     public void crearCliente(Cliente cliente){
         try {
             if (cliente == null ) {
                 System.out.println("debe indicar un cliente");
             }
             em.getTransaction().begin();
             em.persist(cliente);
             em.getTransaction().commit();
             
         } catch (Exception e) {
             throw e;
         }
     }     
     
     public Cliente consultarClientePorId(Integer id){
         try {
             Cliente cliente = null;
             cliente = em.find(Cliente.class, id);
            return cliente; 
         } catch (Exception e) {
             throw e;
         }
     }    
     
     public void modificarCliente(Cliente cliente){
         try {
             if (cliente == null) {
                 System.out.println("debe indicar un cliente");
             }
             em.getTransaction().begin();
             em.merge(cliente);
             em.getTransaction().commit();
             
             
         } catch (Exception e) {
             throw e;
         }
     }  
     
     
     public void eliminarClientePorId(Integer id){
         try {
             if (id == null) {
                 System.out.println("debe indicar el id del objeto a eliminar");
             }
             Cliente cliente = new Cliente();
             cliente = em.find(Cliente.class,id);
             
             em.getTransaction().begin();
             em.remove(cliente);
             em.getTransaction().commit();
             
         } catch (Exception e) {
             throw e;
         }
     }     
     
     
     
     
     
     
     
     
     
     
     
     
}
