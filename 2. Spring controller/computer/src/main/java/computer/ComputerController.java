package computer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputerController {
    @GetMapping("/computer")
    public String showResult(Model model, @RequestParam(defaultValue = "") String cal,
                             @RequestParam(defaultValue = "0") double first,
                             @RequestParam(defaultValue = "0") double second) {
        double result = 0;
        switch (cal) {
            case "plus":
                result = first + second;
                break;
            case "minus":
                result = first - second;
                break;
            case "multi":
                result = first * second;
                break;
            case "div":
                result = first / second;
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
