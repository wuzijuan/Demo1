package com.example.ypc.demo1;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class DemoBean {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String stare;
    @Property
    private String criy;

    @Override
    public String toString() {
        return "DemoBean{" +
                "id=" + id +
                ", stare='" + stare + '\'' +
                ", criy='" + criy + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Property
    private  String type;
    @Property
    private String price;
    @Generated(hash = 1549156460)
    public DemoBean(Long id, String stare, String criy, String type, String price) {
        this.id = id;
        this.stare = stare;
        this.criy = criy;
        this.type = type;
        this.price = price;
    }
    @Generated(hash = 2085635340)
    public DemoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStare() {
        return this.stare;
    }
    public void setStare(String stare) {
        this.stare = stare;
    }
    public String getCriy() {
        return this.criy;
    }
    public void setCriy(String criy) {
        this.criy = criy;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

}
