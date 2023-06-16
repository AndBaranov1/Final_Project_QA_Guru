package models;

import lombok.Data;

@Data
public class AddCartBodyModel {
    private boolean bAllowAppImpressions;

    public boolean isbAllowAppImpressions() {
        return bAllowAppImpressions;
    }
}
