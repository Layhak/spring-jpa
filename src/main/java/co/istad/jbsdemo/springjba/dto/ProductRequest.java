package co.istad.jbsdemo.springjba.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record ProductRequest(
        @NotNull
        @NotEmpty
        String title,
        String description,
        @NotNull
        @NotEmpty
        String imageUrl,
        @Positive
        float price) {
}
