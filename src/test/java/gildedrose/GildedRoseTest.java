package gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

    private static final int STANDARD_SELLIN = 10;

    public static final int STANDARD_QUALITY = 20;

    public static final String STANDARD_NAME = "Standard-Item";

    private final Item item = createStandardItem();

    private GildedRose app = new GildedRose(new Item[] { item });

    @Test
    public void standard_item_quality() {
        app.updateQuality();
        assertEquals(19, item.quality);
    }

    private Item createStandardItem() {
        return new Item("Standard-Item", STANDARD_SELLIN, STANDARD_QUALITY);
    }

    @Test
    public void standard_item_sellin() {
        app.updateQuality();
        assertEquals(9, item.sellIn);
    }

    @Test
    public void aged_brie_quality_100() {
        item.name = "Aged Brie";
        item.quality = 100;
        app.updateQuality();
        assertEquals(100, item.quality);
    }

    @Test
    public void aged_brie_quality_0() {
        item.name = "Aged Brie";
        item.sellIn = 0;
        app.updateQuality();
        assertEquals(STANDARD_QUALITY + 2, item.quality);
    }

    @Test
    public void ragnaros_quality_do_not_change() {
        item.name = "Sulfuras, Hand of Ragnaros";
        app.updateQuality();
        assertEquals(STANDARD_QUALITY, item.quality);
    }

    @Test
    public void ragnaros_sellin_do_not_change() {
        item.name = "Sulfuras, Hand of Ragnaros";
        app.updateQuality();
        assertEquals(STANDARD_SELLIN, item.sellIn);
    }

    @Test
    public void item5_quality_sellin_10() {
        item.name = "Backstage passes to a TAFKAL80ETC concert";
        item.sellIn = 10;
        app.updateQuality();
        assertEquals(STANDARD_QUALITY + 2, item.quality);
    }

    @Test
    public void item5_quality_sellin_5() {
        item.name = "Backstage passes to a TAFKAL80ETC concert";
        item.sellIn = 5;
        app.updateQuality();
        assertEquals(STANDARD_QUALITY + 3, item.quality);
    }

    @Test
    public void item5_quality_sellin_0() {
        item.name = "Backstage passes to a TAFKAL80ETC concert";
        item.sellIn = 0;
        app.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    public void item5_quality_max_50() {
        item.name = "Backstage passes to a TAFKAL80ETC concert";
        item.quality = 50;
        app.updateQuality();
        assertEquals(50, item.quality);
    }

}
