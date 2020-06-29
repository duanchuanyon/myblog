package com.qfedu.dcy.entity;

//从后端获取数据发送给前端
public class GUserEntity {

    private Integer id;
    private String name;
    private String password;
    private String image;
    private String email;
    private Integer is_admin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return  image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
       return email;
}

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Integer is_admin) {
        this.is_admin = is_admin;
    }

    @Override
    public String toString() {
        return "GUserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", is_admin=" + is_admin +
                '}';
    }
}
