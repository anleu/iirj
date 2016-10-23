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
 */



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileOutputStream;

import uk.me.berndporr.iirj.ChebyshevI;

// Various impulse responses written out to files so that you can plot them
public class ChebyshevITest {

	static double ripple = 0.1; // db

	static void bandPassTest() {
		ChebyshevI chebyshevI = new ChebyshevI();
		chebyshevI.bandPass(2, 250, 50, 5, ripple);

		FileOutputStream os = null;
		try {
			os = new FileOutputStream("bp.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream bp = new PrintStream(os);

		// let's do an impulse response
		for (int i = 0; i < 500; i++) {
			double v = 0;
			if (i == 10)
				v = 1;
			v = chebyshevI.filter(v);
			bp.println("" + v);
		}

		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void bandStopTest() {
		ChebyshevI chebyshevI = new ChebyshevI();
		chebyshevI.bandStop(2, 250, 50, 5, ripple);

		FileOutputStream os = null;
		try {
			os = new FileOutputStream("bs.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream bp = new PrintStream(os);

		// let's do an impulse response
		for (int i = 0; i < 500; i++) {
			double v = 0;
			if (i == 10)
				v = 1;
			v = chebyshevI.filter(v);
			bp.println("" + v);
		}

		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void lowPassTest() {
		ChebyshevI chebyshevI = new ChebyshevI();
		chebyshevI.lowPass(4, 250, 50, ripple);

		FileOutputStream os = null;
		try {
			os = new FileOutputStream("lp.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream bp = new PrintStream(os);

		// let's do an impulse response
		for (int i = 0; i < 500; i++) {
			double v = 0;
			if (i == 10)
				v = 1;
			v = chebyshevI.filter(v);
			bp.println("" + v);
		}

		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void highPassTest() {
		ChebyshevI chebyshevI = new ChebyshevI();
		chebyshevI.highPass(4, 250, 50, ripple);

		FileOutputStream os = null;
		try {
			os = new FileOutputStream("hp.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream bp = new PrintStream(os);

		// let's do an impulse response
		for (int i = 0; i < 500; i++) {
			double v = 0;
			if (i == 10)
				v = 1;
			v = chebyshevI.filter(v);
			bp.println("" + v);
		}

		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		lowPassTest();
		highPassTest();
		bandPassTest();
		bandStopTest();
	}

}