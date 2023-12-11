package org.example.gilded_rose;

import java.util.Optional;

public abstract class Product {

    private final Item item;

    public Product(Item item) {
        this.item = item;
    }

    protected void increaseQuality() {
        item.quality = Math.min(item.quality + 1, 50);
    }

    protected int getSellIn() {
        return item.sellIn;
    }

    protected void qualityToZero() {
        Optional.of(getSellIn()).filter(sellIn -> sellIn < 0).ifPresent(value -> item.quality = 0);
    }

    protected void decreaseSellIn() {
        item.sellIn -= 1;
    }

    protected void decreaseQuality() {
        item.quality = Math.max(0, item.quality - 1);
    }

    protected void increaseOver(int sellIn) {
        Optional.of(getSellIn()).filter(value -> value < sellIn).ifPresent(value -> increaseQuality());
    }

    public abstract void accept(Visitor visitor);
}
