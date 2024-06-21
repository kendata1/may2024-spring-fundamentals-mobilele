package bg.softuni.mobilele.service;

import bg.softuni.mobilele.models.dtos.CreateOfferDTO;
import bg.softuni.mobilele.models.dtos.OfferDetailsDTO;
import bg.softuni.mobilele.models.entities.Offer;

import java.util.List;

public interface OfferService {
    long createOffer(CreateOfferDTO createOfferDTO);
    OfferDetailsDTO showOffer (Long id);
    List<Offer> getAllOffers();
    void deleteOffer(long id);
}
