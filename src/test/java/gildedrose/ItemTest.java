package gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {

    private static final String NAME = "name";

    private static final int SELL_IN = 12;

    private static final int QUALITY = 14;

    private final Item item = new Item(NAME, SELL_IN, QUALITY);

    @Test
    public void constuctor_name() {
        assertEquals(NAME, item.name);
    }

    @Test
    public void constuctor_quality() {
        assertEquals(QUALITY, item.quality);
    }

    @Test
    public void constuctor_sellin() {
        assertEquals(SELL_IN, item.sellIn);
    }

}
