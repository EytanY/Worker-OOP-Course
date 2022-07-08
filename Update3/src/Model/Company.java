package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Company implements Serializable {
	
	private String name;
	private ArrayList<Department> departments;
	private ArrayList<Role> employees;
	
	public Company(String name) {
		this.name = name;
		departments = new ArrayList<>();
		employees = new ArrayList<>();
	}
	
	public double calculateProfitForRole(Role role) {
		for(Department d : departments) {
			for(Role r : d.getRoles()) {
				if(role.equals(r))
					return d.calculateProfitForRole(role);
			}
		}
		return -1;
	}
	
	public void save(String path) throws IOException {
		ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream(path));
		Company c = new Company(name);
		c.setDepartments(departments);
		c.setEmployees(employees);
		outFile.writeObject(c);
		outFile.close();
	}
	

	public void update(String path) throws IOException, ClassNotFoundException {
		ObjectInputStream inFile = new ObjectInputStream(new FileInputStream(path));
		Company c = (Company)inFile.readObject();
		setName(c.getName());
		setDepartments(c.getDepartments());
		setEmployees(c.getEmployees());
		inFile.close();
	}
	
	public double calculateProfitForDepartment(Department department) {
		return department.calculateProfit();
	}
	
	public double calculateProfit() {
		double profit = 0;
		for(Department department : departments) {
			profit += department.calculateProfit();
		}
		return profit;
	}
	
	public boolean addRole(Role role,int indexDepartment) {
		for(Department d : departments) {
			for(Role r : d.getRoles()) {
				if(r.getEmployee().equals(role.getEmployee()))
					return false;
			}
		}
		return departments.get(indexDepartment).addRole(role) && employees.add(role);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Company name's:" + name+"\n");
		for(Department departments : departments) {
			sb.append(departments+"\n");
			sb.append("\n");
		}
		return sb +"";
	}
	
	public String showDepartmentsNames() {
		StringBuffer sb = new StringBuffer();
		sb.append("Departments:\n");
		for(Department d : departments) {
			sb.append("["+(departments.indexOf(d)+1)+"] - " + d.getName()+"\n");
		}
		return sb +"";
	}
	
	public String showAllEmlpoyees() {
		StringBuffer sb = new StringBuffer();
		sb.append("All Employees:\n");
		for(Role employee: employees) {
			sb.append("["+(employees.indexOf(employee)+1)+"] - " + employee+"\n");
		}
		return sb+"";
	}
	
	public Object[] searchEmployee(int serialNumber) {
		for(Department department: departments) {
			for(Role role : department.getRoles()) {
				if(serialNumber == role.getEmployee().getSerialNumber());{
					Object[] arr = {department,role};
					return arr;
				}
			}
		}
		return null;
	}
	
	public String showCompany() {
		StringBuffer sb = new StringBuffer();
		sb.append("Company " + name +":\n\n");
		for(Department department : departments) {
			sb.append(department+"\n");
			
		}
		return sb +"";
	}
	
	public boolean addDeparment(Department department) {
		for(Department d: departments) {
			if(d.equals(department))
				return false;
		}
		departments.add(department);
		return true;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Department> getDepartments() {
		return departments;
	}
	
	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}

	public ArrayList<Role> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Role> employees) {
		this.employees = employees;
	}
	
	public Department getDepartmentDitails(int index) {
		return departments.get(index);
	}
	
	
	
}
