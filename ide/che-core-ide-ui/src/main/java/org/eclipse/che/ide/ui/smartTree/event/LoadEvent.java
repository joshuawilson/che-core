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
package org.eclipse.che.ide.ui.smartTree.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

import org.eclipse.che.ide.api.project.node.Node;
import org.eclipse.che.ide.ui.smartTree.LoadParams;

import java.util.List;

/**
 * Event fires when node requestedNode for loading children.
 *
 * @author Vlad Zhukovskiy
 */
public class LoadEvent extends GwtEvent<LoadEvent.LoadHandler> {

    public interface LoadHandler extends EventHandler {
        void onLoad(LoadEvent event);
    }

    public interface HasLoadHandlers {
        public HandlerRegistration addLoadHandler(LoadHandler handler);
    }

    private static Type<LoadHandler> TYPE;

    public static Type<LoadHandler> getType() {
        if (TYPE == null) {
            TYPE = new Type<>();
        }
        return TYPE;
    }

    private Node       requestedNode;
    private List<Node> receivedNodes;
    private LoadParams params;

    public LoadEvent(Node requestedNode, List<Node> receivedNodes) {
        this.requestedNode = requestedNode;
        this.receivedNodes = receivedNodes;
    }

    public LoadEvent(Node requestedNode, List<Node> receivedNodes, LoadParams params) {
        this.requestedNode = requestedNode;
        this.receivedNodes = receivedNodes;
        this.params = params;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public Type<LoadHandler> getAssociatedType() {
        return (Type)TYPE;
    }

    public Node getRequestedNode() {
        return requestedNode;
    }

    public List<Node> getReceivedNodes() {
        return receivedNodes;
    }

    public LoadParams getParams() {
        return params;
    }

    @Override
    protected void dispatch(LoadHandler handler) {
        handler.onLoad(this);
    }
}
