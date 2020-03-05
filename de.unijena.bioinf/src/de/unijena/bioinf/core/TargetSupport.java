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

		/*
		 * Set the compound name.
		 */
		ILibraryInformation libraryInformation = new LibraryInformation();
		libraryInformation.setName("6-N-(1,3-benzodioxol-5-ylmethyl)-4-N-(4-methylpiperazin-1-yl)pyrimidine-4,5,6-triamine");
		libraryInformation.setCasNumber("");
		libraryInformation.setComments("This is a demo.");
		libraryInformation.setContributor("Sirius");
		libraryInformation.setDatabase("PubChem");
		libraryInformation.setFormula("C17H23N7O2");
		libraryInformation.setInChI("1S/C18H15Cl2N5O2/c19-11-4-12(20)6-13(5-11)25-18-16(21)17(23-8-24-18)22-7-10-1-2-14-15(3-10)27-9-26-14/h1-6,8H,7,9,21H2,(H2,22,23,24,25)");
		libraryInformation.setMiscellaneous("");
		libraryInformation.setMolWeight(404.2d);
		libraryInformation.setReferenceIdentifier("");
		libraryInformation.setSmiles("CN1CCN(CC1)NC2=C(C(=NC=N2)NCC3=CC=C4C(=C3)OCO4)N");
		Set<String> synonyms = new HashSet<>();
		synonyms.add("AKOS002881732");
		libraryInformation.setSynonyms(synonyms);
		libraryInformation.addClassifier("Metabolite");
		/*
		 * Add the search quality here.
		 * Match Factor, Reverse Match Factor, ... 0 -> no match, 100 -> best match
		 */
		IComparisonResult comparisonResult = new ComparisonResult(52.32f, 55.43f, 60.53f, 59.53f);
		/*
		 * Create the target.
		 */
		IIdentificationTarget identificationTarget = new IdentificationTarget(libraryInformation, comparisonResult);
		identificationTarget.setIdentifier("");
		//
		return identificationTarget;
	}
}
