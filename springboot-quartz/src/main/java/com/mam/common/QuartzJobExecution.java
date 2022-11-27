package com.mam.common;

import com.mam.entity.QuartzJob;
import com.mam.utils.JobInvokeUtil;
import org.quartz.JobExecutionContext;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
public class QuartzJobExecution extends AbstractQuartzJob{
    @Override
    protected void doExecute(JobExecutionContext context, QuartzJob job) throws Exception {
        JobInvokeUtil.invokeMethod(job);
    }
}
