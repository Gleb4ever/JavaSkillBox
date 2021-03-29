package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";

    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber()
    {
        this.number = number;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight()
    {
        this.height = height;
    }

    public void setWeight()
    {
        this.weight = weight;
    }

    public double getWeight()
    {
        return weight;
    }

    public boolean HasVehicle()
    {
        return true;
    }

    public boolean isSpecial()
    {
        return true;
    }




}