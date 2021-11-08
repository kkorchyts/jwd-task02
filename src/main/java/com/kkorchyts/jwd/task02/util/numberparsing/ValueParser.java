package com.kkorchyts.jwd.task02.util.numberparsing;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class ValueParser {
    private static final DecimalFormat decimalFormat;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        decimalFormat = new DecimalFormat("#.#", symbols);
    }

    public static Float parseFloat(String value) {
        try {
            return decimalFormat.parse(value.trim()).floatValue();
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Integer parseInteger(String value) {
        try {
            return decimalFormat.parse(value.trim()).intValue();
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
