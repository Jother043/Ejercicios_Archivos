import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1_2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String opcion = "";
        do {
            System.out.println(menu());
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    crearDirectorio();
                    break;
                case "2":
                    crearFichero();
                    break;
                case "3":
                    borrarFichero();
                    break;
                case "4":
                    mostrarFicheros();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("5"));

    }

    public static String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("1. Crear directorio.\n");
        sb.append("2. Crear fichero de texto.\n");
        sb.append("3. Borrar fichero de texto.\n");
        sb.append("4. Mostrar ficheros que contiene la carpeta.\n");
        sb.append("5. Salir.\n");
        return sb.toString();
    }

    public static void crearDirectorio() {
        System.out.println("Introduce el nombre del directorio: ");
        String nombre = sc.nextLine();

        File directorio = new File(nombre);
        if (!directorio.exists()) {
            directorio.mkdir();
            System.out.println("El directorio se ha creado correctamente");
        } else {
            System.out.println("El directorio ya existe");
        }
    }

    public static void crearFichero() {
        System.out.println("Introduce el nombre del fichero: ");
        String nombre = sc.nextLine();

        File fichero = new File(nombre);
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
                System.out.println("Introduce el contenido del fichero: ");
                String contenido = sc.nextLine();
                bw.write(contenido);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("El fichero se ha creado correctamente");
            }
        } else {
            System.out.println("El fichero ya existe");
        }
    }

    public static void borrarFichero(){
        System.out.println("Introduce el nombre del fichero: ");
        String nombre = sc.nextLine();
        File fichero = new File(nombre);
        if(fichero.exists()) {
            fichero.delete();
            System.out.println("El fichero se ha borrado correctamente");
        } else {
            System.out.println("El fichero no existe");
        }
    }

    public static void mostrarFicheros(){
        System.out.println("Ficheros del directorio actual: ");
        String nombre = sc.nextLine();
        File directorio = new File(nombre);
        String[] ficheros = directorio.list();
        for (int i = 0; i < ficheros.length; i++) {
            System.out.println(ficheros[i]);
        }
    }
}
