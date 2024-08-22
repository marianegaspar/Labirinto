import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Labirinto labirinto = new Labirinto();

        try {
            labirinto.criaLabirinto("test.txt");

            System.out.println(labirinto.percorreLabirinto());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello world!");
    }
}