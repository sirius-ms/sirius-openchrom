/*******************************************************************************
 * Copyright (c) 2020 Lablicate GmbH.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Philip Wenig - initial API and implementation
 *******************************************************************************/
package de.unijena.bioinf.ui.parts;

import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.unijena.bioinf.ui.swt.CompoundsUI;

public class CompoundsPart {

	private CompoundsUI compoundsUI;

	@Inject
	public CompoundsPart(Composite parent, MPart part) {
		compoundsUI = new CompoundsUI(parent, SWT.NONE);
	}

	@Focus
	public void setFocus() {

		compoundsUI.setFocus();
	}
}
