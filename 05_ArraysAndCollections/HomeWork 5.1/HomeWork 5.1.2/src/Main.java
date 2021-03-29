import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        // создадим  массив температуры поциентов
        Float[] patient = new Float[30];

        // добавим константы
        final int PATIENT_MAX = 30;
        final int PATIENT_MAX_TEMP = 40;
        final int PATIENT_MIN_TEMP = 32;
        final double HEALTH_PATIENT_MIN_TEMP = 36.2;
        final double HEALTH_PATIENT_MAX_TEMP = 36.9;

        // перменные для счёта здоровых людей и общей сумму всей температуры
        float healthPeople = 0;
        float tempCount = 0;

        //создадим формат для float с 1 цифрой после запятой
        DecimalFormat df = new DecimalFormat("#.#");
        String s = "";

        for(int i = 0; i < patient.length; i++){

            // рандомно установим температуру для каждого пациента
            float value = (float) (PATIENT_MIN_TEMP + (Math.random() * (PATIENT_MAX_TEMP - PATIENT_MIN_TEMP)));
            patient [i] = value;

            //запишем в строку s все значения (т.к. форматируя значения float переходят в String) и для читаемости добавим скобки и тире
            s = s + "  " + "(" + (i + 1) + ")" + " - " + df.format(patient [i]);
            tempCount = tempCount + patient[i];
            if(patient[i] >= HEALTH_PATIENT_MIN_TEMP && patient[i] <= HEALTH_PATIENT_MAX_TEMP){
                healthPeople++;
            }
        }
        float midTemp = tempCount / PATIENT_MAX;

        // выведим требуемое значение
        System.out.println();
        System.out.println("Температура пациентов: " + s);
        System.out.println("\n" + "Срендяя температура: " + df.format(midTemp));
        System.out.println();
        System.out.println("Количество здоровых пациентов: " + df.format(healthPeople));

    }
}
