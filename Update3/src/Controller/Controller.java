package Controller;

import Model.Company;
import Model.Department;
import Model.Employee;
import Model.EmployeeSalaryPerHour;
import Model.EmployeeSalaryPerMonth;
import Model.EmployeeSalaryPerMonthAndBonus;
import Model.Role;
import Model.Person.Preference;
import View.View;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Controller {
	private Company company;
	private View view;

	public Controller(Company company, View view) {
		super();
		this.company = company;
		this.view = view;
	}

	public Employee addEmployee() throws Exception {
		String name = view.getNameField().getText();
		String id = view.getIdField().getText();
		Integer.parseInt(id);
		double salaryPerHour = Double.parseDouble(view.getSalaryPerHourFiled().getText());
		int numOfHoursWorkInMonth = Integer.parseInt(view.getNumOfHoursFiled().getText());

		if (id.length() != 9)
			throw new Exception();
		Employee e;
		if (view.getTypeOfEmployee() == 1) {
			e = new EmployeeSalaryPerHour(name, id, salaryPerHour, numOfHoursWorkInMonth);
		} else if (view.getTypeOfEmployee() == 2) {
			e = new EmployeeSalaryPerMonth(name, id, salaryPerHour);
		} else {
			e = new EmployeeSalaryPerMonthAndBonus(name, id, salaryPerHour, 0.1);
		}
		e.setPreference(view.getPreferenc());
		return e;
	}

	public boolean addRole(Employee employee) {
		String name = view.getNameField().getText();
		boolean canChangeHours = view.isCanChangeHour();
		int indexOfDepartment = Integer.parseInt(view.getIndexOfDepartment().getText()) - 1;
		return company.addRole(new Role(name, employee, canChangeHours), indexOfDepartment);
	}

	public boolean addDepartment() throws Exception {
		String name = view.getNameField().getText();
		boolean canChangeHours = view.isCanChangeHour();
		boolean sameHours = view.isSameHoursForDepartment();
		int hourStart = Integer.parseInt(view.getNumOfHoursFiled().getText());
		if(name.equals(""))
			throw new Exception();
		if (hourStart < 0 || hourStart > 16)
			throw new Exception();
		return company.addDeparment(new Department(name, canChangeHours, sameHours, hourStart));
	}

	public Department findDepatment() {
		int index = Integer.parseInt(view.getIdField().getText()) - 1;
		return company.getDepartments().get(index);
	}

	public Role findRole() {
		int index = Integer.parseInt(view.getIdField().getText()) - 1;
		return company.getEmployees().get(index);
	}

	public boolean changeDepartment(Department department) {
		boolean canChangeHours = view.isCanChangeHour();
		boolean sameHours = view.isSameHoursForDepartment();
		department.setCanChangePereference(canChangeHours);
		department.setSameHoursForAllRoles(sameHours);
		department.sameHours(sameHours);
		department.canChange(canChangeHours);
		return true;
	}

	public boolean changeRole(Role role) {
		Preference prefernce = view.getPreferenc();
		boolean canChangeHours = view.isCanChangeHour();
		role.getEmployee().setPreference(prefernce);
		role.setCanChangePreference(canChangeHours);
		return true;
	}
	
	public void saveData(String path) {
		try {
		company.save(path);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateData(String path) {
		try {
			company.update(path);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Scene getSceneMenu() {
		return view.getSceneMenu();
	}

	public Scene getSceneAddEmployee() {
		return view.getSceneAddEmployee(company);
	}

	public Scene getSceneAddRole() {
		return view.getSceneAddRole(company);
	}

	public Scene getSceneAddDepartment() {
		return view.getSceneAddDeparment();
	}

	public Scene getSceneShowAllEmployees() {
		return view.getSceneShowAllEmployees(company);
	}

	public Scene getSceneShowCompany() {
		return view.getSceneShowCompany(company);
	}

	public Scene getSceneSearchDepartment() {
		return view.searchDepartment(company);
	}

	public Scene getSceneSearchEmployee() {
		return view.searchRole(company);
	}

	public Scene getSceneChangeDeatailsDepartment(Department department) {
		return view.sceneChangeDeatailsOfDepartment(department);
	}

	public Scene getSceneChangeDeatailsForRole(Role role) {
		return view.sceneChangeDeatailsOfRole(role);
	}

	public Scene getSceneProfitForRole(Role role) {
		return view.sceneShowProfitForRole(role, company);
	}
	
	public Scene getSceneProfitForDepartment(Department department) {
		return view.sceneShowProfitForDepartment(department, company);
	}
	
	public Scene getSceneProfitForCompany() {
		return view.sceneShowProfitForCompany(company);
	}

	public Button getBAddRole() {
		return view.getbAddRole();
	}

	public Button getBAddDepartment() {
		return view.getbAddDepartment();
	}

	public Button getBShowAllEmployees() {
		return view.getbShowAllEmployees();
	}

	public Button getBShowCompany() {
		return view.getbShowAllDepartments();
	}

	public Button getBChangeDeatailsForRole() {
		return view.getbChangeDetailsRole();
	}

	public Button getBChangeDeatailsForDepartment() {
		return view.getbChangeDetailsDepartment();
	}
	
	public Button getBProfitForDepartment() {
		return view.getbProfitForDepartment();
	}
	
	public Button getBProfitForCompany() {
		return view.getbProfitForComapany();
	}

	public Button getBEnter() {
		return view.getbEnter();
	}

	public Button getBEnter2() {
		return view.getBEnter2();
	}

	public Button getBMenu() {
		return view.getbMenu();
	}

	public Button getBExit() {
		return view.getbExit();
	}

	public Button getBProfitForRole() {
		return view.getBProfitForRole();
	}

}
