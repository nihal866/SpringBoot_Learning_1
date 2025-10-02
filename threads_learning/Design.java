import java.util.ArrayList;
import java.util.List;

public class Design {
    private String name;
    private int id;
    private int count;
    private List<Integer> votes;

    public List<Integer> getVotes() {
        return votes;
    }

    public void setVotes(List<Integer> votes) {
        this.votes = votes;
    }

    public Design(String name, int id) {
        this.name = name;
        this.id = id;
        this.votes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
