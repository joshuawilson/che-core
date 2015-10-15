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
package org.eclipse.che.api.machine.server.impl;

import org.eclipse.che.api.machine.server.spi.InstanceKey;
import org.eclipse.che.api.core.model.machine.Snapshot;

import java.util.Objects;

/**
 * Saved state of {@link org.eclipse.che.api.machine.server.spi.Instance}.
 *
 * @author andrew00x
 */
public class SnapshotImpl implements Snapshot {
    private String      id;
    private String      type;
    private InstanceKey instanceKey;
    private String      owner;
    private long        creationDate;
    private String      workspaceId;
    private boolean     isDev;
    private String      description;

    public SnapshotImpl() {
    }

    public SnapshotImpl(String id,
                        String type,
                        InstanceKey instanceKey,
                        String owner,
                        long creationDate,
                        String workspaceId,
                        String description,
                        boolean isDev) {
        this.id = id;
        this.type = type;
        this.instanceKey = instanceKey;
        this.owner = owner;
        this.creationDate = creationDate;
        this.workspaceId = workspaceId;
        this.isDev = isDev;
        this.description = description;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SnapshotImpl withId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SnapshotImpl withType(String type) {
        this.type = type;
        return this;
    }

    public InstanceKey getInstanceKey() {
        return instanceKey;
    }

    public void setInstanceKey(InstanceKey instanceKey) {
        this.instanceKey = instanceKey;
    }

    public SnapshotImpl withInstanceKey(InstanceKey instanceKey) {
        this.instanceKey = instanceKey;
        return this;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public SnapshotImpl withOwner(String owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public SnapshotImpl withCreationDate(long creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @Override
    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

    public SnapshotImpl withWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SnapshotImpl withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean isDev() {
        return this.isDev;
    }

    public void setDev(boolean isDev) {
        this.isDev = isDev;
    }

    public SnapshotImpl withDev(boolean isDev) {
        this.isDev = isDev;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SnapshotImpl)) return false;
        SnapshotImpl snapshot = (SnapshotImpl)o;
        return Objects.equals(creationDate, snapshot.creationDate) &&
               Objects.equals(isDev, snapshot.isDev) &&
               Objects.equals(id, snapshot.id) &&
               Objects.equals(type, snapshot.type) &&
               Objects.equals(instanceKey, snapshot.instanceKey) &&
               Objects.equals(owner, snapshot.owner) &&
               Objects.equals(workspaceId, snapshot.workspaceId) &&
               Objects.equals(description, snapshot.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, instanceKey, owner, creationDate, workspaceId, isDev, description);
    }
}
