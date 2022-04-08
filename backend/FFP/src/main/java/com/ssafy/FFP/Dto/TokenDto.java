package com.ssafy.FFP.Dto;

public class TokenDto {

    private String accessJws;
    private String refreshJws;

    @Override
    public String toString() {
        return "TokenDto [accessJws=" + accessJws + ", refreshJws=" + refreshJws + "]";
    }

    public String getAccessJws() {
        return accessJws;
    }

    public void setAccessJws(String accessJws) {
        this.accessJws = accessJws;
    }

    public String getRefreshJws() {
        return refreshJws;
    }

    public void setRefreshJws(String refreshJws) {
        this.refreshJws = refreshJws;
    }

}
