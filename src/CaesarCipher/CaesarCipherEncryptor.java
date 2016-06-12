package CaesarCipher;
/**
 * Class implementing Caesar Cipher Encryptor
 */
public class CaesarCipherEncryptor {

    final String ALPHABET_LOWER_CASE = "aąbcćdeęfghijklłmnńoóprsśtuwyzźż";  // Wielkie i małe litery Polskiego alfabetu
    final String ALPHABET_UPPER_CASE = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ";

    /**
     * Encrypts a Polish character in Caeser Cipher using the key.
     * If sign is not in Polish alphabet, method returns this sign.
     * @param sign The sign to encrypt.
     * @param key  The key used to encrypt.
     * @return Sign - encrypting results.
     */
   public char encrypt (char sign, int key){
     char result=' ';
     if( ! isPolishChar(sign) )
         result = sign;
     else{
         for(int i = 0; i < 32 ; i++){
             if(sign == ALPHABET_LOWER_CASE.charAt(i)) {
                 result = ALPHABET_LOWER_CASE.charAt((i + key) % 32);
                 break;
             }
             else if (sign == ALPHABET_UPPER_CASE.charAt(i)) {
                 result = ALPHABET_UPPER_CASE.charAt((i + key) % 32);
                 break;
             }
         }
     }
        return result;
    }

    /**
     * Checking if sign is in Polish alphabet.
     * @param sign The sign to check.
     * @return True if sign is in Polish alphabet.
     */

    public boolean isPolishChar (char sign){
        if ((sign >= 97 && sign <= 122) || (sign >= 65 && sign <= 90) || sign == 'Ą' || sign == 'ą' || sign == 'ć' ||
                sign == 'Ć' || sign == 'Ę' || sign == 'ę' || sign == 'Ł' || sign == 'ł' || sign =='Ń' || sign == 'ń'||
                sign == 'Ó'|| sign == 'ó' ||  sign == 'Ś' || sign == 'ś' || sign == 'Ź' || sign == 'ź' || sign == 'ż' ||
                sign == 'Ż')
            return true;

        return false;
    }
}
