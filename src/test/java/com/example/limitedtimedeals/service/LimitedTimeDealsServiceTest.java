package com.example.limitedtimedeals.service;

import com.example.limitedtimedeals.entity.Deal;
import com.example.limitedtimedeals.entity.Item;
import com.example.limitedtimedeals.entity.Seller;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LimitedTimeDealsServiceTest {

  private LimitedTimeDealsService dealsService = new LimitedTimeDealsService();

  @Test
  public void testCreateDeal() {

    Seller seller = getSeller();
    Deal createdDeal = dealsService.createDeal(seller,
        getItems("1", "Holmes", "detective", 100.0d, 5),
        100L, 2L);

    System.out.println(createdDeal.getItems().size() == 5 ? "true" : "false");
  }

  @Test
  public void testEndDeal() {

    Seller seller = getSeller();
    Deal createdDeal = dealsService.createDeal(seller,
        getItems("1", "Holmes", "detective", 100.0d, 5),
        100L, 2L);
    System.out.println(createdDeal.isExpired() == false ? "true" : "false");

    Deal expiredDeal = dealsService.endDeal(seller, createdDeal);

    System.out.println(expiredDeal.isExpired() == true ? "true" : "false");
  }

  private Seller getSeller() {
    Seller seller = new Seller("sid123", "reg123");
    //seller.setSellerId("sid123");
    seller.setName("Sushovan Karmakar");
    seller.setEmailId("sk@gmail.com");
    //seller.setRegistrationNumber("reg123");
    return seller;
  }

  private List<Item> getItems(String id, String name, String desc, Double price, int numberOfItems) {

    List<Item> items = new ArrayList<>(numberOfItems);

    for (int i = 0; i < numberOfItems; i++) {
      Item item = new Item(id, name, desc, price);
      items.add(item);
    }

    return items;
  }

}
