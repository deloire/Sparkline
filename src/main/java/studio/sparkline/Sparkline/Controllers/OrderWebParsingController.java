package studio.sparkline.Sparkline.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import studio.sparkline.Sparkline.Models.Orders;
import studio.sparkline.Sparkline.Service.OrderService;

@Controller
public class OrderWebParsingController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order-parsing")
    public String orderParsing() {
        return "order-parsing";
    }

    @PostMapping("/order-parsing")
    @ResponseBody
    public Orders createParsingOrder(@RequestBody Orders order, @RequestParam("telegramName") String telegramName) {
        order.setTelegramName(telegramName);
        return orderService.saveOrder(order);
    }

}
