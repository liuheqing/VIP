package pojo;

/**
 * Created by Liuheqing on 2016/5/12.
 */
public class Goods {
   private  int cost;
   private  String name;
    private String message;

    public Goods(int cost, String message, String name) {
        this.cost = cost;
        this.message = message;
        this.name = name;
    }

    public Goods() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
