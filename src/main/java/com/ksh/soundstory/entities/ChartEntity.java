package com.ksh.soundstory.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(of = "chartId")
public class ChartEntity {
    private int chartId;
    private int song;
}
