package org.springframework.data.couchbase.repository.index;

import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.User;

@N1qlSecondaryIndexed(indexName = IndexedRepositoryTests.SECONDARY, ensurePrimaryIndex = true)
@ViewIndexed(designDoc = IndexedRepositoryTests.VIEW_DOC, viewName = IndexedRepositoryTests.VIEW_NAME)
public interface IndexedUserRepository extends CouchbaseRepository<User, String> {
}
