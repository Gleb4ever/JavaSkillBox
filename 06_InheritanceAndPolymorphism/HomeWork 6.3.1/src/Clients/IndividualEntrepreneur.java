package Clients;
public class IndividualEntrepreneur extends Client{

    IndividualEntrepreneur(double account)
    {
        super(account);
    }

    @Override
    public void topUpBalance(double amount)
    {
        if (amount > 0 && amount > 1000){
            setAccount(getAccount() + (amount - amount * get_BANK_COMMISION()));
        }
        if (amount > 0 && amount <= 1000){
            setAccount(getAccount() + (amount - amount * get_BANK_COMMISION_2()));
        } else {System.out.println("Введена некоректная сумма для внесения!");
        }
    }

    @Override
    public void accountInfo()
    {
        System.out.println("ИП - пополнение с комиссией 1%, если сумма меньше 1000 рублей." +
                " \tИ с комиссией 0,5%, если сумма больше либо равна 1000 рублей. Баланс составляет: " + getAccount());
    }
}
