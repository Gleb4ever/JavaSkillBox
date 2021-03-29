import java.util.HashMap;

public class CustomerStorage
{
    private final String PHONE_NUMB_REG = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}";
    private final String EMAIL_REG = ".+@.+\\..+";
    private final String NAME_REG = "^[А-я]+";
    private final String SECOND_NAME_REG = "[А-я]+";

    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");

        if(components.length != 4){
            throw new IllegalArgumentException("Wrong format. Correct format : \n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }

        if(!components[3].matches(PHONE_NUMB_REG)){
            System.out.println("Wrong phone number format. Correct format is: +79231843635");
            throw new PhoneFormatException();
        }

        if(!components[2].matches(EMAIL_REG)){
            System.out.println("Wrong email format. Correct format is: example@gmail.com");
            throw new MailFormatException();
        }

        if(!components[0].matches(NAME_REG) || !components[1].matches(SECOND_NAME_REG)){
            System.out.println("Wrong name format. Correct format is: Глеб Чернявский");
            throw new NameFormatException();
        }

        if(components[0].matches(NAME_REG) && components[1].matches(SECOND_NAME_REG)
                && components[2].matches(EMAIL_REG) && components[3].matches(PHONE_NUMB_REG)){
            String name = components[0] + " " + components[1];
            storage.put(name, new Customer(name, components[3], components[2]));
        }
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}