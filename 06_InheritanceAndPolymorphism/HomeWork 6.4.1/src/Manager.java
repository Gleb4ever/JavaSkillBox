public class Manager extends Profession{

    public Manager(Company company, double fixSalary)
    {
        super(company, fixSalary);
    }

    @Override
    public double getMonthSalary()
    {
        return getMoneyForCompany() * get_MANAGER_PROCENT() + getFixSalary();
    }
}