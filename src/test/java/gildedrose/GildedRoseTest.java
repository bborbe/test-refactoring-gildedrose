package gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

    private static final int STANDARD_SELLIN = 10;

    private static final int STANDARD_QUALITY = 20;

    private static final String STANDARD_NAME = "Standard-Item";

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private static final String SULFURAS_HAND = "Sulfuras, Hand of Ragnaros";

    private static final String AGED_BRIE = "Aged Brie";

    private final Item item = new Item("Standard-Item", STANDARD_SELLIN, STANDARD_QUALITY);

    private final GildedRose app = new GildedRose(new Item[] { item });

    @Test
    public void standard_quality_descrease_by_1() {
        app.updateQuality();
        assertEquals(STANDARD_QUALITY-1, item.quality);
    }

    @Test
    public void standard_sellin_descrese_by_1() {
        app.updateQuality();
        assertEquals(STANDARD_SELLIN - 1, item.sellIn);
    }

    @Test
    public void aged_brie_max_quality_100() {
        item.name = AGED_BRIE;
        item.quality = 100;
        app.updateQuality();
        assertEquals(100, item.quality);
    }

    @Test
    public void aged_brie_quality_increase_by_2() {
        item.name = AGED_BRIE;
        item.sellIn = 0;
        app.updateQuality();
        assertEquals(STANDARD_QUALITY + 2, item.quality);
    }

    @Test
    public void ragnaros_quality_do_not_change() {
        item.name = SULFURAS_HAND;
        app.updateQuality();
        assertEquals(STANDARD_QUALITY, item.quality);
    }

    @Test
    public void ragnaros_sellin_do_not_change() {
        item.name = SULFURAS_HAND;
        app.updateQuality();
        assertEquals(STANDARD_SELLIN, item.sellIn);
    }

    @Test
    public void backstage_quality_sellin_10() {
        item.name = BACKSTAGE_PASSES;
        item.sellIn = 10;
        app.updateQuality();
        assertEquals(STANDARD_QUALITY + 2, item.quality);
    }

    @Test
    public void backstage_quality_sellin_5() {
        item.name = BACKSTAGE_PASSES;
        item.sellIn = 5;
        app.updateQuality();
        assertEquals(STANDARD_QUALITY + 3, item.quality);
    }

    @Test
    public void backstage_quality_0_if_sell_0() {
        item.name = BACKSTAGE_PASSES;
        item.sellIn = 0;
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void backstage_quality_max_50() {
        item.name = BACKSTAGE_PASSES;
        item.quality = 50;
        app.updateQuality();
        assertEquals(50, item.quality);
    }

}
