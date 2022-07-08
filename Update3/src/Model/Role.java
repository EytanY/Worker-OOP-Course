package Model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Role implements CanChangeHours,Serializable {
	private String name;
	private Employee employee;
	private boolean canChangePreference;

	public Role(String nameRole, Employee employee, boolean canChangePreference) {
		this.employee = employee;
		this.name = nameRole;
		this.canChangePreference = canChange(canChangePreference);
	}

	@Override
	public String toString() {
		return "Role: " + name + ", " + employee + ".";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Role) {
			Role r = (Role) obj;
			if (r.getEmployee() == null)
				return false;
			return this.name.equals(r.getNameRole()) && this.employee.equals(r.getEmployee());
		}
		return false;
	}

	public String getNameRole() {
		return name;
	}

	public void setNameRole(String nameRole) {
		this.name = nameRole;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public boolean isCanChangePreference() {
		return canChangePreference;
	}

	public void setCanChangePreference(boolean canChangePreference) {
		this.canChangePreference = canChangePreference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean canChange(boolean change) {
		boolean answer = change;
		return answer;
	}

}
