import static java.lang.System.out;
import static java.lang.System.setOut;

public class Loader
{
    private static Cat getKitten ()
    {
        return new Cat(1100.00);
    }

    public static void main(String[] args){

        // проверяем кол-во кошек
        out.println("Кол-во кошек = " + Cat.getCount());
        out.println("Создадим несколько кошек");

        // создаём несколько кошек
        Cat lisa = new Cat();
        Cat vasya = new Cat();
        Cat dima = new Cat();
        Cat anjella = new Cat();
        Cat maxim = new Cat();

        out.println("Теперь кол-во кошек = " + Cat.getCount());
        out.println("Давайте покормим кошек");

        // кормим наших кошек
        lisa.feed(100.0);
        vasya.feed(50.0);
        dima.feed(150.0);

        // давайте закормим Анжеллу до смерти
        while(!anjella.getStatus().equals("Exploded"))
        {
            anjella.feed(100.00);
        }
        out.println("Статус анжеллы = " + anjella.getStatus());
        //анжелла погибла

        //проверим, может ли мертвая коша совершать действия
        anjella.feed(10.0);
        anjella.pee();
        anjella.drink(200.00);
        anjella.getFoodCount();

        // проверяем количество котов после смерти Анжеллы
        out.println("Теперь кол-во кошек " + Cat.getCount());

        //проверяем сколько еды съел вася
        out.println("Вася съел в граммах " + vasya.foodCount);

        // похоже дима хочет в туалет, сначало взвешаем его
        out.println("Дима весит " + dima.getWeight());
        dima.pee();
        // взвешаем его после похода в туалет
        out.println("Дима весит " + dima.getWeight());

        //замяукаем максима до смерти
        while (!maxim.getStatus().equals("Dead")){
            maxim.meow();
        }
        out.println("Статус Максима = " + maxim.getStatus());
        // Максим погиб

        //проверяем количество котов после смерти максима
        out.println("Теперь кол-во кошек " + Cat.getCount());

        // создадим 3 котёнка с помощью getKitten
        getKitten();
        getKitten();
        getKitten();
        out.println("Теперь кол-во кошек " + Cat.getCount());

        // создадим с помощью конструктора нового кота

        Cat albert = new Cat(new Cat());
        out.println(albert.getWeight());
        out.println(albert.getName());


        //создадим нового кота через тот же конструктор, с теми же параметрами и получим полную копию альберта
        Cat rita = new Cat(new Cat());
        out.println(rita.getWeight());
        out.println(rita.getName());
        // мы создали две разные кошки с идентичными значениями параметров

    }}