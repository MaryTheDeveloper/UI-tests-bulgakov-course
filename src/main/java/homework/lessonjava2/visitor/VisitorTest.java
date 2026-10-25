package homework.lessonjava2.visitor;

public class VisitorTest {
    public static void main(String[] args) {
        Visitor visitor1 = new Visitor();
        System.out.println(visitor1.getTotalVisitors());

        Visitor visitor2 = new Visitor();
        System.out.println(visitor2.getTotalVisitors());

        Visitor visitor3 = new Visitor();
        System.out.println(visitor3.getTotalVisitors());

        Visitor visitor4 = new Visitor();
        System.out.println(visitor4.getTotalVisitors());

        Visitor visitor5 = new Visitor();
        System.out.println(visitor5.getTotalVisitors()); //5
        System.out.println(visitor1.getTotalVisitors()); // 5

        // переменная статичная и принадлежит классу Visitor, а не создается для каждого экземпляра класса
        // на создание экземпляра класса вызывается конструктор, в котором переменная увеличивается на 1
        // не важно, какой экземпляр класса вызовет переменную после создания всех экземпляров, totalVisitors для них всех будет одна
    }
}
