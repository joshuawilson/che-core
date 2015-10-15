/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.api.machine.server.dao;

import org.eclipse.che.api.core.NotFoundException;
import org.eclipse.che.api.machine.server.exception.SnapshotException;
import org.eclipse.che.api.machine.server.impl.SnapshotImpl;

import java.util.List;

/**
 * Stores metadata of snapshots
 *
 * @author andrew00x
 */
public interface SnapshotDao {
    /**
     * Retrieve snapshot metadata by id
     *
     * @param snapshotId
     *         id of required snapshot
     * @return {@link SnapshotImpl} with specified id
     * @throws NotFoundException
     *         if snapshot with specified id not found
     * @throws SnapshotException
     *         if other error occurs
     */
    SnapshotImpl getSnapshot(String snapshotId) throws NotFoundException, SnapshotException;

    /**
     * Save snapshot metadata
     *
     * @param snapshot
     *         snapshot metadata to store
     * @throws SnapshotException
     *         if error occurs
     */
    void saveSnapshot(SnapshotImpl snapshot) throws SnapshotException ;

    /**
     * Find snapshots by owner, workspace, project
     *
     * @param owner
     *         id of the owner of desired snapshot
     * @param workspaceId
     *         workspace specified in desired snapshot, optional
     * @return list of snapshot that satisfy provided queries, or empty list if no desired snapshots found
     * @throws SnapshotException
     *         if error occurs
     */
    List<SnapshotImpl> findSnapshots(String owner, String workspaceId) throws SnapshotException ;

    /**
     * Remove snapshot by id
     *
     * @param snapshotId
     *         id of snapshot that should be removed
     * @throws NotFoundException
     *         if snapshot with specified id not found
     * @throws SnapshotException
     *         if other error occur
     */
    void removeSnapshot(String snapshotId) throws NotFoundException, SnapshotException ;
}
