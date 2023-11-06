package homework.onlineShop.model;

import homework.onlineShop.enums.UserType;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String id;
    private String name;
    private String emile;
    private String password;
    private UserType type2;

    public User(String id, String name, String emile, String password, UserType type2) {
        this.id = id;
        this.name = name;
        this.emile = emile;
        this.password = password;
        this.type2 = type2;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmile() {
        return emile;
    }

    public void setEmile(String emile) {
        this.emile = emile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType2() {
        return type2;
    }

    public void setType2(UserType type2) {
        this.type2 = type2;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", emile='" + emile + '\'' +
                ", password='" + password + '\'' +
                ", type2=" + type2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(emile, user.emile) && Objects.equals(password, user.password) && type2 == user.type2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, emile, password, type2);
    }
}

