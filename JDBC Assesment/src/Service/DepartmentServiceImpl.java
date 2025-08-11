package Service;

import java.util.List;

import Dao.DepartmentDao;
import Dao.DepartmentDaoImpl;
import Model.Department;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao dao = new DepartmentDaoImpl();

	@Override
	public void addDepartment(Department dept) {
		// TODO Auto-generated method stub
		dao.addDepartment(dept);
		
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return dao.getDepartmentById(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		 return dao.getAllDepartments();
	}

	@Override
	public boolean updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		return dao.updateDepartment(dept);
	}

	@Override
	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return dao.deleteDepartment(id);
	}

}
