package de.turing85.refaster.test.rules;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;

import java.util.List;

public class ListRules {
  private ListRules() {
  }

  @SuppressWarnings("unused")
  static final class EmptyList<T> {
    @BeforeTemplate
    boolean equalsZero(List<T> list) {
      return list.size() == 0;
    }

    @AfterTemplate
    boolean isEmpty(List<T> list) {
      return list.isEmpty();
    }
  }
}
