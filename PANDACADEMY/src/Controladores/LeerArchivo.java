package Controladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerArchivo {

    static File archivo = new File("");

    public static String leer(String ruta) {
        String line = "";
        try {
            FileReader _objfrReader = new FileReader(archivo.getAbsolutePath() + ruta);
            BufferedReader input = new BufferedReader(_objfrReader);
            while (input.ready()) {
                line = line + input.readLine() + " ";
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return line;
    }
}
