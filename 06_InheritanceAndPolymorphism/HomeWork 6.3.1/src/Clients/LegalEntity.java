package Clients;
public class LegalEntity extends Client{

    LegalEntity(double account)
    {
        super(account);
    }

    @Override
    public void withdrawMoney(double amount)
    {
        if (amount > 0 && amount < getAccount()) {
            setAccount(getAccount() - (amount + (amount * get_BANK_COMMISION())));
        }
    }

    @Override
    public void accountInfo()
    {
        System.out.println("Юридическое лицо. Снятие средств облагается коммиссией в 1%. " +
                " Баланс составляет: " + getAccount());
    }
}
