package de.turing85.refaster.test.rules;

import autovalue.shaded.com.google.common.collect.ImmutableSet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tech.picnic.errorprone.refaster.test.RefasterRuleCollection;

import java.util.stream.Stream;

final class RefasterRulesTest {
  private static final ImmutableSet<Class<?>> RULE_COLLECTIONS =
      ImmutableSet.of(
          ListRules.class,
          StreamRules.class);

  private static Stream<Arguments> validateRuleCollectionTestCases() {
    return RULE_COLLECTIONS.stream()
        .map(Arguments::arguments);
  }

  @MethodSource("validateRuleCollectionTestCases")
  @ParameterizedTest
  void validateRuleCollection(Class<?> clazz) {
    RefasterRuleCollection.validate(clazz);
  }
}
