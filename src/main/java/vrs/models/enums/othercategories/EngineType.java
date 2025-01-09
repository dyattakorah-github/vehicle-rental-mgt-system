package vrs.models.enums.othercategories;

import vrs.models.interfaces.OtherCategory;

public enum EngineType implements OtherCategory {
    SINGLE_CYLINDER,
    TWIN_CYLINDER,
    TRIPLE_CYLINDER,
    FOUR_CYLINDER,
    SIX_CYLINDER,
    ELECTRIC,
    ROTARY;

    @Override
    public String getCategoryName() {
        return this.name();
    }
}
