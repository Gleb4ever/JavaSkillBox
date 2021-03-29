import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class StudentParser {

    private final String FILE;

    private final Set<Student> students;

    public StudentParser(String file)throws IOException
    {
        this.FILE = file;
        students = new LinkedHashSet<>();
        parse();
    }

    private void parse() throws IOException
    {
        Reader in = new FileReader(FILE);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in).getRecords();
        records.forEach(record -> {
            String name = record.get(0);
            int age = Integer.parseInt(record.get(1));
            HashSet<String> courses  = new HashSet<>(Arrays.asList(record.get(2).split(",")));
            students.add(new Student(name, age, courses));
        });
    }

    public Set<Student> getStudents()
    {
        return students;
    }
}
