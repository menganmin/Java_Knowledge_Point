## 基础使用

Quartz 的核心类有以下三部分：

- 任务 Job ：需要实现的任务类，实现 `execute()` 方法，执行后完成任务。 
- 触发器 Trigger ：包括 SimpleTrigger 和 CronTrigger。
- 调度器 Scheduler ：任务调度器，负责基于 Trigger触发器，来执行 Job任务。

### JobDetail

JobDetail 的作用是绑定 Job，是一个任务实例，它为 Job 添加了许多扩展参数。

| 主要字段   | 涵义、作用                                                   |
| ---------- | ------------------------------------------------------------ |
| name       | 任务名称                                                     |
| group      | 任务分组，默认分组 `DEFAULT`                                 |
| jobClass   | 任务类，就是上面 Demo 中的 `MyJob` 的路径                    |
| jobDataMap | 任务参数信息。JobDetail、Trigger 都可以使用 JobDataMap 来设置一些参数或信息。 |

每次Scheduler调度执行一个Job的时候，首先会拿到对应的Job，然后创建该Job实例，再去执行Job中的execute()的内容，任务执行结束后，关联的Job对象实例会被释放，且会被JVM GC清除。

**为什么设计成JobDetail + Job，不直接使用Job？**

> JobDetail 定义的是任务数据，而真正的执行逻辑是在Job中。
>
> 这是因为任务是有可能并发执行，如果Scheduler直接使用Job，就会存在对同一个Job实例并发访问的问题。
>
> 而JobDetail & Job 方式，Sheduler每次执行，都会根据JobDetail创建一个新的Job实例，这样就可以 **规避并发访问** 的问题。

### add job请求体
 {
   "concurrent": "1",
   "cronExpression": "0/10 * * * * ?",
   "invokeTarget": "myJob.execute('hello')",
   "jobGroup": "myJob",
   "jobId": 10086,
   "jobName": "新增 myJob 任务",
   "misfirePolicy": "1",
   "remark": "",
   "status": "0"
 }
 
### Swagger UI: http://localhost:8080/swagger-ui.html#/
