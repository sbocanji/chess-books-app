package com.project.chessbooksapp.dto;

public class AuthorEntityDto {

    private String playerName;
    private boolean active;
    private boolean worldChampion;
    private String nationality;

    public AuthorEntityDto() {
    }

    public AuthorEntityDto(String playerName, boolean active, boolean worldChampion, String nationality) {
        this.playerName = playerName;
        this.active = active;
        this.worldChampion = worldChampion;
        this.nationality = nationality;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isWorldChampion() {
        return worldChampion;
    }

    public void setWorldChampion(boolean worldChampion) {
        this.worldChampion = worldChampion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
