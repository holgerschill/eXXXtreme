import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.eclipse.eXXXtreme.tutorial.DBAccess;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Example extends DBAccess {
  private static Connection conn = getConnection("/Users/zarnekow/projects/xbaseexample/org.eclipse.eXXXtreme.tutorial.example/db/test");
  
  public static void main(final String... args) throws SQLException {
    try{
    	Example.myQuery(Example._myQueryTableContent);
    	Example.myQuery2(Example._myQuery2TableContent);
    } catch (Exception e) {
    	e.printStackTrace(); // superior exception handling
    } finally {
    	Example.conn.close();
    }
  }
  
  private static List<Person> _myQueryTableContent = loadTable(conn, Person.class);
  
  public static List<Person> myQuery(final List<Person> it) {
    for (final Person person : it) {
      String _name = person.getName();
      String _plus = (_name + " ");
      String _lastname = person.getLastname();
      String _plus_1 = (_plus + _lastname);
      String _plus_2 = (_plus_1 + " ");
      Adress _adress = person.getAdress();
      String _city = _adress.getCity();
      String _plus_3 = (_plus_2 + _city);
      InputOutput.<String>println(_plus_3);
    }
    return it;
  }
  
  public static List<Person> myQuery() {
    return Example.myQuery(Example._myQueryTableContent);
  }
  
  private static List<Adress> _myQuery2TableContent = loadTable(conn, Adress.class);
  
  public static String myQuery2(final List<Adress> it) {
    Adress _head = IterableExtensions.<Adress>head(it);
    return _head.getCity();
  }
  
  public static String myQuery2() {
    return Example.myQuery2(Example._myQuery2TableContent);
  }
}
