package com.xofuratech.BlogApplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
    private List<PostDto> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;
}
