package de.turing85.refaster.test.rules;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import tech.picnic.errorprone.refaster.test.RefasterRuleCollectionTestCase;

class StreamRulesTest implements RefasterRuleCollectionTestCase {
  void testFlatMapRule() {
    Stream.of((Supplier<List<String>>) () -> List.of())
        .filter(ignored -> true)
        .map(foo -> foo.get())
        .flatMap(Collection::stream);
  }
}