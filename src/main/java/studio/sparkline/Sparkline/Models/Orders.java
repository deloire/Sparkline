package studio.sparkline.Sparkline.Models;


import jakarta.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private String description;
    private String currency;
    private String budget;

    @Column(name = "detailedTask")
    private String detailedTask;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDetailedTask() {
        return detailedTask;
    }

    public void setDetailedTask(String detailedTask) {
        this.detailedTask = detailedTask;
    }

    public Orders() {
    }

    public Orders(String description, String currency, String budget, String detailedTask) {
        this.description = description;
        this.currency = currency;
        this.budget = budget;
        this.detailedTask = detailedTask;
    }
}
