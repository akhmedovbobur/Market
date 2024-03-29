package com.example.market.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class FilterDto {
    private Integer page;
    private Integer size;
    private String sortBy;
    private Sort.Direction direction;
}
