package View;

import Model.Company;
import Model.Department;
import Model.Person.Preference;
import Model.Role;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class View {
	private Button bAddRole = new Button("Add role");
	private Button bAddDepartment = new Button("Add department");
	private Button bShowAllEmployees = new Button("Show all employees");
	private Button bShowAllDepartments = new Button("Show company(all departments)");
	private Button bChangeDetailsRole = new Button("Change the details of role");
	private Button bChangeDetailsDepartment = new Button("Change the details of department");
	private Button bProfitForDepartment = new Button("Show profit for department");
	private Button bProfitForRole = new Button("Show profit for role");
	private Button bProfitForComapany = new Button("Show profit for company");
	private Button bExit = new Button("Save&Exit");
	private Button bEnter = new Button("Enter");
	private Button bMenu = new Button("Menu");
	private Button bEnter2 = new Button("Enter");

	private TextField nameField = new TextField();
	private TextField idField = new TextField();
	private TextField salaryPerHourFiled = new TextField();
	private TextField numOfHoursFiled = new TextField();
	private TextField indexOfDepartmentFiled = new TextField();
	private TextField indexOfRoleFiled = new TextField();
	private int typeOfEmployee;
	private boolean canChangeHour, sameHoursForDepartment;
	private Preference preferenc;

	String departmentName;

	public Scene getSceneMenu() {
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));
		bAddRole.setStyle("-fx-font: 22 arial; -fx-base: #7CFC00;");
		bAddDepartment.setStyle("-fx-font: 22 arial; -fx-base: #7CFC00;");
		bEnter.setStyle("-fx-font: 22 arial; -fx-base: #6495ED;");
		bMenu.setStyle("-fx-font: 22 arial; -fx-base: #6495ED;");
		bEnter2.setStyle("-fx-font: 22 arial; -fx-base: #6495ED;");
		bChangeDetailsRole.setStyle("-fx-font: 22 arial; -fx-base: #FF7F50;");
		bChangeDetailsDepartment.setStyle("-fx-font: 22 arial; -fx-base: #FF7F50;");
		bShowAllDepartments.setStyle("-fx-font: 22 arial; -fx-base: #40E0D0;");
		bShowAllEmployees.setStyle("-fx-font: 22 arial; -fx-base: #40E0D0;");
		bProfitForRole.setStyle("-fx-font: 22 arial; -fx-base: #FFD700;");
		bProfitForComapany.setStyle("-fx-font: 22 arial; -fx-base: #FFD700;");
		bProfitForDepartment.setStyle("-fx-font: 22 arial; -fx-base: #FFD700;");

		bExit.setStyle("-fx-font: 22 arial; -fx-base: #ee2211;");

		vb.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));
		vb.getChildren().addAll(bAddRole, bAddDepartment, bShowAllEmployees, bShowAllDepartments, bChangeDetailsRole,
				bChangeDetailsDepartment,bProfitForRole ,bProfitForDepartment, bProfitForComapany, bExit);
		Scene scene = new Scene(vb, 500, 630);
		return scene;
	}

	public Scene getSceneAddEmployee(Company company) {
		nameField.setText("");
		idField.setText("");
		salaryPerHourFiled.setText("");
		numOfHoursFiled.setText("");

		VBox vb = new VBox(5);
		nameField.setPromptText("Name");
		idField.setPromptText("ID");
		salaryPerHourFiled.setPromptText("0");
		numOfHoursFiled.setPromptText("0");

		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(new Text("Enter Name of Employee:"), nameField, new Text("Enter id:"), idField);

		RadioButton rbEmployeePerHour = new RadioButton("Salary per hour");
		RadioButton rbEmployeeMonth = new RadioButton("Salary per month (160 hours per month)");
		RadioButton rbEmploeeMonthAndBonus = new RadioButton(
				"Salary per month (160 hours per month) and bonus from salse");

		rbEmployeePerHour.setSelected(true);
		typeOfEmployee = 1;
		rbEmployeePerHour.setOnAction(e -> {
			rbEmploeeMonthAndBonus.setSelected(false);
			rbEmployeeMonth.setSelected(false);
			typeOfEmployee = 1;
		});
		rbEmployeeMonth.setOnAction(e -> {
			rbEmploeeMonthAndBonus.setSelected(false);
			rbEmployeePerHour.setSelected(false);
			numOfHoursFiled.setText("160");
			typeOfEmployee = 2;
		});
		rbEmploeeMonthAndBonus.setOnAction(e -> {
			rbEmployeePerHour.setSelected(false);
			rbEmployeeMonth.setSelected(false);
			numOfHoursFiled.setText("160");
			typeOfEmployee = 3;
		});

		HBox hbox = new HBox(30, rbEmployeePerHour, rbEmployeeMonth, rbEmploeeMonthAndBonus);
		TitledPane tpane = new TitledPane("Choose salary type:", hbox);

		vb.getChildren().addAll(tpane, new Text("Enter salary per hour($):"), salaryPerHourFiled,
				new Text("Enter number of work hours in month:"), numOfHoursFiled);

		RadioButton rbWorkWithoutChange = new RadioButton("Work without change");
		RadioButton rbWorEarly = new RadioButton("Work early");
		RadioButton rbWorkLater = new RadioButton("Work later");
		RadioButton rbWorkFromHome = new RadioButton("Work from home");

		HBox hbox1 = new HBox(10, rbWorkWithoutChange, rbWorEarly, rbWorkLater, rbWorkFromHome);
		TitledPane tpane1 = new TitledPane("Choose prefernce:", hbox1);

		rbWorkWithoutChange.setSelected(true);
		setPreferenc(Preference.WorkWithoutChange);

		rbWorkWithoutChange.setOnAction(e -> {
			rbWorEarly.setSelected(false);
			rbWorkLater.setSelected(false);
			rbWorkFromHome.setSelected(false);
			setPreferenc(Preference.WorkWithoutChange);
		});
		rbWorkLater.setOnAction(e -> {
			rbWorEarly.setSelected(false);
			rbWorkWithoutChange.setSelected(false);
			rbWorkFromHome.setSelected(false);
			setPreferenc(Preference.WorkLater);
		});
		rbWorEarly.setOnAction(e -> {
			rbWorkWithoutChange.setSelected(false);
			rbWorkFromHome.setSelected(false);
			rbWorkLater.setSelected(false);
			setPreferenc(Preference.WorkEarlier);
		});
		rbWorkFromHome.setOnAction(e -> {
			rbWorEarly.setSelected(false);
			rbWorkLater.setSelected(false);
			rbWorkWithoutChange.setSelected(false);
			setPreferenc(Preference.WorkFromHome);
		});
		vb.getChildren().addAll(tpane1, bEnter);
		Scene scene = new Scene(vb, 800, 600);
		return scene;

	}

	public Scene getSceneAddRole(Company company) {
		nameField.setText("");
		numOfHoursFiled.setText("");
		salaryPerHourFiled.setText("");
		numOfHoursFiled.setText("");
		indexOfDepartmentFiled.setText("0");
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));

		RadioButton rbTrue = new RadioButton("True");
		RadioButton rbFalse = new RadioButton("False");

		rbTrue.setSelected(true);
		setCanChangeHour(true);
		rbTrue.setOnAction(e -> {
			rbFalse.setSelected(false);
			setCanChangeHour(true);
		});
		rbFalse.setOnAction(e -> {
			rbTrue.setSelected(false);
			setCanChangeHour(false);
		});

		HBox hbox = new HBox(30, rbTrue, rbFalse);
		TitledPane tpane = new TitledPane("The role allowed to change hours work:", hbox);

		vb.getChildren().addAll(new Text("Add Role:\n Enter name of role:"), nameField, tpane,
				new Text("Enter the index of department:"), indexOfDepartmentFiled);
		ScrollPane sp = new ScrollPane();
		sp.setPadding(new Insets(20));
		sp.setContent(new Label(company.showDepartmentsNames()));
		sp.setPrefSize(300, 300);
		vb.getChildren().addAll(sp, bEnter);

		Scene scene = new Scene(vb, 600, 500);
		return scene;

	}

	public Scene getSceneAddDeparment() {
		nameField.setText("");
		nameField.setPromptText("Name");
		numOfHoursFiled.setPromptText("0");

		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));

		RadioButton rbTrue = new RadioButton("True");
		RadioButton rbFalse = new RadioButton("False");

		rbTrue.setSelected(true);
		setCanChangeHour(true);
		rbTrue.setOnAction(e -> {
			rbFalse.setSelected(false);
			setCanChangeHour(true);
		});
		rbFalse.setOnAction(e -> {
			rbTrue.setSelected(false);
			setCanChangeHour(false);
		});

		HBox hbox = new HBox(30, rbTrue, rbFalse);
		TitledPane tpane = new TitledPane("The department allowed to change hours work:", hbox);

		RadioButton rbTrue1 = new RadioButton("True");
		RadioButton rbFalse1 = new RadioButton("False");

		rbFalse1.setSelected(true);
		setSameHoursForDepartment(false);
		;
		rbTrue1.setOnAction(e -> {
			rbFalse1.setSelected(false);
			setSameHoursForDepartment(true);
		});
		rbFalse1.setOnAction(e -> {
			rbTrue1.setSelected(false);
			setSameHoursForDepartment(false);
		});

		HBox hbox1 = new HBox(30, rbTrue1, rbFalse1);
		TitledPane tpane1 = new TitledPane("The Deparment's employees must to work in same hours:", hbox1);

		vb.getChildren().addAll(new Text("Add Department:\n\n Enter name of department:"), nameField, tpane, tpane1,
				new Text("Enter the the hour the work start for this department (between 0 - 16)"),new Text("Example: for 8:00 enter 8"), numOfHoursFiled, bEnter);
		Scene scene = new Scene(vb, 600, 550);
		return scene;
	}

	public Scene getSceneShowAllEmployees(Company company) {
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));

		ScrollPane sp = new ScrollPane();
		sp.setPadding(new Insets(10));
		sp.setContent(new Label(company.showAllEmlpoyees()));
		sp.setPrefSize(600, 500);
		bMenu.setStyle("-fx-font: 22 arial; -fx-base: #6495ED;");
		vb.getChildren().addAll(sp, new Text("Numbe of employees:" + company.getEmployees().size()), bMenu);
		Scene scene = new Scene(vb, 800, 500);
		return scene;
	}

	public Scene getSceneShowCompany(Company company) {
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));
		ScrollPane sp = new ScrollPane();
		sp.setPadding(new Insets(10));
		sp.setContent(new Label(company.showCompany()));
		sp.setPrefSize(600, 600);
		bMenu.setStyle("-fx-font: 22 arial; -fx-base: #6495ED;");
		vb.getChildren().addAll(sp, bMenu);
		Scene scene = new Scene(vb, 850, 600);
		return scene;
	}

	public Scene changeDeatailsOfEmployee(Role role) {
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));

		Scene scene = new Scene(vb, 600, 400);
		return scene;
	}

	public Scene sceneChangeDeatailsOfDepartment(Department department) {
		idField.setText("");
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));

		RadioButton rbTrue = new RadioButton("True");
		RadioButton rbFalse = new RadioButton("False");

		rbTrue.setSelected(true);
		setCanChangeHour(true);
		rbTrue.setOnAction(e -> {
			rbFalse.setSelected(false);
			setCanChangeHour(true);
		});
		rbFalse.setOnAction(e -> {
			rbTrue.setSelected(false);
			setCanChangeHour(false);
		});

		HBox hbox = new HBox(30, rbTrue, rbFalse);
		TitledPane tpane = new TitledPane("The department allowed to change hours work:", hbox);

		RadioButton rbTrue1 = new RadioButton("True");
		RadioButton rbFalse1 = new RadioButton("False");

		rbFalse1.setSelected(true);
		setSameHoursForDepartment(false);
		;
		rbTrue1.setOnAction(e -> {
			rbFalse1.setSelected(false);
			setSameHoursForDepartment(true);
		});
		rbFalse1.setOnAction(e -> {
			rbTrue1.setSelected(false);
			setSameHoursForDepartment(false);
		});

		HBox hbox1 = new HBox(30, rbTrue1, rbFalse1);
		TitledPane tpane1 = new TitledPane("The Deparment's employees must to work in same hours:", hbox1);

		vb.getChildren().addAll(new Text("Name:" + department.getName()), tpane, tpane1, bEnter2);

		Scene scene = new Scene(vb, 600, 400);
		return scene;

	}

	public Scene sceneChangeDeatailsOfRole(Role role) {
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));

		RadioButton rbWorkWithoutChange = new RadioButton("Work without change");
		RadioButton rbWorEarly = new RadioButton("Work early");
		RadioButton rbWorkLater = new RadioButton("Work later");
		RadioButton rbWorkFromHome = new RadioButton("Work from home");
		HBox hbox1 = new HBox(10, rbWorkWithoutChange, rbWorEarly, rbWorkLater, rbWorkFromHome);
		TitledPane tpane1 = new TitledPane("Choose prefernce:", hbox1);

		rbWorkWithoutChange.setSelected(true);
		setPreferenc(Preference.WorkWithoutChange);

		rbWorkWithoutChange.setOnAction(e -> {
			rbWorEarly.setSelected(false);
			rbWorkLater.setSelected(false);
			rbWorkFromHome.setSelected(false);
			setPreferenc(Preference.WorkWithoutChange);
		});
		rbWorkLater.setOnAction(e -> {
			rbWorEarly.setSelected(false);
			rbWorkWithoutChange.setSelected(false);
			rbWorkFromHome.setSelected(false);
			setPreferenc(Preference.WorkLater);
		});
		rbWorEarly.setOnAction(e -> {
			rbWorkWithoutChange.setSelected(false);
			rbWorkFromHome.setSelected(false);
			rbWorkLater.setSelected(false);
			setPreferenc(Preference.WorkEarlier);
		});
		rbWorkFromHome.setOnAction(e -> {
			rbWorEarly.setSelected(false);
			rbWorkLater.setSelected(false);
			rbWorkWithoutChange.setSelected(false);
			setPreferenc(Preference.WorkFromHome);
		});

		RadioButton rbTrue = new RadioButton("True");
		RadioButton rbFalse = new RadioButton("False");

		rbTrue.setSelected(true);
		setCanChangeHour(true);
		rbTrue.setOnAction(e -> {
			rbFalse.setSelected(false);
			setCanChangeHour(true);
		});
		rbFalse.setOnAction(e -> {
			rbTrue.setSelected(false);
			setCanChangeHour(false);
		});

		HBox hbox = new HBox(30, rbTrue, rbFalse);
		TitledPane tpane = new TitledPane("The role allowed to change hours work:", hbox);

		vb.getChildren().addAll(new Text(role + ""), tpane1, tpane, bEnter2);
		Scene scene = new Scene(vb, 600, 400);
		return scene;
	}

	public Scene searchDepartment(Company company) {
		idField.setText("");
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));
		Label l = new Label("First enter index of department:");
		l.setFont(new Font("Ariel", 30));
		ScrollPane sp = new ScrollPane();
		sp.setContent(new Label(company.showDepartmentsNames()));
		vb.getChildren().addAll(l, idField, sp, bEnter);
		Scene scene = new Scene(vb, 600, 400);
		return scene;
	}

	public Scene searchRole(Company company) {
		idField.setText("");
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));
		Label l = new Label("First enter index of Employee:");
		l.setFont(new Font("Ariel", 30));
		ScrollPane sp = new ScrollPane();
		sp.setContent(new Label(company.showAllEmlpoyees()));
		vb.getChildren().addAll(l, idField, sp, bEnter);
		Scene scene = new Scene(vb, 600, 400);
		return scene;
	}

	public Scene sceneShowProfitForRole(Role role,Company company) {
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));
		vb.getChildren().addAll(new Text(role + ""),new Text("Profit: "+company.calculateProfitForRole(role)+"$"),bMenu);
		Scene scene = new Scene(vb, 600, 400);
		return scene;
	}
	
	public Scene sceneShowProfitForDepartment(Department department,Company company) {
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));
		ScrollPane sp = new ScrollPane();
		sp.setContent(new Label(department+""));
		vb.getChildren().addAll(sp,new Text("Profit: "+company.calculateProfitForDepartment(department)+"$"),bMenu);
		Scene scene = new Scene(vb, 600, 400);
		return scene;
	}
	public Scene sceneShowProfitForCompany(Company company) {
		VBox vb = new VBox(20);
		vb.setPadding(new Insets(10));
		ScrollPane sp = new ScrollPane();
		sp.setContent(new Label(company+""));
		vb.getChildren().addAll(sp,new Text("Profit: "+company.calculateProfit()+"$"),bMenu);
		Scene scene = new Scene(vb, 600, 400);
		return scene;
	}

	public Button getbAddRole() {
		return bAddRole;
	}

	public Button getbAddDepartment() {
		return bAddDepartment;
	}

	public Button getbShowAllEmployees() {
		return bShowAllEmployees;
	}

	public Button getbShowAllDepartments() {
		return bShowAllDepartments;
	}

	public Button getbChangeDetailsRole() {
		return bChangeDetailsRole;
	}

	public Button getbChangeDetailsDepartment() {
		return bChangeDetailsDepartment;
	}

	public Button getbProfitForDepartment() {
		return bProfitForDepartment;
	}

	public Button getbProfitForComapany() {
		return bProfitForComapany;
	}

	public Button getbExit() {
		return bExit;
	}

	public TextField getNameField() {
		return nameField;
	}

	public TextField getIdField() {
		return idField;
	}

	public TextField getSalaryPerHourFiled() {
		return salaryPerHourFiled;
	}

	public TextField getNumOfHoursFiled() {
		return numOfHoursFiled;
	}

	public int getTypeOfEmployee() {
		return typeOfEmployee;
	}

	public Button getbEnter() {
		return bEnter;
	}
	
	public Button getBProfitForRole() {
		return bProfitForRole;
	}
	
	public TextField getIndexOfDepartment() {
		return indexOfDepartmentFiled;
	}

	public TextField getIndexOfRow() {
		return indexOfRoleFiled;
	}

	public boolean isCanChangeHour() {
		return canChangeHour;
	}

	public void setCanChangeHour(boolean canChangeHour) {
		this.canChangeHour = canChangeHour;
	}

	public boolean isSameHoursForDepartment() {
		return sameHoursForDepartment;
	}

	public void setSameHoursForDepartment(boolean sameHoursForDepartment) {
		this.sameHoursForDepartment = sameHoursForDepartment;
	}

	public Button getbMenu() {
		return bMenu;
	}

	public Button getBEnter2() {
		return bEnter2;
	}

	public Preference getPreferenc() {
		return preferenc;
	}

	public void setPreferenc(Preference preferenc) {
		this.preferenc = preferenc;
	}

}
