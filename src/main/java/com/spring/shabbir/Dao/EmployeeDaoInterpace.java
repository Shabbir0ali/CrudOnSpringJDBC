package com.spring.shabbir.Dao;

import java.util.List;
import java.util.Scanner;

import com.spring.shabbir.enteties.EmployeeBean;

public interface EmployeeDaoInterpace {

	EmployeeBean register(Scanner sc, EmployeeBean bean2);

	int update(Scanner sc, EmployeeBean bean2);

	List<EmployeeBean> seeAllUser(Scanner sc, EmployeeBean bean2);

	EmployeeBean seeUserById(Scanner sc, EmployeeBean bean2);

	int delete(Scanner sc, EmployeeBean bean2);

	int findId(Scanner sc, EmployeeBean bean2);
}
