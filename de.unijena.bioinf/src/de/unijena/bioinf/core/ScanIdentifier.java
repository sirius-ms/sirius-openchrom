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

import java.util.List;

import org.eclipse.chemclipse.chromatogram.msd.identifier.massspectrum.AbstractMassSpectrumIdentifier;
import org.eclipse.chemclipse.chromatogram.msd.identifier.settings.IMassSpectrumIdentifierSettings;
import org.eclipse.chemclipse.msd.model.core.IMassSpectra;
import org.eclipse.chemclipse.msd.model.core.IRegularMassSpectrum;
import org.eclipse.chemclipse.msd.model.core.IScanMSD;
import org.eclipse.chemclipse.processing.core.IProcessingInfo;
import org.eclipse.chemclipse.processing.core.ProcessingInfo;
import org.eclipse.core.runtime.IProgressMonitor;

import de.unijena.bioinf.preferences.PreferenceSupplier;
import de.unijena.bioinf.settings.ScanIdentifierSettings;

public class ScanIdentifier extends AbstractMassSpectrumIdentifier {

	@Override
	public IProcessingInfo<IMassSpectra> identify(List<IScanMSD> massSpectra, IMassSpectrumIdentifierSettings identifierSettings, IProgressMonitor monitor) {

		ScanIdentifierSettings settings;
		if(identifierSettings instanceof ScanIdentifierSettings) {
			settings = (ScanIdentifierSettings)identifierSettings;
		} else {
			settings = PreferenceSupplier.getScanIdentifierSettings();
		}
		//
		IProcessingInfo<IMassSpectra> processingInfo = new ProcessingInfo<>();
		identify(massSpectra, settings);
		processingInfo.addInfoMessage("Sirius", "Mass spectra have been identified.");
		return processingInfo;
	}

	private void identify(List<IScanMSD> massSpectra, ScanIdentifierSettings settings) {

		for(IScanMSD massSpectrum : massSpectra) {
			if(massSpectrum instanceof IRegularMassSpectrum) {
				IRegularMassSpectrum regularMassSpectrum = (IRegularMassSpectrum)massSpectrum;
				System.out.println(regularMassSpectrum.getMassSpectrometer()); // MS1, MS2, ...
				System.out.println(regularMassSpectrum.getMassSpectrumType()); // 0 = centroid, 1 = profile
			}
			massSpectrum.getTargets().add(TargetSupport.createTarget());
		}
	}
}
