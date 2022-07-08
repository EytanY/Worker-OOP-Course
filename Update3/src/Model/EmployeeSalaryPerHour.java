package Model;

@SuppressWarnings("serial")
public class EmployeeSalaryPerHour extends Employee{

	public EmployeeSalaryPerHour(String name, String id, double salaryPerHour, double numOfHoursWork) {
		super(name, id, salaryPerHour, numOfHoursWork);
		setTotalSalary(salaryPerHour * numOfHoursWork);
	}
	

	
}
