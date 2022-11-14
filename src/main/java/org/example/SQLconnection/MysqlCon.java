package org.example.SQLconnection;

import org.example.ORM.Repository;
import org.example.exampleClasses.Product;
import org.example.exampleClasses.Shop;
import org.example.exampleClasses.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MysqlCon<T> {

    public static void main(String arg[]) throws SQLException {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "summery_project", "root", "omar135790864");

        } catch(ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        Repository<User> userORM = new Repository<>(User.class, connection);
        userORM.connect("root", "omar135790864");
//        userORM.createTable();

        User user1 = new User(112,"omar", "a");
        User user2 = new User(113,"shay", "b");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        userORM.addAll(userList);


//        Repository<Product> productORM = new Repository<>(Product.class, connection);
//        productORM.createTable();
//
//        Repository<Shop> shopORM = new Repository<>(Shop.class, connection);
//        shopORM.createTable();

        connection.close();
    }
}
