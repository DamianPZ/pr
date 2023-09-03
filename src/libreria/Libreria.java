
package libreria;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Cliente;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;

import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.clienteServicio;
import libreria.servicios.prestamoServicio;


public class Libreria {

    public static void main(String[] args) throws Exception {
      EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
      
      LibroServicio libroser = new LibroServicio();
      EditorialServicio editser = new EditorialServicio();
      AutorServicio autorser = new AutorServicio();
      clienteServicio clienteser = new clienteServicio();
      prestamoServicio prestamoser = new prestamoServicio();
      
      
      //Autor autor = new Autor("chino", true);
        //System.out.println(autorser.buscarAutorPorNombre("chino"));
        
      
      Editorial editorial1 = new Editorial("malena perez", true);
      
      editser.crearEditorial(editorial1);
      //editser.eliminalEditorial(351);
      
      
      
    //libroser.crearLibro(new Libro( "como joder todo el dia", 4, 5, 9, 4, false, null,editorial1));
    //libroser.eliminarLibroPorId(501L);
    
        //System.out.println(libroser.buscarLibroPorIsbn(601L));
    
      //buscar libro por titulo
       // System.out.println( libroser.buscarLibroPorTitulo("poo"));
       
       
        //System.out.println( libroser.buscarLibrosPorAutor("cristina medina"));
      
      /*List<Libro> librosEncontrados = libroser.buscarLibrosPorTitulo("cristina medina");
      
        for (Libro libro : librosEncontrados) {
         System.out.println(libro.getTitulo()); // Imprime el título del libro encontrado
        }*/

       //clienteser.crearCliente(new Cliente (55L, "negro", "perez", "57452212"));
        
        //System.out.println(clienteser.consultarClientePorId(1351));
        
       Cliente cliente = new Cliente(39480065L, "chino", "perez", "3815780035");
       
       /* cliente= em.find(Cliente.class, 1401);*/
        
       /* cliente.setDocumento(39480036L);
        cliente.setNombre("negro hdp");
        cliente.setApellido("medina");
        cliente.setTelefono("3814521205");*/
        
        clienteser.crearCliente(cliente);
        
        
       // clienteser.eliminarClientePorId(1401);
        Libro libro1 = new Libro("caperusita roja", 1950, 150, 45, 59, true, null, editorial1);
        libroser.crearLibro(libro1);
        
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
           String fechaInicioStr = "12/03/1993";
        String fechaFinStr = "12/03/2023";
        
        Date fechaInicio = sdf.parse(fechaInicioStr);
        Date fechaFin = sdf.parse(fechaFinStr);
        
       // prestamoser.crearPrestamo(new Prestamo(fechaInicio, fechaFin, libro1, cliente));
        
        
        
        
        
        
    }
    
}
