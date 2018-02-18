package jjsevi.junitand.mockito.spyVsMock;

import jjsevi.junitand.mockito.mockitoExtension.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ListTest {

    @Spy
    List<String> spyList = new ArrayList<>();


    @Mock
    List<String> mockList = new ArrayList<>();

    @Test
    @DisplayName("Testing spy objects")
    void testSpy() {

        // Mockito.when(spyList.get(0)).thenReturn("Rambo"); Error with spy
        // Because we do not define the behaviour
        // We need first this instruction
        Mockito.doReturn("Rambo").when(spyList).get(0);
        Assertions.assertSame("Rambo", spyList.get(0));
        Mockito.doReturn(3).when(spyList).size();
        Assertions.assertSame(3, spyList.size());
    }

    @Test
    @DisplayName("Testing mock objects")
    void testMock() {
        Mockito.when(mockList.get(0)).thenReturn("Rambo");
        Assertions.assertSame("Rambo", mockList.get(0));
        Mockito.when(mockList.size()).thenReturn(3);
        Assertions.assertSame(3, mockList.size());
    }
}
