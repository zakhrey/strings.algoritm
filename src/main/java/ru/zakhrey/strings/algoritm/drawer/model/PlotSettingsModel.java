package ru.zakhrey.strings.algoritm.drawer.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlotSettingsModel {

    private String legendLocation;
    private String title;
    private String xLabel;
    private String yLabel;
}
