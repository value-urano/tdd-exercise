package money;

/**
 * Created by masao on 2018/09/23.
 */
public class Pair {
    private String from;
    private String to;

    public Pair(String from, String to){
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (!from.equals(pair.from)) return false;
        return to.equals(pair.to);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }
}
