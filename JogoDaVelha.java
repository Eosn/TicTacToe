
package jogodavelha;
import java.util.Scanner;

/**
 * @author 20202BSI0071
 */

public class JogoDaVelha {
    
    public static void main(String[] args) {
        
        Tabuleiro tab = new Tabuleiro();
        Jogador jog = new Jogador('X');
        int jogador = 1;
        Scanner s = new Scanner(System.in);
        boolean fim = tab.acabou();
        int linha;
        int coluna;
        boolean deuerro;
        
        while (!fim) {
            tab.printaTab();
            if (jogador == 1) {
                jog.setCaracter('X');
                jogador = 0;
            } else {
                jog.setCaracter('O');
                jogador = 1;
            }
            
            System.out.println("\n----- Vez do jogador " + jog.getCaracter() + " -----");
            deuerro = true;
            while (deuerro) { //continua no loop enquanto não tiver jogado (aka enquanto não inserir um campo válido)
                System.out.print("Digite a linha: ");
                linha = s.nextInt() - 1;
                System.out.print("Digite a coluna: ");
                coluna = s.nextInt() - 1;

                try {
                    tab.jogada(jog, linha, coluna);
                    deuerro = false;
                } catch (JogadaImpossivelException | ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Tente novamente e insira um campo válido.");
                    deuerro = true;
                }
                
            }

            fim = tab.acabou();
        }
        System.out.println("\nO jogo acabou! Resultado: ");
        tab.printaTab();
        s.close();
    }
}
