package Classes;

public class PromotionClient extends Actor {
    private String ActionName;
    private int ActId;
    private int quantity;
    public PromotionClient(String name, int ActId, String ActionName, int quantity) {
        super(name);
        this.ActId = ActId;
        this.ActionName = ActionName;
        this.quantity = quantity;
    }

    private int getActId () {
        return ActId;
    }

    @Override
    public void setMakeOrder(boolean makeOrder) {
        super.isMakeOrder = makeOrder;
    }

    @Override
    public void setTakeOrder(boolean pickUpOrder) {
        super.isTakeOrder = pickUpOrder;
    }
    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }
    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }
    @Override
    public Actor getActor() {
        return this;
    }
    @Override
    public String getName() {
        return super.name;
    }

}