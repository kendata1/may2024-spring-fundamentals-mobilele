package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.Engine;
import bg.softuni.mobilele.models.enums.Transmission;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateOfferDTO(
        @NotNull(message = "Engine type is required")
        @Enumerated(value = EnumType.STRING)
        Engine engine,
        @NotNull(message = "Transmission type is required")
        @Enumerated(value = EnumType.STRING)
        Transmission transmission,
        @PositiveOrZero(message = "Mileage should be >= 0")
        @NotNull
        Long mileage,
        @NotNull
        @Size(min = 5, max = 500, message = "Have to be between 5 and 500 symbols")
        String description
) {
        public static CreateOfferDTO empty() {
                return new CreateOfferDTO(null, null, null, null);
        }
}
