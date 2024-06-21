package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.Engine;
import bg.softuni.mobilele.models.enums.Transmission;

public record OfferDetailsDTO(Long id,
                              String description,
                              Long mileage,
                              Engine engine,
                              Transmission transmission) {


}
