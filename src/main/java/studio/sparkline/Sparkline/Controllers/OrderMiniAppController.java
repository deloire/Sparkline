package studio.sparkline.Sparkline.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public Orders createMiniappOrder(@RequestBody Orders order) {
        return orderService.saveOrder(order);
    }


}
