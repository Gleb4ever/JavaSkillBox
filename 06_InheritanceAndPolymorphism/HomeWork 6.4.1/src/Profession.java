public abstract class Profession implements Employee {

    private double fixSalary;

    private Company company;

    private double moneyForCompany = (Math.random() * (140000 - 115000)) + 115000;

    private final double MANAGER_PROCENT = 0.05;

    protected Profession(Company company, double fixSalary)
    {
        this.company = company;
        this.fixSalary = fixSalary;
    }

    protected Company getCompany()
    {
        return company;
    }

    public void setCompany(Company company)
    {
        this.company = company;
    }

    public double getFixSalary()
    {
        return fixSalary;
    }

    public double get_MANAGER_PROCENT()
    {
        return MANAGER_PROCENT;
    }

    public double getMoneyForCompany()
    {
        return moneyForCompany;
    }

    public double getMonthSalary()
    {
        return getFixSalary();
    }
}
