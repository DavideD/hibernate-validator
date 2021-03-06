/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.internal.metadata.aggregated.rule;

import org.hibernate.validator.internal.metadata.raw.ConstrainedExecutable;

/**
 * Rule that ensures that void methods don't have any constraints or are marked
 * as cascaded.
 *
 * @author Gunnar Morling
 */
public class VoidMethodsMustNotBeReturnValueConstrained extends MethodConfigurationRule {

	@Override
	public void apply(ConstrainedExecutable method, ConstrainedExecutable otherMethod) {
		if ( method.getExecutable().getReturnType() == void.class &&
				( !method.getConstraints().isEmpty() || method.isCascading() ) ) {
			throw log.getVoidMethodsMustNotBeConstrainedException( method.getLocation().getMember() );
		}
	}
}
