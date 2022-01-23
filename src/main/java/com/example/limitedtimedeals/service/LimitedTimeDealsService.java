package com.example.limitedtimedeals.service;

import com.example.limitedtimedeals.entity.Deal;
import com.example.limitedtimedeals.entity.Item;
import com.example.limitedtimedeals.entity.Seller;
import java.util.ArrayList;
import java.util.List;

public class LimitedTimeDealsService {



  public Deal createDeal(Seller seller, List<Item> items, long startTime, long hours) {

    Deal deal = new Deal();

    deal.setDealId("1");
    deal.setStartTime(startTime);
    deal.setEndTime(startTime + (hours * 3600));
    deal.setItems(items);

    seller.getDeals().add(deal);
    return deal;
  }

  public Deal endDeal(Seller seller, Deal dealToBeEnded) {

    for (Deal deal : seller.getDeals()) {
      if (deal.getDealId().equals(dealToBeEnded.getDealId())) {
        deal.setExpired(true);
        break;
      }
    }

    return dealToBeEnded;
  }

  public Deal increaseDealEndTime(Seller seller, Deal dealToBeUpdated, long endTime) {

    for (Deal deal : seller.getDeals()) {
      if (deal.getDealId().equals(dealToBeUpdated.getDealId())) {
        deal.setEndTime((endTime * 3600));
        break;
      }
    }

    return dealToBeUpdated;
  }

  public Deal increaseNumberOfItemsInDeal(Seller seller, Deal dealToBeUpdated, int number) {

    for (Deal deal : seller.getDeals()) {
      if (deal.getDealId().equals(dealToBeUpdated.getDealId())) {
        increaseItems(deal, number);
        break;
      }
    }
    return dealToBeUpdated;
  }

  private void increaseItems(Deal deal, int number) {
    int oldSize = deal.getItems().size();
    int newSize = oldSize + number;

    Item item = deal.getItems().get(0);

    List<Item> items = new ArrayList<>(newSize);
    for (int i = 0; i < newSize; i++) {
      items.add(item);
    }

    deal.setItems(items);
  }

  public Deal claimDeal(Seller seller, Deal dealToBeClaimed) {
    for (Deal deal : seller.getDeals()) {
      if (deal.getDealId().equals(dealToBeClaimed.getDealId())) {
        return deal;
      }
    }
    return null;
  }

}
