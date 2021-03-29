package Clients;

public abstract class Client {

    private double account;

    Client(double account)
    {
        this.account = account;
    }

    public double getAccount()
    {
        return account;
    }

    public void setAccount(double account)
    {
        this.account = account;
    }

    public double get_BANK_COMMISION() { return 0.01; }

    public double get_BANK_COMMISION_2()
    {
        return 0.005;
    }

    public abstract void accountInfo();

    public void topUpBalance(double amount)
    {
        if (amount > 0){
            setAccount(getAccount() + amount);
        } else {System.out.println("Введена некоректная сумма для внесения!");
        }
    }

    public void withdrawMoney(double amount)
    {
        {
            if (amount > 0 && amount < getAccount()){
                setAccount(getAccount() - amount);
            } else {System.out.println("Введена некоректная сумма для снятия!");
            }
        }
    }
}
