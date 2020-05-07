package common.utils;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultUtil {
    private int resultCode;
    private String resultMsg;
    private Object resultData;
}
