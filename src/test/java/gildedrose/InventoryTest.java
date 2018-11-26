package gildedrose;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class InventoryTest {
    protected Inventory inv;
    Item[] ancienneListeSesItems;


    @Before
    public void setUp() {
        inv = new Inventory();
        ancienneListeSesItems = inv.getItems();

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testupdateQualityWhensellInFinished() throws Exception {
        inv.updateQuality();
        Item[] items = inv.getItems();
        for (int i =0; i<items.length; i++){
            if(ancienneListeSesItems[i].getSellIn() ==0)
                assertEquals(ancienneListeSesItems[i].getQuality()-2, items[i].getQuality());
        }
    }

    @Test
    public void qualityCheck() throws Exception{
        Inventory inventory = new Inventory();
        Item[] items = inventory.getItems();
        Item itemConjured = items[5];
        assertThat(itemConjured.getName(), is("Conjured Mana Cake"));
        assertThat(itemConjured.getQuality(), is (6));
        inventory.updateQuality();
        assertThat(itemConjured.getQuality(), is (4));
    }
}
