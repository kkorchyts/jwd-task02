package com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.impl;

import com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.ApplianceBuilder;
import com.ccorchyts.jwd.task02.entity.builder.property.ApplianceFields;
import com.ccorchyts.jwd.task02.entity.impl.Speakers;
import com.ccorchyts.jwd.task02.util.numberparsing.ValueParser;

import java.util.Map;

public final class SpeakersBuilderImpl implements ApplianceBuilder<Speakers> {
    private Integer powerConsumption;
    private Integer numberOfSpeakers;
    private String frequencyRange;
    private Float cordLength;

    public SpeakersBuilderImpl() {
    }

    public static SpeakersBuilderImpl builder() {
        return new SpeakersBuilderImpl();
    }

    public SpeakersBuilderImpl powerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public SpeakersBuilderImpl numberOfSpeakers(Integer numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
        return this;
    }

    public SpeakersBuilderImpl frequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
        return this;
    }

    public SpeakersBuilderImpl cordLength(Float cordLength) {
        this.cordLength = cordLength;
        return this;
    }

    @Override
    public SpeakersBuilderImpl properties(Map<String, Object> properties) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            switch (ApplianceFields.Speakers.valueOf(entry.getKey())) {
                case POWER_CONSUMPTION:
                    powerConsumption = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case NUMBER_OF_SPEAKERS:
                    numberOfSpeakers = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case FREQUENCY_RANGE:
                    frequencyRange = String.valueOf(entry.getValue());
                    break;
                case CORD_LENGTH:
                    cordLength = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ApplianceFields.Speakers.valueOf(entry.getKey()));
            }
        }
        return this;
    }

    @Override
    public Speakers build() {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(powerConsumption);
        speakers.setNumberOfSpeakers(numberOfSpeakers);
        speakers.setFrequencyRange(frequencyRange);
        speakers.setCordLength(cordLength);
        return speakers;
    }
}
