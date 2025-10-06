package ru.zakhrey.strings.algoritm.servise.impl.count_duplicate;

import ru.zakhrey.strings.algoritm.servise.CountDuplicateCharsService;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class CountDuplicateCharSimpleImpl implements CountDuplicateCharsService {
    @Override
    public Map<Character, Integer> countDuplicateCharacters(String s) {

        var charMap = new HashMap<Character, Integer>();

        int charRes;

        for (Character i : s.toCharArray()) {

            if (isNull(charMap.get(i))) {
                charRes = 0;

                for (Character j : s.toCharArray()) {
                    if (i.equals(j)) {
                        charRes++;
                    }
                }
                charMap.put(i, charRes);
            }
        }
        return charMap;
    }
}
