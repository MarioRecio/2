
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class Model {

    public static String abrirFichero() throws IOException {

        File file = new File("original.txt");
        String contenido = "";

        try {
            FileInputStream leer = new FileInputStream(file);

            int caracter = leer.read();

            while (caracter != -1) {
                contenido += (char) caracter;
                caracter = leer.read();
            }
            //System.out.print(contenido);

        } catch (IOException e) {

        }
        return contenido;
    }

    public static int buscarPalabra(String palabra) {
        
        int coincidencias = 0;
        try {

            File file = new File("original.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String linea;

            while ((linea = br.readLine()) != null) {
                
                String[] palabras = linea.split(" ");
                
                for(int i=0;i<palabras.length;i++){
                    if(palabras[i].equalsIgnoreCase(palabra)){
                        coincidencias++;
                    }
                }
                //System.out.println(coincidencias);
            }
            System.out.println(coincidencias);

        } catch (IOException e) {

        }
        return coincidencias;
    }
    
    public static String reemplazarPalabra(String buscar, String remp) throws IOException{
        
        String editado = Model.abrirFichero().replaceAll(buscar, remp);
        
        File file = new File("original.txt");
        
        if(file.exists()){
            file.delete();
            file = new File("original.txt");
            file.createNewFile();
        }
        
        FileWriter fw = new FileWriter(file, true);
        fw.write(editado);
        fw.close();
        
        return editado;
    }

}
