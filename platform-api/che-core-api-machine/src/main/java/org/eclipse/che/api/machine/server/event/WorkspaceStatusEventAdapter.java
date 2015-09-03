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
package org.eclipse.che.api.machine.server.event;

import org.eclipse.che.api.core.notification.EventService;
import org.eclipse.che.api.core.notification.EventSubscriber;
import org.eclipse.che.api.machine.shared.dto.event.MachineStatusEvent;
import org.eclipse.che.api.workspace.shared.dto.event.WorkspaceStatusEvent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;

import static org.eclipse.che.dto.server.DtoFactory.newDto;

/**
 * Adopts {@link MachineStatusEvent machine status events} to {@link WorkspaceStatusEvent}.
 *
 * @author Eugene Voevodin
 * @author Alexander Garagatyi
 */
@Singleton // should be eager
public class WorkspaceStatusEventAdapter implements EventSubscriber<MachineStatusEvent> {

    private final EventService eventService;

    @Inject
    public WorkspaceStatusEventAdapter(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void onEvent(MachineStatusEvent event) {
        final WorkspaceStatusEvent.EventType eventType;
        switch (event.getEventType()) {
            case CREATING:
                eventType = WorkspaceStatusEvent.EventType.MACHINE_CREATING;
                break;
            case RUNNING:
                eventType = WorkspaceStatusEvent.EventType.MACHINE_RUNNING;
                break;
            case DESTROYING:
                eventType = WorkspaceStatusEvent.EventType.MACHINE_DESTROYING;
                break;
            case DESTROYED:
                eventType = WorkspaceStatusEvent.EventType.MACHINE_DESTROYED;
                break;
            case ERROR:
                eventType = WorkspaceStatusEvent.EventType.ERROR;
                break;
            default:
                eventType = WorkspaceStatusEvent.EventType.ERROR;
                event.withError(event.getEventType() + " event type may not be adopted to " + WorkspaceStatusEvent.class.getName());
        }
        eventService.publish(newDto(WorkspaceStatusEvent.class).withMachineId(event.getMachineId())
                                                               .withWorkspaceId(event.getWorkspaceId())
                                                               .withMachineName(event.getMachineName())
                                                               .withIsDevMachine(event.isDev())
                                                               .withError(event.getError())
                                                               .withEventType(eventType));
    }

    @PostConstruct
    private void subscribe() {
        eventService.subscribe(this);
    }

    @PreDestroy
    private void unsubscribe() {
        eventService.unsubscribe(this);
    }
}
