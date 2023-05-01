package Ejercicios_Nuevos_7_4;

import java.io.*;
import java.util.Vector;

public class ejercicio6 {

    public class EjemploTexto {
        private static File archivo = null;
        private static FileWriter fichero = null;
        private static FileReader fr = null;
        private static BufferedReader br = null;
        private static PrintWriter escrive = null;

        public static void main(String[] args) {
            LeerArchivo();
            System.out.println("Ejemplo borrando la linea numero 3 ");
            int n = 3;
            BorrarLinea(n);
            GuardarArchivo();
            LeerArchivo();
        }

        public static void GuardarArchivo() {
            try {
                fichero = new FileWriter("c:/prueba.txt");
                escrive = new PrintWriter(fichero);
                for (int i = 0; i < lineas.size(); i++) {
                    escrive.println(lineas.elementAt(i));
                }
                fichero.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static Vector lineas = new Vector();

        public static void LeerArchivo() {
            System.out.println("Leyendo archivo");
            try {
                archivo = new File("C:\\prueba.txt");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void BorrarLinea(int n) {
            try {
                archivo = new File("C:\\prueba.txt");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea;
                int cont = 0;
                String completo = "";
                while ((linea = br.readLine()) != null) {
                    cont++;
                    if (cont != n) {
                        lineas.addElement(linea);//AGREGAR LINEASS A UN VECTOR
                    }
                }
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
