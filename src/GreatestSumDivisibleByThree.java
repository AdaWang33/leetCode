import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For example, let us consider 555, it is divisible by 3 because sum of digits is 5 + 5 + 5 = 15, which is divisible by 3. If a sum of digits is not divisible by 3 then the remainder should be either 1 or 2.
 * If we get remainder either ‘1’ or ‘2’, we have to remove maximum two digits to make a number that is divisible by 3:
 *
 * If remainder is ‘1’ : We have to remove single digit that have remainder ‘1’ or we have to remove two digit that have remainder ‘2’ ( 2 + 2 => 4 % 3 => ‘1’)
 * If remainder is ‘2’ : .We have to remove single digit that have remainder ‘2’ or we have to remove two digit that have remainder ‘1’ ( 1 + 1 => 2 % 3 => 2 ).
 */

public class GreatestSumDivisibleByThree {

}
