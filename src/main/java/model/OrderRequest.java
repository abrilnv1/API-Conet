package model;

import java.util.List;

public class OrderRequest {
    private int amount;
    private String currency;
    private String paymentSourceId;
    private List<LineItem> lineItems;
    private CustomerInfo customerInfo;

    // Constructor, getters y setters...

    public static class LineItem {
        private String name;
        private int unitPrice;
        private int quantity;

        // Constructor, getters y setters...
    }

    public static class CustomerInfo {
        private String customerID;
        private String name;
        private String email;
        private String phone;

        // Constructor, getters y setters...
    }
}