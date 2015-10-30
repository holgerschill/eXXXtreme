import com.google.common.base.Objects;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.eXXXtreme.tutorial.DBAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Car extends DBAccess {
  private static Connection conn = getConnection("/Users/schill/Documents/Conferences/ECE2015/eXXXtreme/xbaseexample/org.eclipse.eXXXtreme.tutorial.example/db/car");
  
  public static void main(final String... args) throws SQLException {
    try{
    	Car.myQuery(Car._myQueryTableContent);
    } catch (Exception e) {
    	e.printStackTrace(); // superior exception handling
    } finally {
    	Car.conn.close();
    }
  }
  
  private static List<Cardata> _myQueryTableContent = loadTable(conn, Cardata.class);
  
  public static String myQuery(final List<Cardata> it) {
    String _xblockexpression = null;
    {
      final Function1<Cardata, Boolean> _function = (Cardata it_1) -> {
        String _vehmfrcode = it_1.getVehmfrcode();
        return Boolean.valueOf(Objects.equal(_vehmfrcode, "ADX"));
      };
      Iterable<Cardata> _filter = IterableExtensions.<Cardata>filter(it, _function);
      final Consumer<Cardata> _function_1 = (Cardata it_1) -> {
        String _vehiclemanufacturername = it_1.getVehiclemanufacturername();
        InputOutput.<String>println(_vehiclemanufacturername);
      };
      _filter.forEach(_function_1);
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public static String myQuery() {
    return Car.myQuery(Car._myQueryTableContent);
  }
}
