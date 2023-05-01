package Ejercicios_Nuevos_7_4;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5Nuevo {
    static Scanner sc = new Scanner(System.in);
    private static final String DATOS_FILE = "Datos.txt";

    public static void main(String[] args) {

        int opciones;
        do {
            System.out.println(menu());
            opciones = sc.nextInt();
            opciones(opciones);
        } while (opciones != 3);
    }

    public static void opciones(int opciones) {

        switch (opciones) {
            case 1:
                addLinea();
                break;
            case 2:
                mostrarContenido();
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción incorrecta");
                break;
        }
    }

    public static void addLinea() {
        String linea;

        try {
            File archivo = new File(DATOS_FILE);
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATOS_FILE, true));
            if (archivo.exists()) {
                System.out.println("Introduce un texto para escribir en el fichero: ");
                linea = sc.next();
                writer.write(linea);
                writer.newLine();
                writer.flush();
                writer.close();
            } else {
                System.out.println("El fichero no existe");
                archivo.createNewFile();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void mostrarContenido() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(DATOS_FILE));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. Añadir una línea al fichero\n");
        sb.append("2. Mostrar el contenido del fichero\n");
        sb.append("3. Salir\n");
        return sb.toString();
    }
}
