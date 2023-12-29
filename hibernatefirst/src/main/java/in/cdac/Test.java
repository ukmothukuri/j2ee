package in.cdac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
    
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Employee emp = new Employee();
        emp.setEmpName("Praveen");

        session.save(emp);
        session.close();
    }


}
