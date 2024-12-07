package studio.sparkline.Sparkline.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import studio.sparkline.Sparkline.Models.Orders;
import studio.sparkline.Sparkline.Service.OrderService;

@Controller
public class OrderMiniAppController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order-miniapp")
    public String orderBot() {
        return "order-miniapp";
    }

    @PostMapping("/order-miniapp")
    @ResponseBody
    public Orders createMiniappOrder(@RequestBody Orders order, @RequestParam("telegramName") String telegramName) {
        order.setTelegramName(telegramName);
        return orderService.saveOrder(order);
    }


}
