package Client;

import java.util.List;
import java.util.Scanner;

import Model.Department;
import Service.DepartmentService;
import Service.DepartmentServiceImpl;

public class MainApp {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        DepartmentService service = new DepartmentServiceImpl();

	        while (true) {
	            System.out.println(" Department Management System ");
	            System.out.println("1. Add Department");
	            System.out.println("2. Get Department by ID");
	            System.out.println("3. Get All Departments");
	            System.out.println("4. Update Department");
	            System.out.println("5. Delete Department");
	            System.out.println("6. Exit");
	            System.out.print("Choose: ");
	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter Dept ID: ");
	                    int id = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter Name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter Location: ");
	                    String loc = sc.nextLine();
	                    service.addDepartment(new Department(id, name, loc));
	                    break;
	                case 2:
	                    System.out.print("Enter Dept ID: ");
	                    System.out.println(service.getDepartmentById(sc.nextInt()));
	                    break;
	                case 3:
	                    List<Department> list = service.getAllDepartments();
	                    for (Department d : list) System.out.println(d);
	                    break;
	                case 4:
	                    System.out.print("Enter Dept ID to update: ");
	                    int updId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("Enter New Name: ");
	                    String newName = sc.nextLine();
	                    System.out.print("Enter New Location: ");
	                    String newLoc = sc.nextLine();
	                    boolean updated = service.updateDepartment(new Department(updId, newName, newLoc));
	                    System.out.println(updated ? "Updated successfully" : "Update failed");
	                    break;
	                case 5:
	                    System.out.print("Enter Dept ID to delete: ");
	                    boolean deleted = service.deleteDepartment(sc.nextInt());
	                    System.out.println(deleted ? "Deleted successfully" : "Deletion failed");
	                    break;
	                case 6:
	                    sc.close();
	                    System.exit(0);
	            }
	        }
	    }

}
