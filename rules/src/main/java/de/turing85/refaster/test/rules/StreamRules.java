package de.turing85.refaster.test.rules;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;
import com.google.errorprone.refaster.annotation.MayOptionallyUse;
import com.google.errorprone.refaster.annotation.Placeholder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamRules {
  private StreamRules() {
  }

  @SuppressWarnings("unused")
  abstract static class FlatMapRule<T, U> {
    @Placeholder
    abstract List<U> getList(@MayOptionallyUse T t);

    @BeforeTemplate
    Stream<U> flatMap(Stream<T> stream) {
      return stream
          .flatMap(t -> getList(t).stream());
    }

    @AfterTemplate
    Stream<U> mapFlatMap(Stream<T> stream) {
      return stream
          .map(t -> getList(t))
          .flatMap(Collection::stream);
    }
  }
}
