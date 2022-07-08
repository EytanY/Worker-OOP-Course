package Model;


@SuppressWarnings("serial")
public class EmployeeSalaryPerMonth extends EmployeeSalaryPerHour{

	public EmployeeSalaryPerMonth(String name, String id, double salaryPerHour) {
		super(name, id, salaryPerHour, 160);
		setTotalSalary(salaryPerHour*160);
	}
	
}
