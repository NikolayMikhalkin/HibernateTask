package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl uss = new UserServiceImpl();
        uss.createUsersTable();

        uss.saveUser("ivan", "ivanov", (byte) 18);
        uss.saveUser("vasya", "ivanov", (byte) 12);
        uss.saveUser("kolya", "ivanov", (byte) 43);
        uss.saveUser("vladyan", "ivanov", (byte) 21);

        List<User> users = uss.getAllUsers();
        System.out.println(users.toString());

        uss.cleanUsersTable();
        uss.dropUsersTable();
    }
}
