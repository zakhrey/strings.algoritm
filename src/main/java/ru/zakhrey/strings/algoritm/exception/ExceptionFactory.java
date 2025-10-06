package ru.zakhrey.strings.algoritm.exception;

public class ExceptionFactory {

    public static UniqueSymbolsSearchingException noUniqueSymbolsException(final String source) {

        return new UniqueSymbolsSearchingException(
                String.format(
                        "There is no symbols which does not have a duplicate in the String: %s",
                        source
                )
        );
    }

}
