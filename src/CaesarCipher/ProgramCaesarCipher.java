package CaesarCipher;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *The main class of the program
 */
public class ProgramCaesarCipher {
    /**
     * Method that launches CaeserCipherEncryptor.
     * @param args args[0] - The title of  the file with text to encrypt (String).
     *             args[1] - The Value of key used for encryption (int, positive or negative value).
     */

    public static void main(String[] args) {

        int key = 0;
        if (args.length != 2) {
            System.out.println("Bład - Nalezy wprowadzic dwa argumenty");
            System.exit(1);
        }
        try {
            key = Integer.parseInt(args[1]);

        } catch (NumberFormatException e) {
            System.err.println("Drugi argument musi byc liczbą całkowitą");
            System.exit(1);
        }
        while (key < 0) // Można używać ujemnych kluczy. Działania wykonywanywane w modulo 32
            key +=32 ;
        String buffer = readFile(args[0]); // buffor przechowujący tekst do zaszfrowania
        writeFile(buffer, key);
    }

    /**
     * Reading from file to buffer.
     * @param fileTitle The title of  the file with text to encrypt.
     * @return Buffer that stores text to encrypt.
     */
    public static String readFile(String fileTitle) {
        File file = new File(fileTitle);
        String inputBuffer = "";
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine())
                inputBuffer += in.nextLine() + "\n";
        } catch (FileNotFoundException e) {
            System.err.println("Nie znaleziono pliku");
        }
        return inputBuffer;
    }

    /**
     * Encrypts buffer using a key and write it to the new file.
     * @param inputBuffer Buffer that stores text to encrypt.
     * @param key The key used for encryption.
     */

    public static void writeFile(String inputBuffer, int key) {
        String outputBuffer = "";
        CaesarCipherEncryptor Caesar = new CaesarCipherEncryptor();
        for (int i = 0; i < inputBuffer.length(); i++) {
            outputBuffer += (char) Caesar.encrypt(inputBuffer.charAt(i), key);
        }
        try {
            PrintWriter out = new PrintWriter("Result.txt");
            out.print(outputBuffer);
            out.close();
        } catch (FileNotFoundException e) {
            System.err.println("Niestety, nie mogę utworzyc pliku");
        }
    }
}
