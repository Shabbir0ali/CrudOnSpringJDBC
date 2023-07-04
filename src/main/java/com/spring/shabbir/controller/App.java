package com.spring.shabbir.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.shabbir.Dao.EmployeeDaoInterpace;
import com.spring.shabbir.enteties.EmployeeBean;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springJdbcConfig.xml");

		EmployeeDaoInterpace bean = context.getBean("daoImple", EmployeeDaoInterpace.class);
		EmployeeBean bean2 = context.getBean("bean2", EmployeeBean.class);
		Scanner sc = new Scanner(System.in);

		System.err.println("WELCOME TO OUT APPLICATION...\n");

		boolean flag = true;

		while (flag) {
			System.out.println("ENTER 1 TO REGISTER :\t");
			System.out.println("ENTER 2 TO SEE ALL USER :\t");
			System.out.println("ENTER 3 TO SEE ONE USER :\t");
			System.out.println("ENTER 4 TO UPDATE USER :\t");
			System.out.println("ENTER 5 TO DELETE USER :\t");
			System.out.println("ENTER 6 TO FORGET YOUR ID :\t");
			System.out.println("ENTER 7 TO EXIT OUR APPLICATION :\t");
			int val = sc.nextInt();
			int update = 0;
			switch (val) {
			case 1:
				EmployeeBean register = bean.register(sc, bean2);
				System.out.println(register.getId() + " This is your id remember that");
				break;
			case 2:
				List<EmployeeBean> view = bean.seeAllUser(sc, bean2);
				for (EmployeeBean employeeBean : view) {
					System.out.println(employeeBean.getId() + "  \t" + employeeBean.getFirstName() + "      \t"
							+ employeeBean.getLastName() + "      \t" + employeeBean.getCity() + "        \t"
							+ employeeBean.getCountry());
				}
				break;
			case 3:
				EmployeeBean bean3 = bean.seeUserById(sc,bean2);
				System.out.println(bean3);
				break;
			case 4:
				update = bean.update(sc, bean2);
				System.out.println("Number of User Updated :" + update);
				break;
			case 5:
				update = bean.delete(sc,bean2);
				if(update > 0) {
					System.out.println("User Deleted Seccessfully");
				}
				else {
					System.out.println("Enter valid id");
				}
				break;
			case 6:
				 update = bean.findId(sc,bean2);
				 System.out.println("YOUR ID IS "+update);
				break;
			case 7:
				context.close();
				flag = false;
				break;
			default:
				System.out.println("Enter Valid Number Number Only");
				break;
			}
		}
	}
}
