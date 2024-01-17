package com.norwayyachtbrockers.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.norwayyachtbrockers.util.TrimStringDeserializer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Countries",
        description = "Schema to hold Country information"
)
public class CountryRequestDto {

    @Schema(
            description = "Country id ", example = "1"
    )
    private Long id;

    @NotNull(message="Country name is required")
    @Size(min=3, max=30, message="Country name must be at least 3 characters long")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s\\-]*$", message = "Country must start with a capital "
            + "letter and can consist of letters, spaces, and hyphens")
    @JsonDeserialize(using = TrimStringDeserializer.class)
    @JsonProperty("country_name")
    @Schema(
            description = "Name of Country", example = "Norway"
    )
    private String name;
}
