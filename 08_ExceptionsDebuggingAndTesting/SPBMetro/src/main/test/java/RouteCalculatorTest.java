import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RouteCalculatorTest extends TestCase {

    //создадим переменные для тестов
    List<Station> threeTransferRoute;
    List<Station> twoTransferRoute;
    List<Station> noTransferRoute;

    StationIndex stationIndex;
    RouteCalculator calculator;

    //вынесим эти станции за пределы метода setUp для использования в других методах
    Station studencheskaya;
    Station gagarinskaya;
    Station zaelcovskaya;
    Station ploshadLenina;

    @Override
    protected void setUp() throws Exception
    {
        //Схема тестовой линии
        //[l1]            [l2]            [l3]
        //[l1]-[transfer]-[l2]            [l3]
        //[l1]            [l2]-[transfer]-[l3]

        stationIndex = new StationIndex();

        // создадим три ветки
        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Line line3 = new Line(3, "Third");

        //создадим по три станции на ветке
        studencheskaya = new Station("Студенческая", line1);
        Station ploshadMarksa = new Station("Площадь Маркса", line1);
        gagarinskaya = new Station("Гагаринская", line1);

        zaelcovskaya = new Station("Заельцовская", line2);
        Station zolotayaRosha = new Station("Золотая роща", line2);
        Station krasniyProspekt = new Station("Красный проспект", line2);

        ploshadLenina = new Station("Площадь Ленина", line3);
        Station marshalaPokrishkina = new Station("Маршала-Покрышкина", line3);
        Station zolotayaNiva = new Station("Золотая Нива", line3);

        //добавим ветки и станции в stationIndex
        Stream.of(line1, line2, line3).forEach(stationIndex::addLine);

        Stream.of(studencheskaya, ploshadMarksa, gagarinskaya,zaelcovskaya, zolotayaRosha,
                krasniyProspekt, ploshadLenina, marshalaPokrishkina, zolotayaNiva)
                .peek(s -> s.getLine().addStation(s))
                .forEach(stationIndex::addStation);

        //объявим станции для пересадки на другие ветки
        stationIndex.addConnection(Stream.of(ploshadMarksa, zolotayaRosha)
                .collect(Collectors.toList()));

        stationIndex.addConnection(Stream.of(krasniyProspekt, zolotayaNiva)
                .collect(Collectors.toList()));

        stationIndex.getConnectedStations(ploshadMarksa);
        stationIndex.getConnectedStations(krasniyProspekt);

        calculator = new RouteCalculator(stationIndex);

        //тестовые маршруты
        noTransferRoute = Stream.of
                (studencheskaya, ploshadMarksa, gagarinskaya).
                collect(Collectors.toList());

        twoTransferRoute = Stream.of
                (studencheskaya,ploshadMarksa,zolotayaRosha,zaelcovskaya)
                .collect(Collectors.toList());

        threeTransferRoute = Stream.of
                (studencheskaya, ploshadMarksa,zolotayaRosha, krasniyProspekt, zolotayaNiva,
                        marshalaPokrishkina, ploshadLenina)
                .collect(Collectors.toList());
    }

    //тест для расчёта времени маршрута
    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(threeTransferRoute);
        double expected = 17;
        assertEquals(expected, actual);
    }

    //тесты для маршуртов без пересадок, с одной пересадкой и с двумя пересадками
    public void testGetRouteWithOutConnection()
    {
        List<Station> actualNoTransfer = calculator.getShortestRoute(studencheskaya, gagarinskaya);
        List<Station> expectedNoTransfers = noTransferRoute;
        assertEquals(actualNoTransfer, expectedNoTransfers);
    }

    public void testGetRouteWithOneConnection()
    {
        List<Station> actualTwoTransfer = calculator.getShortestRoute(studencheskaya, zaelcovskaya);
        List<Station> expectedTwoTransfers = twoTransferRoute;
        assertEquals(actualTwoTransfer, expectedTwoTransfers);
    }

    public void testGetRouteWithTwoConnections()
    {
        List<Station> actualThreeTransfers = calculator.getShortestRoute(studencheskaya, ploshadLenina);
        List<Station> expectedThreeTransfers = threeTransferRoute;
        assertEquals(actualThreeTransfers, expectedThreeTransfers);
    }

    @Override
    protected void tearDown() throws Exception
    {

    }
}
