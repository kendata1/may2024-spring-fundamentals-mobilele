package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.dtos.CreateOfferDTO;
import bg.softuni.mobilele.models.dtos.OfferDetailsDTO;
import bg.softuni.mobilele.models.enums.Engine;
import bg.softuni.mobilele.models.enums.Transmission;
import bg.softuni.mobilele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/add")
    public String newOffer (Model model) {
        model.addAttribute("engineTypes", Engine.values());
        model.addAttribute("transmissionTypes", Transmission.values());

        if (!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", CreateOfferDTO.empty());
        }

        return "offer-add";
    }

    @PostMapping("add")
    public String createOffer (@Valid CreateOfferDTO createOfferDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createOfferDTO", createOfferDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offers/add";
        }

        long newOfferId = offerService.createOffer(createOfferDTO);

        return "redirect:/offers/" + newOfferId;
    }

    @GetMapping("/{id}")
    public String offerDetails(@PathVariable("id") Long id, Model model) {
        model.addAttribute("offerDetails", offerService.showOffer(id));
        return "details";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        offerService.deleteOffer(id);
        return "redirect:/offers/all";
    }

}
