package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void
    update_quality_decreases_quality_by_1() {
        Item[] items = new Item[] {new Item("pepito", 10, 23)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 22);
    }

    @Test
    public void
    update_quality_decreases_sellIn_by_1() {
        Item[] items = new Item[] {new Item("pepito", 10, 23)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].sellIn == 9);
    }

    @Test
    public void
    quality_is_never_negative() {
        Item[] items = new Item[] {new Item("pepito", 10, 1)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 0);
    }

    @Test
    public void
    quality_decreases_by_2_when_sell_by_has_passed() {
         Item[] items = new Item[] {new Item("pepito", 0 , 2)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 0);
    }

    @Test
    public void
    update_quality_increase_quality_of_aged_brie() {
        Item[] items = new Item[] {new Item("Aged Brie", 10 , 2)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 3);
    }

    @Test
    public void
    update_quality_quality_is_never_bigger_than_50() {
            Item[] items = new Item[] {new Item("Aged Brie", 10 , 49)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 50);
    }

    @Test
    public void
    update_quality_sulfuras_never_decreases_quality() {
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 10 , 49)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 49);
    }

        @Test
    public void
    update_quality_sulfuras_never_decreases_sellIn() {
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 10 , 49)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].sellIn == 10);
    }

        @Test
    public void
    update_quality_backstagePasses_increases_quality_by_2_when_sellIn_is_less_than_11() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 42);
    }

    @Test
    public void
    update_quality_backstagePasses_increases_quality_by_3_when_sellIn_is_less_than_6(){

        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",5 , 40)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 43);
    }

    @Test
    public void
    update_quality_backstagePasses_quality_drops_to_0_when_sellIn_is_0() {


        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",0 , 40)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 0);

    }
}
