package jjsevi.junitand.mockito.order.bo;


import jjsevi.junitand.mockito.order.bo.exception.BOException;
import jjsevi.junitand.mockito.order.dto.Order;

public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int id) throws BOException;

    boolean deleteOrder(int id) throws BOException;

}
