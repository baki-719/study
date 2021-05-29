package com.baaaki.posting.mockito.dto;

import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SampleDto {

    @Getter
    @Setter
    private Long no;

    @Getter
    @Setter
    private String name;

}
