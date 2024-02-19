package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoHibernateImpl();

    public UserServiceImpl() {
    }

    @Override
    public void createUsersTable() {
        try {
            userDao.createUsersTable();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
        userDao.dropUsersTable();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
        userDao.saveUser(name, lastName, age);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
        userDao.removeUserById(id);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
        return userDao.getAllUsers();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void cleanUsersTable() {
        try {
        userDao.cleanUsersTable();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
