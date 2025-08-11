package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exception.DepartmentNotFoundException;
import Model.Department;
import util.DatabaseConnect;

public class DepartmentDaoImpl implements DepartmentDao {
	Connection con = DatabaseConnect.getConnection();

	@Override
	public void addDepartment(Department dept) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO department (deptId, depName, depLocation) VALUES (?, ?, ?)";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dept.getDepId());
            ps.setString(2, dept.getDepName());
            ps.setString(3, dept.getDepLocation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM department WHERE deptId = ?";
	        try {
	        	PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return new Department(rs.getInt("deptId"), rs.getString("depName"), rs.getString("depLocation"));
	            } else {
	                throw new DepartmentNotFoundException("Department with ID " + id + " not found.");
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e.getMessage());
	        }
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Department(rs.getInt("deptId"), rs.getString("depName"), rs.getString("depLocation")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		String sql = "UPDATE departement SET depName = ?, depLocation = ? WHERE deptId = ?";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dept.getDepName());
            ps.setString(2, dept.getDepLocation());
            ps.setInt(3, dept.getDepId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM department WHERE deptId = ?";
        try {
        	PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) throw new DepartmentNotFoundException("Department ID " + id + " not found for deletion.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	

}
