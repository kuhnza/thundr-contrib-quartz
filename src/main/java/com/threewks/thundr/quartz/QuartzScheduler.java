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

import com.threewks.thundr.logger.Logger;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.JobFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuartzScheduler implements Scheduler {
	private Scheduler delegate;

	public QuartzScheduler(Scheduler delegate) {
		this.delegate = delegate;
	}

	@Override
	public String getSchedulerName() throws QuartzException {
		try {
			return delegate.getSchedulerName();
		} catch (SchedulerException e) {
			throw new QuartzException(e);
		}
	}

	@Override
	public String getSchedulerInstanceId() throws QuartzException {
		try {
			return delegate.getSchedulerInstanceId();
		} catch (SchedulerException e) {
			throw new QuartzException(e);
		}
	}

	@Override
	public SchedulerContext getContext() throws QuartzException {
		try {
			return delegate.getContext();
		} catch (SchedulerException e) {
			throw new QuartzException(e);
		}
	}

	@Override
	public void start() throws QuartzException {
		try {
			delegate.start();
		} catch (SchedulerException e) {
			throw new QuartzException(e);
		}
	}

	@Override
	public void startDelayed(int seconds) throws QuartzException {
		try {
			delegate.startDelayed(seconds);
		} catch (SchedulerException e) {
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean isStarted() throws QuartzException {
		try {
			return delegate.isStarted();
		} catch (SchedulerException e) {
			throw new QuartzException(e);
		}
	}

	@Override
	public void standby() throws QuartzException {
		try {
			delegate.standby();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean isInStandbyMode() throws QuartzException {
		try {
			return delegate.isInStandbyMode();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void shutdown() throws QuartzException {
		try {
			delegate.shutdown();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void shutdown(boolean waitForJobsToComplete) throws QuartzException {
		try {
			delegate.shutdown(waitForJobsToComplete);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean isShutdown() throws QuartzException {
		try {
			return delegate.isShutdown();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public SchedulerMetaData getMetaData() throws QuartzException {
		try {
			return delegate.getMetaData();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public List<JobExecutionContext> getCurrentlyExecutingJobs() throws QuartzException {
		try {
			return delegate.getCurrentlyExecutingJobs();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void setJobFactory(JobFactory factory) throws QuartzException {
		try {
			delegate.setJobFactory(factory);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public ListenerManager getListenerManager() throws QuartzException {
		try {
			return delegate.getListenerManager();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Date scheduleJob(JobDetail jobDetail, Trigger trigger) {
		try {
			return delegate.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Date scheduleJob(Trigger trigger) throws QuartzException {
		try {
			return delegate.scheduleJob(trigger);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void scheduleJobs(Map<JobDetail, List<Trigger>> triggersAndJobs, boolean replace) throws QuartzException {
		try {
			delegate.scheduleJobs(triggersAndJobs, replace);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean unscheduleJob(TriggerKey triggerKey) throws QuartzException {
		try {
			return delegate.unscheduleJob(triggerKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean unscheduleJobs(List<TriggerKey> triggerKeys) throws QuartzException {
		try {
			return delegate.unscheduleJobs(triggerKeys);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Date rescheduleJob(TriggerKey triggerKey, Trigger newTrigger) throws QuartzException {
		try {
			return delegate.rescheduleJob(triggerKey, newTrigger);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void addJob(JobDetail jobDetail, boolean replace) throws QuartzException {
		try {
			delegate.addJob(jobDetail, replace);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean deleteJob(JobKey jobKey) throws QuartzException {
		try {
			return delegate.deleteJob(jobKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean deleteJobs(List<JobKey> jobKeys) throws QuartzException {
		try {
			return delegate.deleteJobs(jobKeys);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void triggerJob(JobKey jobKey) throws QuartzException {
		try {
			delegate.triggerJob(jobKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void triggerJob(JobKey jobKey, JobDataMap data) throws QuartzException {
		try {
			delegate.triggerJob(jobKey, data);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void pauseJob(JobKey jobKey) throws QuartzException {
		try {
			delegate.pauseJob(jobKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void pauseJobs(GroupMatcher<JobKey> matcher) throws QuartzException {
		try {
			delegate.pauseJobs(matcher);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void pauseTrigger(TriggerKey triggerKey) throws QuartzException {
		try {
			delegate.pauseTrigger(triggerKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void pauseTriggers(GroupMatcher<TriggerKey> matcher) throws QuartzException {
		try {
			delegate.pauseTriggers(matcher);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void resumeJob(JobKey jobKey) throws QuartzException {
		try {
			delegate.resumeJob(jobKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void resumeJobs(GroupMatcher<JobKey> matcher) throws QuartzException {
		try {
			delegate.resumeJobs(matcher);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void resumeTrigger(TriggerKey triggerKey) throws QuartzException {
		try {
			delegate.resumeTrigger(triggerKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void resumeTriggers(GroupMatcher<TriggerKey> matcher) throws QuartzException {
		try {
			delegate.resumeTriggers(matcher);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void pauseAll() throws QuartzException {
		try {
			delegate.pauseAll();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void resumeAll() throws QuartzException {
		try {
			delegate.resumeAll();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public List<String> getJobGroupNames() throws QuartzException {
		try {
			return delegate.getJobGroupNames();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) throws QuartzException {
		try {
			return delegate.getJobKeys(matcher);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public List<? extends Trigger> getTriggersOfJob(JobKey jobKey) throws QuartzException {
		try {
			return delegate.getTriggersOfJob(jobKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public List<String> getTriggerGroupNames() throws QuartzException {
		try {
			return delegate.getTriggerGroupNames();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) throws QuartzException {
		try {
			return delegate.getTriggerKeys(matcher);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Set<String> getPausedTriggerGroups() throws QuartzException {
		try {
			return delegate.getPausedTriggerGroups();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public JobDetail getJobDetail(JobKey jobKey) throws QuartzException {
		try {
			return delegate.getJobDetail(jobKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Trigger getTrigger(TriggerKey triggerKey) throws QuartzException {
		try {
			return delegate.getTrigger(triggerKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws QuartzException {
		try {
			return delegate.getTriggerState(triggerKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void addCalendar(String calName, Calendar calendar, boolean replace, boolean updateTriggers) throws QuartzException {
		try {
			delegate.addCalendar(calName, calendar, replace, updateTriggers);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean deleteCalendar(String calName) throws QuartzException {
		try {
			return delegate.deleteCalendar(calName);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public Calendar getCalendar(String calName) throws QuartzException {
		try {
			return delegate.getCalendar(calName);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public List<String> getCalendarNames() throws QuartzException {
		try {
			return delegate.getCalendarNames();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean interrupt(JobKey jobKey) throws UnableToInterruptJobException {
		return delegate.interrupt(jobKey);
	}

	@Override
	public boolean interrupt(String fireInstanceId) throws UnableToInterruptJobException {
		return delegate.interrupt(fireInstanceId);
	}

	@Override
	public boolean checkExists(JobKey jobKey) throws QuartzException {
		try {
			return delegate.checkExists(jobKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public boolean checkExists(TriggerKey triggerKey) throws QuartzException {
		try {
			return delegate.checkExists(triggerKey);
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}

	@Override
	public void clear() throws QuartzException {
		try {
			delegate.clear();
		} catch (SchedulerException e) {
			Logger.error(e.getMessage());
			throw new QuartzException(e);
		}
	}
}
