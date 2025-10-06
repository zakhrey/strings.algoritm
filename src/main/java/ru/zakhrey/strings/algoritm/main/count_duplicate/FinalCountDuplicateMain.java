package ru.zakhrey.strings.algoritm.main.count_duplicate;

import com.github.sh0nk.matplotlib4j.NumpyUtils;
import com.github.sh0nk.matplotlib4j.Plot;
import ru.zakhrey.strings.algoritm.metric.TimeMetricCollector;
import ru.zakhrey.strings.algoritm.servise.CountDuplicateCharsService;
import ru.zakhrey.strings.algoritm.servise.impl.count_duplicate.CountDuplicateCharCycleImpl;
import ru.zakhrey.strings.algoritm.servise.impl.count_duplicate.CountDuplicateCharSimpleImpl;
import ru.zakhrey.strings.algoritm.servise.impl.count_duplicate.CountDuplicateCharStreamImpl;

import java.util.List;

import static ru.zakhrey.strings.algoritm.constant.Constants.DISPERSION;
import static ru.zakhrey.strings.algoritm.drawer.ListDrawUtils.buildPlotSettings;
import static ru.zakhrey.strings.algoritm.drawer.ListDrawUtils.buildTimeLineModel;
import static ru.zakhrey.strings.algoritm.drawer.PlotDrawer.*;
import static ru.zakhrey.strings.algoritm.generator.string.RandomStringGenerator.generateRandomString;

public class FinalCountDuplicateMain {

    public static void main(String[] args) {

        CountDuplicateCharsService simpleService = new CountDuplicateCharSimpleImpl();
        CountDuplicateCharsService cycleService = new CountDuplicateCharCycleImpl();
        CountDuplicateCharsService streamService = new CountDuplicateCharStreamImpl();

        List<Double> xValues = NumpyUtils.linspace(10_000, 5_000_000, 100);

        TimeMetricCollector simpleCollector = new TimeMetricCollector(
            el -> simpleService.countDuplicateCharacters(generateRandomString(el)),
            xValues,
            DISPERSION
        );

        Plot timePlot = buildPlot(buildTimeLineModel(xValues, simpleCollector.getTimes(), "Simple count"));

        xValues = NumpyUtils.linspace(10_000, 5_000_000, 100);

        TimeMetricCollector cycleCollector = new TimeMetricCollector(
            el -> cycleService.countDuplicateCharacters(generateRandomString(el)),
            xValues,
            DISPERSION
        );

        addToPlot(timePlot, buildTimeLineModel(xValues, cycleCollector.getTimes(), "Cycle count"));

        TimeMetricCollector streamCollector = new TimeMetricCollector(
            el -> streamService.countDuplicateCharacters(generateRandomString(el)),
            xValues,
            DISPERSION
        );

        addToPlot(timePlot, buildTimeLineModel(xValues, streamCollector.getTimes(), "Stream count"));


        drawPlot(timePlot,
            buildPlotSettings("Characters counting time plot",
                "Characters count in source String",
                "Time to count Characters, ms"
        ));
    }

}
