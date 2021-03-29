public class Cargo {
    // введем необходимые нам переменные
    private int truck;
    private int conteiner;
    private int box;
    private final int MAX_BOX_IN_TRACK = 324;

    //создадим конструктор для объекта типа Cargo
    public Cargo(int box)
    {
        this.box = box;
        if (box != 0){
            // используем % для определния свобдного места
            if (box % 27 == 0){
                conteiner = box / 27;
            } else {
                conteiner = box / 27 + 1;
            }
            if (conteiner != 0){
                if(conteiner % 12 == 0){
                    truck = conteiner / 12;
                } else {
                    truck = conteiner / 12 + 1;
                }
            }
        }
    }

    // создадим геттеры для грузовиков, контейнеров и ящиков
    public int getTruck()
    {
        return truck;
    }

    public int getConteiner()
    {
        return conteiner;
    }

    public int getBox()
    {
        return box;
    }

    // напишем цикл для присвоения номера для грузовика, контейнера и ящика
    public void result()
    {
        for (int b = 1; b <= box; b++){
            if ((b-1) % MAX_BOX_IN_TRACK == 0){
                System.out.println("Грузовик: " + ((b - 1) / MAX_BOX_IN_TRACK + 1));
            }
            if((b-1) % 27 == 0){
                System.out.println("\tКонтейнер: " + ((b - 1) / 27 + 1));
            }
            System.out.println("\t\tЯщик: " + b);
        }
    }
}

