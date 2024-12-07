package studio.sparkline.Sparkline.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import studio.sparkline.Sparkline.Models.Orders;
import studio.sparkline.Sparkline.Service.OrderService;

@Controller
public class OrderWebsiteController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order-website")
    public String orderWebsite() {
        return "order-website";
    }

    @PostMapping("/order-website")
    @ResponseBody
    public Orders createWebsiteOrder(@RequestBody Orders order, @RequestParam("telegramName") String telegramName) {
        order.setTelegramName(telegramName);
        return orderService.saveOrder(order);
    }

}
