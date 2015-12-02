package io.digdag.core.workflow;

import java.util.List;
import com.google.common.base.*;
import io.digdag.core.repository.ResourceNotFoundException;
import io.digdag.core.spi.RevisionInfo;

public interface SessionStore
{
    List<StoredSession> getSessions(int pageSize, Optional<Long> lastId);

    List<StoredSession> getSessionsOfRepository(int repositoryId, int pageSize, Optional<Long> lastId);

    List<StoredSession> getSessionsOfWorkflow(int workflowId, int pageSize, Optional<Long> lastId);

    StoredSession getSessionById(long sesId)
        throws ResourceNotFoundException;

    TaskStateCode getRootState(long sesId)
        throws ResourceNotFoundException;

    List<StoredTask> getTasks(long sesId, int pageSize, Optional<Long> lastId);
}
