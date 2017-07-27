package it.unibz.inf.ontop.ontology.impl;

/*
 * #%L
 * ontop-obdalib-core
 * %%
 * Copyright (C) 2009 - 2014 Free University of Bozen-Bolzano
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import it.unibz.inf.ontop.model.term.functionsymbol.Predicate;
import it.unibz.inf.ontop.model.term.functionsymbol.Predicate.COL_TYPE;
import it.unibz.inf.ontop.ontology.Datatype;

import static it.unibz.inf.ontop.model.OntopModelSingletons.TYPE_FACTORY;

public class DatatypeImpl implements Datatype {
	
	private static final long serialVersionUID = -6228610469212615956L;
	
	private final Predicate predicate;

	public static final  Datatype rdfsLiteral; 
	
	static {
	    rdfsLiteral = new DatatypeImpl(TYPE_FACTORY.getTypePredicate(COL_TYPE.LITERAL));
	}
	
	DatatypeImpl(Predicate p) {
		predicate = p;
	}
	
	@Override
	public Predicate getPredicate() {
		return predicate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DatatypeImpl) {
			DatatypeImpl type2 = (DatatypeImpl) obj;
			return (predicate.equals(type2.getPredicate()));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return predicate.getName().toString();
	}
	
}
