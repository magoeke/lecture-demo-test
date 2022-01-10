package de.magoeke.lecture.demo.romannumbers.control;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RomanNumbersConverterTest {

    private RomanNumbersConverter romanNumbersConverter;

    @BeforeEach
    void setUp() {
        romanNumbersConverter = new RomanNumbersConverter();
    }

    @Test
    void should_return_NAN_when_value_lower_than_the_min_value_is_passed() {
        final var result = romanNumbersConverter.convertToRoman(0);

        assertThat(result).isEqualTo("NAN");
    }

    @Test
    void should_return_NAN_when_value_higher_than_the_max_value_is_passed() {
        final var result = romanNumbersConverter.convertToRoman(4000);

        assertThat(result).isEqualTo("NAN");
    }

    @Test
    void should_return_I_when_1_is_passed() {
        final var result = romanNumbersConverter.convertToRoman(1);

        assertThat(result).isEqualTo("I");
    }

    @Test
    void should_return_IV_when_4_is_passed() {
        final var result = romanNumbersConverter.convertToRoman(4);

        assertThat(result).isEqualTo("IV");
    }

    @Test
    void should_return_XIV_when_14_is_passed() {
        final var result = romanNumbersConverter.convertToRoman(14);

        assertThat(result).isEqualTo("XIV");
    }

}
