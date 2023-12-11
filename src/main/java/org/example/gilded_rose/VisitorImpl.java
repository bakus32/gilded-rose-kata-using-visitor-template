package org.example.gilded_rose;

import java.util.Map;
import java.util.function.Function;

public class VisitorImpl implements Visitor {


    private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE_NAME = "Aged Brie";

    private static final Map<String, Function<Item, Product>> ITEMS_FACTORIES = buildFactories();

    void updateItem(Item item) {
        VisitorImpl.get(item).accept(this);
    }

    public static Product get(Item item) {
        return ITEMS_FACTORIES.getOrDefault(item.name, NormalProduct::new).apply(item);
    }

    private static Map<String, Function<Item, Product>> buildFactories() {
        return Map.of(SULFURAS_NAME, Sulfuras::new, AGED_BRIE_NAME, AgedBrie::new, BACKSTAGE_PASSES_NAME, BackstagePass::new);
    }

    @Override
    public void visitAgeBrie(AgedBrie agedBrie) {
        agedBrie.update();
    }

    @Override
    public void visitBackStagePass(BackstagePass backstagePass) {
        backstagePass.update();
    }

    @Override
    public void visitSulfuras(Sulfuras sulfuras) {
        sulfuras.update();
    }

    @Override
    public void visitNormalProduct(NormalProduct normalProduct) {
        normalProduct.update();
    }
}
