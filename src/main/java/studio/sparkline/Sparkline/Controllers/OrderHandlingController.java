package studio.sparkline.Sparkline.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderHandlingController {

    @GetMapping("/order-handling")
    public String orderHandling() {
        return "order-handling";
    }

}
