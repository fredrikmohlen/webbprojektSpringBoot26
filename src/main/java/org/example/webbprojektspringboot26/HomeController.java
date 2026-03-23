package org.example.webbprojektspringboot26;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("heroText","Detta är en bokdatabas som visar vilka böcker jag läst. " +
                "Det går att visa vilka böcker jag läst hittills via \"Visa alla böcker\". Dessutom kan jag lägga till " +
                "fler böcker via \"Lägg till ny bok\"."
        );

        model.addAttribute("quoteText","\"Karaktären är en muskulös man på 195cm och 110kg. " +
                "Han är en före detta amerikansk militärpolis. Friheten att röra på sig är något som genomsyrar hans " +
                "karaktär, han vandrar och liftar sig igenom USA:s olika stater. Han har flera speciella egenheter " +
                "och mantran som han följer. Något som utmärker honom är att han står upp för dem svaga eller folk som " +
                "råkat ut för orättvisa. Av många anses denna karaktär vara en riktig hjälte. Vet du vem han är?\"");

        return "index";
    }
}
