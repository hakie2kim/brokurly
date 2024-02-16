package com.brokurly.domain;

import com.brokurly.dto.ItemAnnouncementDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ItemAnnouncement {
    private String itemId;
    private String itemAnnCate;
    private String itemAnn;

    public ItemAnnouncementDto makeFullDto(){
        return ItemAnnouncementDto.builder()
                .itemId(itemId)
                .itemAnnCate(itemAnnCate)
                .itemAnn(itemAnn)
                .build();
    }

    public void changeStatus(ItemAnnouncementDto itemAnnouncementDto){
        this.itemId = itemAnnouncementDto.getItemId();
        this.itemAnnCate = itemAnnouncementDto.getItemAnnCate();
        this.itemAnn = itemAnnouncementDto.getItemAnn();
    }

}
