package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void add(User user) {
		String sql = "INSERT INTO user(name, age, username, password,role, gender, image) "
				+ "VALUES (?, ?, ?, ?, ?,?, ?);";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getImage());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE user SET name = ?, username = ?, password = ?,role = ?, age = ?, gender = ?, image = ? WHERE id = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setInt(5, user.getAge());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getImage());
			preparedStatement.setInt(8, user.getId());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
	}
	
	@Override
	public void updateLoginCounter(int id, int counter) {
		String sql = "UPDATE user SET login_counter = ? WHERE id = ? ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, counter);
			preparedStatement.setInt(2, id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM user WHERE id = ?";

		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}
	}

	@Override
	public User get(int id) {
		String sql = "SELECT * FROM user WHERE id = ?";

		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return rowMapper(resultSet);
			}

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}

	@Override
	public List<User> search(String name) {
		List<User> users = new ArrayList<>();

		String sql = "SELECT * FROM user WHERE name LIKE ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, "%" + name + "%");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				users.add(rowMapper(resultSet));
			}
		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return users;
	}

	@Override
	public User getByUsername(String username) {
		String sql = "SELECT * FROM user WHERE username = ?";

		try {
			Connection conn = super.getConnection();

			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				return rowMapper(resultSet);
			}

		} catch (Exception e) {
			System.out.println("Loi: " + e);
		}

		return null;
	}

	private User rowMapper(ResultSet resultSet) throws SQLException {
		User user = new User();

		user.setId(resultSet.getInt("id"));
		user.setName(resultSet.getString("name"));
		user.setUsername(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		user.setAge(resultSet.getInt("age"));
		user.setRole(resultSet.getString("role"));
		user.setGender(resultSet.getString("gender"));
		user.setImage(resultSet.getString("image"));
		user.setLoginCounter(resultSet.getInt("login_counter"));

		return user;
	}
}
