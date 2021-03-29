import java.lang.*;
import java.util.*;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;
import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {

    public static void main(String[] args) {

        Calendar now = Calendar.getInstance();

        Calendar nowPlus2Hours = Calendar.getInstance();

        nowPlus2Hours.add(Calendar.HOUR, 2);

        Airport airport = Airport.getInstance();

        List<Terminal> terminals = airport.getTerminals();

        terminals.stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight ->{
                    Calendar c = Calendar.getInstance();
                    c.setTime(flight.getDate());
                    return c.after(now) && c.before(nowPlus2Hours) && flight.getType() == DEPARTURE;
                })
                .forEach(flight -> System.out.println(flight.toString()));
    }
}
