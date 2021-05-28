package com.baaaki.posting.bindingTest.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    @NotNull
    @Positive
    @Getter
    @Setter
    private Long orderNo;

}
