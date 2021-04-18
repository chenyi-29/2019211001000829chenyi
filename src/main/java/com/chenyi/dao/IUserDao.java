package com.chenyi.dao;

import com.chenyi.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public interface IUserDao {
    public boolean saveUser(Connection con, User user) throws SQLException;
    public int deleteUser(Connection con, User user) throws SQLException;
    public int updateUser(Connection con, User user) throws SQLException;

    public User findById(Connection con, Integer id) throws SQLException;
    public User findByUsernamePassword(Connection con, String username,String password) throws SQLException;
    public User findByUsername(Connection con, String username) throws SQLException;
    public User findByPassword(Connection con, String password) throws SQLException;
    public User findByEmail(Connection con, String email) throws SQLException;
    public User findByGender(Connection con, String gender) throws SQLException;
    public User findByBirthdate(Connection con, Date birthDate) throws SQLException;
    public User findAllUser(Connection con) throws SQLException;


}
