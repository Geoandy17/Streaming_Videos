package com.dons.krohn.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;

    @NonNull
    private String name;

}
