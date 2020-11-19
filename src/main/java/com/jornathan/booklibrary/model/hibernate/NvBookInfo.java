package com.jornathan.booklibrary.model.hibernate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

import lombok.Value;

/**
 * 외부에서 view 전용으로 가져오는 데이터 이므로 일급 객체로 사용하는 것이 좋을 거 같음
 * "@Value" 를 사용해 봤다.
 */
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastBuildDate",
    "total",
    "start",
    "display",
    "items"
})
public class NvBookInfo {

  private String lastBuildDate;

  private Integer total;

  private Integer start;

  private Integer display;

  private List<Item> items = null;
}