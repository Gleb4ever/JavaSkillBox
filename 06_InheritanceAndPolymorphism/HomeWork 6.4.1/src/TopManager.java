public class TopManager extends Profession{

    public TopManager(Company company, double fixSalary)
    {
        super(company, fixSalary);
    }

    @Override
    public double getMonthSalary()
    {
        if(getCompany().getIncome() >= 10000000){
            return getFixSalary() + getFixSalary() * 1.5;
        }
        else return getFixSalary();
    }
}
