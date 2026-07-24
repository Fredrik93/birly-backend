package com.birly.backend.service;

import com.birly.backend.Union;
import com.birly.backend.dto.BillboardItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockedBillboardPosts {

    public List<BillboardItemDTO> createMockPosts() {

        BillboardItemDTO post1 = new BillboardItemDTO.Builder()
                .title("Fire Alarms being checked")
                .description("The annual fire alarm inspection will take place on Tuesday between 09:00 and 15:00. Please ensure access if you are home.")
                .id("1")
                .union(Union.BANDLANDET)
                .createdByUser("1106")
                .build();

        BillboardItemDTO post2 = new BillboardItemDTO.Builder()
                .title("Water shut-off on Wednesday")
                .description("The water will be turned off between 10:00 and 13:00 due to maintenance. We recommend filling a few containers beforehand.")
                .id("2")
                .union(Union.BANDLANDET)
                .createdByUser("1204")
                .build();

        BillboardItemDTO post3 = new BillboardItemDTO.Builder()
                .title("Spring cleaning day")
                .description("Join us this Saturday at 10:00 to help clean the courtyard and common areas. Coffee and snacks will be provided!")
                .id("3")
                .union(Union.BANDLANDET)
                .createdByUser("1002")
                .build();

        BillboardItemDTO post4 = new BillboardItemDTO.Builder()
                .title("Bicycle storage reminder")
                .description("Please label your bicycles before the end of the month. Unlabeled bikes may be removed from the storage room.")
                .id("4")
                .union(Union.BANDLANDET)
                .createdByUser("1301")
                .build();

        BillboardItemDTO post5 = new BillboardItemDTO.Builder()
                .title("Elevator maintenance")
                .description("The elevator will be unavailable from 08:00 to 12:00 on Friday due to scheduled maintenance.")
                .id("5")
                .union(Union.BANDLANDET)
                .createdByUser("0905")
                .build();

        BillboardItemDTO post6 = new BillboardItemDTO.Builder()
                .title("Package room updated")
                .description("A new package shelf has been installed. Please collect your deliveries within 48 hours to keep the area tidy.")
                .id("6")
                .union(Union.BANDLANDET)
                .createdByUser("1408")
                .build();

        BillboardItemDTO post7 = new BillboardItemDTO.Builder()
                .title("Barbecue evening")
                .description("All residents are invited to a barbecue in the courtyard this Friday at 18:00. Bring your own food and drinks!")
                .id("7")
                .union(Union.BANDLANDET)
                .createdByUser("1103")
                .build();

        BillboardItemDTO post8 = new BillboardItemDTO.Builder()
                .title("Quiet hours reminder")
                .description("Please remember that quiet hours are between 22:00 and 07:00. Thank you for being considerate of your neighbors.")
                .id("8")
                .union(Union.BANDLANDET)
                .createdByUser("1201")
                .build();

        BillboardItemDTO post9 = new BillboardItemDTO.Builder()
                .title("Garage cleaning")
                .description("Please move your vehicles out of the garage by 08:00 on Monday to allow for floor cleaning.")
                .id("9")
                .union(Union.SKOGSMARDEN)
                .createdByUser("0101")
                .build();

        BillboardItemDTO post10 = new BillboardItemDTO.Builder()
                .title("Board meeting summary")
                .description("The minutes from the latest board meeting are now available in the documents section of the app.")
                .id("10")
                .union(Union.LINDSDAL)
                .createdByUser("0000")
                .build();

        return List.of(
                post1, post2, post3, post4, post5,
                post6, post7, post8, post9, post10
        );
    }
}