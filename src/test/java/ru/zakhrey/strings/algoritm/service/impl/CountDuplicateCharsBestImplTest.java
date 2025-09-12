package ru.zakhrey.strings.algoritm.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.zakhrey.strings.algoritm.servise.CountDuplicateCharsService;
import ru.zakhrey.strings.algoritm.servise.impl.CountDuplicateCharsBestImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDuplicateCharsBestImplTest {

    private CountDuplicateCharsService count;

    @BeforeEach
    public void config() {
        this.count = new CountDuplicateCharsBestImpl();
    }

    @Test
    public void countDoublesTest() {

        assertEquals(0, count.countDuplicateChars("123"));
        assertEquals(1, count.countDuplicateChars("1123"));
        assertEquals(2, count.countDuplicateChars("111223"));
    }

}
