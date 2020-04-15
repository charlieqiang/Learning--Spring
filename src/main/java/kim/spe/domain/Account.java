package kim.spe.domain;

import java.io.Serializable;

/**
 * @author charlie
 * @date 2020/4/15 - 15:35
 * @description
 */
public class Account implements Serializable {
    private Integer id;
    private String last_name;
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", money=" + money +
                '}';
    }
}
