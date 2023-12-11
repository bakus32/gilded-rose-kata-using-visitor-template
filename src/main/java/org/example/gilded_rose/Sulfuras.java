package org.example.gilded_rose;

public class Sulfuras extends Product {

    public Sulfuras(Item item) {
        super(item);
    }

    public void update() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSulfuras(this);
    }
}
