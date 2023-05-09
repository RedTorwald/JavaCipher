import java.sql.SQLOutput;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //INPUT
        Scanner input = new Scanner(System.in);
        System.out.println("Input a text: ");
        String txt = input.nextLine();
        System.out.println("Input a key: ");
        String KEY = input.nextLine();
        int Num = txt.length();

        char[] text = txt.toCharArray();
        char[] charKey = KEY.toCharArray();
        char[] key = new char[txt.length()];

        for (int i=0; i<txt.length(); i++){
            System.out.print(text[i]);
        }
        System.out.println();

        //FIRST METHOD: writing right key
        int l=0;
        for (int i=0; i<txt.length(); i++){
            if (l>KEY.length()){
                l=Math.abs(l-KEY.length());
                System.out.println("tut");
                key[i]=charKey[l];
                l++;
            }
            else if(l==KEY.length()){
                l=Math.abs(l-KEY.length());
                System.out.println("tut");
                key[i]=charKey[l];
                l++;
            }
            else{
                key[i]=charKey[l];
                l++;
            }
        }

        String TEXT = new String();
        String KEYstr = new String();
        for (int i=0; i<txt.length(); i++){
            TEXT+=text[i];
            KEYstr+=key[i];
        }

        for(int i = 0; i < KEYstr.length() ; i++){
            System.out.print(key[i]);
        }
        System.out.println();

        //SECOND METHOD: cipher
        int ASCII = 26; //Количество задействованных символов
        int beginASCII = 65; //Инициализируем первым символом 'A'
        char[] alphabetBoard = new char[ASCII];//Размер доски - промежуток между(включая) 65 и 90 ASCII
        String cipher = new String();

        for(int i = 0; i < ASCII; i++){
            alphabetBoard[i] = (char) beginASCII++;  //запись алфавита
        }
        //Бежим по алфавитной доске и сравниваем значения
        // for(int j = 0; j < txt.length(); j++)
        for(int j = 0; j < TEXT.length(); j++)
        {
            //Поиск буквы текста в алфавите
            for(int i = 0; i < ASCII; i++)
            {
                if(alphabetBoard[i] == TEXT.charAt(j))
                {
                    //Если нашли, переходим к ключу
                    for(int k = 0; k < ASCII; k++)
                    {
                        //Поиск буквы ключа в алфавите
                        if(alphabetBoard[k] == KEYstr.charAt(j))
                        {
                            //Если нашли переходим к выявлению шифро-буквы
                            int cryptLetter = (i + k) % ASCII; //Индекс буквы текста + индекс ключа % на алфавит
                            cipher+=alphabetBoard[cryptLetter];
                        }
                    }
                }
            }

        }
        System.out.println();
        System.out.print(cipher);

        //THIRD METHOD: decipher
        String decipher = new String();
        for(int j = 0; j < cipher.length(); j++)
        {
            //Поиск буквы текста в алфавите
            for(int i = 0; i < ASCII; i++)
            {
                if(alphabetBoard[i] == cipher.charAt(j))
                {
                    //Если нашли, переходим к ключу
                    for(int k = 0; k < ASCII; k++)
                    {
                        //Поиск буквы ключа в алфавите
                        if(alphabetBoard[k] == KEYstr.charAt(j))
                        {
                            //Если нашли переходим к выявлению шифро-буквы
                            int encryptLetter = (i - k) % ASCII; //Индекс буквы текста + индекс ключа % на алфавит
                            decipher+=alphabetBoard[encryptLetter];
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.print(decipher);


    }
}