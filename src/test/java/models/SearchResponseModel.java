package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseModel {

    @JsonProperty("total_count")
    private Integer totalCount;
    private Integer success;
 }