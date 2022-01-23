package com.example.limitedtimedeals.entity;

import lombok.Data;

@Data
public abstract class User {

  private String name;
  private String emailId;
  private String phoneNumber;

}
