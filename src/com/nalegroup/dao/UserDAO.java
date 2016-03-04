package com.nalegroup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UserDAO {
	
	public boolean validateUser(String userid, String password) {

		Connection connection = null;
		ResultSet rs = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo", "postgres", "admin");

			rs = connection.createStatement().executeQuery(
					"SELECT * FROM users where login='" + userid + "'" + " and password ='" + password + "'");

			if (!rs.next()) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}


}
