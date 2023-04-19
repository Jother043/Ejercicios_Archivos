import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EjemploNIO1 {
    public static void main(String[] args) {
        long size;
        try{
            size = Files.walk(Paths.get("PruebaDirectorio"))
                    .parallel()
                    .filter(p -> p.toFile().isFile())
                    .mapToLong(p -> p.toFile().length()).sum();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tamaño total: " + size);
    }
}
