import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowSpliteratorTest {

    @Test
    void testThatWindowedWorksCorrectly() {
        List<List<Integer>> collect = SlidingWindowSpliterator.windowed(List.of(1, 2, 3, 4, 5), 3)
            .map(group -> group.collect(Collectors.toList()))
            .collect(Collectors.toList());
        assertThat(collect.get(0)).isEqualTo(List.of(1, 2, 3));
        assertThat(collect.get(1)).isEqualTo(List.of(2, 3, 4));
        assertThat(collect.get(2)).isEqualTo(List.of(3, 4, 5));
    }
}
