package org.example.gilded_rose;

import java.util.Optional;

public class NormalProduct extends Product{

    public NormalProduct(Item item) {
        super(item);
    }

    void update() {
        decreaseSellIn();
        decreaseQuality();

        Optional.of(getSellIn()).filter(sellIn -> sellIn < 0).ifPresent(sellIn -> decreaseQuality());
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitNormalProduct(this);
    }
}
