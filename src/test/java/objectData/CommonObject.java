package objectData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonObject {

    public List<String> getValueList(String value) {

        String[] valueSplit = value.split(",");
        return Arrays.stream(valueSplit).collect(Collectors.toList());
    }

    public String[] getDateAsArrayFromString(String date, String delimiter) {

        return date.split(delimiter);
    }
}
