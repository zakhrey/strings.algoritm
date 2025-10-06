package ru.zakhrey.strings.algoritm.drawer;

import ru.zakhrey.strings.algoritm.drawer.model.LineModel;
import ru.zakhrey.strings.algoritm.drawer.model.PlotSettingsModel;

import java.util.List;

public class ListDrawUtils {

    public static LineModel buildTimeLineModel(final List<Double> count,
                                               final List<Double> times,
                                               final String label) {

        return LineModel.builder()
                .x(count)
                .y(times)
                .sign("-")
                .label(label)
                .build();
    }
    public static PlotSettingsModel buildPlotSettings(final String title,
                                                      final String xLabel,
                                                      final String yLabel) {

        return PlotSettingsModel.builder()
                .legendLocation("upper left")
                .title(title)
                .xLabel(xLabel)
                .yLabel(yLabel)
                .build();
    }
}
