package ru.zakhrey.strings.algoritm.metric;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Getter
public class TimeMetricCollector {

    // массив с количеством элементов
    private final List<Double> countsList;

    // массив с временем обработки
    private final List<Double> times;

    /**
     * Класс для измерения времени подсчета повторяющихся символов
     * @param consumer функция для измерения времени, зависящая от количества элементов
     * @param countsList список количества символов в строках
     * @param dispersion дисперсия для замеров не одного вызова метода, а среднего между несколькими вызовами
     */
    public TimeMetricCollector(Consumer<Integer> consumer,
                               List<Double> countsList,
                               int dispersion) {

        this.countsList = countsList;
        this.times = new ArrayList<>();

        long timeStart;
        long timeEnd;
        double finalTime;

        for (Double i : countsList) {

            finalTime = 0;
            timeStart = System.currentTimeMillis();
            for (int j = 0; j < dispersion; j++) {
                consumer.accept(i.intValue());
            }
            timeEnd = System.currentTimeMillis();
            finalTime += timeEnd - timeStart;

            times.add(finalTime  / dispersion);
        }

        System.gc();
    }

}
