package studio.sparkline.Sparkline.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "telegram_name")
    private String telegramName;

    private double budget;
    private String description;
    private String currency;


    @Column(name = "detailedTask")
    private String detailedTask;


    public String getTelegramName() {
        return telegramName;
    }

    public void setTelegramName(String telegramName) {
        this.telegramName = telegramName;
    }

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

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
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

    public Orders(String description, String currency, double budget, String detailedTask, String telegramName) {
        this.description = description;
        this.currency = currency;
        this.budget = budget;
        this.detailedTask = detailedTask;
        this.telegramName = telegramName;
    }
}
