/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.ui.smartTree.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import org.eclipse.che.ide.ui.smartTree.data.Node;

/**
 * Event fires after an node is expanded.
 *
 * @author Vlad Zhukovskiy
 */
public class ExpandNodeEvent extends GwtEvent<ExpandNodeEvent.ExpandNodeHandler> {

  public interface ExpandNodeHandler extends EventHandler {
    void onExpand(ExpandNodeEvent event);
  }

  public interface HasExpandItemHandlers {
    HandlerRegistration addExpandHandler(ExpandNodeHandler handler);
  }

  private static Type<ExpandNodeHandler> TYPE;

  public static Type<ExpandNodeHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<>();
    }
    return TYPE;
  }

  private Node node;

  public ExpandNodeEvent(Node node) {
    this.node = node;
  }

  @Override
  public Type<ExpandNodeHandler> getAssociatedType() {
    return TYPE;
  }

  public Node getNode() {
    return node;
  }

  /** {@inheritDoc} */
  @Override
  protected void dispatch(ExpandNodeHandler handler) {
    handler.onExpand(this);
  }
}
