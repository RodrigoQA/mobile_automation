package Pages.ApplicationRealPages;

import java.util.Random;

public class Utils {
    public String gerarLetras() {
        String letras = "abcdefghijklstuvxwyzopq";

        Random random = new Random();

        String armazenaChaves = "";
        int index = -1;
        for (int i = 0; i < 4; i++) {
            index = random.nextInt(letras.length());
            armazenaChaves += letras.substring(index, index + 1);
        }
        return armazenaChaves;
    }

}