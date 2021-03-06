/*
 * Copyright 2013, 2014, 2015 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.energyos.espi.common.utils;

import java.util.Map;

import org.energyos.espi.common.models.atom.DateTimeType;
import org.energyos.espi.common.models.atom.EntryType;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

@SuppressWarnings("restriction")
public class ExportFilter {
	private Map<String, String> params;
	private int matchedCounter = 0, emittedCounter = 0;

	public ExportFilter(Map<String, String> params) {
		this.params = params;
	}

	public boolean matches(EntryType entry) {

		if (hasParam("max-results")) {
			if (emittedCounter >= Integer
					.valueOf(params.get("max-results"))) {
				return false;
			}
		}
		
		if (hasParam("published-max")) {
			if (toTime("published-max") < toTime(entry.getPublished())) {
				return false;
			}
		}
		
		if (hasParam("published-min")) {
			if (toTime("published-min") > toTime(entry.getPublished())) {
				return false;
			}
		}

		if (hasParam("updated-max")) {
			if (toTime("updated-max") < toTime(entry.getUpdated())) {
				return false;
			}
		}

		if (hasParam("updated-min")) {
			if (toTime("updated-min") > toTime(entry.getUpdated())) {
				return false;
			}
		}

		if (hasParam("start-index")) {
			if (++matchedCounter < Integer.valueOf(params.get("start-index"))) {
				return false;

			}
		}

		if (hasParam("depth")) {
				if (emittedCounter > Integer.valueOf(params.get("depth"))) {
					return false;
				}
		}
		emittedCounter++;
		return true;
	}

	private boolean hasParam(String paramName) {
		return params.get(paramName) != null;
	}

	private long toTime(String key) {
		String param = params.get(key);

		return XMLGregorianCalendarImpl.parse(param).toGregorianCalendar()
				.getTimeInMillis();
	}

	private long toTime(DateTimeType published) {
		return published.getValue().toGregorianCalendar().getTimeInMillis();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ExportFilter that = (ExportFilter) o;

		return params.equals(that.params);

	}

	@Override
	public int hashCode() {
		return params.hashCode();
	}
}
