package studio.sparkline.Sparkline.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import studio.sparkline.Sparkline.Models.Orders;
import studio.sparkline.Sparkline.Service.OrderService;

@Controller
public class OrderBotController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order-bot")
    public String orderBot() {
        return "order-bot";
    }


    @PostMapping("/order-bot")
    @ResponseBody
    public Orders createBotOrder(@RequestBody Orders order, @RequestParam("telegramName") String telegramName) {
        order.setTelegramName(telegramName);
        return orderService.saveOrder(order);
    }


}
