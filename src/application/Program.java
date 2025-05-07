package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== Teste 1: Procurar vendedor por ID ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== Teste 2: Procurar vendedor por departamento ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== Teste 3: Procurar todos vendedores ====");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== Teste 4: Inserção do vendedor ====");
		Seller newSeller = new Seller(null, "Jailson Mendes", "jailson.mendes@gmail.com",new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserção efetuada! Novo ID: " + newSeller.getId());
		
		System.out.println("\n==== Teste 5: Atualização do vendedor ====");
		seller = sellerDao.findById(1);
		seller.setName("Paulo Guina");
		sellerDao.update(seller);
		System.out.println("Atualização completa!");
		
		System.out.println("\n==== Teste 6: Remoção do vendedor ====");
		System.out.print("Informe o ID para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Remoção completa!");
		
		sc.close();
		

	}

}
