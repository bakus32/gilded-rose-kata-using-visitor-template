package org.example.gilded_rose;

public class BackstagePass extends Product {

  public BackstagePass(Item item) {
    super(item);
  }

  public void update() {
    decreaseSellIn();

    increaseQuality();

    increaseOver(10);
    increaseOver(5);
    qualityToZero();
  }

  @Override
  public void accept(Visitor visitor) {
      visitor.visitBackStagePass(this);
  }
}
