public class TreeNumberGenerator {
    private static final String VALID_CHARACTERS = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
    private static final int MAX_NUMBER = 9999;

    public static String generateNextNumber(String currentNumber) throws Exception {
        validateNumber(currentNumber);

        StringBuilder nextNumber = new StringBuilder(currentNumber);
        int lastIndex = nextNumber.length() - 1;
        while (lastIndex >= 0 && nextNumber.charAt(lastIndex) == '9') {
            nextNumber.setCharAt(lastIndex, 'A');
            lastIndex--;
        }

        if (lastIndex < 0) {
            throw new Exception("编号已超出最大范围");
        }

        char lastChar = nextNumber.charAt(lastIndex);
        int nextCharIndex = VALID_CHARACTERS.indexOf(lastChar) + 1;
        nextNumber.setCharAt(lastIndex, VALID_CHARACTERS.charAt(nextCharIndex));

        return nextNumber.toString();
    }

    private static void validateNumber(String number) throws Exception {
        if (!number.matches("[A-Z2-9]{4,}(-[A-Z2-9]{4,})*")) {
            throw new Exception("输入的编号不符合规范");
        }
    }
}
