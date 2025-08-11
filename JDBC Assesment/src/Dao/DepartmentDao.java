package Dao;

import java.util.List;


import Model.Department;

public interface DepartmentDao {
    void addDepartment(Department dept);
    Department getDepartmentById(int id);
    List<Department> getAllDepartments();
    boolean updateDepartment(Department dept);
    boolean deleteDepartment(int id);

}
