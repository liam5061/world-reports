package com.worldreports.world_reports.enitites;

public enum Continent {
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"), // Valid Constant Name
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    SOUTH_AMERICA("South America"); // Valid Constant Name

    private final String displayName;

    // Constructor to set the display name
    Continent(String displayName) {
        this.displayName = displayName;
    }

    // Getter method to retrieve the string
    public String getDisplayName() {
        return displayName;
    }

    // Override toString to return the friendly name
    @Override
    public String toString() {
        return displayName;
    }
}
