package utils;

public class StringUtils {

    public static int parseInt(String string) {
        try{
            return Integer.parseInt(string);
        }catch (NumberFormatException e) {
            System.out.println("숫자만 입력 해 주세요.");
            throw new NumberFormatException("잘못된 문자 입력: "+string);
        }
    }
}
