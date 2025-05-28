package org.hibernate.validator.test.constraints.annotations.hv;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.validator.test.constraints.annotations.AbstractConstrainedTest;

import org.testng.annotations.Test;

import jakarta.validation.Valid;

public class ValidAnnotationTest extends AbstractConstrainedTest {

	@Test
	public void listAsContainer() {
		class Foo {

			@Valid
			private List<@Valid String> prop;

			public Foo(List<String> prop) {
				this.prop = prop;
			}
		}

		Foo foo = new Foo(List.of("K1"));
		validator.validate(foo);
	}

	@Test
	public void setAsContainer() {
		class Foo {

			@Valid
			private Set<@Valid String> prop;

			public Foo(Set<String> prop) {
				this.prop = prop;
			}
		}

		Foo foo = new Foo(Set.of("K1"));
		validator.validate(foo);
	}

	@Test
	public void mapAsContainer() {
		class Foo {

			@Valid
			private Map<String, @Valid String> prop;

			public Foo(Map<String, String> prop) {
				this.prop = prop;
			}
		}

		Foo foo = new Foo(Map.of("K1", "V1"));
		validator.validate(foo);
	}
}
