package controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String greeting() {
        return "dictionary";
    }
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam String address) {
        model.addAttribute("name", "lan anh quê ở " + address);
        return "edit";
    }

    @GetMapping("/plus")
    public String plus(Model model, @RequestParam int a, @RequestParam int b) {
        model.addAttribute("tong", a + b);
        return "plus";
    }

    @PostMapping("/plus")
    public String plusPost(Model model, @RequestParam int a, @RequestParam int b) {
        model.addAttribute("tong", a + b);
        return "plus";
    }

    @GetMapping("/convert")
    public String convert(Model model, @RequestParam int vnd, @RequestParam int usd) {
        model.addAttribute("result", vnd * usd);
        return "currency_conversion";
    }

    @GetMapping("/translate")
    public String translate(Model model, @RequestParam String vietNam) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chao");
        dictionary.put("how", "The nao");
        dictionary.put("book", "Quyen vo");
        dictionary.put("computer", "May tinh");
        String result = dictionary.get(vietNam);
        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Not found");
        }
        return "dictionary";
    }
}
