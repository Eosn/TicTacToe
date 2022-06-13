
package jogodavelha;

/**
 * @author Éllen Oliveira Silva Neves
 */

public class Tabuleiro {
    protected char[][] tab = new char[][] {new char[3], 
                                         new char[3], 
                                         new char[3]};

    public Tabuleiro() {
    }

    public char[][] getTab() {
        return tab;
    }

    public void setTab(char[][] tab) {
        this.tab = tab;
    }
    
    public void jogada(Jogador j, int linha, int coluna) throws JogadaImpossivelException, ArrayIndexOutOfBoundsException {
        if (tab[linha][coluna] == 0) {
            tab[linha][coluna] = j.getCaracter();
        } else if (linha > 2 || coluna > 2) {
            throw new ArrayIndexOutOfBoundsException("Erro: o campo não existe.");
        } else {
            throw new JogadaImpossivelException("Erro: o campo já foi preenchido.");
        }
        
    }
    
    public boolean acabou() {
        if ((tab[0][0] == tab[0][1] && tab[0][1] == tab[0][2] && tab[0][1] != 0) || //linhas preenchida
            (tab[1][0] == tab[1][1] && tab[1][1] == tab[1][2] && tab[1][0] != 0) ||
            (tab[2][0] == tab[2][1] && tab[2][1] == tab[2][2] && tab[2][0] != 0) ||
            (tab[0][0] == tab[1][0] && tab[1][0] == tab[2][0] && tab[0][0] != 0) || //colunas preenchida
            (tab[0][1] == tab[1][1] && tab[1][1] == tab[2][1] && tab[0][1] != 0) ||
            (tab[0][2] == tab[1][2] && tab[1][2] == tab[2][2] && tab[0][2] != 0) ||
            (tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2] && tab[0][0] != 0) || //diagonais preenchida
            (tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0] && tab[0][2] != 0)) 
            return true;
        return false;
    }

    public void printaTab() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print(tab[i][j]);
                }
            }
            System.out.println();
        }

    }
    
}
