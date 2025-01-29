package uvg.edu;
import java.io.IOException;

public interface IPostfixCalculator {
void readFromFile(String path) throws IOException;
double evaluateExpression() throws IllegalArgumentException;
}
