package com.example.market.model.asadbek;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = ("applications"))
public class Applications {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Integer id;
   @Column(name = ("type_id"))
   private Integer typeId;
   @Column(name = ("user_id"))
   private Integer userId;
   @Column(name = ("merchant_id"))
   private Integer merchantId;
   @Column(name = ("vehicle_id"))
   private Integer vehicleId;
   @Column(name = ("vehicle_details"))
   private String vehicleDetails;
   private Double price;
   @Column(name = ("condition_duration_type"))
   private Integer conditionDurationType;
   @Column(name = ("condition_duration"))
   private Integer conditionDuration;
   @Column(name = ("condition_price"))
   private Double conditionPrice;
   @Column(name = ("proses_status_id"))
   private Integer prosesStatusId;

   private LocalDateTime createAt;
   private LocalDateTime updateAt;
   private LocalDateTime deleteAt;
}
