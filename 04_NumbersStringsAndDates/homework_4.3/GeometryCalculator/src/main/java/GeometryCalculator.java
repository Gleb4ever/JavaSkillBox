public class GeometryCalculator {

    double p = (a + b + c) / 2;

    // метод должен использовать абсолютное значение radius

    public static double getCircleSquare(double radius)
    {
        return Math.PI * Math.abs(radius) * Math.abs(radius);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius)
    {
        return (4.0 / 3.0 ) * Math.PI * Math.abs(radius) * Math.abs(radius) * Math.abs(radius);
    }

    public static boolean isTrianglePossible(double a, double b, double c)
    {
        return  a + b > c && a + c > b && b + c > a ;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c)
    {
        if (isTrianglePossible(a, b, c)){
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            return -1.0;
        }
    }
}
