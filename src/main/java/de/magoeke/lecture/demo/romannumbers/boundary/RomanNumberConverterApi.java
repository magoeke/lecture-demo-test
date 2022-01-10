package de.magoeke.lecture.demo.romannumbers.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.magoeke.lecture.demo.romannumbers.control.RomanNumbersConverter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@RestController
@RequestMapping("/roman-numbers")
@SecurityScheme(type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER, name = "X-API-KEY")
public class RomanNumberConverterApi {

    private final RomanNumbersConverter romanNumbersConverter;

    public RomanNumberConverterApi(final RomanNumbersConverter romanNumbersConverter) {
        this.romanNumbersConverter = romanNumbersConverter;
    }

    @Operation(summary = "Takes arabic number and converts it to roman.",
            security = @SecurityRequirement(name = "X-API-KEY"))
    @GetMapping("/{number}")
    public String convertToRomanNumber(@PathVariable("number") final Integer number) {
        return romanNumbersConverter.convertToRoman(number);
    }

}
