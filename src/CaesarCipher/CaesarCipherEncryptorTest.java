package CaesarCipher;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests CaserCipherEncryptor.
 */
public class CaesarCipherEncryptorTest {
    @Test
    public void encrypt() throws Exception {
        CaesarCipherEncryptor Cezar = new CaesarCipherEncryptor();
        assertEquals(Cezar.encrypt('a',1),'ą');
        assertEquals(Cezar.encrypt('b',1),'c');

        assertEquals(Cezar.encrypt('A',10),'H');
        assertEquals(Cezar.encrypt('B',2),'Ć');

        assertEquals(Cezar.encrypt(' ',5),' ');
        assertEquals(Cezar.encrypt('[',10),'[');

    }

    @Test
    public void isPolishChar() throws Exception {
        CaesarCipherEncryptor Cezar = new CaesarCipherEncryptor();

        assertTrue(Cezar.isPolishChar('ą'));
        assertTrue(Cezar.isPolishChar('A'));
        assertTrue(Cezar.isPolishChar('d'));
        assertTrue(Cezar.isPolishChar('F'));
        assertTrue(Cezar.isPolishChar('Ż'));
        assertTrue(Cezar.isPolishChar('Ł'));
        assertTrue(Cezar.isPolishChar('ł'));

        assertFalse(Cezar.isPolishChar(' '));
        assertFalse(Cezar.isPolishChar(';'));
        assertFalse(Cezar.isPolishChar(']'));
    }


}