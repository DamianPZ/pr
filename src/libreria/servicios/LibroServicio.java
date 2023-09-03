
package libreria.servicios;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;


public class LibroServicio {
    
      EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
      
       public void crearLibro(Libro libro ) throws Exception{
         try {
             if ( libro == null) {
                 throw new Exception("debe indicar el libro");
             }
             em.getTransaction().begin();
             em.persist(libro);
             em.getTransaction().commit();
             
         } catch (Exception e) {
             throw  e;
         }
         }
       
        public Libro consultarLibro(Libro libro) throws Exception{
        try {
            if (libro == null) {
                throw new Exception("deebe indicar un libro");
            }
           
            libro = em.find(Libro.class, libro.getIsbn());
           
            
        } catch (Exception e) {
            throw e;
        }
        return libro;
    }  
        
         public void modificarLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean Alta, Autor autor, Editorial editorial){
        try {
            
            Libro libro = new Libro();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setAlta(Alta);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            throw e;
        }
        
    }    
       
         public void eliminarLibroPorId(Long id){
        try {
            if (id == null) {
                System.out.println("debe indicar un id");
            }
           
            Libro libro = em.find(Libro.class, id);
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
            throw e;
        }
       
       
      }
         
         //Búsqueda de un libro por ISBN.
         
         public Libro buscarLibroPorIsbn(Long isbn){
             try {
                 Libro libro = em.find(Libro.class, isbn);
                
                 return libro;
             } catch (Exception e) {
                 throw e;
             }
             
         }         
         
         //Búsqueda de un libro por Título.
         
         public Libro buscarLibroPorTitulo(String titulo){
             try {
                Libro libro;
                libro = (Libro) em.createQuery("SELECT a FROM Libro a"+
                        " WHERE a.titulo = :titulo").setParameter("titulo", titulo).getSingleResult();
                 return libro;
             } catch (Exception e) {
                 throw e;
             }
         }         
         
         //busqueda de un libro por nombre de autor
         
         public Libro buscarLibroPorAutor(String nombre){
             try {
                Libro  libro;
                libro = (Libro) em.createQuery("SELECT l FROM Libro l INNER JOIN "+
                        "Autor a").setParameter("nombre", nombre).getResultList();
                       
                 return libro;
             } catch (Exception e) {
                 throw e;
             }
         }        
         
         
         public List<Libro> buscarLibrosPorTitulo(String titulo){
             try {
               
                List<Libro> libros =  em.createQuery("SELECT l FROM Libro l "+
                        " WHERE l.titulo = :titulo").setParameter("titulo" , titulo).getResultList();
                       
                 return libros;
             } catch (Exception e) {
                 throw e;
             }
         }        
         
          public List<Libro> buscarLibroPorEditorial(Editorial editorial){
             try {
                 
             List<Libro>   libros = em.createQuery("SELECT l FROM Libro l "+ 
                        "WHERE l.editorial = :editorial" ).setParameter("editorial", editorial).getResultList(); 
                       
                       
                 return libros;
             } catch (Exception e) {
                 throw e;
             }
         }        
         
         
         
         
    
}
