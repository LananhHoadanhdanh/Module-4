package sesstion_luyen_tap.demosession.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import sesstion_luyen_tap.demosession.model.Counter;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class CounterController {
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/count")
    public String getCount(Model model){
        Counter counter= (Counter) httpSession.getAttribute("count");
        if (counter != null){
            counter.increment();
            model.addAttribute("counter", counter);
        } else {
            httpSession.setAttribute("count", new Counter(1));
            model.addAttribute("counter", new Counter(1));
        }
        return "/count";
    }
}
