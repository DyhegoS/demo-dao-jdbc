package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department newDepartement = new Department(null, "TI");
		departmentDao.insert(newDepartement);
		System.out.println("Inserção efetuada! ID " + newDepartement.getId());

	}

}
