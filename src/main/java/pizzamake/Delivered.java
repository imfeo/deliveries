package pizzamake;

public class Delivered extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String pizzaname;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getPizzaname() {
        return pizzaname;
    }

    public void setPizzaname(String pizzaname) {
        this.pizzaname = pizzaname;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}