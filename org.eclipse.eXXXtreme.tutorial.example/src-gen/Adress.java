import java.math.BigDecimal;
import org.eclipse.eXXXtreme.tutorial.ITable;

@SuppressWarnings("all")
public class Adress implements ITable {
  private BigDecimal id;
  
  public BigDecimal getId() {
    return this.id;
  }
  
  public void setId(final BigDecimal id) {
    this.id = id;
  }
  
  private String city;
  
  public String getCity() {
    return this.city;
  }
  
  public void setCity(final String city) {
    this.city = city;
  }
}
