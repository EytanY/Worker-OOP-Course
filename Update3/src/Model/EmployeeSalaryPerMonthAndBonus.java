package Model;

@SuppressWarnings("serial")
public class EmployeeSalaryPerMonthAndBonus extends EmployeeSalaryPerMonth {
	
	private double percentageFromMonthlySales;
		
	public EmployeeSalaryPerMonthAndBonus(String name, String id, double salaryPerHour,double percentageFromMonthlySales) {
		super(name, id, salaryPerHour);
		this.percentageFromMonthlySales = percentageFromMonthlySales;
	}

	public double getTotalSalary(double sale) {
		return 160*getSalaryPerHour() + sale*percentageFromMonthlySales;
	}
	
	public double getPercentageFromMonthlySales() {
		return percentageFromMonthlySales;
	}

	public void setPercentageFromMonthlySales(double percentageFromMonthlySales) {
		this.percentageFromMonthlySales = percentageFromMonthlySales;
	}
	
	

}
