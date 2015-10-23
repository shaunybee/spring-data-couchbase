/*
 * Copyright 2012-2015 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.couchbase.core.query;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

/**
 * This annotation is targeted at {@link CouchbaseRepository Repository} interfaces, indicating that
 * the framework should ensure a N1QL Secondary Index is present when the repository is instantiated.
 * <p/>
 * Said index will relate to the "type" field (the one bearing type information) and restrict on documents
 * that match the repository's entity class.
 *
 * @author Simon Baslé
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface N1qlSecondaryIndexed {

  /**
   * the name of the index to be created, in the repository's associated bucket namespace.
   */
  String indexName();

  /**
   * Indicates if the framework should also ensure a N1QL Primary Index is present, even if
   * {@link org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed} is not used.
   */
  boolean ensurePrimaryIndex() default true;
}
