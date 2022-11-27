package com.mam.controller;

import com.mam.entity.ApiResponse;
import com.mam.entity.Constants;
import com.mam.entity.QuartzJob;
import com.mam.service.QuartzJobService;
import com.mam.utils.CronUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Anmin
 * @Date 2022/11/27
 **/
@Api(tags = "Quartz 任务调度接口")
@RestController
@RequestMapping("/quartz/job")
public class QuartzJobController extends BaseController{

    @Autowired
    private QuartzJobService quartzJobService;

    @ApiOperation(value = "新增task任务", notes = "将任务信息添加到数据库")
    @PostMapping(value = "add")
    public ApiResponse<QuartzJob> add(@RequestBody QuartzJob job){
        if (!CronUtils.isValid(job.getCronExpression())) {
            return ApiResponse.<QuartzJob>builder().code(error).msg("新增任务'" + job.getJobName() + "'失败，Cron表达式不正确").build();
        } else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_RMI)) {
            return ApiResponse.<QuartzJob>builder().code(error).msg("新增任务'" + job.getJobName() + "'失败，目标字符串不允许'rmi://'调用").build();
        } else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_LDAP)) {
            return ApiResponse.<QuartzJob>builder().code(error).msg("新增任务'" + job.getJobName() + "'失败，目标字符串不允许'ldap://'调用").build();
        }
        try {
            quartzJobService.insertJob(job);
        }catch (Exception e){
            logger.error("执行异常 {}",e);
        }
        return ApiResponse.<QuartzJob>builder().code(success).build();
    }

    @ApiOperation(value = "根据任务ID修改状态，0启动 1暂停")
    @PostMapping(value = "changeStatus")
    public ApiResponse<Object> changeStatus(Long jobId, String status) throws SchedulerException {
        quartzJobService.changeStatus(jobId, status);
        return ApiResponse.builder().code(success).build();
    }

    @ApiOperation(value = "修改task任务", notes = "根据ID修改已有的任务，同时更新调度任务信息")
    @PostMapping(value = "update")
    public ApiResponse<QuartzJob> update(@RequestBody QuartzJob job) throws Exception {
        if (!CronUtils.isValid(job.getCronExpression())) {
            return ApiResponse.<QuartzJob>builder().code(error).msg("修改任务'" + job.getJobName() + "'失败，Cron表达式不正确").build();
        } else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_RMI)) {
            return ApiResponse.<QuartzJob>builder().code(error).msg("修改任务'" + job.getJobName() + "'失败，目标字符串不允许'rmi://'调用").build();
        } else if (StringUtils.containsIgnoreCase(job.getInvokeTarget(), Constants.LOOKUP_LDAP)) {
            return ApiResponse.<QuartzJob>builder().code(error).msg("修改任务'" + job.getJobName() + "'失败，目标字符串不允许'ldap://'调用").build();
        }
        quartzJobService.updateJob(job);
        return ApiResponse.<QuartzJob>builder().code(success).build();
    }

    @ApiOperation(value = "删除task任务", notes = "根据ID删除已有的任务")
    @DeleteMapping(value = "delete")
    public ApiResponse<QuartzJob> delete(@RequestBody QuartzJob job) throws Exception {
        logger.info("当前jobId为 {}",job.getJobId());
        int row = quartzJobService.deleteJob(job);
        return ApiResponse.<QuartzJob>builder().code(success).msg("删除成功,删除行数: " + row).build();
    }
}
