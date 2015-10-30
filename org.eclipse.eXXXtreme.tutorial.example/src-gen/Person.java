import java.util.Date;
import org.eclipse.eXXXtreme.tutorial.ITable;

@SuppressWarnings("all")
public class Person implements ITable {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  private String lastname;
  
  public String getLastname() {
    return this.lastname;
  }
  
  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }
  
  private Date dateofbirth;
  
  public Date getDateofbirth() {
    return this.dateofbirth;
  }
  
  public void setDateofbirth(final Date dateofbirth) {
    this.dateofbirth = dateofbirth;
  }
  
  private Adress adress;
  
  public Adress getAdress() {
    return this.adress;
  }
  
  public void setAdress(final Adress adress) {
    this.adress = adress;
  }
}
