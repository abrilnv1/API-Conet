package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class PaymentRequest {
    private int amount; // Monto total en centavos
    private String currency; // Código de moneda, por ejemplo, "MXN"
    private List<LineItem> items; // Lista de artículos en la orden
    private String customerEmail; // Email del cliente

    // Constructor por defecto
    public PaymentRequest() {}

    // Constructor con todos los campos
    public PaymentRequest(int amount, String currency, List<LineItem> items, String customerEmail) {
        this.amount = amount;
        this.currency = currency;
        this.items = items;
        this.customerEmail = customerEmail;
    }

    // Getters y setters

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    // Clase LineItem
    @Setter
    @Getter
    public static class LineItem {
        private String name; // Nombre del producto
        private int unitPrice; // Precio por unidad en centavos
        private int quantity; // Cantidad

        public LineItem() {}

        public LineItem(String name, int unitPrice, int quantity) {
            this.name = name;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        // Getters y setters

    }
}
