package Service;

import java.util.List;

import Model.Department;

public interface DepartmentService {
	void addDepartment(Department dept);
    Department getDepartmentById(int id);
    List<Department> getAllDepartments();
    boolean updateDepartment(Department dept);
    boolean deleteDepartment(int id);

}
