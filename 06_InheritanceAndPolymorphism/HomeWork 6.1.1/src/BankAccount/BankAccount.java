package BankAccount;

public class BankAccount {

    private double amountMoney;

    private double BANK_COMMISION = 0.01;

    public BankAccount(double amountMoney)
    {
        this.amountMoney = amountMoney;
    }

    protected double getAmountMoney()
    {
        return amountMoney;
    }

    protected void setAmountMoney(double amountMoney)
    {
        this.amountMoney = amountMoney;
    }

    public boolean withdrawMoney(double amount)
    {
        if (amount > 0 && amount < getAmountMoney()) {
            setAmountMoney(getAmountMoney() - amount);
            System.out.println("Вы сняли" + amount + "рублей. " +
                    "Остаток на Вашем счёте составляет: " + getAmountMoney());
            return true;
        } else {
            System.out.println("Введена некоректная сумма для снятия!");
            return false;
        }
    }

    public void topUpBalance(double amount)
    {
        if (amount > 0) {
            setAmountMoney(getAmountMoney() + amount);
            System.out.println("Вы положили на счёт" + amount + "рублей. " +
                    "Остаток на Вашем счёте составляет: " + getAmountMoney());
        } else {
            System.out.println("Введена некоректная сумма для внесения!");
        }
    }

    public boolean send(BankAccount receiver, double amount)
    {
        if (withdrawMoney(amount)){
            receiver.topUpBalance(amount);
            return true;
        }
        return false;
    }

    public double get_BANK_COMMISION()
    {
        return BANK_COMMISION;
    }
}
