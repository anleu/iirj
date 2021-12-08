/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 *  Copyright (c) 2009 by Vinnie Falco
 *  Copyright (c) 2021 by Bernd Porr
 */


package uk.me.berndporr.iirj;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexUtils;

/**
 *         User facing class which contains two methods
 *         to create Custom SOS filters. This is done in this way:
 *         SOSCascade sosCascase = new SOSCascade(); 
 *         Then call one of the setup() methods below to 
 *         set the SOS coefficients.
 */
public class SOSCascade extends Cascade {

	/**
	 * Sets directly the coefficients of the chain of
	 * 2nd order filters. The layout of the array is
	 * excatly how the scipy python design functions
	 * output the sos coeffcients: b0,b1,b2,a0,a1,a2.
	 * The filter type can be either DirectFormAbstract.DIRECT_FORM_II
	 * or DirectFormAbstract.DIRECT_FORM_I.
	 * @param sosCoefficients SOS coefficients
	 * @param directFormType Direct form type (I or II).
	 **/
	public void setup(final double[][] sosCoefficients,
			  final int directFormType) {
		setSOScoeff(sosCoefficients,directFormType);
	}

	/**
	 * Sets directly the coefficients of the chain of
	 * 2nd order filters. The layout of the array is
	 * excatly how the scipy python design functions
	 * output the coeffcients: b0,b1,b2,a0,a1,a2.
	 * The filter type is DIRECT_FORM_II.
	 * @param sosCoefficients SOS coefficients
	 **/
	public void setup(final double[][] sosCoefficients) {
		setSOScoeff(sosCoefficients,DirectFormAbstract.DIRECT_FORM_II);
	}
}
