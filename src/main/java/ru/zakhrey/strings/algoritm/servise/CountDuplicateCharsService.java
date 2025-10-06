package ru.zakhrey.strings.algoritm.servise;

import java.util.Map;

public interface CountDuplicateCharsService {

    /**
     * Подсчет повторяющихся символов
     * @param s  - исходная строка с данными
     * @return количество повторяющихся символов
     */
    Map<Character, ? extends Number> countDuplicateCharacters(final String s);

}
