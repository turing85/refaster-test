package de.turing85.refaster.test.rules;

import tech.picnic.errorprone.refaster.test.RefasterRuleCollectionTestCase;

import java.util.List;

class ListRulesTest implements RefasterRuleCollectionTestCase {
  void testEmptyList() {
    boolean isEmpty = List.of().size() == 0;
  }
}