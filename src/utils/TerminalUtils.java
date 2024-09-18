package utils;

import java.io.IOException;

public class TerminalUtils {
    
    // Método estático para limpar o terminal
    public static void limparTerminal() {
        try {
            // Detecta o sistema operacional
            String sistemaOperacional = System.getProperty("os.name").toLowerCase();

            if (sistemaOperacional.contains("win")) {
                // Executa o comando "cls" para Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Executa o comando "clear" para Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}