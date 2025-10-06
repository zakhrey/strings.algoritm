package ru.zakhrey.strings.algoritm.servise.impl.count_duplicate;

import ru.zakhrey.strings.algoritm.servise.CountDuplicateCharsService;

import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateCharStreamImpl implements CountDuplicateCharsService {
    @Override
    public Map<Character, Long> countDuplicateCharacters(String str) {

        return str.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}

