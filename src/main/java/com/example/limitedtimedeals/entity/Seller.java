package com.example.limitedtimedeals.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Seller extends User {

  private final String sellerId;
  private final String registrationNumber;
  private List<Deal> deals = new ArrayList<>();

}
