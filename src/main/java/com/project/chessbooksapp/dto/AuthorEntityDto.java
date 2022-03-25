package com.project.chessbooksapp.dto;

public class AuthorEntityDto {

    private String playerName;
    private boolean active;
    private boolean worldChampionship;
    private String nationality;

    public AuthorEntityDto() {
    }

    public AuthorEntityDto(String playerName, boolean active, boolean worldChampionship, String nationality) {
        this.playerName = playerName;
        this.active = active;
        this.worldChampionship = worldChampionship;
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

    public boolean isWorldChampionship() {
        return worldChampionship;
    }

    public void setWorldChampionship(boolean worldChampionship) {
        this.worldChampionship = worldChampionship;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
