import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Labirinto {

    //atributo
    private char [][] labirinto;
    private boolean [][] visitados;


 /*na classe Labirinto, crie um método chamado criaLabirinto, que
recebe uma String filename, que corresponde a um arquivo que
contém a estrutura do labirinto, conforme supracitado. Este método abre
o arquivo filename para leitura e preenche o labirinto.*/

    public void criaLabirinto(String filename)throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();


        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();

        int numeroLinha = 0;
        labirinto = new char[lines][lines];
        visitados = new boolean[lines][lines];

        while(line != null){
           labirinto[numeroLinha] = line.toCharArray();

           line = br.readLine();
           numeroLinha++;
        }

        br.close();

        visitados = new boolean[labirinto.length][labirinto[0].length];

    }

    /* ainda na classe Labirinto, você deve criar um método para andar no
labirinto. Este método deve retornar verdadeiro, caso haja pelo menos uma
saída para este labirinto, ou falso caso contrário. Entretanto, este método
deve ser recursivo (com os métodos público e privado). Seu método público
não recebe parâmetros e deve ser nomeado percorreLabirinto. */


    public boolean percorreLabirinto()throws IllegalArgumentException{
        if( labirinto == null){ throw new IllegalArgumentException(); }

        return percorreLabirinto(0, 0);
    }

    private boolean percorreLabirinto(int linha,int coluna){
        if (linha < 0 || linha > labirinto.length-1 || coluna < 0 || coluna > labirinto[linha].length-1 || visitados[linha][coluna]) {
            return false;
        }

        this.visitados[linha][coluna] = true;

        if(labirinto[linha][coluna] != ' ' && labirinto[linha][coluna] != 'D') {
            return false;
        }

        if(labirinto[linha][coluna] == 'D'){
            return true;
        }

        //para o lado esquerdo
        if (percorreLabirinto(linha, coluna - 1)) {
            return true;
        }

        //para o lado direito
        if (percorreLabirinto(linha, coluna + 1)) {
            return true;
        }

        //para cima
        if (percorreLabirinto(linha-1, coluna)) {
            return true;
        }

        //para baixo
        if (percorreLabirinto(linha+1, coluna)) {
            return true;
        }

        return false;
    }












}
