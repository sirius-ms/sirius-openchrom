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
package de.unijena.bioinf.core;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.chemclipse.model.identifier.ComparisonResult;
import org.eclipse.chemclipse.model.identifier.IComparisonResult;
import org.eclipse.chemclipse.model.identifier.IIdentificationTarget;
import org.eclipse.chemclipse.model.identifier.ILibraryInformation;
import org.eclipse.chemclipse.model.identifier.LibraryInformation;
import org.eclipse.chemclipse.model.implementation.IdentificationTarget;

public class TargetSupport {

	public static IIdentificationTarget createTarget() {

		ILibraryInformation libraryInformation = new LibraryInformation();
		libraryInformation.setName("6-N-(1,3-benzodioxol-5-ylmethyl)-4-N-(4-methylpiperazin-1-yl)pyrimidine-4,5,6-triamine");
		libraryInformation.setCasNumber("");
		libraryInformation.setComments("This is a demo.");
		libraryInformation.setContributor("Sirius");
		libraryInformation.setDatabase("PubChem");
		libraryInformation.setFormula("C17H23N7O2");
		libraryInformation.setInChI("");
		libraryInformation.setMiscellaneous("");
		libraryInformation.setMolWeight(0.0d);
		libraryInformation.setReferenceIdentifier("");
		libraryInformation.setSmiles("CN1CCN(CC1)NC2=C(C(=NC=N2)NCC3=CC=C4C(=C3)OCO4)N");
		Set<String> synonyms = new HashSet<>();
		libraryInformation.setSynonyms(synonyms);
		libraryInformation.addClassifier("");
		//
		IComparisonResult comparisonResult = new ComparisonResult(52.32f, 55.43f, 60.53f, 59.53f);
		//
		IIdentificationTarget identificationTarget = new IdentificationTarget(libraryInformation, comparisonResult);
		identificationTarget.setIdentifier("");
		//
		return identificationTarget;
	}
}
