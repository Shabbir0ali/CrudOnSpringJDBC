package com.spring.shabbir.enteties;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

public class FetchingData implements RowMapper<EmployeeBean>{

	public EmployeeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springJdbcConfig.xml");
		
		EmployeeBean bean = context.getBean("bean2",EmployeeBean.class);
		bean.setId(rs.getInt("eid"));
		bean.setFirstName(rs.getString("efirst_name"));
		bean.setLastName(rs.getString("elast_name"));
		bean.setCity(rs.getString("ecity"));
		bean.setCountry(rs.getString("country"));
		return bean;
	}
}