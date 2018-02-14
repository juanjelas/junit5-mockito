package jjsevi.junitand.mockito.bo;


import jjsevi.junitand.mockito.bo.exception.BOException;
import jjsevi.junitand.mockito.dto.Order;

public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int id) throws BOException;

    boolean deleteOrder(int id) throws BOException;

}
