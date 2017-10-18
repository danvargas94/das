
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Imagenes class facilitates the use of images in the project (gif, jpg or png)
 * This class was taken from a previous course (video games)
 * @author danielavargas
 *
 */
public class Imagenes {

       private static Imagenes instancia=null;
       private HashMap<String,ImageIcon>gifs = new HashMap<String,ImageIcon>();
       private HashMap<String,BufferedImage>imgs = new HashMap<String,BufferedImage>();
      
       public static Imagenes Singleton()
       {
           if(instancia==null)
             instancia = new Imagenes();
           return instancia;
       }
       
       /**
        * Allows you to upload images from the given folder
        * @param carpeta folder
        */
       public void cargaCarpeta(String carpeta){
          File acceso = new File(carpeta);
          String archivos[] = acceso.list();
          for(int i=0; i<archivos.length; i++)
          {
              String llave=archivos[i];
              if(llave.endsWith(".gif"))
              {
                  ImageIcon nuevoGif = new ImageIcon(carpeta + "/" + llave);
                  gifs.put(llave, nuevoGif);
              }
              if(llave.endsWith(".jpg") || llave.endsWith(".png"))
              {
                  BufferedImage nuevaImg = null;
                  try {
                      nuevaImg = ImageIO.read(new File(carpeta + "/" + llave));
                  } catch (IOException ex) {
                      System.out.println(ex);
                  }
                  imgs.put(llave, nuevaImg);
              }
          }
       }
       
       /**
        * Deletes the given folder
        * @param carpeta folder
        */
       public void eliminaCarpeta(String carpeta){
          File acceso = new File(carpeta);
          String archivos[] = acceso.list();
          for(int i=0; i<archivos.length; i++)
          {
              String llave=archivos[i];
              if(llave.endsWith(".gif"))
              {
                  gifs.remove(llave);
              }
              if(llave.endsWith(".jpg") || llave.endsWith(".png"))
              {
                  imgs.remove(llave);
              }
          }
       }
       
       /**
        * Returns the image 
        * @param nombre image
        * @return image
        */
       Image imagen(String nombre){
           if(nombre.endsWith(".gif"))
           {
              return gifs.get(nombre).getImage();
           }
           if(nombre.endsWith(".jpg") || nombre.endsWith(".png"))
           {
              return imgs.get(nombre);
           }
           return null;
       }
       
       Image fragmento(String nombre, int xini, int yini, int ancho, int alto){
           if(nombre.endsWith(".gif"))
           {
              BufferedImage imagen=(BufferedImage)gifs.get(nombre).getImage();
              return imagen.getSubimage(xini, yini, ancho, alto);
           }
           if(nombre.endsWith(".jpg") || nombre.endsWith(".png"))
           {
              return imgs.get(nombre).getSubimage(xini, yini, ancho, alto);
           }
           return null;
       }    
}

