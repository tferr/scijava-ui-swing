/*
 * #%L
 * SciJava UI components for Java Swing.
 * %%
 * Copyright (C) 2010 - 2022 SciJava developers.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package org.scijava.ui.swing.viewer.plot;

import org.scijava.plot.XYPlot;
import org.scijava.plot.XYSeries;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthias Arzt
 */
class XYPlotDemo extends ChartDemo {

	public void run() {
		XYPlot plot = plotService.newXYPlot();
		plot.setTitle("A series forming a circle.");
		plot.xAxis().setAutoRange();
		plot.yAxis().setAutoRange();
		plot.setPreferredSize(400, 400);

		List<Double> xs = new ArrayList<>();
		List<Double> ys = new ArrayList<>();
		for(double t = 0; t < 2 * Math.PI; t += 0.1) {
			xs.add(Math.sin(t));
			ys.add(Math.cos(t));
		}

		XYSeries series = plot.addXYSeries();
		series.setLabel("circle");
		series.setValues(xs, ys);

		ui.show(plot);
	}

	public static void main(final String... args) {
		new XYPlotDemo().run();
	}
}
