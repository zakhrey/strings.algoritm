package ru.zakhrey.strings.algoritm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.zakhrey.strings.algoritm.servise.CountDuplicateCharsService;
import ru.zakhrey.strings.algoritm.servise.impl.count_duplicate.CountDuplicateCharCycleImpl;
import ru.zakhrey.strings.algoritm.servise.impl.count_duplicate.CountDuplicateCharStreamImpl;
import ru.zakhrey.strings.algoritm.servise.impl.count_duplicate.CountDuplicateCharSimpleImpl;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDuplicateCharsTest {

    private CountDuplicateCharsService simpleCount;
    private CountDuplicateCharsService cycleCount;
    private CountDuplicateCharsService streamCount;

    @BeforeEach
    public void config() {
        this.simpleCount = new CountDuplicateCharSimpleImpl();
        this.cycleCount = new CountDuplicateCharCycleImpl();
        this.streamCount = new CountDuplicateCharStreamImpl();
    }

    @Test
    public void countStupidDuplicateTest() {

        Map<Character, Integer> counts = (Map<Character, Integer>) simpleCount.countDuplicateCharacters("122333");

        assertEquals(1, counts.get('1'));
        assertEquals(null, counts.get('0'));
        assertEquals(2, counts.get('2'));
        assertEquals(3, counts.get('3'));
    }

    @Test
    public void countCycleDuplicateTest() {

        Map<Character, Integer> counts = (Map<Character, Integer>) cycleCount.countDuplicateCharacters("122333");

        assertEquals(1, counts.get('1'));
        assertEquals(null, counts.get('0'));
        assertEquals(2, counts.get('2'));
        assertEquals(3, counts.get('3'));
    }



    @Test
    public void countStreamDuplicateTest() {

        Map<Character, Long> counts = (Map<Character, Long>) streamCount.countDuplicateCharacters("122333");

        assertEquals(1, counts.get('1'));
        assertEquals(null, counts.get('0'));
        assertEquals(2, counts.get('2'));
        assertEquals(3, counts.get('3'));
    }

}
