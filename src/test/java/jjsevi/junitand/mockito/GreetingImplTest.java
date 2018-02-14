package jjsevi.junitand.mockito;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class GreetingImplTest {

    Greeting greeting;

    @BeforeEach
    void setUp() throws Exception {
        greeting = new GreetingImpl();
    }

    @Test
    void greetShouldAValidOutput() throws Exception {
        String result = greeting.greet("Junit");
        assertNotNull(result);
        assertEquals("Hello Junit", result);
    }

    @Test
    void greetShlouldThrowAnException_For_NameIsNull() throws Exception {
        Executable exceptionTest = () -> greeting.greet(null);
        assertThrows(IllegalArgumentException.class, exceptionTest);
    }

    @Test
    void greetShlouldThrowAnException_For_NameIsBlank() throws Exception {
        Executable exceptionTest = () -> greeting.greet("");
        assertThrows(IllegalArgumentException.class, exceptionTest);
    }
}