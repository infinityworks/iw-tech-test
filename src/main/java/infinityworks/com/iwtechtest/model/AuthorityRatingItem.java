package infinityworks.com.iwtechtest.model;

/**
 * A single rating item.
 */
public class AuthorityRatingItem {

    private final String name;
    private final double value;

    public AuthorityRatingItem(String name, double value) {
        this.name = name;
        this.value = value;
    }

    /**
     * The name of the rating e.g. (One Star)
     * @return the name of the rating
     */
    public String getName() {
        return name;
    }

    /**
     * The distribution percentage of this rating
     * @return the distribution percentage of this rating
     */
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AuthorityRatingItem{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorityRatingItem that = (AuthorityRatingItem) o;

        if (Double.compare(that.value, value) != 0) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
