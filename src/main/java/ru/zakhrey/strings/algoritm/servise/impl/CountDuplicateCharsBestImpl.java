package ru.zakhrey.strings.algoritm.servise.impl;

import ru.zakhrey.strings.algoritm.servise.CountDuplicateCharsService;

import java.util.HashMap;

import static java.util.Objects.isNull;

public class CountDuplicateCharsBestImpl implements CountDuplicateCharsService {
    @Override
    public int countDuplicateChars(String s) {

        var charMap = new HashMap<Byte, Integer>();

        int res = 0;
        for (byte i : s.getBytes()) {
            if (isNull(charMap.get(i))) {
                charMap.put(i, 1);
            }
            else if (charMap.get(i).equals(1)) {
                res ++;
                charMap.put(i, 2);
            }
        }
        return res;
    }
}
