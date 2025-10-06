package ru.zakhrey.strings.algoritm.main.count_duplicate;

import com.github.sh0nk.matplotlib4j.NumpyUtils;
import com.github.sh0nk.matplotlib4j.Plot;
import ru.zakhrey.strings.algoritm.metric.TimeMetricCollector;
import ru.zakhrey.strings.algoritm.servise.CountDuplicateCharsService;
import ru.zakhrey.strings.algoritm.servise.impl.count_duplicate.CountDuplicateCharCycleImpl;

import java.util.List;

import static ru.zakhrey.strings.algoritm.constant.Constants.DISPERSION;
import static ru.zakhrey.strings.algoritm.drawer.ListDrawUtils.buildPlotSettings;
import static ru.zakhrey.strings.algoritm.drawer.ListDrawUtils.buildTimeLineModel;
import static ru.zakhrey.strings.algoritm.drawer.PlotDrawer.buildPlot;
import static ru.zakhrey.strings.algoritm.drawer.PlotDrawer.drawPlot;
import static ru.zakhrey.strings.algoritm.generator.string.RandomStringGenerator.generateRandomString;

public class CycleCountDuplicateMain {

    public static void main(String[] args) {

        CountDuplicateCharsService countService = new CountDuplicateCharCycleImpl();

        List<Double> xValues = NumpyUtils.linspace(10_000, 5_000_000, 100);

        TimeMetricCollector collector = new TimeMetricCollector(
            el -> countService.countDuplicateCharacters(generateRandomString(el)),
            xValues,
            DISPERSION
        );

        Plot timePlot = buildPlot(buildTimeLineModel(xValues, collector.getTimes(), ""));
        drawPlot(timePlot,
            buildPlotSettings("Cycle characters counting time plot",
                "Characters count in source String",
                "Time to count Characters, ms"
        ));
    }

}
