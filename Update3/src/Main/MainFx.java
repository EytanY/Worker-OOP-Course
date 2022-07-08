package Main;

import javax.swing.JOptionPane;
import Controller.Controller;
import Model.Company;
import Model.Department;
import Model.Employee;
import Model.Role;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainFx extends Application {
	static View view = new View();
	static Company company = new Company("Company");
	static Controller controller = new Controller(company, view);

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception { 
		controller.updateData("Data.dat");
		
		controller.getBAddRole().setOnAction(e -> {
			primaryStage.setScene(controller.getSceneAddEmployee());
			controller.getBEnter().setOnAction(enter -> {
				try {
					Employee employee = controller.addEmployee();
					primaryStage.setScene(controller.getSceneAddRole());
					controller.getBEnter().setOnAction(enter2 -> {
						try {
						if(controller.addRole(employee))
							JOptionPane.showMessageDialog(null, "Sucsses!");
						else
							JOptionPane.showMessageDialog(null, "Already exist!");
						}catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Invalid input");
						}finally {
							primaryStage.setScene(controller.getSceneMenu());
						}
					});
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid input");
					primaryStage.setScene(controller.getSceneMenu());
				}

			});
		});
		controller.getBAddDepartment().setOnAction(e -> {
			primaryStage.setScene(controller.getSceneAddDepartment());
			controller.getBEnter().setOnAction(enter -> {
				try {
					if(controller.addDepartment())
						JOptionPane.showMessageDialog(null, "Sucsses!");
					else
						JOptionPane.showMessageDialog(null, "Already exist!");
					primaryStage.setScene(controller.getSceneMenu());
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Invalid input");
					primaryStage.setScene(controller.getSceneMenu());
				}
			});
		});
		controller.getBShowAllEmployees().setOnAction(e -> {
			primaryStage.setScene(controller.getSceneShowAllEmployees());
		});

		controller.getBShowCompany().setOnAction(e -> {
			primaryStage.setScene(controller.getSceneShowCompany());
		});

		controller.getBChangeDeatailsForRole().setOnAction(e -> {
			primaryStage.setScene(controller.getSceneSearchEmployee());
			controller.getBEnter().setOnAction(enter->{
				try {
					Role role = controller.findRole();
					primaryStage.setScene(controller.getSceneChangeDeatailsForRole(role));
					controller.getBEnter2().setOnAction(enter2->{
						controller.changeRole(role);
						JOptionPane.showMessageDialog(null, "Sucsses!");
						primaryStage.setScene(controller.getSceneMenu());
					});
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Invalid input");
					primaryStage.setScene(controller.getSceneMenu());
				}
			});
		});

		controller.getBChangeDeatailsForDepartment().setOnAction(e->{
			primaryStage.setScene(controller.getSceneSearchDepartment());
			controller.getBEnter().setOnAction(enter -> {
				try {
					Department department = controller.findDepatment();
					primaryStage.setScene(controller.getSceneChangeDeatailsDepartment(department));
					controller.getBEnter2().setOnAction(enter2 ->{
						controller.changeDepartment(department);
						JOptionPane.showMessageDialog(null, "Sucsses!");
						primaryStage.setScene(controller.getSceneMenu());
					});
				}catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Invalid input");
					primaryStage.setScene(controller.getSceneMenu());
				}
			});
		});
		
		controller.getBProfitForRole().setOnAction(e->{
			primaryStage.setScene(controller.getSceneSearchEmployee());
			controller.getBEnter().setOnAction(enter->{
				try {
					Role role = controller.findRole();
					primaryStage.setScene(controller.getSceneProfitForRole(role));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Invalid input");
					primaryStage.setScene(controller.getSceneMenu());
				}
			});
		});
		controller.getBProfitForDepartment().setOnAction(e->{
			primaryStage.setScene(controller.getSceneSearchDepartment());
			controller.getBEnter().setOnAction(enter->{
				try {
					Department department = controller.findDepatment();
					primaryStage.setScene(controller.getSceneProfitForDepartment(department));
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid input");
					primaryStage.setScene(controller.getSceneMenu());
				}
			});
		});
		
		controller.getBProfitForCompany().setOnAction(e->{
			primaryStage.setScene(controller.getSceneProfitForCompany());
		});
		controller.getBMenu().setOnAction(e -> {
			primaryStage.setScene(controller.getSceneMenu());
			controller.getBEnter().setOnAction(enter->{
			});
		});

		controller.getBExit().setOnAction(e -> {
			controller.saveData("Data.dat");
			primaryStage.close();
		});

		primaryStage.setScene(controller.getSceneMenu());
		primaryStage.setTitle(company.getName());
		primaryStage.show();

	}
	

}
