package studio.sparkline.Sparkline.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import studio.sparkline.Sparkline.Models.Orders;




@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {


}
