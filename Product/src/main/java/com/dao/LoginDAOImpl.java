package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

	private static Connection connection;

	static {
		connection = DBUtil.getConnection();
	}

	@Override
	public boolean signIn(Login login) {
		try {
			PreparedStatement pst = connection
					.prepareStatement("select * from login where username = ? and password = ?");
			pst.setString(1, login.getUsername());
			pst.setString(2, login.getPassword());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String username = rs.getString(2);
				String password = rs.getString(3);
				if (username.equals(login.getUsername()) 
						&& password.equals(login.getPassword()))
					return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
