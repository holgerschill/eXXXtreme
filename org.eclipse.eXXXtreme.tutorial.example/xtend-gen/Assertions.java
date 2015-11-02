import com.google.common.base.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Assertions {
  public static <T extends Object> T checkResult(final T value, final T expectation) {
    boolean _notEquals = (!Objects.equal(value, expectation));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(value, "");
      _builder.append(" != ");
      _builder.append(expectation, "");
      throw new IllegalArgumentException(_builder.toString());
    }
    return value;
  }
  
  public static <T extends Object> T unknown() {
    throw new UnsupportedOperationException();
  }
}
