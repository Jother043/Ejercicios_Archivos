package Ejercicios_Nuevos_7_4;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Ejercicio6Nuevo {
    static Scanner sc = new Scanner(System.in);
    private static final String DATOS_FILE = "bitacora.txt";
    private static final int MAX_SIZE = 100;
    private static final int NUM_LINEA = 1;

    public static void main(String[] args) {
        int opciones;
        do {
            System.out.println(menu());
            opciones = (sc.nextInt());
            opciones(opciones);
        } while (opciones != 3);
    }

    public static String menu() {
        return "1. Añadir línea\n"
                + "2. Mostrar contenido\n"
                + "3. Salir\n"
                + "Elige una opción: ";
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

        Scanner fileScanner = new Scanner(DATOS_FILE);
        fileScanner.nextLine();
        try {
            String linea;
            File archivo = new File(DATOS_FILE);
            BufferedWriter writer = new BufferedWriter(new FileWriter(DATOS_FILE, true));
            if(archivo.length() > MAX_SIZE) {
                while (!fileScanner.hasNextLine()) {
                    String next = fileScanner.nextLine();
                    linea = fileScanner.nextLine();
                    if (next.equals("\n")) {
                        writer.newLine();
                    } else {
                        writer.write(linea);

                    }
                    writer.newLine();
                }
                System.out.println("Introduce un texto para escribir en el fichero: ");
                linea = sc.next();
                writer.write(linea);
                writer.flush();
                writer.close();
            }else{
                System.out.println("Introduce un texto para escribir en el fichero: ");
                linea = sc.next();
                writer.write(linea);
                writer.newLine();
                writer.flush();
                writer.close();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void mostrarContenido() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATOS_FILE))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

