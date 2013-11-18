/*
 * This file is a component of thundr, a software library from 3wks.
 * Read more: http://www.3wks.com.au/thundr
 * Copyright (C) 2013 3wks, <thundr@3wks.com.au>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.threewks.thundr.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import com.threewks.thundr.configuration.ConfigurationException;
import com.threewks.thundr.injection.BaseInjectionConfiguration;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.logger.Logger;

public class QuartzInjectionConfiguration extends BaseInjectionConfiguration {

	@Override
	public void configure(UpdatableInjectionContext injectionContext) {
		try {
			// Note: requires scheduler thread to be configured to be a daemon
			// in order to shut down cleanly (see org.quartz.scheduler.makeSchedulerThreadDaemon docs).
			// One day we should have access to the Servlet destroy event in which we can explicitly call stop().
			QuartzScheduler scheduler = new QuartzScheduler(StdSchedulerFactory.getDefaultScheduler());
			scheduler.setJobFactory(new QuartzJobFactory(injectionContext));
			scheduler.start();

			injectionContext.inject(scheduler).as(QuartzScheduler.class);
			Logger.info("Quartz scheduler started");
		} catch (SchedulerException e) {
			throw new ConfigurationException(e, "Failed to start Quartz scheduler.");
		}
	}
}
