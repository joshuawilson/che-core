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
package org.eclipse.che.api.workspace.shared.dto.event;

import org.eclipse.che.api.core.notification.EventOrigin;
import org.eclipse.che.dto.shared.DTO;

/**
 * Describes changes of state of a workspace.
 *
 * @author Eugene Voevodin
 * @author Alexander Garagatyi
 */
@EventOrigin("machine")
@DTO
public interface WorkspaceStatusEvent {

    //TODO add events related to project
    enum EventType {
        STARTING,
        RUNNING,
        STOPPING,
        STOPPED,
        ERROR,
        MACHINE_CREATING,
        MACHINE_RUNNING,
        MACHINE_DESTROYING,
        MACHINE_DESTROYED
    }

    EventType getEventType();

    void setEventType(EventType eventType);

    WorkspaceStatusEvent withEventType(EventType eventType);

    String getWorkspaceId();

    void setWorkspaceId(String machineId);

    WorkspaceStatusEvent withWorkspaceId(String machineId);

    String getError();

    void setError(String error);

    WorkspaceStatusEvent withError(String error);

    String getMachineId();

    WorkspaceStatusEvent withMachineId(String machineId);

    String getMachineName();

    WorkspaceStatusEvent withMachineName(String machineName);

    boolean isDevMachine();

    WorkspaceStatusEvent withIsDevMachine(boolean isDev);
}
