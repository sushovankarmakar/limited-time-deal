package com.example.limitedtimedeals.entity;

import java.util.List;
import lombok.Data;

@Data
public class Deal {

  private String dealId;
  private long startTime;
  private long endTime;
  private boolean isExpired;
  private List<Item> items;

  /*public static class dealBuilder {

    Deal deal;

    dealBuilder() {

    }

    public void dealId() {

    }

  }*/

}
