package jjsevi.junitand.mockito.order.bo;

import jjsevi.junitand.mockito.mockitoExtension.MockitoExtension;
import jjsevi.junitand.mockito.order.bo.exception.BOException;
import jjsevi.junitand.mockito.order.dao.OrderDAO;
import jjsevi.junitand.mockito.order.dto.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderBOImplTest {

    private Order order;
    @InjectMocks
    private OrderBOImpl orderBO;
    @Mock
    private OrderDAO dao;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    /**
     * The mock will return 1 when call to method dao.create with an order
     * Correct behaviour
     */
    @Test
    @DisplayName("Should create an order")
    void placeOrder1() throws SQLException, BOException {
        when(dao.create(order)).thenReturn(1);

        assertTrue(orderBO.placeOrder(order));
        verify(dao).create(order);
    }

    /**
     * The mock will return 0 when call to method dao.create with an order
     * Incorrect behaviour
     */
    @Test
    @DisplayName("Should not create an order")
    void placeOrder2() throws SQLException, BOException {
        when(dao.create(order)).thenReturn(0);

        assertFalse(orderBO.placeOrder(order));
        verify(dao).create(order);
        verify(dao, times(1)).create(order);
        verify(dao, atLeast(1)).create(order);
    }

    @Test
    @DisplayName("Should trow BOException")
    void placeOrder3() throws SQLException, BOException {
        when(dao.create(order)).thenThrow(SQLException.class);

        assertThrows(BOException.class, () -> orderBO.placeOrder(order));
        verify(dao).create(order);
    }

    @Test
    @DisplayName("Should cancel the order")
    void cancelOrder() throws SQLException, BOException {
        when(dao.read(anyInt())).thenReturn(order);
        when(dao.update(order)).thenReturn(1);
        boolean result = orderBO.cancelOrder(anyInt());

        assertTrue(result);
        verify(dao).read(anyInt());
        verify(dao).update(order);
    }

    @Test
    @DisplayName("Should not cancel the order")
    void cancelOrder1() throws SQLException, BOException {
        when(dao.read(anyInt())).thenReturn(order);
        when(dao.update(order)).thenReturn(0);
        boolean result = orderBO.cancelOrder(anyInt());

        assertFalse(result);
        verify(dao).read(anyInt());
        verify(dao).update(order);
    }

    @Test
    @DisplayName("Should trow BOException on read")
    void cancelOrder2() throws SQLException, BOException {
        when(dao.read(anyInt())).thenThrow(SQLException.class);

        assertThrows(BOException.class, () -> orderBO.cancelOrder(anyInt()));
    }

    @Test
    @DisplayName("Should trow BOException on update")
    void cancelOrder3() throws SQLException, BOException {
        when(dao.read(anyInt())).thenReturn(order);
        when(dao.update(order)).thenThrow(SQLException.class);

        assertThrows(BOException.class, () -> orderBO.cancelOrder(anyInt()));
    }

    @Test
    @DisplayName("Should delete order")
    void deleteOrder() throws SQLException, BOException {
        when(dao.delete(anyInt())).thenReturn(1);

        assertTrue(orderBO.deleteOrder(anyInt()));
        verify(dao).delete(anyInt());
    }

    @Test
    @DisplayName("Should not delete order")
    void deleteOrder1() throws SQLException, BOException {
        when(dao.delete(anyInt())).thenReturn(0);

        assertFalse(orderBO.deleteOrder(anyInt()));
        verify(dao).delete(anyInt());
    }

    @Test
    @DisplayName("Should throw an Exception")
    void deleteOrder2() throws SQLException, BOException {
        when(dao.delete(anyInt())).thenThrow(SQLException.class);

        assertThrows(BOException.class, () -> orderBO.deleteOrder(anyInt()));
        verify(dao).delete(anyInt());
    }


    @Test
    @DisplayName("Should get dao")
    void getDao() {
        assertNotNull(orderBO.getDao());
    }

    @Test
    @DisplayName("Should set dao")
    void setDao() {
        assertEquals(dao, orderBO.getDao());
    }

}