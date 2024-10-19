import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class L2022211981_14_Test {

    //测试用例设计总体原则
    //等价类划分：
    //有效等价类：
    //字符串长度为 9 的情况（例如 "255.255.11.135"）。
    //字符串长度为 8 的情况（例如 "192.168.1.1"）。
    //字符串包含前导零但整个段为零的情况（例如 "0.0.0.0"）。
    //字符串包含多个段的情况（例如 "10.10.2.3"）。
    //无效等价类：
    //字符串长度小于 8 或大于 12 的情况。
    //字符串包含超过 255 的段。
    //字符串包含前导零但不是整个段为零的情况（例如 "01.0.0.1"）。
    //字符串包含非数字字符（例如 "192.168@1.1"）。

    @Test
    //测试方法testValidIpAddresses：测试所有有效的 IP 地址情况。使用 assertTrue 和 assertEquals 来验证结果是否符合预期。
    public void testValidIpAddresses() {
        Solution solution = new Solution();

        // Test case 1: Valid IP addresses of length 9
        List<String> result1 = solution.restoreIpAddresses("25525511135");
        assertTrue(result1.contains("255.255.11.135"));
        assertTrue(result1.contains("255.255.111.35"));
        assertEquals(2, result1.size());

        // Test case 2: Valid IP addresses of length 8
        List<String> result2 = solution.restoreIpAddresses("19216811");
        assertTrue(result2.contains("192.168.1.1"));
        assertTrue(result2.contains("192.16.81.1"));
        assertTrue(result2.contains("192.16.8.11"));
        assertTrue(result2.contains("19.21.68.11"));
        assertTrue(result2.contains("19.216.8.11"));
        assertTrue(result2.contains("19.216.81.1"));
        assertTrue(result2.contains("1.92.168.11"));
        assertTrue(result2.contains("19.2.168.11"));
        assertTrue(result2.contains("192.1.68.11"));
        assertEquals(9, result2.size());


        // Test case 3: Valid IP addresses with leading zeros but full segment is zero
        List<String> result3 = solution.restoreIpAddresses("0000");
        assertTrue(result3.contains("0.0.0.0"));
        assertEquals(1, result3.size());

        // Test case 4: Valid IP addresses with multiple segments
        List<String> result4 = solution.restoreIpAddresses("101023");
        assertTrue(result4.contains("1.0.10.23"));
        assertTrue(result4.contains("1.0.102.3"));
        assertTrue(result4.contains("10.1.0.23"));
        assertTrue(result4.contains("10.10.2.3"));
        assertTrue(result4.contains("101.0.2.3"));
        assertEquals(5, result4.size());
    }

    @Test
    //测试方法testInvalidIpAddresses：测试所有无效的 IP 地址情况。使用 assertTrue 和 assertEquals 来验证结果是否符合预期。
    public void testInvalidIpAddresses() {
        Solution solution = new Solution();

        // Test case 1: String length less than 8
        List<String> result1 = solution.restoreIpAddresses("123");
        assertTrue(result1.isEmpty());

        // Test case 2: String length greater than 12
        List<String> result2 = solution.restoreIpAddresses("123456789012");
        assertTrue(result2.isEmpty());

        // Test case 3: Segment exceeds 255
        List<String> result3 = solution.restoreIpAddresses("2560000000");
        assertTrue(result3.isEmpty());

        // Test case 4: Leading zero but not full segment is zero
        List<String> result4 = solution.restoreIpAddresses("0100000000");
        assertTrue(result4.isEmpty());

        // Test case 5: Non-numeric character
        List<String> result5 = solution.restoreIpAddresses("192.168@1.1");
        assertTrue(result5.isEmpty());
    }

}
