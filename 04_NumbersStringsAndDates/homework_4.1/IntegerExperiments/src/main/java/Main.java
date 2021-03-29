public class Main {

    public static void main(String[] args){

        Container container = new Container();
        container.count += 7843;

        int sum = sumDigits(12345);

        System.out.println(sum);
    }
    //добавили число (условное 12345)
    public static int sumDigits(Integer number)
    {
        if (number == null){
            return -1;
        } else {
            //установили новую переменную s равную переводу из числа в строку "12345"
            String string = Integer.toString(number);
            int sum = 0;
            for(int i = 0; i < string.length(); i++){
                /*  ловкий цикл, пробразующий из чара в строку из него в  целое число,
                 пока длина строки не станет равна i */
                sum+= Integer.parseInt(String.valueOf(string.charAt(i)));
            }
            return sum;
        }
    }
}
