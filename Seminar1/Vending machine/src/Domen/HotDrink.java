package Domen;

public class HotDrink extends Product{

    private int temperature;
    /**
     * @param productId *id
     * @param productName
     * @param productCategory
     * @param temperature
     * @param price
     * @throws Exception
     */
    public HotDrink(int productId, String productName, String productCategory, double price, int temperature) throws Exception {
        super(productId, productName, productCategory, price);
        this.temperature = temperature;
    }
    
    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + super.getProductName() + '\'' +
                "category='" + super.getProductCategory() + '\'' +
                ", cost=" + super.getPrice() +
                ", volume=" + temperature +
                '}';
    }
}
