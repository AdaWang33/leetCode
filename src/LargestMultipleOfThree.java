/**
 * Given an integer array of digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order.
 *
 * Since the answer may not fit in an integer data type, return the answer as a string.
 *
 * If there is no answer return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [8,1,9]
 * Output: "981"
 * Example 2:
 *
 * Input: digits = [8,6,7,1,0]
 * Output: "8760"
 * Example 3:
 *
 * Input: digits = [1]
 * Output: ""
 * Example 4:
 *
 * Input: digits = [0,0,0,0,0,0]
 * Output: "0"
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 10^4
 * 0 <= digits[i] <= 9
 * The returning answer must not contain unnecessary leading zeros.
 */

public class LargestMultipleOfThree {
        int sum;
        int[] frequencyCounter;

        public String largestMultipleOfThree(int[] digits) {
            updateFrequencyCounterAndSum(digits);
            if (sum % 3 == 0)
                return getMaxNumber();
            else if (sum % 3 == 1)
                return findAlternative(1);
            else
                return findAlternative(2);
        }

        private void updateFrequencyCounterAndSum(int[] digits) {
            sum = 0;
            frequencyCounter = new int[10];
            for (int digit : digits) {
                sum += digit;
                ++frequencyCounter[digit];
            }
        }

        private String getMaxNumber() {
            if (nonZeroDigitsHaveNoFrequency()) {
                if (frequencyCounter[0] > 0)
                    return "0";
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; --i)
                for (int j = 0; j < frequencyCounter[i]; j++)
                    sb.append(i);
            return sb.toString();
        }

        private String findAlternative(int remainder) {
            if (removeDigits(1, remainder) || removeDigits(2, 3 - remainder))
                return getMaxNumber();
            return "";
        }

        private boolean nonZeroDigitsHaveNoFrequency() {
            for (int i = 1; i < frequencyCounter.length; i++)
                if (frequencyCounter[i] != 0)
                    return false;
            return true;
        }

        private boolean removeDigits(int numberOfDigitsToRemove, int remainder) {
            for (int j = remainder; j < 10 && numberOfDigitsToRemove > 0; j += 3)
                if (frequencyCounter[j] > 0) {
                    --frequencyCounter[j];
                    --numberOfDigitsToRemove;
                    j -= 3;
                }
            return numberOfDigitsToRemove == 0;
        }
}
