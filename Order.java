import java.sql.Date;

public class Order {
    private String orderId;
    private double price;
    private String productId;
    private String categoryId;
    private String affiliateId;
    private Date timestamp;
    private OrderState state;
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public String getAffiliateId() {
        return affiliateId;
    }
    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public OrderState getState() {
        return state;
    }
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", price=" + price + ", productId=" + productId + ", categoryId="
                + categoryId + ", affiliateId=" + affiliateId + ", timestamp=" + timestamp + ", state=" + state + "]";
    }
    public void setState(OrderState state) {
        this.state = state;
    }


}