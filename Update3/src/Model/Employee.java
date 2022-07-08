package Model;

import java.io.Serializable;

public abstract class Employee extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1288316641280378972L;
	private static int globalSerialNumber = 1000;
	protected int serialNumber;
	protected double totalSalary,salaryPerHour,numOfHoursWork;
	
	public Employee(String name, String id,double salaryPerHour , double numOfHoursWork) {
		super(name, id);
		serialNumber = globalSerialNumber++;
		this.salaryPerHour = salaryPerHour;
		this.numOfHoursWork  = numOfHoursWork;
	}

	@Override
	public String toString() {
		return super.toString()+" ,Serial number: "+ serialNumber + " ,Preference: " + preference;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public double getSalaryPerHour() {
		return salaryPerHour;
	}

	public void setSalaryPerHour(int salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}

	public double getNumOfHoursWork() {
		return numOfHoursWork;
	}

	public void setNumOfHoursWork(int numOfHoursWork) {
		this.numOfHoursWork = numOfHoursWork;
	}

	public void setTotalSalary(double d) {
		this.totalSalary = d;
	}

	public double getTotalSalary() {
		return totalSalary;
	}
	
	
	
}
