package sandwich_condiments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("/save")
    public String save(Model model, @RequestParam(value = "condiment", defaultValue = "") String[] condiment) {
        model.addAttribute("condiment", condiment);
        return "index";
    }
}
