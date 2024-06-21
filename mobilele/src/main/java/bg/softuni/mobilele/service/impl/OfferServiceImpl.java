package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.data.OfferRepository;
import bg.softuni.mobilele.models.dtos.CreateOfferDTO;
import bg.softuni.mobilele.models.dtos.OfferDetailsDTO;
import bg.softuni.mobilele.models.entities.Offer;
import bg.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public long createOffer(CreateOfferDTO createOfferDTO) {
        return offerRepository.save(mapToEntity(createOfferDTO)).getId();
    }

    @Override
    public OfferDetailsDTO showOffer(Long id) {
       return offerRepository.findById(id)
               .map(OfferServiceImpl::mapToOfferDetails)
               .orElseThrow();
    }

    @Override
    public List<Offer> getAllOffers () {
        return offerRepository.findAll();
    }

    @Override
    public void deleteOffer(long id) {
        offerRepository.deleteById(id);
    }

    private static Offer mapToEntity(CreateOfferDTO createOfferDTO) {
        Offer offer = new Offer();
        offer.setEngine(createOfferDTO.engine());
        offer.setDescription(createOfferDTO.description());
        offer.setMileage(createOfferDTO.mileage());
        offer.setTransmission(createOfferDTO.transmission());

        return offer;
    }

    private static OfferDetailsDTO mapToOfferDetails (Offer offer) {
       return new OfferDetailsDTO(offer.getId(), offer.getDescription(),
               offer.getMileage(), offer.getEngine(), offer.getTransmission());
    }
}
