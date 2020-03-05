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

import org.eclipse.chemclipse.chromatogram.msd.identifier.chromatogram.AbstractChromatogramIdentifier;
import org.eclipse.chemclipse.chromatogram.msd.identifier.settings.IChromatogramIdentifierSettings;
import org.eclipse.chemclipse.model.core.IScan;
import org.eclipse.chemclipse.msd.model.core.IChromatogramMSD;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.msd.model.core.selection.IChromatogramSelectionMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

import de.unijena.bioinf.preferences.PreferenceSupplier;
import de.unijena.bioinf.settings.ChromatogramIdentifierSettings;

@SuppressWarnings("rawtypes")
public class ChromatogramIdentifier extends AbstractChromatogramIdentifier {

	@Override
	public IProcessingInfo identify(IChromatogramSelectionMSD chromatogramSelection, IChromatogramIdentifierSettings identifierSettings, IProgressMonitor monitor) {

		IProcessingInfo processingInfo = validate(chromatogramSelection, identifierSettings);
		if(!processingInfo.hasErrorMessages()) {
			/*
			 * Settings
			 */
			ChromatogramIdentifierSettings settings;
			if(identifierSettings instanceof ChromatogramIdentifierSettings) {
				settings = (ChromatogramIdentifierSettings)identifierSettings;
			} else {
				settings = PreferenceSupplier.getChromatogramIdentifierSettings();
			}
			/*
			 * Process
			 */
			identify(chromatogramSelection, settings);
			processingInfo.addInfoMessage("Sirius", "Chromatogram has been identified.");
		}
		return processingInfo;
	}

	@Override
	public IProcessingInfo identify(IChromatogramSelectionMSD chromatogramSelection, IProgressMonitor monitor) {

		ChromatogramIdentifierSettings settings = PreferenceSupplier.getChromatogramIdentifierSettings();
		return identify(chromatogramSelection, settings, monitor);
	}

	private void identify(IChromatogramSelectionMSD chromatogramSelection, ChromatogramIdentifierSettings settings) {

		IChromatogramMSD chromatogram = chromatogramSelection.getChromatogram();
		int startScan = chromatogram.getScanNumber(chromatogramSelection.getStartRetentionTime());
		int stopScan = chromatogram.getScanNumber(chromatogramSelection.getStopRetentionTime());
		for(int i = startScan; i <= stopScan; i++) {
			IScan scan = chromatogram.getScan(i);
			if(scan instanceof IScanMSD) {
				IScanMSD massSpectrum = (IScanMSD)scan;
				if(massSpectrum instanceof IRegularMassSpectrum) {
					IRegularMassSpectrum regularMassSpectrum = (IRegularMassSpectrum)massSpectrum;
					System.out.println(regularMassSpectrum.getMassSpectrometer()); // MS1, MS2, ...
					System.out.println(regularMassSpectrum.getMassSpectrumType()); // 0 = centroid, 1 = profile
				}
			}
		}
		/*
		 * Annotate the chromatogram as a whole.
		 */
		chromatogram.getTargets().add(TargetSupport.createTarget());
	}
}
