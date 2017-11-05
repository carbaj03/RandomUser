package com.acv.randomuser.domain.model;

public class Login {
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

    public Login(String username, String password, String salt, String md5, String sha1, String sha256) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getMd5() {
        return md5;
    }

    public String getSha1() {
        return sha1;
    }

    public String getSha256() {
        return sha256;
    }
}