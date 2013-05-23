import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Anton
 * Date: 23.05.13
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */
public class TPreprocessor {

    private Map<String, Number> params = new HashMap<String, Number>();

    public String parse(String inputStr) {
        String[] array = inputStr.trim().split("\n");
        return parseStrings(array);
    }

    private String parseStrings(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<array.length; i++){
            String line = array[i];
            if (line.startsWith("#define")){
                params.put(line.split(" ")[1], Double.parseDouble(line.split(" ")[2]));
            }
            else if (line.startsWith("#undefine")){
                params.remove(line.split(" ")[1]);
            }
            else if (line.startsWith("#if")){
                parseIf(Arrays.copyOfRange(array, i, array.length));
            }
            else if(!line.startsWith("#")){
                stringBuilder.append(line).append("\n");
            }
            else return "";
        }
        return stringBuilder.toString().trim();
    }

    private String parseIf(String[] restArray) {
        if (!expressionIsZero(restArray[0])) {
            parseStrings(Arrays.copyOfRange(restArray,
                                            findNextElseOrEndIf(Arrays.copyOfRange(restArray, 1, restArray.length),
                                            restArray.length));
        }
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

}
