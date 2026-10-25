package homework.lessonjava2.visitor;

public class Visitor {
    public static int totalVisitors = 0;

    public int getTotalVisitors() {
        return totalVisitors;
    }

    public Visitor() {
        totalVisitors += 1;
    }
}
