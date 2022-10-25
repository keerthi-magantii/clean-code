package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class  GildedRoseADefaultItemTest {

	public static final int UNEXPIRED_SELL_IN = 15;
	public static final int DEFAULT_QUALITY = 3;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int EXPIRED_SELL_IN = -1;

	private void assertItem(Item expected, Item actual) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose createGildedRoseWithOneItem(String itemType, int sellIn, int quality) {
		Item item = new Item(itemType, sellIn, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}
	@Test
	public void shouldDecreaseQualityByOneWhenItemUnExpired() {

		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, UNEXPIRED_SELL_IN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM, UNEXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 1);

		assertItem(expected, app.items[0]);
	}

	@Test
	public void shouldDecreaseQualityByTwoWhenItemExpired() {
		GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, EXPIRED_SELL_IN, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 2);

		assertItem(expected, app.items[0]);
	}
}