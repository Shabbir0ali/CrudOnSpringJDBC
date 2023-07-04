package com.spring.shabbir.Dao.imple;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.shabbir.Dao.EmployeeDaoInterpace;
import com.spring.shabbir.enteties.EmployeeBean;
import com.spring.shabbir.enteties.FetchingData;

@Component("daoImple")
public class EmployeeDaoImple implements EmployeeDaoInterpace {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public EmployeeBean register(Scanner sc, EmployeeBean bean2) {
		System.out.println("Enter user First Name :");
		bean2.setFirstName(sc.next());
		System.out.println("Enter user Last Name :");
		bean2.setLastName(sc.next());
		System.out.println("Enter user City :");
		bean2.setCity(sc.next());
		System.out.println("Enter user Country :");
		bean2.setCountry(sc.next());
		jdbcTemplate.update("insert into employees(efirst_name,elast_name,ecity,country) values(?,?,?,?)",
				bean2.getFirstName(), bean2.getLastName(), bean2.getCity(), bean2.getCountry());
		EmployeeBean object = jdbcTemplate.queryForObject("select * from employees where elast_name=?",
				new FetchingData(), bean2.getLastName());

		return object;
	}

	public int update(Scanner sc, EmployeeBean bean2) {
		System.out.println("ENTER YOUR ID");
		int i = sc.nextInt();
		int j = 0;
		boolean flag = false;
		List<EmployeeBean> list = jdbcTemplate.query("select * from employees", new FetchingData());
		for (EmployeeBean employeeBean : list) {
			if (employeeBean.getId() == i) {
				flag = true;
				System.err.println("WHAT DO YOU WANT TO UPDATE...\n");
				System.out.println("Enter 1 to update First Name :");
				System.out.println("Enter 2 to update last Name");
				System.out.println("Enter 3 to update city");
				System.out.println("Enter 4 to update country");
				String query = null;
				byte b = sc.nextByte();
				switch (b) {
				case 1:
					System.out.println("Enter your First Name :");
					bean2.setFirstName(sc.next());
					query = "update employees set efirst_name = ? where eid = ?";
					j = jdbcTemplate.update(query, bean2.getFirstName(), employeeBean.getId());
					break;
				case 2:
					System.out.println("Enter your Last Name :");
					bean2.setLastName(sc.next());
					query = "update employees set elast_name = ? where eid = ?";
					j = jdbcTemplate.update(query, bean2.getLastName(), employeeBean.getId());
					break;
				case 3:
					System.out.println("Enter your city :");
					bean2.setCity(sc.next());
					query = "update employees set ecity= ? where eid = ?";
					j = jdbcTemplate.update(query, bean2.getCity(), employeeBean.getId());
					break;
				case 4:
					System.out.println("Enter your country :");
					bean2.setCountry(sc.next());
					;
					query = "update employees set country= ? where eid = ?";
					j = jdbcTemplate.update(query, bean2.getCountry(), employeeBean.getId());
					break;
				default:
					System.out.println("Enter valid Number");
					break;
				}
				break;
			} else {
				flag = false;
			}
		}
		if (!flag) {
			System.out.println("YOUR ID DOSEN'T EXIST");
		}
		return j;
	}

	public List<EmployeeBean> seeAllUser(Scanner sc, EmployeeBean bean2) {

		List<EmployeeBean> list = jdbcTemplate.query("select * from employees", new FetchingData());
		return list;
	}

	public EmployeeBean seeUserById(Scanner sc, EmployeeBean bean2) {
		System.out.println("Enter your Id :");
		bean2.setId(sc.nextInt());
		EmployeeBean bean = null;
		boolean flag = false;
		List<EmployeeBean> query = jdbcTemplate.query("select * from employees", new FetchingData());
		for (EmployeeBean employeeBean : query) {
			if (bean2.getId() == employeeBean.getId()) {
				flag = true;
				bean = jdbcTemplate.queryForObject("select * from employees where eid = ?", new FetchingData(),
						bean2.getId());
				break;
			} else {
				flag = false;
			}
		}
		if (!flag) {
			System.out.println("Your Id dosen't exist");
		}
		return bean;
	}

	public int delete(Scanner sc, EmployeeBean bean2) {
		System.out.println("Enter Your Id :");
		bean2.setId(sc.nextInt());
		int i = jdbcTemplate.update("delete from employees where eid = ?",bean2.getId());
		return i;
	}

	public int findId(Scanner sc, EmployeeBean bean2) {
		System.out.println("Enter your first name");
		bean2.setFirstName(sc.next());
		System.out.println("Enter your last name");
		bean2.setLastName(sc.next());
		EmployeeBean bean = jdbcTemplate.queryForObject("select * from employees where efirst_name=? and elast_name=?",new FetchingData(),bean2.getFirstName(),bean2.getLastName());
		return bean.getId();
	}
}