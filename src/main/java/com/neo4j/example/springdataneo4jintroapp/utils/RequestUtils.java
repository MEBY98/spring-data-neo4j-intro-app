package com.neo4j.example.springdataneo4jintroapp.utils;

import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

public class RequestUtils {
    // Hide contructor
    private RequestUtils() {
    };

    public static PageRequest pageAndSort(Map<String, String> map, String[] sortBy) {
        int page = map.containsKey("page") ? Integer.parseInt(map.get("page")) : 0;
        int size = map.containsKey("size") ? Integer.parseInt(map.get("size")) : 10;
        Direction direction = map.containsKey("sort") ? Direction.valueOf(map.get("sort")) : Direction.ASC;
        return sortBy == null ? PageRequest.of(page, size) : PageRequest.of(page, size, direction, sortBy);
    }
}
