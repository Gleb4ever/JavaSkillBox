package BankAccount;
public class CardAccount extends BankAccount {

    public CardAccount(double amountMoney)
    {
        super(amountMoney);
    }

    public boolean withdrawMoney(double amount)
    {
        if (amount > 0 && amount < getAmountMoney()){
            setAmountMoney(getAmountMoney() - (amount + (amount * get_BANK_COMMISION())));
            System.out.println("Вы сняли" + amount + "рублей. Остаток на Вашем счёте составляет: " + getAmountMoney());
            return true;
        } else {System.out.println("Введена некоректная сумма для снятия!");}
        return false;
    }
}
