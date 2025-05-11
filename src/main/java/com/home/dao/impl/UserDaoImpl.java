package com.home.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.home.constant.Constants;
import com.home.dao.UserDao;
import com.home.dto.UserDto;
import com.home.entity.UserEntity;
import com.home.repository.UserRepository;
import com.home.utils.DbConnection;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository mySqlUserRepository;

	@Autowired
	private DbConnection dbConection;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
	String message = Constants.ERROR;

	@Override
	public List<UserEntity> getMySqlUsers() {
		LOGGER.info("UserDaoImpl getMySqlUsers method   :: START");
		return mySqlUserRepository.findAll();
	}

	@Override
	public Optional<UserEntity> getUserById(int id) {
		LOGGER.info("UserDaoImpl getUserById method :: START");
		return mySqlUserRepository.findById(id);
	}

	@Override
	public String deleteUser(int id) {
		LOGGER.info("UserDaoImpl deleteUser method  :: START");
		mySqlUserRepository.deleteById(id);
		Optional<UserEntity> response = mySqlUserRepository.findById(id);
		LOGGER.info("UserDaoImpl deleteUser method  :: END");
		return response.toString();
	}

	@Override
	public UserEntity loginUser(UserEntity user) {
		LOGGER.info("UserDaoImpl loginUser method   :: START");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UserEntity userResponse = new UserEntity();

		try {
			connection = dbConection.getDbConnection();
			String sql = "SELECT Id,Name,Password FROM user WHERE Name =" + " '" + user.getUsername() + "' "
					+ " AND Password = " + " '" + user.getPassword() + "' ";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				userResponse.setId(rs.getInt("Id"));
				userResponse.setUsername(rs.getString("Name"));
				userResponse.setPassword(rs.getString("Password"));
			}

		} catch (Exception e) {
			LOGGER.error("UserDaoImpl loginUser method catch block :: Exception :: ", e);
		} finally {
			try {
				if (connection != null && preparedStatement != null) {
					preparedStatement.close();
					connection.close();
				}

			} catch (SQLException e) {

				LOGGER.error("UserDaoImpl loginUser method finally block :: SQLException :: ", e);
			}
		}
		LOGGER.info("UserDaoImpl loginUser method  :: END");
		return userResponse;
	}

	@Override
	public UserEntity saveUser(UserDto user) {
		UserEntity newUser = new UserEntity();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setAge(user.getAge());
		newUser.setSalary(user.getSalary());
		newUser.setServiceType(user.getServiceType());
		return mySqlUserRepository.save(newUser);
	}

}
