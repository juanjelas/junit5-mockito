package jjsevi.junitand.mockito.order.dao;

import jjsevi.junitand.mockito.order.dto.Order;

import java.sql.SQLException;


public interface OrderDAO {

    int create(Order order) throws SQLException;

    Order read(int id) throws SQLException;

    int update(Order order) throws SQLException;

    int delete(int id) throws SQLException;
}
