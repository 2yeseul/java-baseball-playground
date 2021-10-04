package study;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현")
    void splitTest() throws Exception {
        String actual = "1,2";
        String[] splitArray = actual.split(",");

        assertThat(splitArray).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열 반환 여부 테스트")
    void splitTest2() {
        String actual = "1";
        String[] splitArray = actual.split(",");

        assertThat(splitArray).contains("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2를 반환하도록 구현")
    void substringTest() {
        String actual = "(1,2)";
        String result = actual.substring(actual.indexOf("(") + 1, actual.indexOf(")"));

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAtTest() {
        String actual = "abc";

        assertThat(actual.charAt(0)).isEqualTo('a');
        assertThat(actual.charAt(1)).isEqualTo('b');
        assertThat(actual.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            actual.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    void checkSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkNumbersContained(int input) {
        assertThat(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void notContainsTest(String input, String expected) {
        assertEquals(numbers.contains(Integer.parseInt(input)), Boolean.parseBoolean(expected));
    }
}
