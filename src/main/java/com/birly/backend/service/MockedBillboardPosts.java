package com.birly.backend.service;

import com.birly.backend.Union;
import com.birly.backend.dto.BillboardItemDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockedBillboardPosts {


    public List<BillboardItemDTO> createMockPosts() {
        BillboardItemDTO post1 = new BillboardItemDTO(
                "Fire alarms being checked",
                "The annual fire alarm inspection will take place on Tuesday between 09:00 and 15:00. Please ensure access if you are home.",
                "1",
                Union.BANDLANDET,
                "1106"
        );

        BillboardItemDTO post2 = new BillboardItemDTO(
                "Water shut-off on Wednesday",
                "The water will be turned off between 10:00 and 13:00 due to maintenance. We recommend filling a few containers beforehand.",
                "2",
                Union.BANDLANDET,
                "1204"
        );

        BillboardItemDTO post3 = new BillboardItemDTO(
                "Spring cleaning day",
                "Join us this Saturday at 10:00 to help clean the courtyard and common areas. Coffee and snacks will be provided!",
                "3",
                Union.BANDLANDET,
                "1002"
        );

        BillboardItemDTO post4 = new BillboardItemDTO(
                "Bicycle storage reminder",
                "Please label your bicycles before the end of the month. Unlabeled bikes may be removed from the storage room.",
                "4",
                Union.BANDLANDET,
                "1301"
        );

        BillboardItemDTO post5 = new BillboardItemDTO(
                "Elevator maintenance",
                "The elevator will be unavailable from 08:00 to 12:00 on Friday due to scheduled maintenance.",
                "5",
                Union.BANDLANDET,
                "0905"
        );

        BillboardItemDTO post6 = new BillboardItemDTO(
                "Package room updated",
                "A new package shelf has been installed. Please collect your deliveries within 48 hours to keep the area tidy.",
                "6",
                Union.BANDLANDET,
                "1408"
        );

        BillboardItemDTO post7 = new BillboardItemDTO(
                "Barbecue evening",
                "All residents are invited to a barbecue in the courtyard this Friday at 18:00. Bring your own food and drinks!",
                "7",
                Union.BANDLANDET,
                "1103"
        );

        BillboardItemDTO post8 = new BillboardItemDTO(
                "Quiet hours reminder",
                "Please remember that quiet hours are between 22:00 and 07:00. Thank you for being considerate of your neighbors.",
                "8",
                Union.BANDLANDET,
                "1201"
        );

        BillboardItemDTO post9 = new BillboardItemDTO(
                "Garage cleaning",
                "Please move your vehicles out of the garage by 08:00 on Monday to allow for floor cleaning.",
                "9",
                Union.SKOGSMARDEN,
                "0101"
        );

        BillboardItemDTO post10 = new BillboardItemDTO(
                "Board meeting summary",
                "The minutes from the latest board meeting are now available in the documents section of the app.",
                "10",
                Union.SKOGSMARDEN,
                "0000"
        );
        return List.of(post1, post2, post3, post4, post5, post6, post7, post8, post9, post10);
    }
}
