package BankAccount;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositeMoney extends BankAccount{

    private Calendar topUpBalanceDate = new GregorianCalendar();
    private Calendar withdrawMoneyDate = new GregorianCalendar();

    public DepositeMoney(double amountMoney)
    {
        super(amountMoney);
    }

    @Override
    public void topUpBalance(double amount)
    {
        topUpBalanceDate = Calendar.getInstance();
        setAmountMoney(getAmountMoney() + amount);
        System.out.println("Вы положили на счёт" + amount + "рублей. Остаток на Вашем счёте составляет: " + getAmountMoney());
    }

    @Override
    public boolean withdrawMoney(double amount)
    {
        withdrawMoneyDate = Calendar.getInstance();
        withdrawMoneyDate.roll(Calendar.MONTH,-1);
        if(withdrawMoneyDate.after(topUpBalanceDate)){
            setAmountMoney(getAmountMoney() - amount);
            System.out.println("Вы сняли" + amount + "рублей. Остаток на Вашем счёте составляет: " + getAmountMoney());
            return true;
        }else{System.out.println("Еще не прошло месяца с последнего пополнения счёта!");}
        return false;
    }
}
