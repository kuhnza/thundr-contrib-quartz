# Thundr Quartz

A Quartz scheduler module for [Thundr](http://3wks.github.io/thundr/)

## Usage

In your module.properties file:
```ini
com.threewks.thundr.quartz=
```

When included in your module.properties file thundr-quartz injects a QuartzScheduler into the injection context. Hence
you can use it as follows:

```java
QuartzScheduler scheduler = injectionContext.get(QuartzScheduler.class);

JobDetail myJob = JobBuilder.newJob(MyJob.class)
                            .withIdentity("MyJob")
                            .build();

Trigger myJobTrigger = TriggerBuilder
        .newTrigger()
        .withIdentity("myJobTrigger")
        .withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInHours(24)
                        .repeatForever())
                        .build();

scheduler.scheduleJob(myJob, myJobTrigger);
```

Since Thundr Quartz is just a thin wrapper around Quartz virtually anything you can do with Quartz standalone should
be possible. Refer to the official [Quartz docs](http://quartz-scheduler.org/documentation) for details.

### Quartz configuration

To ensure a clean shutdown you should also create a quartz.properties file in your src/resources folder with the
following configurations as a minimum. Note that all other
[Quartz configuration](http://quartz-scheduler.org/documentation/quartz-2.2.x/configuration/) values are also valid.

```ini
org.quartz.scheduler.makeSchedulerThreadDaemon=true
org.quartz.threadPool.makeThreadsDaemons=true
```

Thundr lacks a servlet shutdown even hook at present which means that we cannot call `scheduler.shutdown()` without
which the JVM will hang waiting for all threads to terminate. Setting the thread pool to use daemon threads alleviates
this as the JVM will not wait for them to terminate.

