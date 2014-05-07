# Thundr Quartz

A Quartz scheduler module for [Thundr](http://3wks.github.io/thundr/)

[![Build Status](https://travis-ci.org/kuhnza/thundr-contrib-quartz.png)](https://travis-ci.org/kuhnza/thundr-contrib-quartz)

## Usage

In your `ApplicationModule`:
```java
@Override
public void requires(DependencyRegistry dependencyRegistry) {
    super.requires(dependencyRegistry);

    dependencyRegistry.addDependency(QuartzModule.class);
}
```

Once registered as a dependency thundr-contrib-quartz injects a QuartzScheduler into the injection context. Hence
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

### A note on previous versions

Previous versions of thundr-contrib-quartz required that you run the Quartz scheduler as a daemon thread to ensure a clean shutdown. This is no longer necessary as Thundr 1.x now provides shutdown hooks that allow the module to manage clean up properly.

### Quartz configuration

Should you need to provide further configurations options to Quartz you should also create a quartz.properties file in your src/resources folder. All configuration values specified in the  [Quartz configuration docs](http://quartz-scheduler.org/documentation/quartz-2.2.x/configuration/) are valid.

