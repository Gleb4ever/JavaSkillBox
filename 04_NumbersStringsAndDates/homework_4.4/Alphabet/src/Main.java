public class Main {
    public static void main(String[] args) {
        char i, y, z, x;

// отдельный цикл для английского алфавита
        for(i = 'A', y = 'a'; i <= 'Z' && y <= 'z'; i++, y++){
            int c = i;
            int d = y;
            System.out.println(i +" :" + c);
            System.out.println(y +" :" + d);
            System.out.println();
        }
// отдельный цикл для русского алфавита
        for(z = 'А', x = 'а'; z <= 'Я' && x <= 'я';z++,x++){
            int v = z;
            int p = x;
            System.out.println(z +" :" + v);
            System.out.println(x +" :" + p);
            System.out.println();
        }
    }
}
