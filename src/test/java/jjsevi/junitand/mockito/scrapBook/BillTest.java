package jjsevi.junitand.mockito.scrapBook;

import jjsevi.junitand.mockito.mockitoExtension.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BillTest {

    @Mock
    private Book book;
    private Bill bill;

    @BeforeEach
    void setUp() {
        bill = new Bill(book);
    }

    @Test
    @DisplayName("Use void method should call the void method")
    void payBill() throws Exception {
        assertSame(1, bill.pay());
        verify(book).voidMethod();
    }

    @Test
    @DisplayName("Another use void method should call the void method")
    void payBill1() throws Exception {
        doNothing().when(book).voidMethod();
        assertSame(1, bill.pay());
        verify(book).voidMethod();
    }

    @Test
    @DisplayName("Use void method should throw runtime exception")
    void payBill2() throws Exception {
        doThrow(Exception.class).when(book).voidMethod();
        assertThrows(Exception.class, () -> bill.pay());
        verify(book).voidMethod();
    }

    @Test
    @DisplayName("Use void method should throw runtime exception with chain calls, first do nothing, " +
            "second throw Exception")
    void payBill3() throws Exception {
        doNothing().doThrow(Exception.class).when(book).voidMethod();
        bill.pay();
        verify(book).voidMethod();
        assertThrows(Exception.class, () -> bill.pay());
        verify(book).voidMethod();
    }

}
