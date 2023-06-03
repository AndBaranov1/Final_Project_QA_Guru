package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseModel {
    private Integer total_count;

    public Integer getTotal_count() {
        return total_count;
    }
 }