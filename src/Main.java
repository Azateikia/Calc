import java.io.IOException;
import java.util.Scanner;

public class Main {


    static String result;

    public static void main(String[] args) {
        result = calc(" ");



    }

    public static String calc(String inputString) {

        int a ;

        int b ;
        char op = ' ';
        int rez = 0;
        boolean bo = true;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] arrStr ;
        arrStr= input.split(" ");




        String s0 = arrStr[0]; // i || 1 ...
        String s1 = arrStr[1]; // + || - || * || /
        String s2 = arrStr[2]; // ii || 2 ...
        if (arrStr.length>3){
            System.out.println(" слшиком много всего");
            System.exit(0);
        }
//        String s3 = arrStr[3]; // null
//        if (s3 != "ghjdjngdng"){ // что-то не то
//            System.out.println(" слшиком много всего");
//            System.exit(0);
//        }              Жаль, не сработало...





        try {
            if (s1.equals("+")) {
                op = '+';
            }else
            if (s1.equals("-")) {
                op = '-';
            }else
            if (s1.equals("*")) {
                op = '*';
            }else
            if (s1.equals("/")) {
                op = '/';
            }else
                throw new IOException();

        } catch (IOException e){
            System.out.println("что за знак?");
            System.exit(0);

        }

        if (isRomeOrNot(s0) == isRomeOrNot(s2)) {   // очень понравился этот способ проверки.
            // спасибо каналу Coducation на youtube!
            // я не скопировал, просто взял идею =)
            if ( bo == isRomeOrNot(s0)){        // увидели римские отправляем считать
                a = findInt(s0);            // I --> 1
                b = findInt(s2);            // II --> 2

                switch (op) {
                    case '+':
                        rez = a + b;
                        break;
                    case '-':
                        rez = a - b;
                        break;
                    case '*':
                        rez = a * b;
                        break;
                    case '/':
                        rez = a / b;

                        break;
                }
                try{
                    if (rez>0){                             // проверил ответ для римских
                        String rezRome = backToRome(rez);   // отправили на конвертацию обратно в римские
                        System.out.println(rezRome);
                        System.exit(0);

                    }else throw new IOException();
                } catch (IOException e) {
                    System.out.println("ответ < 1");
                    System.exit(0);
                }



            }

            a = findInt(s0);
            b = findInt(s2);

            switch (op){
                case '+':
                    rez = a+b;
                    break;
                case '-':
                    rez = a-b;
                    break;
                case '*':
                    rez = a*b;
                    break;
                case '/':
                    rez = a/b;
                    break;
            }
            System.out.println(rez);                 // вывод в арабских
            System.exit(0);


        }

        else {
            System.out.println("выбери что-то одно");
        }




        return null;
    }


    // до сюда метод калк


    public static int findInt (String sss){             // меняем строку на число
        try
        {
            if (sss.equals("I")||sss.equals("1")){
                return 1;
            }
            if (sss.equals("II")||sss.equals("2")){
                return 2;
            }
            if (sss.equals("III")||sss.equals("3")){
                return 3;
            }
            if (sss.equals("IV")||sss.equals("4")){
                return 4;
            }
            if (sss.equals("V")||sss.equals("5")){
                return 5;
            }
            if (sss.equals("VI")||sss.equals("6")){
                return 6;
            }
            if (sss.equals("VII")||sss.equals("7")){
                return 7;
            }
            if (sss.equals("VIII")||sss.equals("8")){
                return 8;
            }
            if (sss.equals("IX")||sss.equals("9")){
                return 9;
            }
            if (sss.equals("X")||sss.equals("10")){
                return 10;
            } else

                throw new IOException();


        } catch (IOException e){
            System.out.println("странные символы");
            System.exit(0);                                 //  не знаю что это, но оно помогло. Спасибо гугл!


        }

        return -1;
    }

    public static boolean isRomeOrNot (String num){         // для проверки ара или рим
        if (num.equals("I")) {
            return true;
        }
        if (num.equals("II")) {
            return true;
        }
        if (num.equals("III")) {
            return true;
        }
        if (num.equals("IV")) {
            return true;
        }
        if (num.equals("V")) {
            return true;
        }
        if (num.equals("VI")) {
            return true;
        }
        if (num.equals("VII")) {
            return true;
        }
        if (num.equals("VIII")) {
            return true;
        }
        if (num.equals("IX")) {
            return true;
        }
        if (num.equals("X")) {
            return true;
        }

        return false;

    }
    public static String backToRome (int numAra){           // конвертер из числа в римские для ответа





        String[] roman = {"пустая клетка", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String out = roman[numAra];
        for (int i = 0; i < numAra; i++) {
            out = roman[numAra];
        }


        return out;
    }










}