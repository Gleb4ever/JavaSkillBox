public class Main {
    public static void main(String[] args) {
        String [] rainbowWords = {"Каждый","охотник","желает","знать,","где","сидит","фазан"};
        // изначальный цикл for
        for(int i = 0; i < rainbowWords.length; i++){
            System.out.println(rainbowWords[i]);
        }

        int rainbowWordsLenght = rainbowWords.length;
        //создадим переменную типа String для хранения перевернутых значений
        String temp;

        //цикл для записи в temp новую последовательность массива
        for(int i = 0; i < rainbowWordsLenght / 2; i++){
            temp = rainbowWords[rainbowWordsLenght - i - 1];
            rainbowWords[rainbowWordsLenght - i - 1] = rainbowWords[i];
            // запишем новые значения с помощью переменной temp
            rainbowWords[i] = temp;
        }
        //измененный цикл for
        for (int i = 0; i < rainbowWords.length; i++){
            System.out.println(rainbowWords[i]);
        }
    }
}
