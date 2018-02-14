package jjsevi.junitand.mockito.bo;

import jjsevi.junitand.mockito.MockitoExtension;
import jjsevi.junitand.mockito.bo.exception.BOException;
import jjsevi.junitand.mockito.dao.OrderDAO;
import jjsevi.junitand.mockito.dto.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderBOImplTest {

    @InjectMocks
    private OrderBOImpl orderBO;

    @Mock
    private OrderDAO dao;

    @Test
    @DisplayName("Creamos una orden de pedido")
    void placeOrder1() throws SQLException, BOException {
        Order order = new Order();
        when(dao.create(order)).thenReturn(1);

        assertTrue(orderBO.placeOrder(order));
        verify(dao).create(order);
    }

    @Test
    void cancelOrder() {
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void getDao() {
    }

    @Test
    void setDao() {
    }

}