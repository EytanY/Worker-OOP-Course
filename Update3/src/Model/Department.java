package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Model.Person.Preference;

@SuppressWarnings("serial")
public class Department implements CanChangeHours, SameHoursForAll , Serializable{
	private String name;
	private ArrayList<Role> roles;
	private int hourStart;
	private boolean canChangePereference;
	private boolean sameHoursForAllRoles;

	public Department(String name, boolean canChangePereference, boolean sameHoursForAllRoles, int hourStart) {
		this.name = name;
		this.canChangePereference = canChange(sameHoursForAllRoles);
		this.sameHoursForAllRoles = sameHours(sameHoursForAllRoles);
		this.hourStart = hourStart;
		roles = new ArrayList<Role>();
	}

	public double calculateProfitForRole(Role role) {
		double profit = 0;
		if(role.getEmployee().preference == Preference.WorkWithoutChange)
			return profit;
		if(isCanChangePereference())
			if(role.getEmployee().preference == Preference.WorkFromHome)
				return 8*0.1*role.getEmployee().getSalaryPerHour();
			else
				return 8*0.2*role.getEmployee().getSalaryPerHour();
		else {
			if(role.getEmployee().preference == Preference.WorkFromHome)
				return -0.2*8*role.getEmployee().getSalaryPerHour();
			else if(role.getEmployee().preference == Preference.WorkEarlier)
				return (8-hourStart)*0.2*role.getEmployee().getSalaryPerHour();
			else
				return (hourStart-8)*0.2*role.getEmployee().getSalaryPerHour();
		}
	}
	
	public double calculateProfit() {
		double profit = 0;
		for(Role role : roles) {
			profit += calculateProfitForRole(role);
		}
		return profit;
	}

	public boolean addRole(Role role) {
		for (Role r : roles) {
			if (r.getEmployee().equals(role.getEmployee())) {
				return false;
			}
		}
		roles.add(role);
		return true;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Department name's: " + name + ", can change pereference: " + canChangePereference
				+ ", same hours for all roles: " + sameHoursForAllRoles + "\n");
		for (Role role : roles) {
			sb.append("[" + (roles.indexOf(role) + 1) + "]-" + role + "\n");
		}
		return sb + "";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Department)
			return ((Department)obj).getName().equalsIgnoreCase(name);
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	public boolean isCanChangePereference() {
		return canChangePereference;
	}

	public void setCanChangePereference(boolean canChangePereference) {
		this.canChangePereference = canChange(canChangePereference);
	}

	public boolean isSameHoursForAllRoles() {
		return sameHoursForAllRoles;
	}

	public void setSameHoursForAllRoles(boolean sameHoursForAllRoles) {
		this.sameHoursForAllRoles = sameHours(sameHoursForAllRoles);
	}

	public int getHourStart() {
		return hourStart;
	}

	public void setHourStart(int hourStart) {
		this.hourStart = hourStart;
	}

	@Override
	public boolean sameHours(boolean same) {
		boolean answer = same;
		return answer;
	}

	@Override
	public boolean canChange(boolean change) {
		boolean answer = change;
		return answer;
	}

}
