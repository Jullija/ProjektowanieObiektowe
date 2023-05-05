package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
	private final UUID id;

    private final List<Product> products;
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;
    private BigDecimal discount;

    private String clientName;

    public Order(List<Product> products) {
        this.products = products;
        id = UUID.randomUUID();
        paid = false;
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }

    public BigDecimal getPrice() {
        BigDecimal price = BigDecimal.valueOf(0.0);
        for (Product prod : products){
            price = price.add(prod.getPrice());
        }
        return price;
    }

    public BigDecimal getPriceEachProduct(){
        BigDecimal price = BigDecimal.valueOf(0.0);
        for (Product prod : products){
            price = price.add(prod.getPriceWithDiscount());
        }

        return price;
    }

    public BigDecimal getPriceWithOrderDiscount(){
        if (discount != null){
            return getPriceEachProduct().subtract(getPriceEachProduct().multiply(discount).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY));
        }
        return getPriceEachProduct();
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public List<Product> getProducts() {
        return products;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccesful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccesful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public BigDecimal getDiscount(){
        return this.discount;
    }

    public void setDiscount(BigDecimal discount){
        this.discount = discount;
    }

    public void setClientName(String name){
        this.clientName = name;
    }

    public String getClientName(){
        return this.clientName;
    }
}
