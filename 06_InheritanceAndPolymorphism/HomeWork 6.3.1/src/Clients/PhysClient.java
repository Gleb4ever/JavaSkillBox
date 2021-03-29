package Clients;

public class PhysClient extends Client{

    PhysClient(double account)
    {
        super(account);
    }

    @Override
    public void accountInfo()
    {
        System.out.println("Физическое лицо. " +
                "Снятие и пополнение осуществляется без коммиссии. Баланс составляет: " + getAccount());
    }
}
