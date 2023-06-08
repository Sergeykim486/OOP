package Classes;

import Interfaces.iActorBehaviour;

public abstract class Actor implements iActorBehaviour {
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    public Object makeOrder;

    public Actor(String name) {
        this.name = name;
    }
    abstract public String getName();

}
