package ru.zakhrey.strings.algoritm.servise.impl.count_duplicate;

import ru.zakhrey.strings.algoritm.servise.CountDuplicateCharsService;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicateCharCycleImpl implements CountDuplicateCharsService {
    @Override
    public Map<Character, Integer> countDuplicateCharacters(String str) {

        Map<Character, Integer> result = new HashMap<>();

        for (char ch: str.toCharArray()) {
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }
}

