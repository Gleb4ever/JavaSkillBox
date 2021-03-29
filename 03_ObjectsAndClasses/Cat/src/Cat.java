public class Cat{

    private double originWeight;
    private double weight;
    public final int COUNT_LEGS = 4;
    public final int COUNT_EYES = 2;

    private final double MIN_WEIGHT = 1000 ;
    private final double MAX_WEIGHT = 9000;
    public double foodCount;
    public static int count;
    private boolean isCatAlive;
    public String name;
    private ColorType colorType;

    public Cat()
    {
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(double weight)
    {
        this.weight = weight;
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT){
            isCatAlive = false;
        } else {
            isCatAlive = true;
            count++;
        }
    }

    public Cat (Cat cat)
    {
        if(!isCatAlive){
            this.weight = cat.weight;
            this.name = cat.name;
            this.colorType = cat.colorType;
        } else {
            this.weight = cat.weight;
            this.name = cat.name;
            this.colorType = cat.colorType;
            count++;
        }
    }

    // напишем геттер и сеттер для окраса
    public ColorType getColorType()
    {
        return colorType;
    }

    public void setColorType()
    {
        this.colorType = colorType;
    }

    public void setName()
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static int getCount()
    {
        return count;
    }

    public double getFoodCount()
    {
        if(!isCatAlive){
            System.out.println("Кошки нет в живых!");
            return 0.0;
        } else {
            return foodCount;
        }
    }

    public void meow()
    {
        if(!isCatAlive){
            System.out.println("Кошки нет в живых!");
        } else {
            weight = weight - 1;
            System.out.print("Meow ");
        }
        if (weight < MIN_WEIGHT || weight > MAX_WEIGHT){
            isCatAlive = false;
            count--;
        }
    }

    public void pee()
    {
        if(!isCatAlive){
            System.out.println("Кошки нет в живых!");
        } else {
            weight = weight - 5;
            System.out.println("Кошке стало полегче");
        }
        if(weight < MIN_WEIGHT || weight > MAX_WEIGHT){
            isCatAlive = false;
            count--;
        }
    }

    public void feed (Double amount)
    {
        if(!isCatAlive){
            System.out.println("Кошки нет в живых!");
        } else {
            weight = weight + amount;
            foodCount += amount;
        }
        if(weight < MIN_WEIGHT || weight > MAX_WEIGHT){
            isCatAlive = false;
            count--;
        }
    }
    public void drink (Double amount)
    {
        if(!isCatAlive){
            System.out.println("Кошки нет в живых!");
        } else {
            weight = weight + amount;
        }

        if(weight < MIN_WEIGHT || weight > MAX_WEIGHT)
        {
            isCatAlive = false;
            count--;
        }
    }

    public Double getWeight()
    {
        if(!isCatAlive){
            System.out.println("Кошки нет в живых!");
            return 0.0;
        } else {
            return weight;
        }
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT){
            isCatAlive = false;
            return "Dead";
        } else if (weight > MAX_WEIGHT){
            isCatAlive = false;
            return "Exploded";
        } else if (weight > originWeight){
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}