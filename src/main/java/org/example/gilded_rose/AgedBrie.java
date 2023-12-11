package org.example.gilded_rose;

public class AgedBrie extends Product {

    public AgedBrie(Item item) {
        super(item);
    }

    public void update() {
        decreaseSellIn();

        increaseQuality();

        increaseOver(0);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAgeBrie(this);
    }
}
