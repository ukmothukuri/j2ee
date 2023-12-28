package in.cdac.dao;

public class Product {
    private int productID;
    private String productName;   
    private int productPrice;  
    private String productDesc;
    public Product() {
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductDesc() {
        return productDesc;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }   
}
